package com.mat.engine;

import java.util.List;

public class Teste {
    public static void main(String[] args) {

        Vertice central = new Vertice(0f, 0f, -3f);

        Vertice vertice1;
        Vertice vertice2;
        Vertice vertice3;

        vertice1 = new Vertice(-1f, -1f, 2f);
        vertice2 = new Vertice(0f, -1f, 4f);
        vertice3 = new Vertice(1f, -1f, 2f);
        Triangle bottomTriangle = new Triangle(vertice1, vertice2, vertice3);

        vertice1 = new Vertice(-1f, -1f, 2f);
        vertice2 = new Vertice(0f, 1f, 3f);
        vertice3 = new Vertice(1f, -1f, 2f);
        Triangle southTriangle = new Triangle(vertice1, vertice2, vertice3);

        vertice1 = new Vertice(0f, -1f, 4f);
        vertice2 = new Vertice(0f, 1f, 3f);
        vertice3 = new Vertice(-1f, -1f, 2f);
        Triangle northWestTriangle = new Triangle(vertice1, vertice2, vertice3);

        vertice1 = new Vertice(1f, -1f, 2f);
        vertice2 = new Vertice(0f, 1f, 3f);
        vertice3 = new Vertice(0f, -1f, 4f);
        Triangle northEastTriangle = new Triangle(vertice1, vertice2, vertice3);
        
        Screen screen = new Screen(List.of(bottomTriangle, southTriangle, northWestTriangle, northEastTriangle), central);
        screen.startRotating();
    }
    
}
