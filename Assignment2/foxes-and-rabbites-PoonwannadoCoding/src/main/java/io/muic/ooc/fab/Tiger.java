package io.muic.ooc.fab;

import io.muic.ooc.fab.view.AnimalType;

import java.util.List;
import java.util.Iterator;
import java.util.Random;

public class Tiger extends Animal {

    private static final int BREEDING_AGE = 30;

    private static final int MAX_AGE = 200;

    private static final double BREEDING_PROBABILITY = 0.01;

    private static final int MAX_LITTER_SIZE = 3;

    private static final Random RANDOM = new Random();

    private int foodLevel;

    public Tiger(boolean randomAge, Field field, Location location) {
        super(randomAge, field, location);

        foodLevel = RANDOM.nextInt(AnimalType.FOX.getFoodValue()) + RANDOM.nextInt(AnimalType.RABBIT.getFoodValue());
    }

    private Location findFood(){
        List<Location> adjacent = getField().adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while (it.hasNext()){
            Location where = it.next();
            Object animal = getField().getObjectAt(where);


            if(animal instanceof Fox){
                Fox fox = (Fox) animal;
                if(fox.isAlive()){
                    fox.setDead();
                    foodLevel = AnimalType.FOX.getFoodValue();
                    return where;
                }
            }
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if (rabbit.isAlive()) {
                    rabbit.setDead();
                    foodLevel = AnimalType.RABBIT.getFoodValue();
                    return where;
                }
            }
        }
        return null;
    }

    private void incrementHunger(){
        foodLevel--;
        if (foodLevel <= 0){
            setDead();
        }
    }


    @Override
    protected int getBreedingAge() {
        return BREEDING_AGE;
    }

    @Override
    protected int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected int getMaxLitterSize() {
        return MAX_LITTER_SIZE;
    }

    @Override
    protected double getBreedingProbability() {
        return BREEDING_PROBABILITY;
    }

    private void giveBirth(List<Actor> newTigers){
        List<Location> free = getField().getFreeAdjacentLocations(getLocation());
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++){
            Location loc = free.remove(0);
            Animal young = new Tiger(false, getField(), loc);
            newTigers.add(young);
        }
    }

    @Override
    public void act(List<Actor> newAnimal) {
        incrementAge();
        incrementHunger();
        if(isAlive()){
            giveBirth(newAnimal);
            Location newLocation = findFood();
            if(newLocation == null){
                newLocation = getField().freeAdjacentLocation(getLocation());
            }
            if(newLocation != null){
                setLocation(newLocation);
            } else {
                setDead();

            }
        }

    }
}
