package io.muic.gigadot.ssc.zork.item.weapon;

import io.muic.gigadot.ssc.zork.item.Item;

import java.io.Serializable;

public class Weapon extends Item  implements Serializable {

    private int attackDamage;


    public int getAttackDamage(){
        return attackDamage;
    }

    public Weapon(String name, String description, int attackDamage, String picture) {
        super(name, description, picture);
        this.attackDamage = attackDamage;


    }
}
