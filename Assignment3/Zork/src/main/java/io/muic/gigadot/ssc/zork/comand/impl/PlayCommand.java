package io.muic.gigadot.ssc.zork.comand.impl;

import io.muic.gigadot.ssc.zork.Game;
import io.muic.gigadot.ssc.zork.comand.Command;
import io.muic.gigadot.ssc.zork.map.MapFactory;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class PlayCommand implements Command {


    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "play";
    }

    @Override
    public String getDescription() {
        return "Type play follow with map name at the main screen to select the level that player would like to play.";
    }

    @Override
    public void execute(Game game, List<String> argument) {
        String input = argument.get(0).toLowerCase(Locale.ROOT).trim();

        if(argument.size() < 1 || argument.get(0).equals("")){
            System.out.println("");
            System.out.println("Please select the map");
            System.out.println("");

        } else {
            for(String map : MapFactory.getAvaliableMap().keySet()) {
                if (map.toLowerCase(Locale.ROOT).equals(input)) {
                    game.start(map);
                    System.out.println("");
                    System.out.println("GAME START!!!");
                    System.out.println("");
                    System.out.println("==========================");
                    System.out.println("");

                    System.out.println("Greeting the stranger to the " + game.getCurrentLevel().getName());
                    System.out.println(game.getCurrentLevel().getDescription());
                    System.out.println("");
                    System.out.println("Your goal is to " + game.getCurrentLevel().getObjective() + ".");
                    System.out.println("");

                    game.setMainMenu(false);
                    game.setInGame(true);
                    return;


                }
            }

            System.out.println("");
            System.out.println("Incorrent map name. Check again");
            System.out.println("");


        }
    }

}
