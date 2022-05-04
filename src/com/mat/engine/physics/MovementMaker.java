package com.mat.engine.physics;

import com.mat.engine.Object;
import com.mat.engine.elements.Vector;

//essa classe está somente fazendo a rotação para fins de teste
public class MovementMaker implements Runnable {

    private Thread thread;
    private Object object;

    public MovementMaker(Object object) {
        this.object = object;
    }

    public void startRunning() {
        thread = new Thread(this);
        thread.start();
    }

    //TODO métodos somente para testar o funcionamento do programa
    private void startSpinning() {
        Vector vector = new Vector(0f, 0f, 7f);
        float alpha = 0f;
        while (true) {
            try {
                Thread.sleep(50);
            } catch (Exception e) {}
            object.rotateY(alpha);
            object.move(vector);
            try {
                object.applyModifications();
            } catch (Exception e) {}
            alpha += 1f;
            alpha %= 360;
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        startSpinning();
    }
    
}
