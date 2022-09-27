package io.muic.gigadot.ssc.zork.comand.impl;

import io.muic.gigadot.ssc.zork.Game;
import io.muic.gigadot.ssc.zork.comand.Command;

import java.util.List;

public class ExitCommand implements Command {


    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "Use when you want to exit the game";
    }

    @Override
    public void execute(Game game, List<String> argument) {
        game.exit();


    }
}
