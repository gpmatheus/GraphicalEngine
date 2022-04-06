package com.mat.engine;

import java.util.List;

import com.mat.engine.elements.Triangle;
import com.mat.engine.elements.Vector;

public class Object implements Runnable {

    private List<Triangle> triangles;
    private Screen screen;
    private Vector currentPosition = new Vector(0f, 0f, 0f);

    public Object(List<Triangle> triangles) {
        this.triangles = triangles;
    }

    public List<Triangle> getTriangles() {
        return triangles;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    //TODO
    public void moveObject(Vector position) {
        for (var t : triangles) {
            t.move(position.getX(), position.getY(), position.getZ());
        }
        this.currentPosition.sum(position);
    }

    public void startRotating() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        double alpha = 0f;
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (var s : triangles) {
                s.rotateX(alpha, currentPosition);
                //s.rotateY(alpha, position);
                //s.rotateZ(alpha, position);
                //s.translateX(alpha);
                //s.translateY(alpha);
                //s.translateZ(alpha);
            }
            alpha += 1f;
            alpha %= 360f;
            if (screen != null)
                screen.repaint();
        }
    }
    
}
