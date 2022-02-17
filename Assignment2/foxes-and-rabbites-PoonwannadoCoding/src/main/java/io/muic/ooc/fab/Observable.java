package io.muic.ooc.fab;

public abstract class Observable {

    abstract void notifyAllObserver(int step, Field field);

    abstract void addObserver(Observer o);

}
