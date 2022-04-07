package com.mat.engine;

import java.awt.Color;
import java.awt.Graphics;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.mat.engine.elements.Triangle;
import com.mat.engine.elements.Vertice;

public class Panel extends JPanel {

    private static Panel panel;
    private Projector projector = new Projector(30f, 1000f, 1f);
    private List<Object> objects = new ArrayList<>();

    public static Panel getPanel(Object object) {
        if (panel == null) {
            panel = new Panel();
        }
        panel.addObject(object);
        return panel;
    }

    public static Panel getPanel() {
        if (panel == null) {
            panel = new Panel();
        }
        return panel;
    }

    private Panel() {
        setBackground(Color.BLACK);
    }

    public void setProjectorFov(double fov) {
        projector.setFov(fov);
    }

    private void addObject(Object object) {
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

    private void paintLines(Graphics g, double frameHeight, double frameWidth, double res) {

        for (Object o : objects) {
            for (Triangle tr : o.getTriangles()) {
                g.setColor(Color.WHITE);
                var vertices = tr.projectedVertices(projector, res);
                for (int i = 0; i < vertices.length; i++) {
                    double x1 = vertices[i].getX();
                    double y1 = vertices[i].getY() * -1;
                    int index = i + 1;
                    index %= vertices.length;
                    double x2 = vertices[index].getX();
                    double y2 = vertices[index].getY() * -1;
                    x1 += 1f;
                    y1 += 1f;
                    x1 *= frameWidth / 2;
                    y1 *= frameHeight / 2;
                    x2 += 1f;
                    y2 += 1f;
                    x2 *= frameWidth / 2;
                    y2 *= frameHeight / 2;
                    g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
                }
                
                
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
                x1 *= frameWidth / 2;
                y1 *= frameHeight / 2;
                x2 += 1f;
                y2 += 1f;
                x2 *= frameWidth / 2;
                y2 *= frameHeight / 2;
                g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
            }
        }
    }
}
