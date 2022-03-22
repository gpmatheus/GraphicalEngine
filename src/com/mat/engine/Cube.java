package com.mat.engine;

import java.util.List;

public class Cube implements Runnable {

    private List<Shape> shapes;
    private Screen screen;

    public Cube(List<Shape> shapes, Screen screen) {
        this.shapes = shapes;
        this.screen = screen;
    }

    public void startRotating() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        double alpha = 1f;
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (var s : shapes) {
                //s.rotateX(alpha);
                s.rotateY(alpha);
                s.rotateZ(alpha);
            }
            screen.repaint();
        }
    }
    
}
