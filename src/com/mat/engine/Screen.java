package com.mat.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Screen extends JPanel {
    private JFrame frame;
    private Projector projector = new Projector(30f, 1000f, 1f);
    private List<Triangle> triangles;
    private Vertice central;

    public Screen(List<Triangle> shapes, Vertice central) {
        this.triangles = shapes;
        this.central = central;
        setBackground(Color.BLACK);

        JSlider slider = new JSlider();
        slider.setOrientation(JSlider.VERTICAL);
        slider.setMinimum(45);
        slider.setMaximum(120);
        slider.setValue(45);
        slider.addChangeListener(l -> projector.setFov((double) slider.getValue()));

        frame = new JFrame("Engine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(700, 700);
        frame.setVisible(true);
        frame.add(this, BorderLayout.CENTER);
        frame.add(slider, BorderLayout.EAST);
    }

    public void startRotating() {
        Object cube = new Object(triangles, this, central);
        cube.startRotating();
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

        for (Triangle tr : triangles) {
            g.setColor(Color.WHITE);
            var vertices = tr.projectedVertices(projector, res);
            for (int i = 0; i < vertices.length; i++) {
                double x1 = vertices[i].x;
                double y1 = vertices[i].y;
                int nIndex = i + 1;
                nIndex %= vertices.length;
                double x2 = vertices[nIndex].x;
                double y2 = vertices[nIndex].y;
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
            //Vertice baseVertice = tr.getProjectedBaseVertice(projector, res);
            Vertice centerVertice = tr.getProjectedCenterVertice(projector, res);
            Vertice perpendicularVertice = tr.getPojectedPerpendicularVertice(projector, res, centerVertice);
            double x1 = centerVertice.x;
            double y1 = centerVertice.y;
            double x2 = perpendicularVertice.x;
            double y2 = perpendicularVertice.y;
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
