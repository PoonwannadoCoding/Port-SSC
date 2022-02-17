package io.muic.ooc.fab.view;


import io.muic.ooc.fab.*;

import java.awt.*;


public enum AnimalType {
    RABBIT(Rabbit.class, Color.ORANGE, 0.08,9),
    FOX(Fox.class, Color.BLUE, 0.02,18),
    HUNTER(Hunter.class, Color.GREEN, 0.001,0),
    TIGER(Tiger.class, Color.RED, 0.01,0)
    ;

    private Class<? extends Actor> animalClass;

    private int foodValue;

    private Color color;

    private double probability;

    AnimalType(Class<? extends Actor> animalClass, Color color, Double probability, int foodValue) {
        this.animalClass = animalClass;
        this.color = color;
        this.probability = probability;
        this.foodValue = foodValue;
    }

    public int getFoodValue() {
        return foodValue;
    }

    public Class<? extends Actor> getAnimalClass() {
        return animalClass;
    }

    public Color getColor() {
        return color;
    }

    public double getProbability() {
        return probability;
    }
}
