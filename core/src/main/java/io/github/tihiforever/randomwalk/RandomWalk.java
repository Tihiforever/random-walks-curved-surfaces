package io.github.tihiforever.randomwalk;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import java.util.Random;

public class RandomWalk extends ApplicationAdapter {

    private SpriteBatch batch;
    private BitmapFont font;
    private ShapeRenderer shapeRenderer;
    private Random random;

    private float x, y;       // screen coordinates
    private float theta, phi; // torus angular coordinates

    private enum Mode { NORMAL, FLAT_TORUS, CURVED_TORUS }
    private Mode mode = Mode.CURVED_TORUS;

    private static final int MAX_STEPS = 1000000;
    private float[][] path;
    private int stepCount = 0;

    private float R = 3f;      // major radius
    private float r = 1f;      // minor radius
    private float baseStep = 0.01f;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        font = new BitmapFont();
        random = new Random();

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        x = width / 2f;
        y = height / 2f;
        theta = (float)Math.PI;
        phi = (float)Math.PI;

        path = new float[MAX_STEPS][2];
        path[0][0] = x;
        path[0][1] = y;
        stepCount = 1;
    }

    private void step() {
        if (stepCount >= MAX_STEPS) return;

        int direction = random.nextInt(4);
        float dx = 0, dy = 0;
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        if (mode == Mode.NORMAL) {
            if (direction == 0) dx = baseStep * 100;
            if (direction == 1) dx = -baseStep * 100;
            if (direction == 2) dy = baseStep * 100;
            if (direction == 3) dy = -baseStep * 100;

            x += dx;
            y += dy;
            x = Math.max(0, Math.min(width, x));
            y = Math.max(0, Math.min(height, y));

        } else if (mode == Mode.FLAT_TORUS) {
            if (direction == 0) dx = baseStep * 100;
            if (direction == 1) dx = -baseStep * 100;
            if (direction == 2) dy = baseStep * 100;
            if (direction == 3) dy = -baseStep * 100;

            x += dx;
            y += dy;
            if (x > width) x -= width;
            if (x < 0) x += width;
            if (y > height) y -= height;
            if (y < 0) y += height;

        } else if (mode == Mode.CURVED_TORUS) {
            float dTheta = 0, dPhi = 0;
            if (direction == 0) dPhi += baseStep;
            if (direction == 1) dPhi -= baseStep;
            if (direction == 2) dTheta += baseStep;
            if (direction == 3) dTheta -= baseStep;

            float metricFactor = (R + r * (float)Math.cos(theta));
            if (metricFactor < 0.1f) metricFactor = 0.1f;
            dPhi /= metricFactor;

            theta += dTheta;
            phi += dPhi;

            float twoPi = (float)(2 * Math.PI);
            theta = (theta + twoPi) % twoPi;
            phi = (phi + twoPi) % twoPi;

            x = (phi / twoPi) * width;
            y = (theta / twoPi) * height;
            if (x > width) x -= width;
            if (x < 0) x += width;
            if (y > height) y -= height;
            if (y < 0) y += height;
        }

        path[stepCount][0] = x;
        path[stepCount][1] = y;
        stepCount++;
    }

    @Override
    public void render() {

        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.N)) mode = Mode.NORMAL;
        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.F)) mode = Mode.FLAT_TORUS;
        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.C)) mode = Mode.CURVED_TORUS;

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        step();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        for (int i = 1; i < stepCount; i++) {
            float x1 = path[i - 1][0];
            float y1 = path[i - 1][1];
            float x2 = path[i][0];
            float y2 = path[i][1];

            if (mode == Mode.CURVED_TORUS) {
                // Gradient color based on theta
                float twoPi = (float)(2 * Math.PI);
                float t1 = (path[i - 1][1] / Gdx.graphics.getHeight()); // normalized 0-1
                float t2 = (path[i][1] / Gdx.graphics.getHeight());
                Color color = new Color(t1, 0f, 1f - t1, 1f); // blue→red gradient
                shapeRenderer.setColor(color);
            } else {
                shapeRenderer.setColor(Color.WHITE);
            }

            float dx = Math.abs(x2 - x1);
            float dy = Math.abs(y2 - y1);

            if (dx > Gdx.graphics.getWidth() / 2f || dy > Gdx.graphics.getHeight() / 2f) {
                continue; // skip this line
            }

            shapeRenderer.line(x1, y1, x2, y2);

            shapeRenderer.line(x1, y1, x2, y2);

            shapeRenderer.line(x1, y1, x2, y2);
        }

        shapeRenderer.end();

        batch.begin();
        font.draw(batch, "Steps: " + stepCount, 10, 20);

        String modeText = "";
        if (mode == Mode.NORMAL) modeText = "Normal Walk (N)";
        else if (mode == Mode.FLAT_TORUS) modeText = "Flat 2D Torus (F)";
        else if (mode == Mode.CURVED_TORUS) modeText = "Curved 3D Torus (C)";

        font.draw(batch, "Mode: " + modeText, 20, Gdx.graphics.getHeight() - 20);
        batch.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
        batch.dispose();
        font.dispose();
    }
}
