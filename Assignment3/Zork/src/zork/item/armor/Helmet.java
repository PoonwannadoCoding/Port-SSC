package io.muic.gigadot.ssc.zork.item.armor;

import java.io.Serializable;

public class Helmet extends Armor implements Serializable {
    public Helmet() {
        super("Helmet",
                "Wear this it will increase your MaxHp 50 HP",
                50,
                "\n" +
                        "         _\n" +
                        "        ( )\n" +
                        "       ( )(\n" +
                        "    ../ \\..)\n" +
                        "   /__ - __\\)\n" +
                        "   |\\_\\_/_/|(\n" +
                        "   \\ /|||\\ / )\n" +
                        "    \\\\|||//( (\n" +
                        "     -\\_/-  v");
    }
}
