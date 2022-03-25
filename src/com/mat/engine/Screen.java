package com.mat.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen extends JPanel {
    private JFrame frame;
    private Projector projector = new Projector(90, 1000f, 1f);
    private List<Triangle> shapes;
    private Vertice central;

    public Screen(List<Triangle> shapes, Vertice central) {
        this.shapes = shapes;
        this.central = central;
        setBackground(Color.BLACK);
        frame = new JFrame("Engine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(700, 700);
        frame.setVisible(true);
        frame.add(this);
    }

    public void startRotating() {
        Cube cube = new Cube(shapes, this, central);
        cube.startRotating();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        double frameHeight = (double) frame.getHeight();
        double frameWidth = (double) frame.getWidth();
        double res = frameHeight / frameWidth;
        
        g.setColor(Color.WHITE);

        for (Triangle sh : shapes) {
            var vertices = sh.projectedVertices(projector, res);
            for (int i = 0; i < vertices.size(); i++) {
                double x1 = vertices.get(i).x;
                double y1 = vertices.get(i).y * -1;
                double x2 = 0;
                double y2 = 0;
                if (i == vertices.size() - 1) {
                    x2 = vertices.get(0).x;
                    y2 = vertices.get(0).y * -1;
                } else {
                    x2 = vertices.get(i + 1).x;
                    y2 = vertices.get(i + 1).y * -1;
                }
                
                if (((x1 > -1f && x1 < 1f) && (y1 > -1f && y1 < 1f)) || ((x2 > -1f && x2 < 1f) && (y2 > -1f && y2 < 1f))) {
                    
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
}
