package io.muic.gigadot.ssc.zork.item.potion;

import io.muic.gigadot.ssc.zork.item.Item;

import java.io.Serializable;

public class Potion extends Item  implements Serializable {

    public Potion(String name, String description, int increaseHp, String picture) {
        super(name, description, picture);
        this.increaseHp = increaseHp;
    }

    public int increaseHp;

    public int increaseHp(){
        return increaseHp;
    }
}
