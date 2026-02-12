package io.github.tihiforever.randomwalk;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import java.util.ArrayList;
import java.util.Random;


public class RandomWalk extends ApplicationAdapter {

    private ShapeRenderer shapeRenderer;
    private Random random;

    private float x, y;
    private float stepSize = 5f;

    private static final int MAX_STEPS = 10000;
    private float[][] path;
    private int stepCount = 0;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        random = new Random();

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

        // Clamp to screen bounds
        x = Math.max(0, Math.min(x, Gdx.graphics.getWidth()));
        y = Math.max(0, Math.min(y, Gdx.graphics.getHeight()));

        path[stepCount][0] = x;
        path[stepCount][1] = y;
        stepCount++;

    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        step();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        for (int i = 1; i < stepCount; i++) {
            shapeRenderer.line(
                path[i - 1][0], path[i - 1][1],
                path[i][0], path[i][1]
            );
        }

        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
