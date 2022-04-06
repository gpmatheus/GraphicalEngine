package com.mat.engine;

import static com.matsol.mat.Matrix.*;

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
        double x = this.x + vector.x;
        double y = this.y + vector.y;
        double z = this.z + vector.z;
        return new Vertice(x, y, z);
    }

    public void rotateX(double alpha, Vector position) {
        
        double[][] rotateXMatrix = {
            {1, 0, 0, 0},
            {0, Math.cos(Math.toRadians(alpha)), Math.sin(Math.toRadians(alpha)), 0},
            {0, -Math.sin(Math.toRadians(alpha)), Math.cos(Math.toRadians(alpha)), 0},
            {0, 0, 0, 1}
        };

        double[][] result = matmul(rotateXMatrix, baseCoordinate.toMatrix());
        x = result[0][0];
        y = result[1][0];
        z = result[2][0];
        move(position);
    }

    //TODO o translate vai ter que ser modificado depois
    public Vertice translateX(double alpha) {
        double[][] rotateXMatrix = {
            {1, 0, 0, 0},
            {0, Math.cos(Math.toRadians(alpha)), Math.sin(Math.toRadians(alpha)), 0},
            {0, -Math.sin(Math.toRadians(alpha)), Math.cos(Math.toRadians(alpha)), 0},
            {0, 0, 0, 1}
        };

        double[][] result = matmul(rotateXMatrix, toMatrix());
        double x = result[0][0];
        double y = result[1][0];
        double z = result[2][0];
        return new Vertice(x, y, z);
    }

    public void rotateY(double alpha, Vector position) {
        move(position.getOpositeVector());
        Vertice resultingVertice = translateY(alpha);
        this.x = resultingVertice.x;
        this.y = resultingVertice.y;
        this.z = resultingVertice.z;
        move(position);
    }

    public Vertice translateY(double alpha) {
        double[][] rotateYMatrix = {
            {Math.cos(Math.toRadians(alpha)), 0f, -Math.sin(Math.toRadians(alpha)), 0},
            {0, 1, 0, 0},
            {Math.sin(Math.toRadians(alpha)), 0, Math.cos(Math.toRadians(alpha)), 0},
            {0, 0, 0, 1}
        };
        double[][] result = matmul(rotateYMatrix, toMatrix());
        double x = result[0][0];
        double y = result[1][0];
        double z = result[2][0];
        return new Vertice(x, y, z);
    }

    public void rotateZ(double alpha, Vector position) {
        move(position.getOpositeVector());
        Vertice resultingVertice = translateZ(alpha);
        this.x = resultingVertice.x;
        this.y = resultingVertice.y;
        this.z = resultingVertice.z;
        move(position);
    }

    public Vertice translateZ(double alpha) {
        double[][] rotateZMatrix = {
            {Math.cos(Math.toRadians(alpha)), Math.sin(Math.toRadians(alpha)), 0, 0},
            {-Math.sin(Math.toRadians(alpha)), Math.cos(Math.toRadians(alpha)), 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };

        double[][] result = matmul(rotateZMatrix, toMatrix());
        double x = result[0][0];
        double y = result[1][0];
        double z = result[2][0];
        return new Vertice(x, y, z);
    }

    //TODO está com bug porque tem está movendo o vertice em vez da coordenada base, então está fazendo transçação em vez de rotação

    public void move(Vector vector) {
        double[][] movingMatrix = {
            {1f, 0f, 0f, vector.getX()},
            {0f, 1f, 0f, vector.getY()},
            {0f, 0f, 1f, vector.getZ()},
            {0f, 0f, 0f, 1f}
        };

        double[][] result = matmul(movingMatrix, toMatrix());
        x = result[0][0];
        y = result[1][0];
        z = result[2][0];

        //TODO teste
        //System.out.println(x + "  " + y + "  " + z);
    }
}
