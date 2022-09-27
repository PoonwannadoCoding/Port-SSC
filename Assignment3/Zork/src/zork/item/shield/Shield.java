package io.muic.gigadot.ssc.zork.item.shield;

import io.muic.gigadot.ssc.zork.item.Item;

import java.io.Serializable;

public class Shield extends Item  implements Serializable {


    private int duration;
    private double reduceDmg;

    public Shield(String name, String description, String picture, int duration, double reduceDmg) {
        super(name, description, picture);
        this.duration = duration;
        this.reduceDmg = 1-reduceDmg;
    }

    public double getReduceDmg() {
        return reduceDmg;
    }

    public int getDuration() {
        return duration;
    }


}
