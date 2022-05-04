package com.mat.engine;

import java.util.List;

import com.mat.engine.elements.Triangle;
import com.mat.engine.elements.Vertice;
import com.mat.engine.physics.MovementMaker;

import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {

        Vertice vertice1;
        Vertice vertice2;
        Vertice vertice3;

        List<Triangle> triangles = new ArrayList<>();

        vertice1 = new Vertice(-1f, -1f, -1f);
        vertice2 = new Vertice(1f, -1f, -1f);
        vertice3 = new Vertice(1f, -1f, 1f);
        triangles.add(new Triangle(vertice1, vertice2, vertice3));

        vertice1 = new Vertice(-1f, -1f, -1f);
        vertice2 = new Vertice(1f, 1f, -1f);
        vertice3 = new Vertice(1f, -1f, -1f);
        triangles.add(new Triangle(vertice1, vertice2, vertice3));

        vertice1 = new Vertice(1f, -1f, -1f);
        vertice2 = new Vertice(1f, 1f, -1f);
        vertice3 = new Vertice(1f, -1f, 1f);
        triangles.add(new Triangle(vertice1, vertice2, vertice3));

        vertice1 = new Vertice(1f, -1f, 1f);
        vertice2 = new Vertice(1f, 1f, -1f);
        vertice3 = new Vertice(-1f, -1f, -1f);
        triangles.add(new Triangle(vertice1, vertice2, vertice3));

        new Screen();
        Object object = new Object(triangles);
        MovementMaker mm = new MovementMaker(object);
        mm.startRunning();
        
    }
    
}
