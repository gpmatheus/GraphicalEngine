package com.mat.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen extends JPanel {
    private JFrame frame;
    private Projector projector = new Projector(90, 1000f, 1f);
    private List<Triangle> triangles;
    private Vertice central;

    public Screen(List<Triangle> shapes, Vertice central) {
        this.triangles = shapes;
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
        Object cube = new Object(triangles, this, central);
        cube.startRotating();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        double frameHeight = (double) frame.getHeight();
        double frameWidth = (double) frame.getWidth();
        double res = frameHeight / frameWidth;
        paintDots(g, frameHeight, frameWidth, res);
    }

    private void paintDots(Graphics g, double frameHeight, double frameWidth, double res) {
        g.setColor(Color.GREEN);

        for (Triangle tr : triangles) {
            var vertices = tr.projectedVertices(projector, res);
            for (int i = 0; i < vertices.size(); i++) {
                double x = vertices.get(i).x;
                double y = vertices.get(i).y * -1;
                x += 1f;
                y += 1f;
                x *= frameWidth / 2;
                y *= frameHeight / 2;
                g.drawLine((int) x, (int) y, (int) x, (int) y);
            }
        }
    }
}
