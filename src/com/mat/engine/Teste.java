package com.mat.engine;

import java.util.List;

import com.mat.engine.elements.Triangle;
import com.mat.engine.elements.Vector;
import com.mat.engine.elements.Vertice;

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

        List<Object> objects = new ArrayList<>();

        Object object = new Object(triangles);
        objects.add(object);
        Screen screen = new Screen(objects);

        var v = new Vector(0f, 0f, 3f);
        for (var o : objects)
            o.moveObject(v);
        screen.startRotating();
    }
    
}
