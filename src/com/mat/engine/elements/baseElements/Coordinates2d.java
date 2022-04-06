package com.mat.engine.elements.baseElements;

public class Coordinates2d {
    protected double x;
    protected double y;

    public Coordinates2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double[][] toMatrix() {
        return new double[][]{{x}, {y}, {1f}};
    }
}
