package io.muic.gigadot.ssc.zork.item.shield;

import java.io.Serializable;

public class WoodenShield extends Shield  implements Serializable {
    public WoodenShield() {
        super("Wooden Shield",
                "Duration: 3",
                 "  |`-._/\\_.-`|\n" +
                        "  |    ||    |\n" +
                        "  |___o()o___|\n" +
                        "  |__((<>))__|\n" +
                        "  \\   o\\/o   /\n" +
                        "   \\   ||   /\n" +
                        "    \\  ||  /\n" +
                        "     '.||.'\n" +
                        "       ``",
                3,0.3);
    }
}
