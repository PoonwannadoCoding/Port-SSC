package io.muic.gigadot.ssc.zork.map;

import java.io.Serializable;

public abstract class Map implements Serializable {
    private String name;
    private String description;
    private String objective;
    private Room startRoom;

    public abstract boolean objectiveComplete();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public Room getStartRoom() {
        return startRoom;
    }

    public void setStartRoom(Room startRoom) {
        this.startRoom = startRoom;
    }

    public abstract void printMap();

}
