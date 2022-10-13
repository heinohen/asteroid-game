package com.astse.astse;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.*;

public class GameController extends Application {

    Map<KeyCode, Boolean> pressedKeys = new HashMap<>();
    List<Asteroid> asteroidList = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {

        //window
        Pane pane = new Pane();
        pane.setPrefSize(600,400);

        // create players ship
        Ship ship = new Ship(150,100);

        // create asteroids. change of amount is possible
        Random rnd = new Random();
        for (int i = 0; i < 5; i++) {
            Asteroid asteroid = new Asteroid(rnd.nextInt(300), rnd.nextInt(200));
            asteroidList.add(asteroid);
        }
        // adds elements to screen
        pane.getChildren().add(ship.getElement());

        //intialize random direction for each asteroid and accelerate!
        asteroidList.forEach(asteroid -> {
            pane.getChildren().add(asteroid.getElement());
            for (int i = 0; i < rnd.nextInt(3000); i++) {
                asteroid.turnRight();
            }
            asteroid.accelerate();
        });


        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Asteroidz!");


        //event listeners for keyboard inputs
        scene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });

        scene.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });


        new AnimationTimer() {

            @Override
            public void handle(long l) {
                if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }

                if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }

                if (pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }

                ship.move();
                asteroidList.forEach(PlayElement::move);

                asteroidList.forEach(asteroid -> {
                    if (ship.collide(asteroid)) {
                        stop();
                    }
                });
            }

        }.start();

        stage.show();
    }
}