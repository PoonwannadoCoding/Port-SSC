package io.muic.gigadot.ssc.zork.comand.impl;

import io.muic.gigadot.ssc.zork.Game;
import io.muic.gigadot.ssc.zork.comand.Command;
import io.muic.gigadot.ssc.zork.map.Map;

import java.util.List;

public class MapCommand implements Command {
    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "map";
    }

    @Override
    public String getDescription() {
        return "Print 2D map for the player to see the structure of the level";
    }

    @Override
    public void execute(Game game, List<String> argument) {
        Map map = game.getCurrentLevel();
        map.printMap();

    }
}
