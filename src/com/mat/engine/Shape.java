package com.mat.engine;

import java.util.ArrayList;
import java.util.List;

public class Shape {
    private Vertice[] vertices;
    private Vertice central;
    private boolean[][] graphMatrix;

    public Shape(Vertice[] vertices, Vertice central) {
        this.vertices = vertices;
        this.central = central;
        int len = vertices.length;
        graphMatrix = new boolean[len][len];
    }

    public void makeDefaultGraph() {
        for (int i = 0; i < graphMatrix.length; i++) {
            if (i == graphMatrix.length - 1)
                graphMatrix[0][i] = true;
            else
                graphMatrix[i + 1][i] = true;
        }
    }

    public boolean[][] getGraphMatrix() {
        return graphMatrix;
    }

    public void rotateX(double alpha) {
        for (Vertice v : vertices) {
            v.rotateX(alpha, central);
        }
    }

    public void rotateY(double alpha) {
        for (Vertice v : vertices) {
            v.rotateY(alpha, central);
        }
    }

    public void rotateZ(double alpha) {
        for (Vertice v : vertices) {
            v.rotateZ(alpha, central);
        }
    }

    public void move(double x, double y, double z) {
        for (Vertice v : vertices) {
            v.move(new Vertice(x, y, z));
        }
    }

    public List<Vertice> projectedVertices(Projector projector, double res) {
        List<Vertice> projectedVertices = new ArrayList<>();
        for (var vertice : vertices) {
            projectedVertices.add(projector.project(vertice, res));
        }
        return projectedVertices;
    }
}
