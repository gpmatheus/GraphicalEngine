package com.mat.engine.elements;

import com.mat.engine.elements.baseElements.Coordinates3d;
import static java.lang.Math.*;

public class Vector extends Coordinates3d {
    
    public Vector(double x, double y, double z) {
        super(x, y, z);
    }


    /**
     * retorna o valor do comprimento do vetor
     */
    public double getVectorModule() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    /**
     * retorna um vetor com a mesma direção e módulo mas sentido oposto
     */
    public Vector getOpositeVector() {
        return new Vector(x * -1, y * -1, z * -1);
    }

    /**
     * muda o tamanho do vetor, mantendo a mesma direção e sentido
     */

    public void scale(double value) {
        this.x *= value;
        this.y *= value;
        this.z *= value;
    }

    /**
     * soma o vetor atual com o vetor parâmetro 
     */

    public void sum(Vector vector) {
        this.x += vector.x;
        this.y += vector.y;
        this.z += vector.z;
    }

    /**
     * retorna uma soma de vetores
     */

    public Vector getSum(Vector vector) {
        return new Vector(this.x + vector.x, this.y + vector.y, this.z + vector.z);
    }

    /**
     * retorna o dot product
     */

    public double dotProduct(Vector vector) {
        return this.x * vector.getX() + this.y * vector.getY() + this.z * vector.getZ();
    }

    /**
     * return o angulo entre os vetores em radianos
     */

    public double angleBetween(Vector vector) {
        return acos(dotProduct(vector) / (getVectorModule() * vector.getVectorModule()));
    }

    /**
     * retorna o angulo entre os dois vetores em raios
     */
    public double angleBetweenInDegree(Vector vector) {
        return toDegrees(angleBetween(vector));
    }

    /**
     * normaliza o vetor em relação ao parâmetro.
     * o parâmetro (sendo double) representa um porcentagem, se multiplicado por 100
     * @param normal
     */

    public void normalize(double normal) {
        double value = normal / getVectorModule();
        scale(value);
    }
}
