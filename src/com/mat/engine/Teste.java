package com.mat.engine;

import java.util.List;

public class Teste {
    public static void main(String[] args) {

        Vertice central = new Vertice(0f, 0f, -3f);
        
        Vertice westVertice1 = new Vertice(-1f, -1f, 2f);
        Vertice westVertice2 = new Vertice(-1f, -1f, 4f);
        Vertice westVertice3 = new Vertice(-1f, 1f, 4f);
        Vertice westVertice4 = new Vertice(-1f, 1f, 2f);
        Shape westSquare = new Shape(new Vertice[] {westVertice1, westVertice2, westVertice3, westVertice4}, central);

        Vertice northVertice1 = new Vertice(-1f, -1f, 4f);
        Vertice northVertice2 = new Vertice(1f, -1f, 4f);
        Vertice northVertice3 = new Vertice(1f, 1f, 4f);
        Vertice northVertice4 = new Vertice(-1, 1f, 4f);
        Shape northSquare = new Shape(new Vertice[] {northVertice1, northVertice2, northVertice3, northVertice4}, central);

        Vertice eastVertice1 = new Vertice(1f, -1f, 4f);
        Vertice eastVertice2 = new Vertice(1f, -1f, 2f);
        Vertice eastVertice3 = new Vertice(1f, 1f, 2f);
        Vertice eastVertice4 = new Vertice(1f, 1f, 4f);
        Shape eastSquare = new Shape(new Vertice[] {eastVertice1, eastVertice2, eastVertice3, eastVertice4}, central);

        Vertice bottomVertice1 = new Vertice(1f, -1, 4f);
        Vertice bottomVertice2 = new Vertice(-1f, -1f, 4f);
        Vertice bottomVertice3 = new Vertice(-1f, -1f, 2f);
        Vertice bottomVertice4 = new Vertice(1f, -1f, 2f);
        Shape bottomSquare = new Shape(new Vertice[] {bottomVertice1, bottomVertice2, bottomVertice3, bottomVertice4}, central);

        Vertice southVertice1 = new Vertice(1f, -1f, 2f);
        Vertice southVertice2 = new Vertice(-1f, -1f, 2f);
        Vertice southVertice3 = new Vertice(-1f, 1f, 2f);
        Vertice southVertice4 = new Vertice(1f, 1f, 2f);
        Shape southSquare = new Shape(new Vertice[] {southVertice1, southVertice2, southVertice3, southVertice4}, central);

        Vertice topVertice1 = new Vertice(1f, 1f, 2f);
        Vertice topVertice2 = new Vertice(-1f, 1f, 2f);
        Vertice topVertice3 = new Vertice(-1f, 1f, 4f);
        Vertice topVertice4 = new Vertice(1f, 1f, 4f);
        Shape topSquare = new Shape(new Vertice[] {topVertice1, topVertice2, topVertice3, topVertice4}, central);
        
        Screen screen = new Screen(List.of(westSquare, northSquare, eastSquare, bottomSquare, southSquare, topSquare));
        screen.startRotating();
    }
    
}
