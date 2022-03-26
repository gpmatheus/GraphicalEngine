package com.mat.engine;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    private Vertice[] vertices = new Vertice[3];
    private List<Vertice> projectedVertices;

    public Triangle(Vertice vertice1, Vertice vertice2, Vertice vertice3) {
        vertices[0] = vertice1;
        vertices[1] = vertice2;
        vertices[2] = vertice3;
    }

    public void rotateX(double alpha, Vertice central) {
        projectedVertices = null;
        for (Vertice v : vertices) {
            v.rotateX(alpha, central);
        }
    }

    public void translateX(double alpha) {
        projectedVertices = null;
        for (Vertice v : vertices) {
            v.translateX(alpha);
        }
    }

    public void rotateY(double alpha, Vertice central) {
        projectedVertices = null;
        for (Vertice v : vertices) {
            v.rotateY(alpha, central);
        }
    }

    public void translateY(double alpha) {
        projectedVertices = null;
        for (Vertice v : vertices) {
            v.translateY(alpha);
        }
    }

    public void rotateZ(double alpha, Vertice central) {
        projectedVertices = null;
        for (Vertice v : vertices) {
            v.rotateZ(alpha, central);
        }
    }

    public void translateZ(double alpha) {
        projectedVertices = null;
        for (Vertice v : vertices) {
            v.translateZ(alpha);
        }
    }

    public void move(double x, double y, double z) {
        projectedVertices = null;
        for (Vertice v : vertices) {
            v.move(new Vertice(x, y, z));
        }
    }

    public List<Vertice> projectedVertices(Projector projector, double res) {
        if (projectedVertices != null)
            return projectedVertices;
        projectedVertices = new ArrayList<>();
        for (var vertice : vertices) {
            projectedVertices.add(projector.project(vertice, res));
        }
        return projectedVertices;
    }
}
