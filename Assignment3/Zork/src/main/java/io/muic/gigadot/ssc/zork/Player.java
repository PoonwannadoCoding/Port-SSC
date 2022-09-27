package io.muic.gigadot.ssc.zork;

import io.muic.gigadot.ssc.zork.item.Item;
import io.muic.gigadot.ssc.zork.map.Map;
import io.muic.gigadot.ssc.zork.map.Room;
import io.muic.gigadot.ssc.zork.mob.Monster;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Player implements Serializable{

    private int maxHp;
    private int hp;
    private int attackDmg;
    private boolean alive;
    private List<Item> inventory;
    private boolean haveShield;
    private int duration;
    private int counter;
    private double reduceDmg;
    private double criticalRate;
    private Room currentRoom;
    private Map currentMap;
    private Monster monster;


    public Player(){
        maxHp = 100;
        hp = maxHp;
        attackDmg = 50;
        alive = true;
        inventory = new ArrayList<>();
        haveShield = false;
        counter = 0;
        criticalRate = 0.2;

    }



    public void setCounter(int counter) {
        this.counter = counter;
    }


    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void setCurrentMap(Map currentMap) {
        this.currentMap = currentMap;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Map getCurrentMap() {
        return currentMap;
    }

    public int getHp() {
        return hp;
    }

    public double getCriticalRate() {
        return criticalRate;
    }

    public void heal(int hpToHeal){
        if(hp + hpToHeal >= maxHp){
            hp = maxHp;
        }
        else
        {
            hp += hpToHeal;
        }
    }

    public void increseMaxHp(int hpToAdd){ //for armor
        System.out.println("set max");
        maxHp += hpToAdd;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setHaveShield(boolean haveShield) {
        this.haveShield = haveShield;
    }

    public void getDamage(int attackDmg){
        if(!haveShield) {
            hp -= attackDmg;
            if (hp <= 0) {
                hp = 0;
                alive = false;
            }
        } else{
            hp -= attackDmg*reduceDmg;
            counter++;
            if (hp <= 0) {
                hp = 0;
                alive = false;

            }
        }

        if(counter == duration){
            haveShield = false;
        }
    }



    public int getMaxHp() {
        return maxHp;
    }



    public void setReduceDmg(double reduceDmg) {
        this.reduceDmg = reduceDmg;
    }

    public int getAttackDmg() {
        return attackDmg;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public Boolean hasSpecificItem(String itemToTake){
        for(Item item : inventory){
            if(item.getName().toLowerCase(Locale.ROOT).equals(itemToTake)) {
                return true;
            }
        }
        return false;
    }



    public void setAttackDmg(int attackDmg) {
        this.attackDmg = attackDmg;
    }

    public boolean isAlive() {
        return alive;
    }


    public void pickUpItem(Item item){
        this.inventory.add(item);
    }

    public int getCounter() {
        return counter;
    }

    public void printStatus() {
        System.out.println("==========[ PLAYER INFO ]==========");
        System.out.println("The current hp: " + getHp() + "/" + getMaxHp());
        System.out.println("The attack power: " + this.attackDmg);
        System.out.println("Shield Status: " + this.haveShield);
        System.out.println("Shield Duration " + (duration - getCounter()));
        System.out.println("=========[ INVENTORY ITEM ]========");
        if (this.inventory.isEmpty()) {
            System.out.println("It's empty");
        } else {

            for (Item item : this.inventory) {
                System.out.println(item.getPicture());
                System.out.println("\t" + item.getName());

                System.out.println("===================================");

            }

            System.out.println("");
        }







    }


}
