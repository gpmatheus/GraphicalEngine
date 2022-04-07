package com.mat.engine;

import java.util.List;

import static com.matsol.mat.Matrix.*;
import com.mat.engine.elements.Triangle;
import com.mat.engine.elements.Vector;

public class Object {

    private Panel screen = Panel.getPanel(this);
    private List<Triangle> triangles;
    private double[][] matrix;

    public Object(List<Triangle> triangles) {
        this.triangles = triangles;
    }

    public List<Triangle> getTriangles() {
        return triangles;
    }

    public void rotateX(double alpha) {
        double[][] rotateXMatrix = {
            {1, 0, 0, 0},
            {0, Math.cos(Math.toRadians(alpha)), Math.sin(Math.toRadians(alpha)), 0},
            {0, -Math.sin(Math.toRadians(alpha)), Math.cos(Math.toRadians(alpha)), 0},
            {0, 0, 0, 1}
        };
        stackMatrix(rotateXMatrix);
    }

    public void rotateY(double alpha) {
        double[][] rotateYMatrix = {
            {Math.cos(Math.toRadians(alpha)), 0f, -Math.sin(Math.toRadians(alpha)), 0},
            {0, 1, 0, 0},
            {Math.sin(Math.toRadians(alpha)), 0, Math.cos(Math.toRadians(alpha)), 0},
            {0, 0, 0, 1}
        };
        stackMatrix(rotateYMatrix);
    }

    public void rotateZ(double alpha) {
        double[][] rotateZMatrix = {
            {Math.cos(Math.toRadians(alpha)), Math.sin(Math.toRadians(alpha)), 0, 0},
            {-Math.sin(Math.toRadians(alpha)), Math.cos(Math.toRadians(alpha)), 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };
        stackMatrix(rotateZMatrix);
    }

    public void move(Vector movementVector) {
        double[][] movingMatrix = {
            {1f, 0f, 0f, movementVector.getX()},
            {0f, 1f, 0f, movementVector.getY()},
            {0f, 0f, 1f, movementVector.getZ()},
            {0f, 0f, 0f, 1f}
        };
        stackMatrix(movingMatrix);
    }

    public void scale(double alphaX, double alphaY, double alphaZ) {
        double[][] scaleMatrix = {
            {alphaX, 0f, 0f, 0f},
            {0f, alphaY, 0f, 0f},
            {0f, 0f, alphaZ, 0f},
            {0f, 0f, 0f, 1f}
        };
        stackMatrix(scaleMatrix);
    }

    private void stackMatrix(double[][] modMatrix) {
        if (matrix == null) {
            matrix = modMatrix;
        } else {
            matrix = matmul(modMatrix, matrix);
        }
    }

    public void applyModifications() throws Exception {
        if (matrix == null)
            throw new Exception();
        for (Triangle t : triangles) {
            t.executeMovement(matrix);
        }
        screen.repaint();
        matrix = null;
    }
}
