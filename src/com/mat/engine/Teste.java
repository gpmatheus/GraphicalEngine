package com.mat.engine;

import java.util.List;

public class Teste {
    public static void main(String[] args) {

        Vertice central = new Vertice(0f, 0f, 3f);

        Vertice vertice1;
        Vertice vertice2;
        Vertice vertice3;

        vertice1 = new Vertice(-1f, -1f, -1f);
        vertice2 = new Vertice(1f, -1f, -1f);
        vertice3 = new Vertice(1f, -1f, 1f);
        Triangle bottomTriangle = new Triangle(vertice1, vertice2, vertice3);

        vertice1 = new Vertice(-1f, -1f, -1f);
        vertice2 = new Vertice(1f, 1f, -1f);
        vertice3 = new Vertice(1f, -1f, -1f);
        Triangle frontTriangle = new Triangle(vertice1, vertice2, vertice3);

        vertice1 = new Vertice(1f, -1f, -1f);
        vertice2 = new Vertice(1f, 1f, -1f);
        vertice3 = new Vertice(1f, -1f, 1f);
        Triangle rightTriangle = new Triangle(vertice1, vertice2, vertice3);

        vertice1 = new Vertice(1f, -1f, 1f);
        vertice2 = new Vertice(1f, 1f, -1f);
        vertice3 = new Vertice(-1f, -1f, -1f);
        Triangle sideTriangle = new Triangle(vertice1, vertice2, vertice3);
        
        Screen screen = new Screen(List.of(bottomTriangle, frontTriangle, rightTriangle, sideTriangle), central);
        screen.startRotating();
    }
    
}
