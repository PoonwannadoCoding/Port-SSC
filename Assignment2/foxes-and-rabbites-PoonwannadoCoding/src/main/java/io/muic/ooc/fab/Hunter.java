package io.muic.ooc.fab;

import java.util.List;
import java.util.Iterator;


public class Hunter extends Actor {

    private static final int MAX_AGE = Integer.MAX_VALUE;

    public Hunter(boolean randomAge, Field field, Location location) {
        super(randomAge, field, location);
    }

    private Location huntAnimal(){
        List<Location> adjacent = getField().adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()){
            Location where = it.next();
            Object animal = getField().getObjectAt(where);
            if(animal instanceof Fox){
                Fox fox = (Fox) animal;
                if(fox.isAlive()){
                    fox.setDead();
                    return where;
                }

            }
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if (rabbit.isAlive()) {
                    rabbit.setDead();
                    return where;
                }
            }

            if (animal instanceof Tiger) {
                Tiger tiger = (Tiger) animal;
                if (tiger.isAlive()) {
                    tiger.setDead();
                    return where;
                }
            }
        }
        return null;
    }

    @Override
    protected int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    public void act(List<Actor> newAnimal) {
        if(isAlive()){
            Location newLocation = huntAnimal();
            if(newLocation == null){
                newLocation = getField().freeAdjacentLocation(getLocation());
            }
            if(newLocation != null){
                setLocation(newLocation);
            }
        }

    }
}
