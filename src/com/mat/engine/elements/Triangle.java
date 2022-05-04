package com.mat.engine.elements;

public class Triangle {
    /**
     * são os três vertices dp triângulo
     */
    private Vertice[] vertices = new Vertice[3];

    public Triangle(Vertice vertice1, Vertice vertice2, Vertice vertice3) {
        vertices[0] = vertice1;
        vertices[1] = vertice2;
        vertices[2] = vertice3;
    }

    /**
     * retorna o vertice principal, ou seja o que começa o triângulo.
     */

    public Vertice getBaseVertice() {
        return vertices[0];
    }

    public Vertice[] getVertices() {
        return vertices;
    }

    /**
     * retorna o vertice que fica no centro do triangulo
     */

    public Vertice getCenterVertice() {
        Vector opositeVector = vertices[1].vectorTo(vertices[2]);
        opositeVector.scale(.5);
        Vertice opositeVertice = vertices[1].sumWithVector(opositeVector);
        Vector crossingVector = getBaseVertice().vectorTo(opositeVertice);
        crossingVector.scale(2f / 3f);
        return getBaseVertice().sumWithVector(crossingVector);
    }

    /**
     * returna o vetor normal, ou seja, o que aponta perpenducularmente à superficie que deve ser vista do triangulo
     */

    public Vector getPerpendicularVector() {
        Vertice baseVertice = getBaseVertice();
        Vector u = baseVertice.vectorTo(vertices[1]);
        Vector v = baseVertice.vectorTo(vertices[2]);
        double x = u.getY() * v.getZ() - u.getZ() * v.getY();
        double y = u.getZ() * v.getX() - u.getX() * v.getZ();
        double z = u.getX() * v.getY() - u.getY() * v.getX();
        return new Vector(x, y, z);
    }

    /**
     * executa a matrix em cada um dos vertices do triangulo
     */

    public void executeMovement(double[][] matrix) {
        for (Vertice v : vertices)
            v.executeMovement(matrix);
    }

    public double[] getXValues() {
        return new double[] {vertices[0].getX(), vertices[1].getX(), vertices[2].getX()};
    }

    public double[] getYValues() {
        return new double[] {vertices[0].getY(), vertices[1].getY(), vertices[2].getY()};
    }

    public double[] getZValues() {
        return new double[] {vertices[0].getZ(), vertices[1].getZ(), vertices[2].getZ()};
    }

}
