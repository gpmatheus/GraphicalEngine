package com.mat.engine;

import java.util.List;

import static com.matsol.mat.Matrix.*;
import com.mat.engine.elements.Triangle;
import com.mat.engine.elements.Vector;

/**
 * essa classe representa um objeto qualquer que pode ser formado por um ou mais triangulos
 */

public class Object {

    private List<Triangle> triangles;

    /**
     * a matrix que recebe as transformações geométricas
     */
    private double[][] matrix;

    public Object(List<Triangle> triangles) {
        this.triangles = triangles;
    }

    public List<Triangle> getTriangles() {
        return triangles;
    }

    /**
     * adiciona a transformação geométrica de rotação do eixo x do objeto.
     * ele na verdade faz um translação em torno do ponto central do espaço.
     */

    public void rotateX(double alpha) {
        double[][] rotateXMatrix = {
            {1, 0, 0, 0},
            {0, Math.cos(Math.toRadians(alpha)), Math.sin(Math.toRadians(alpha)), 0},
            {0, -Math.sin(Math.toRadians(alpha)), Math.cos(Math.toRadians(alpha)), 0},
            {0, 0, 0, 1}
        };
        stackMatrix(rotateXMatrix);
    }

    /**
     * adiciona a transformação geométrica de rotação do eixo y do objeto.
     * ele na verdade faz um translação em torno do ponto central do espaço.
     */

    public void rotateY(double alpha) {
        double[][] rotateYMatrix = {
            {Math.cos(Math.toRadians(alpha)), 0f, -Math.sin(Math.toRadians(alpha)), 0},
            {0, 1, 0, 0},
            {Math.sin(Math.toRadians(alpha)), 0, Math.cos(Math.toRadians(alpha)), 0},
            {0, 0, 0, 1}
        };
        stackMatrix(rotateYMatrix);
    }

    /**
     * adiciona a transformação geométrica de rotação do eixo z do objeto.
     * ele na verdade faz um translação em torno do ponto central do espaço.
     */

    public void rotateZ(double alpha) {
        double[][] rotateZMatrix = {
            {Math.cos(Math.toRadians(alpha)), Math.sin(Math.toRadians(alpha)), 0, 0},
            {-Math.sin(Math.toRadians(alpha)), Math.cos(Math.toRadians(alpha)), 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };
        stackMatrix(rotateZMatrix);
    }

    /**
     * faz a transformação geométrica de translação.
     * ele move o objeto com o vetor de movimento
     */

    public void move(Vector movementVector) {
        double[][] movingMatrix = {
            {1f, 0f, 0f, movementVector.getX()},
            {0f, 1f, 0f, movementVector.getY()},
            {0f, 0f, 1f, movementVector.getZ()},
            {0f, 0f, 0f, 1f}
        };
        stackMatrix(movingMatrix);
    }

    /**
     * transforma a proposção do objeto, no eixo x, y e z.
     * essa transformação pode deixar o objeto mais largo ou alto ou comprido
     */

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

    /**
     * aplica as modificações ao objeto.
     * também deixa a matrix como nula.
     */

    public void applyModifications() throws Exception {
        if (matrix == null)
            throw new Exception();
        for (Triangle t : triangles) {
            t.executeMovement(matrix);
        }
        matrix = null;
    }
}
