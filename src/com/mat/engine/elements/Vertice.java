package com.mat.engine.elements;

import static com.matsol.mat.Matrix.*;

import com.mat.engine.elements.baseElements.Coordinates3d;

public class Vertice extends Coordinates3d {

    private Coordinates3d baseCoordinate;

    public Vertice(double x, double y, double z) {
        super(x, y, z);
        this.baseCoordinate = new Coordinates3d(x, y, z);
    }

    public Vector asVector() {
        return new Vector(x, y, z);
    }

    public Vector vectorTo(Vertice vertice) {
        double x = vertice.x - this.x;
        double y = vertice.y - this.y;
        double z = vertice.z - this.z;
        return new Vector(x, y, z);
    }

    public Vertice sumWithVector(Vector vector) {
        double x = this.x + vector.getX();
        double y = this.y + vector.getY();
        double z = this.z + vector.getZ();

        return new Vertice(x, y, z);
    }

    public void executeMovement(double[][] matrix) {
        double[][] resultingMatrix = matmul(matrix, baseCoordinate.toMatrix());
        x = resultingMatrix[0][0];
        y = resultingMatrix[1][0];
        z = resultingMatrix[2][0];
    }
}
