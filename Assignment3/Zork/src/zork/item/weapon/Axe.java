package io.muic.gigadot.ssc.zork.item.weapon;

import java.io.Serializable;

public class Axe extends Weapon implements Serializable {
    public Axe() {
        super("Axe",
                "Attack Damage 130",
                130,
                "          A\n" +
                        "         /!\\\n" +
                        "        / ! \\\n" +
                        " /\\     )___(\n" +
                        "(  `.____(_)_________\n" +
                        "|           __..--\"\"\n" +
                        "(       _.-|\n" +
                        " \\    ,' | |\n" +
                        "  \\  /   | |\n" +
                        "   \\(    | |\n" +
                        "    `    | |\n" +
                        "         | |\n" +
                        "         | |\n" +
                        "         | |\n" +
                        "         | |\n" +
                        "         | |\n" +
                        "         |_|\n" +
                        "         |#|\n" +
                        "         |#|\n" +
                        "         |#|\n" +
                        "         |_|");
    }
}
