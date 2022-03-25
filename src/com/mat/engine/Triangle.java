package com.mat.engine;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    private Vertice[] vertices = new Vertice[3];

    public Triangle(Vertice vertice1, Vertice vertice2, Vertice vertice3) {
        vertices[0] = vertice1;
        vertices[1] = vertice2;
        vertices[2] = vertice3;
    }

    public void rotateX(double alpha, Vertice central) {
        for (Vertice v : vertices) {
            v.rotateX(alpha, central);
        }
    }

    public void translateX(double alpha) {
        for (Vertice v : vertices) {
            v.translateX(alpha);
        }
    }

    public void rotateY(double alpha, Vertice central) {
        for (Vertice v : vertices) {
            v.rotateY(alpha, central);
        }
    }

    public void translateY(double alpha) {
        for (Vertice v : vertices) {
            v.translateY(alpha);
        }
    }

    public void rotateZ(double alpha, Vertice central) {
        for (Vertice v : vertices) {
            v.rotateZ(alpha, central);
        }
    }

    public void translateZ(double alpha) {
        for (Vertice v : vertices) {
            v.translateZ(alpha);
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
