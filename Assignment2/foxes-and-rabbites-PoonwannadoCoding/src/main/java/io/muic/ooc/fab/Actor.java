package io.muic.ooc.fab;

import java.util.List;
import java.util.Random;

public abstract class Actor {

    // The rabbit's position.
    private Location location;
    // The field occupied.
    private Field field;

    private int age = 0;
// if use protected it can excess the sub class

    // Whether the rabbit is alive or not.
    private boolean alive = true;

    // A shared random number generator to control breeding.
    private static final Random RANDOM = new Random();

    public Actor(boolean randomAge, Field field, Location location){
        this.field = field;
        setLocation(location);
        if (randomAge) {
            setAge(RANDOM.nextInt(getMaxAge()));
        }

    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }


    protected void setLocation(Location newLocation) {
        if (location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    public void setField(Field field) {
        this.field = field;
    }

    protected void incrementAge() {
        age++;
        if (age > getMaxAge()) {
            setDead();
        }
    }

    protected void setDead() {
        setAlive(false);
        if (getLocation() != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    protected boolean isAlive(){
        return alive;
    }

    protected abstract int getMaxAge();

    public Location getLocation() {
        return location;
    }

    public Field getField() {
        return field;
    }

    public abstract void act(List<Actor> newAnimal);

}
