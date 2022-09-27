package io.muic.gigadot.ssc.zork.comand.impl;

import io.muic.gigadot.ssc.zork.Game;
import io.muic.gigadot.ssc.zork.comand.Command;

import java.util.List;

public class QuitCommand implements Command {
    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "quit";
    }

    @Override
    public String getDescription() {
        return "End the current game and return to command prompt to let user choose the map or load from saved point again.";
    }

    @Override
    public void execute(Game game, List<String> argument) {
        System.out.println("");
        System.out.println("Return to main session...");
        System.out.println("");
        game.setMainMenu(true);
        game.setInGame(false);

    }
}
