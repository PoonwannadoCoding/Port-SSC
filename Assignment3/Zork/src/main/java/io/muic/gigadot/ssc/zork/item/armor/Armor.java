package io.muic.gigadot.ssc.zork.item.armor;

import io.muic.gigadot.ssc.zork.item.Item;

import java.io.Serializable;

public class Armor extends Item implements Serializable {

    private int addotionMaxHp;

    public Armor(String name, String description,int addotionMaxHp, String picture) {
        super(name, description, picture);
        this.addotionMaxHp = addotionMaxHp;
    }

    public int getAdditionMaxHp() {
        return addotionMaxHp;
    }
}
