package com.astse.astse;

import java.util.Random;
import java.util.random.*;
import javafx.scene.shape.Polygon;

public class PolygonFactory {
    
    
    public Polygon createPolygon() {
        Random rnd = new Random();
        Polygon poly = new Polygon();

        double size = 10 + rnd.nextInt(10);

        double c1 = Math.cos(Math.PI * 2 / 5);
        double c2 = Math.cos(Math.PI / 5);
        double s1 = Math.sin(Math.PI * 2 / 5);
        double s2 = Math.sin(Math.PI / 5);

        poly.getPoints().addAll(
            size, 0.0,
            size * c1, -1 * size * s1,
            -1 * size * c2, -1 * size * s2,
            -1 * size * c2, size * s2,
            size * c1, size * s1
        );

        for (int i = 0; i < poly.getPoints().size(); i++) {
            int change = rnd.nextInt(5) - 2;
            poly.getPoints().set(i, poly.getPoints().get(i) + change);
        }

        return poly;
    }    
}
