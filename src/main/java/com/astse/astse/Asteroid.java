package com.astse.astse;


public class Asteroid extends PlayElement {
    public Asteroid(int x, int y) {
        super(new PolygonFactory().createPolygon(), x, y);
    }
}
