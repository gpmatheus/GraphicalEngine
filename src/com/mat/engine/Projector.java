package com.mat.engine;

import static java.lang.Math.*;
import com.matsol.mat.Matrix;

public class Projector {
    
    private double fov;
    private double zFar;
    private double zNear;

    public Projector(double fov, double zFar, double zNear) {
        this.fov = fov;
        this.zFar = zFar;
        this.zNear = zNear;
    }

    public void setFov(int fov) {
        this.fov = fov;
    }

    public double getFov() {
        return fov;
    }

    public double getZFar() {
        return zFar;
    }

    public double getZNear() {
        return zNear;
    }

    private double[][] projectionMatrix;
    public Vertice project(Vertice vertice, double res) {  
        double fovScale = 1 / tan(fov / 2);
        double zNormalized = zFar / (zFar - zNear);
        double offset = (zFar * zNear) / (zFar - zNear);

        projectionMatrix = new double[][] {
            {res * fovScale, 0f, 0f, 0f},
            {0f, fovScale, 0f, 0f},
            {0f, 0f, zNormalized, 1f},
            {0f, 0f, offset, 0f}
        };

        var matrix = vertice.toMatrix();
        var projectedMatrix = Matrix.matmul(projectionMatrix, matrix);
        double rest = projectedMatrix[3][0];
        Vertice finalVertice = new Vertice(projectedMatrix[0][0], projectedMatrix[1][0], projectedMatrix[2][0]);
        finalVertice.x /= rest;
        finalVertice.y /= rest;
        finalVertice.z /= rest;
        return finalVertice;
    }
}
