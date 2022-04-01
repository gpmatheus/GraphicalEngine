package com.mat.engine;

public class Coordinates3d {
    protected double x;
    protected double y;
    protected double z;

    public Coordinates3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
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

    public double[][] toMatrix() {
        return new double[][] {{x}, {y}, {z}, {1f}};
    }
}
