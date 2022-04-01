package com.mat.engine;

import java.util.List;

public class Object implements Runnable {

    private List<Triangle> shapes;
    private Screen screen;
    private Vertice central;

    public Object(List<Triangle> shapes, Screen screen, Vertice central) {
        this.shapes = shapes;
        this.screen = screen;
        this.central = central;
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
            for (var s : shapes) {
                //s.rotateX(alpha, central);
                s.rotateY(alpha, central);
                //s.rotateZ(alpha, central);
                //s.translateX(alpha);
                //s.translateY(alpha);
                //s.translateZ(alpha);
            }
            alpha += 1f;
            alpha %= 360f;

            //System.out.println(alpha);
            screen.repaint();
        }
    }
    
}
