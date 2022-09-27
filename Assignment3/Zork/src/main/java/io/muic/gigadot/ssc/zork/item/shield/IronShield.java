package io.muic.gigadot.ssc.zork.item.shield;

import java.io.Serializable;

public class IronShield extends Shield  implements Serializable {
    public IronShield() {
        super("Iron Shield",
                "Duration: 5",
                "\\_              _/\n" +
                        "] --__________-- [\n" +
                        "|       ||       |\n" +
                        "\\       ||       /\n" +
                        " [      ||      ]\n" +
                        " |______||______|\n" +
                        " |------..------|\n" +
                        " ]      ||      [\n" +
                        "  \\     ||     /\n" +
                        "   [    ||    ]\n" +
                        "   \\    ||    /\n" +
                        "    [   ||   ]\n" +
                        "     \\__||__/\n" +
                        "        --",
                5,0.5);
    }
}
