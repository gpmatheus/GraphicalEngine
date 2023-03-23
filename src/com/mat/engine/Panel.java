package com.mat.engine;

import java.awt.Color;
import java.awt.Graphics;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.mat.engine.elements.Triangle;
import com.mat.engine.elements.Vector;
import com.mat.engine.elements.Vertice;

public class Panel extends JPanel {

    /**
     * campo estárico para o padrão singleton
     */
    private static Panel panel;
    private final float INICIAL_FOV = 30f;
    private Projector projector = new Projector(INICIAL_FOV, 1000f, 1f);
    private List<Object> objects = new ArrayList<>();

    /**
     * método estático para o padrão singleton chamado por objetos da classe object
     */
    public static Panel getPanel(Object object) {
        if (panel == null) {
            panel = new Panel();
        }
        panel.addObject(object);
        return panel;
    }

    /**
     * método estático para o padrão singleton 
     */
    public static Panel getPanel() {
        if (panel == null) {
            panel = new Panel();
        }
        return panel;
    }

    private Panel() {
        setBackground(Color.BLACK);
    }

    public float getInicialFov() {
        return INICIAL_FOV;
    }

    public void setProjectorFov(double fov) {
        projector.setFov(fov);
    }

    /**
     * adiciona objeto ao painel para que a classe painel tenha acesso aos atributos da classe Object
     */
    public void addObject(Object object) {
        objects.add(object);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        double frameHeight = (double) this.getHeight();
        double frameWidth = (double) this.getWidth();
        double res = frameHeight / frameWidth;

        paintTriangles(g, frameHeight, frameWidth, res);
    }

    private void paintTriangles(Graphics g, double panelHeight, double panelWidth, double res) {

        for (Object o : objects) {
            for (Triangle tr : o.getTriangles()) {

                Vector centerVector = tr.getBaseVertice().asVector().getOpositeVector();
                Vector normalVector = tr.getPerpendicularVector();
                double dotProduct = centerVector.dotProduct(normalVector);

                if (dotProduct > 0f) {

                    Vertice[] vertices = tr.getVertices();
                    int[] xValues = new int[vertices.length];
                    int[] yValues = new int[vertices.length];

                    Vertice temporaryVertice = null;
                    for (int i = 0; i < vertices.length; i++) {
                        temporaryVertice = projector.project(vertices[i], res);
                        double x = temporaryVertice.getX();
                        double y = temporaryVertice.getY();
                        x += 1f;
                        y += 1f;
                        x *= panelWidth / 2;
                        y *= panelHeight / 2;
                        xValues[i] = (int) x;
                        yValues[i] = (int) y;
                    }

                    /**
                     * nessa parte vou fazer o sombreamento
                     */

                    float grayShade = 150f;
                    
                    //nesse caso, a luz vai estar vindo da câmera
                    //int colorShade = (int) (grayShade * dotProduct + 40f);

                    //nesse caso, a luz vem em raios paralelos de trás da câmera
                    Vector lightVector = new Vector(0f, 0f, -10f);

                    double dProduct = normalVector.dotProduct(lightVector);
                    int colorShade = (int) (Math.abs(dProduct) * grayShade + 40f);


                    Color color = new Color(colorShade, colorShade, colorShade);
                    g.setColor(color);
                    g.fillPolygon(xValues, yValues, vertices.length);

                    g.setColor(Color.GREEN);
                    g.drawPolygon(xValues, yValues, vertices.length);
                    
                }
            }
        }
    }
}
