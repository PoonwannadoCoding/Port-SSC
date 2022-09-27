package io.muic.gigadot.ssc.zork.item;

import java.io.Serializable;

public class Item implements Serializable {

    private String name;
    private String description;
    private String picture;

    public Item(String name, String description, String picture) {
        this.name = name;
        this.description = description;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }

    public String getDescription() {
        return description;
    }
}
