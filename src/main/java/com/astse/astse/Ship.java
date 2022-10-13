package com.astse.astse;

import javafx.scene.shape.Polygon;

public class Ship extends PlayElement {
    public Ship(int x, int y) {
        super(new Polygon(-5,-5, 10, 0, -5, 5), x, y);
    }
}
