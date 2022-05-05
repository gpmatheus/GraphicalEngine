package com.mat.engine.elements;

import static com.matsol.mat.Matrix.*;

import com.mat.engine.elements.baseElements.Coordinates3d;

public class Vertice extends Coordinates3d {

    /**
     * atributo que representa a coordenada inicial do vertice,
     * pois quando forem feitas transformações geométricas no triangulo a qual ele pertence,
     * o vertice não perde a sua coordenada inicial, para que o triangulo não perca o seu formato.
     */
    private Coordinates3d baseCoordinate;

    public Vertice(double x, double y, double z) {
        super(x, y, z);
        this.baseCoordinate = new Coordinates3d(x, y, z);
    }

    /**
     * retorna um vetor com os mesmos valores de x, y e z do Vertice.
     */
    public Vector asVector() {
        return new Vector(x, y, z);
    }

    /**
     * retorna o vertice que aponta do vertice da classe para o vertice parâmetro
     */
    public Vector vectorTo(Vertice vertice) {
        double x = vertice.x - this.x;
        double y = vertice.y - this.y;
        double z = vertice.z - this.z;
        return new Vector(x, y, z);
    }

    /**
     * retorna um vetice resultante da soma do vertice atual com o vetor de parâmetro
     */
    public Vertice sumWithVector(Vector vector) {
        double x = this.x + vector.getX();
        double y = this.y + vector.getY();
        double z = this.z + vector.getZ();
        return new Vertice(x, y, z);
    }

    /**
     * executa uma multiplicação de matrizes e modifica as coordenadas atuais do vertice
     */
    public void executeMovement(double[][] matrix) {
        double[][] resultingMatrix = matmul(matrix, baseCoordinate.toMatrix());
        x = resultingMatrix[0][0];
        y = resultingMatrix[1][0];
        z = resultingMatrix[2][0];
    }
}
