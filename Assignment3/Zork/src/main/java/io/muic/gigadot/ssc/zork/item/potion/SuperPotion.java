package io.muic.gigadot.ssc.zork.item.potion;

import io.muic.gigadot.ssc.zork.Player;

import java.io.Serializable;

public class SuperPotion extends Potion implements Serializable {
    public SuperPotion() {
        super("Super Potion"
                , "Can heal 100 Hp"
                , 1000
                , "   [|||||]\n" +
                        "    |\"\"\"|\n" +
                        "    )   (\n" +
                        "  ,'_    `.\n" +
                        " //#/      \\\n" +
                        "/   ,---.   \\\n" +
                        "|__//\"\"\"\\\\__|\n" +
                        "|--'_  _ `--|\n" +
                        "| _(_ (_)(_||\n" +
                        "|(  \\/ |) | |\n" +
                        "|_) /  |\\ |_|\n" +
                        "|-----------|\n" +
                        "|\"\"\"\"\"\"\"\"\"\"\"|\n" +
                        "`-._______.-' ");
    }
}
