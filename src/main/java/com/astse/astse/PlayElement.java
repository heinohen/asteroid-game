package com.astse.astse;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public abstract class PlayElement {

    private final Polygon element;
    private Point2D movement;



    public PlayElement(Polygon polygon, int x, int y) {
        this.element = polygon;
        this.element.setTranslateX(x);
        this.element.setTranslateY(y);

        this.movement = new Point2D(0,0);
    }

    public Polygon getElement() { return element; }

    public Boolean collide(PlayElement other) {
        Shape collisionArea = Shape.intersect(this.element, other.getElement());
        return collisionArea.getBoundsInLocal().getWidth() != -1;

    }
    public void turnLeft() {
        this.element.setRotate(this.element.getRotate() - 5 );
    }

    public void turnRight() {
        this.element.setRotate(this.element.getRotate() + 5 );
    }

    public void move() {
        this.element.setTranslateX(this.element.getTranslateX() + this.movement.getX());
        this.element.setTranslateY(this.element.getTranslateY() + this.movement.getY());
    }

    public void accelerate() {
        double changeX = Math.cos(Math.toRadians(this.element.getRotate()));
        double changeY = Math.sin(Math.toRadians(this.element.getRotate()));

        changeX *= 0.05;
        changeY *= 0.05;

        this.movement = this.movement.add(changeX, changeY);
    }



}
