package com.mat.engine;

import static com.matsol.mat.Matrix.*;

public class Vertice extends Coordinates3d {

    public Vertice(double x, double y, double z) {
        super(x, y, z);
    }

    public double[][] toMatrix() {
        return new double[][] {{x}, {y}, {z}, {1f}};
    }

    private Vector getAsVector() {
        return new Vector(x, y, z);
    }

    public Vector vectorTo(Vertice vertice) {
        double x = vertice.x - this.x;
        double y = vertice.y - this.y;
        double z = vertice.z - this.z;
        return new Vector(x, y, z);
    }

    public Vertice sumWithVector(Vector vector) {
        double x = this.x + vector.x;
        double y = this.y + vector.y;
        double z = this.z + vector.z;
        return new Vertice(x, y, z);
    }

    public void rotateX(double alpha, Vertice central) {

        Vector vector = central.getAsVector();
        move(vector.getOpositeVector());
        translateX(alpha);
        move(vector);
    }

    public void translateX(double alpha) {
        double[][] rotateXMatrix = {
            {1, 0, 0, 0},
            {0, Math.cos(Math.toRadians(alpha)), Math.sin(Math.toRadians(alpha)), 0},
            {0, -Math.sin(Math.toRadians(alpha)), Math.cos(Math.toRadians(alpha)), 0},
            {0, 0, 0, 1}
        };

        double[][] result = matmul(rotateXMatrix, toMatrix());
        x = result[0][0];
        y = result[1][0];
        z = result[2][0];
    }

    public void rotateY(double alpha, Vertice central) {

        Vector vector = central.getAsVector();
        move(vector.getOpositeVector());
        translateY(alpha);
        move(vector);
    }

    public void translateY(double alpha) {
        double[][] rotateYMatrix = {
            {Math.cos(Math.toRadians(alpha)), 0f, -Math.sin(Math.toRadians(alpha)), 0},
            {0, 1, 0, 0},
            {Math.sin(Math.toRadians(alpha)), 0, Math.cos(Math.toRadians(alpha)), 0},
            {0, 0, 0, 1}
        };

        double[][] result = matmul(rotateYMatrix, toMatrix());
        x = result[0][0];
        y = result[1][0];
        z = result[2][0];
    }

    public void rotateZ(double alpha, Vertice central) {

        Vector vector = central.getAsVector();
        move(vector.getOpositeVector());
        translateZ(alpha);
        move(vector);
    }

    public void translateZ(double alpha) {
        double[][] rotateZMatrix = {
            {Math.cos(Math.toRadians(alpha)), Math.sin(Math.toRadians(alpha)), 0, 0},
            {-Math.sin(Math.toRadians(alpha)), Math.cos(Math.toRadians(alpha)), 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };

        double[][] result = matmul(rotateZMatrix, toMatrix());
        x = result[0][0];
        y = result[1][0];
        z = result[2][0];
    }

    public void move(Vector vector) {
        double[][] translationMathix = {
            {1f, 0f, 0f, vector.getX()},
            {0f, 1f, 0f, vector.getY()},
            {0f, 0f, 1f, vector.getZ()},
            {0f, 0f, 0f, 1f}
        };

        double[][] result = matmul(translationMathix, toMatrix());
        x = result[0][0];
        y = result[1][0];
        z = result[2][0];
    }
}
