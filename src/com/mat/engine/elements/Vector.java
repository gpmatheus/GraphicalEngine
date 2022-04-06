package com.mat.engine.elements;

import com.mat.engine.elements.baseElements.Coordinates3d;

public class Vector extends Coordinates3d {
    
    public Vector(double x, double y, double z) {
        super(x, y, z);
    }

    public double getVectorModule() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public Vector getOpositeVector() {
        return new Vector(x * -1, y * -1, z * -1);
    }

    public void scale(double value) {
        this.x *= value;
        this.y *= value;
        this.z *= value;
    }

    public void sum(Vector vector) {
        this.x += vector.x;
        this.y += vector.y;
        this.z += vector.z;
    }

    public Vector getSum(Vector vector) {
        return new Vector(this.x + vector.x, this.y + vector.y, this.z + vector.z);
    }

    public void normalize(double normal) {
        double value = normal / getVectorModule();
        scale(value);
    }
}