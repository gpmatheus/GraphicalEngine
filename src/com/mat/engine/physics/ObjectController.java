package com.mat.engine.physics;

import com.mat.engine.Object;
import com.mat.engine.Panel;
import com.mat.engine.elements.Vector;

public class ObjectController implements Runnable {
    /**
     * esse campo é o painel no qual os objetos devem ser pintados.
     * ele deve ser um atributo dessa classe, pois quando o objeto sofre modificações,
     * ele deve repintar o painel
     */
    private Panel panel = Panel.getPanel();
    
    private Object object;

    private Vector deslocation;
    private double angleX;
    private double angleY;
    private double angleZ;
    private double proportionX = 1f;
    private double proportionY = 1f;
    private double proportionZ = 1f;

    public ObjectController(Object object) {
        this.object = object;
        panel.addObject(object);
    }

    public void startRunning() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        deslocation = new Vector(0f, 0f, 6f);
        while (true) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            /**
             * modificar proporções
             */

            object.scale(proportionX, proportionY, proportionZ);
            if (proportionX < 1f) {
                proportionX += .01f;
            } else if (proportionX > 2f){
                proportionX -= .01f;
            }

            /**
             * modificar angulos
             */

            object.rotateX(angleX);
            angleX += 1f;
            angleX %= 360;
            object.rotateY(angleY);
            angleY += 1f;
            angleY %= 360;
            object.rotateZ(angleZ);
            angleZ += 1f;
            angleZ %= 360;

            /**
             * modificar local
             */
            object.move(deslocation);

            try {
                object.applyModifications();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            panel.repaint();
        }
    }


}
