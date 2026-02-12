package io.github.tihiforever.randomwalk;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
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

    private float x, y;
    private float stepSize = 5f;
    private boolean isTorus = false;

    private static final int MAX_STEPS = 100000000;
    private float[][] path;
    private int stepCount = 0;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        random = new Random();
        font = new BitmapFont();

        x = Gdx.graphics.getWidth() / 2f;
        y = Gdx.graphics.getHeight() / 2f;

        path = new float[MAX_STEPS][2];
        path[0][0] = x;
        path[0][1] = y;
        stepCount = 1;
    }

    private void step() {
        if (stepCount >= MAX_STEPS) return;

        int direction = random.nextInt(4);

        if (direction == 0) x += stepSize; // right
        if (direction == 1) x -= stepSize; // left
        if (direction == 2) y += stepSize; // up
        if (direction == 3) y -= stepSize; // down

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        if (isTorus) {

            if (x > width) x = 0;
            if (x < 0) x = width;

            if (y > height) y = 0;
            if (y < 0) y = height;

        } else {
            x = Math.max(0, Math.min(x, width));
            y = Math.max(0, Math.min(y, height));
        }



        path[stepCount][0] = x;
        path[stepCount][1] = y;
        stepCount++;

    }

    @Override
    public void render() {
        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.T)) {
            isTorus = !isTorus;
        }

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        step();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        for (int i = 1; i < stepCount; i++) {

            float x1 = path[i - 1][0];
            float y1 = path[i - 1][1];
            float x2 = path[i][0];
            float y2 = path[i][1];

            float dx = Math.abs(x2 - x1);
            float dy = Math.abs(y2 - y1);

            // If jump is too large in either direction, skip drawing
            if (dx < stepSize * 2 && dy < stepSize * 2) {
                shapeRenderer.line(x1, y1, x2, y2);
            }
        }


        shapeRenderer.end();

        batch.begin();
        font.draw(batch,"Steps: "+stepCount, 0,20);

        if (isTorus) {
            font.draw(batch, "Mode: Torus (Press T to toggle)", 20, Gdx.graphics.getHeight() - 20);
        } else {
            font.draw(batch, "Mode: Bounded Plane (Press T to toggle)", 20, Gdx.graphics.getHeight() - 20);
        }

        batch.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
        batch.dispose();
    }
}
