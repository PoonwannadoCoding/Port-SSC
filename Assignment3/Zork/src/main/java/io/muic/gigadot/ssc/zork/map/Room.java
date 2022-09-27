package io.muic.gigadot.ssc.zork.map;

import io.muic.gigadot.ssc.zork.item.Item;
import io.muic.gigadot.ssc.zork.mob.Monster;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {

    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private List<String> allDoor;
    private String description;
    private List<Item> allItem;
    private Monster monster;

    public Room(String description){
        north = null;
        east = null;
        south = null;
        west = null;
        allDoor = new ArrayList<>();
        this.description = description;
        allItem = new ArrayList<>();
        monster = null;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room room) {
        this.north = room;
        allDoor.add("north");
        north.south = this; //current position is south and want to go to north
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room room) {
        this.east = room;
        allDoor.add("east");
        east.west = this;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room room) {
        this.south = room;
        allDoor.add("south");
        south.north = this;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room room) {
        this.west = room;
        allDoor.add("west");
        west.east = this;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public boolean containsMonster(){
        return monster != null;
    }

    public void setAllItem(Item allItem){
        this.allItem.add(allItem);
    }

    public void removeItem(Item item){
        this.allItem.remove(item);
    }

    public List<Item> getAllItem() {
        return allItem;
    }

    public List<String> getAllDoor() {
        return allDoor;
    }



    public String getDescription() {
        return description;
    }


}
