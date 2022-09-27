package io.muic.gigadot.ssc.zork.item.potion;

import java.io.Serializable;

public class HealPotion extends Potion  implements Serializable {
    public HealPotion() {
        super("Healing Potion", "Heal 50 HP", 50, "      _____\n" +
                "     `.___,'\n" +
                "      (___)\n" +
                "      <   >\n" +
                "       ) (\n" +
                "      /`-.\\\n" +
                "     /     \\\n" +
                "    / _    _\\\n" +
                "   :,' `-.' `:\n" +
                "   |         |\n" +
                "   :         ;\n" +
                "    \\       /\n" +
                "     `.___.'");
    }
}
