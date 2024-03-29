package io.muic.ooc.fab;


import io.muic.ooc.fab.view.AnimalType;
import io.muic.ooc.fab.view.SimulatorView;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;

public class Simulator extends Observable{

    // Constants representing configuration information for the simulation.
    // The default width for the grid.
    private static final int DEFAULT_WIDTH = 120;
    // The default depth of the grid.
    private static final int DEFAULT_DEPTH = 80;
    // The probability that a fox will be created in any given grid position.
    private static final double FOX_CREATION_PROBABILITY = 0.02;
    // The probability that a rabbit will be created in any given position.
    private static final double RABBIT_CREATION_PROBABILITY = 0.08;

    private ArrayList<Observer> observers = new ArrayList<>();

    // Lists of animals in the field.
    private List<Actor> animals;

    // The current state of the field.
    private Field field;
    // The current step of the simulation.
    private int step;
    // A graphical view of the simulation.
    private SimulatorView view;
    // Random generator
    private static final Random RANDOM = new Random();

    /**
     * Construct a simulation field with default size.
     */
    public Simulator() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        this(DEFAULT_DEPTH, DEFAULT_WIDTH);
    }

    /**
     * Create a simulation field with the given size.
     *
     * @param depth Depth of the field. Must be greater than zero.
     * @param width Width of the field. Must be greater than zero.
     */
    public Simulator(int depth, int width) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (width <= 0 || depth <= 0) {
            System.out.println("The dimensions must be >= zero.");
            System.out.println("Using default values.");
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        }

        animals = new ArrayList<>();
        field = new Field(depth, width);

        // Create a view of the state of each location in the field.
        view = new SimulatorView(depth, width);
        for (AnimalType animalType: AnimalType.values()) {
            view.setColor(animalType.getAnimalClass(), animalType.getColor());

        }

        addObserver(view);

        view.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });

        // Setup a valid starting point.
        reset();
    }

    /**
     * Run the simulation from its current state for a reasonably long period
     * (4000 steps).
     */
    public void runLongSimulation() {
        simulate(4000);
    }

    /**
     * Run the simulation for the given number of steps. Stop before the given
     * number of steps if it ceases to be viable.
     *
     * @param numSteps The number of steps to run for.
     */
    public void simulate(int numSteps) {
        for (int step = 1; step <= numSteps && view.isViable(field); step++) {
            simulateOneStep();

             //delay(60);   // uncomment this to run more slowly
        }
    }

    /**
     * Run the simulation from its current state for a single step. Iterate over
     * the whole field updating the state of each fox and rabbit.
     */
    public void simulateOneStep() {
        step++;

        // Provide space for newborn rabbits.
        List<Actor> newAnimals = new ArrayList<>();
        // Let all animal act.
        for (Iterator<Actor> it = animals.iterator(); it.hasNext();) {
            Actor animal = it.next();
            animal.act(newAnimals);
            if (!animal.isAlive()) {
                it.remove();
            }
        }

        // Add the newly born foxes and rabbits to the main lists.
        animals.addAll(newAnimals);
        notifyAllObserver(step, field);
    }

    /**
     * Reset the simulation to a starting position.
     */
    public void reset() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        step = 0;
        animals.clear();
        populate();

        // Show the starting state in the view.
        notifyAllObserver(step, field);
        //view.showStatus(step, field);
    }

    /**
     * Randomly populate the field with foxes and rabbits.
     */
    private void populate(){
        
        field.clear();
        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                //fox prob
                // rabbit prob
                double cummulativeProbability = 0;
                double random = RANDOM.nextDouble();
                for (AnimalType animalType: AnimalType.values()) {

                    cummulativeProbability += animalType.getProbability();
                    if(random <= cummulativeProbability){
                        Location location = new Location(row, col);
                        Actor animal = AnimalFactory.createAnimal(animalType, true, field, location);
                        animals.add(animal);
                        break;
                    }
                }
                // else leave the location empty.
            }
        }
    }

    /**
     * Pause for a given time.
     *
     * @param millisec The time to pause for, in milliseconds
     */
    private void delay(int millisec) {
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException ie) {
            // wake up
        }
    }

    @Override
    void notifyAllObserver(int step, Field field) {
        for(Observer observer : observers){
            observer.update(step, field);
        }
    }

    @Override
    void addObserver(Observer o) {
        observers.add(o);
    }
}
