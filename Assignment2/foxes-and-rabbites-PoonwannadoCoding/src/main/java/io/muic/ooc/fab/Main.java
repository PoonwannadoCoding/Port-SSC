package io.muic.ooc.fab;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        var simulator = new Simulator();
        simulator.simulate(1000);

    }
}
