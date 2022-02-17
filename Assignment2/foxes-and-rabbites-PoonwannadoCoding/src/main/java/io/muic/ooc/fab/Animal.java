package io.muic.ooc.fab;

import io.muic.ooc.fab.view.AnimalType;

import java.util.List;
import java.util.Random;

public abstract class Animal extends Actor {
// if use protected it can excess the sub class

    // The rabbit's position.
    // The field occupied.
    //private int foodLevel;

    // Whether the rabbit is alive or not.


    // A shared random number generator to control breeding.
    private static final Random RANDOM = new Random();

    protected abstract int getBreedingAge();

    public Animal(boolean randomAge, Field field, Location location) {

        super(randomAge, field, location);
    }

    /**
     * Indicate that the rabbit is no longer alive. It is removed from the
     * field.
     */



    protected boolean canBreed(){
        return getAge() >= getBreedingAge();
    }


    /**
     * Place the rabbit at the new location in the given field.
     *
     * @param newLocation The rabbit's new location.
     */


    /**
     * Generate a number representing the number of births, if it can breed.
     *
     * @return The number of births (may be zero).
     */
    protected int breed() {
        int births = 0;
        if (canBreed() && RANDOM.nextDouble() <= getBreedingProbability()) {
            births = RANDOM.nextInt(getMaxLitterSize()) + 1;

        }
        return births;
    }





    protected abstract int getMaxLitterSize();


    protected abstract double getBreedingProbability();












}
