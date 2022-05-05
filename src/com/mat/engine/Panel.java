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

        paintLines(g, frameHeight, frameWidth, res);
    }

    private void paintLines(Graphics g, double panelHeight, double panelWidth, double res) {

        for (Object o : objects) {
            for (Triangle tr : o.getTriangles()) {
                g.setColor(Color.WHITE);
                Vector centerVector = tr.getBaseVertice().asVector().getOpositeVector(); // pode ser qualquer uma dos vertices do triangulo pode ser usado, não precisa ser o vertice central
                Vector normalVector = tr.getPerpendicularVector();
                if (centerVector.dotProduct(normalVector) > 0f) {
                    Vertice[] vertices = tr.getVertices();
                    for (int i = 0; i < vertices.length; i++) {
                        Vertice projected1 = projector.project(vertices[i], res);
                        double x1 = projected1.getX();
                        double y1 = projected1.getY() * -1;
                        int index = i + 1;
                        index %= vertices.length;
                        Vertice projected2 = projector.project(vertices[index], res);
                        double x2 = projected2.getX();
                        double y2 = projected2.getY() * -1;
                        x1 += 1f;
                        y1 += 1f;
                        x1 *= panelWidth / 2;
                        y1 *= panelHeight / 2;
                        x2 += 1f;
                        y2 += 1f;
                        x2 *= panelWidth / 2;
                        y2 *= panelHeight / 2;
                        g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
                    }
                }

                /*
                g.setColor(Color.BLUE);
                Vertice projectedCenterVertice = tr.getProjectedCenterVertice(projector, res);
                Vertice centerVertice = tr.getCenterVertice();
                Vertice perpendicularVertice = tr.getPojectedPerpendicularVertice(projector, res, centerVertice);
                double x1 = projectedCenterVertice.getX();
                double y1 = projectedCenterVertice.getY() * -1;
                double x2 = perpendicularVertice.getX();
                double y2 = perpendicularVertice.getY() * -1;
                x1 += 1f;
                y1 += 1f;
                x1 *= panelWidth / 2;
                y1 *= panelHeight / 2;
                x2 += 1f;
                y2 += 1f;
                x2 *= panelWidth / 2;
                y2 *= panelHeight / 2;
                g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
                */
            }
        }
    }
}
