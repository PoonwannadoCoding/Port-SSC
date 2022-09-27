package io.muic.gigadot.ssc.zork.item.armor;

import java.io.Serializable;

public class ChestArmor extends Armor implements Serializable {
    public ChestArmor() {
        super("Chest Armor",
                "This item will add your MaxHP 75",
                75,
                 "  #####         #####\n" +
                         " ######\\     /######\n" +
                         "   \\#############/\n" +
                         "    ####/===\\####\n" +
                         "    ####| * |####\n" +
                         "    ####\\===/####\n" +
                         "    #############\n" +
                         "    \\###########/");
    }
}
