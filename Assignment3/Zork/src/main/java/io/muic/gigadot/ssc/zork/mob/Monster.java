package io.muic.gigadot.ssc.zork.mob;

import java.io.Serializable;

public class Monster implements Serializable {

    private String name;
    private String description;
    private int maxHp;
    private int hp;
    private int attackDmg;
    private double probability;
    private boolean alive;
    private String picture;
    private double criticalRate;

    public Monster(String name, String description, int maxHp, int hp ,int attackDmg, double probability,double criticalRate, String picture) {
        this.name = name;
        this.description = description;
        this.maxHp = maxHp;
        this.hp = hp;
        this.attackDmg = attackDmg;
        this.probability = probability;
        this.picture = picture;
        alive = true;
        this.criticalRate = criticalRate;
    }

    public void getDamage(int attackDmg){
        hp -= attackDmg;
        if(hp <= 0){
            hp = 0;
            alive = false;
        }
    }

    public double getCriticalRate() {
        return criticalRate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getAttackDmg() {
        return attackDmg;
    }

    public double getProbability() {
        return probability;
    }

    public boolean isAlive() {
        return alive;
    }


    public void printPic(){
        System.out.println("");
        System.out.println(picture);
        System.out.println("");
    }

    public void printMons(){
        System.out.println("");
        System.out.println(picture);
        System.out.println("    Name: " + name);
        System.out.println("    HP: " + hp + "/" + maxHp);
        System.out.println("    ATTK: " + attackDmg);
        System.out.println("    Description: " + description);
        System.out.println("");
    }

}
