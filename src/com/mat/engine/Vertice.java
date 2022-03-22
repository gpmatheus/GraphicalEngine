package com.mat.engine;

import static com.matsol.mat.Matrix.*;

public class Vertice {

    //está publico somente para testar
    public double x;
    public double y;
    public double z;

    public Vertice(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double[][] toMatrix() {
        return new double[][] {{x}, {y}, {z}, {1f}};
    }

    public void rotateX(double alpha, Vertice central) {

        double[][] rotateXMatrix = {
            {1, 0, 0, 0},
            {0, Math.cos(Math.toRadians(alpha)), Math.sin(Math.toRadians(alpha)), 0},
            {0, -Math.sin(Math.toRadians(alpha)), Math.cos(Math.toRadians(alpha)), 0},
            {0, 0, 0, 1}
        };

        //tem bug nessas partes do código
        move(central);
        double[][] result = matmul(rotateXMatrix, toMatrix());
        x = result[0][0];
        y = result[1][0];
        z = result[2][0];
        move(new Vertice(central.x * -1, central.y * -1, central.z * -1));
    }

    public void rotateY(double alpha, Vertice central) {
        double[][] rotateYMatrix = {
            {Math.cos(Math.toRadians(alpha)), 0f, -Math.sin(Math.toRadians(alpha)), 0},
            {0, 1, 0, 0},
            {Math.sin(Math.toRadians(alpha)), 0, Math.cos(Math.toRadians(alpha)), 0},
            {0, 0, 0, 1}
        };

        move(central);
        double[][] result = matmul(rotateYMatrix, toMatrix());
        x = result[0][0];
        y = result[1][0];
        z = result[2][0];
        move(new Vertice(central.x * -1, central.y * -1, central.z * -1));
    }

    public void rotateZ(double alpha, Vertice central) {
        double[][] rotateZMatrix = {
            {Math.cos(Math.toRadians(alpha)), Math.sin(Math.toRadians(alpha)), 0, 0},
            {-Math.sin(Math.toRadians(alpha)), Math.cos(Math.toRadians(alpha)), 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };

        move(central);
        double[][] result = matmul(rotateZMatrix, toMatrix());
        x = result[0][0];
        y = result[1][0];
        z = result[2][0];
        move(new Vertice(central.x * -1, central.y * -1, central.z * -1));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void move(Vertice vector) {
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
