package com.mat.engine;

public class Coordinates3d extends Coordinates2d {
    protected double z;

    public Coordinates3d(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    @Override
    public double[][] toMatrix() {
        return new double[][] {{x}, {y}, {z}, {1f}};
    }
}
