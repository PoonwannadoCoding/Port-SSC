package io.muic.ooc.fab;

import io.muic.ooc.fab.view.AnimalType;

import java.lang.reflect.InvocationTargetException;


public class AnimalFactory {

    public static Actor createAnimal(AnimalType animalType, boolean randomAge, Field field, Location location){

        try {
            return animalType.getAnimalClass().getDeclaredConstructor(boolean.class, Field.class, Location.class).newInstance(randomAge, field, location);
        } catch (InstantiationException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e){
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
            throw new RuntimeException("Unknown animal type");

    }
}
