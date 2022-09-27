package io.muic.gigadot.ssc.zork.item.armor;

import java.io.Serializable;

public class PantArmor extends Armor  implements Serializable {
    public PantArmor() {
        super("Pant Armor",
                "Wear this item and your MaxHp will increase for 75",
                75,
                " =============\n" +
                        " |           |\n" +
                        " |   ____    |\n" +
                        " |   |   |   |\n" +
                        " |   |   |   |\n" +
                        " |   |   |   |\n" +
                        " |   |   |   |\n" +
                        " |___|   |___|");
    }
}
