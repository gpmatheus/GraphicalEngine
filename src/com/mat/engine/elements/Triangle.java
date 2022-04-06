package com.mat.engine.elements;

import com.mat.engine.Projector;

public class Triangle {
    private Vertice[] vertices = new Vertice[3];

    public Triangle(Vertice vertice1, Vertice vertice2, Vertice vertice3) {
        vertices[0] = vertice1;
        vertices[1] = vertice2;
        vertices[2] = vertice3;
    }

    public Vertice getBaseVertice() {
        return vertices[0];
    }

    public Vertice getCenterVertice() {
        Vector opositeVector = vertices[1].vectorTo(vertices[2]);
        opositeVector.scale(.5);
        Vertice opositeVertice = vertices[1].sumWithVector(opositeVector);
        Vector crossingVector = getBaseVertice().vectorTo(opositeVertice);
        crossingVector.scale(2f / 3f);
        return getBaseVertice().sumWithVector(crossingVector);
    }

    public Vector getPerpendicularVector() {
        Vertice baseVertice = getBaseVertice();
        Vector u = baseVertice.vectorTo(vertices[2]);
        Vector v = baseVertice.vectorTo(vertices[1]);
        double x = u.getY() * v.getZ() - u.getZ() * v.getY();
        double y = u.getZ() * v.getX() - u.getX() * v.getZ();
        double z = u.getX() * v.getY() - u.getY() * v.getX();
        return new Vector(x, y, z);
    }

    public void rotateX(double alpha, Vector central) {
        for (Vertice v : vertices) {
            v.rotateX(alpha, central);
        }
    }

    public void translateX(double alpha) {
        for (Vertice v : vertices) {
            v.translateX(alpha);
        }
    }

    public void rotateY(double alpha, Vector position) {
        for (Vertice v : vertices) {
            v.rotateY(alpha, position);
        }
    }

    public void translateY(double alpha) {
        for (Vertice v : vertices) {
            v.translateY(alpha);
        }
    }

    public void rotateZ(double alpha, Vector central) {
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
            v.move(new Vector(x, y, z));
        }
    }

    public Vertice[] projectedVertices(Projector projector, double res) {
        Vertice[] projectedVertices = new Vertice[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            projectedVertices[i] = projector.project(vertices[i], res);
        }
        return projectedVertices;
    }

    public Vertice getPojectedPerpendicularVertice(Projector projector, double res, Vertice vertice) {
        Vector perpendicularVector = getPerpendicularVector();
        perpendicularVector.normalize(1f);
        Vertice resultingVertice = vertice.sumWithVector(perpendicularVector);
        return projector.project(resultingVertice, res);
    }

    public Vertice getProjectedCenterVertice(Projector projector, double res) {
        return projector.project(getCenterVertice(), res);
    }

    public Vertice getProjectedBaseVertice(Projector projector, double res) {
        return projector.project(getBaseVertice(), res);
    }
}
