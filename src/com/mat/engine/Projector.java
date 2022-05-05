package com.mat.engine;

import static java.lang.Math.*;

import com.mat.engine.elements.Vertice;
import com.matsol.mat.Matrix;

/**
 * essa classe é um projetos, ou seja, transforma um coordenada em 3d em um em 2d para ser apresentada na tela
 * ela leva em consideração a distância do objeto.
 */

public class Projector {
    
    private double fov;
    private double zFar;
    private double zNear;

    private double[][] projectionMatrix;

    public Projector(double fov, double zFar, double zNear) {
        this.fov = fov;
        this.zFar = zFar;
        this.zNear = zNear;
    }

    public void setFov(double fov) {
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

    public Vertice project(Vertice vertice, double res) { 
        double fovScale = 1f / tan(toRadians(fov / 2));
        double zNormalized = zFar / (zFar - zNear);
        double offset = (-zFar * zNear) / (zFar - zNear);

        projectionMatrix = new double[][] {
            {res * fovScale, 0f, 0f, 0f},
            {0f, fovScale, 0f, 0f},
            {0f, 0f, zNormalized, offset},
            {0f, 0f, 1f, 0f}
        };

        var matrix = vertice.toMatrix();
        var projectedMatrix = Matrix.matmul(projectionMatrix, matrix);
        double rest = projectedMatrix[3][0];
        Vertice finalVertice = new Vertice(projectedMatrix[0][0] / rest, projectedMatrix[1][0] / rest, projectedMatrix[2][0] / rest);
        return finalVertice;
    }
}
