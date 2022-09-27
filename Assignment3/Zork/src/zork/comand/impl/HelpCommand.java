package io.muic.gigadot.ssc.zork.comand.impl;

import io.muic.gigadot.ssc.zork.Game;
import io.muic.gigadot.ssc.zork.comand.Command;
import io.muic.gigadot.ssc.zork.comand.CommandFactory;

import java.util.List;

public class HelpCommand implements Command {
    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Print all commands";
    }

    @Override
    public void execute(Game game, List<String> argument) {

        if(game.isMainMenu()){
            List<String> cmd = CommandFactory.getMainManuCommand();
            System.out.println("===================================");
            System.out.println("");
            System.out.println("Command That you can use in main menu");
            for(String command: cmd){
                System.out.println("=> " + command + " : " + CommandFactory.get(command).getDescription());
            }
            System.out.println("");
            System.out.println("===================================");

        }
        else{
            List<String> cmd = CommandFactory.getInGameCommand();
            System.out.println("===================================");
            System.out.println("");
            System.out.println("Command That you can use in gameplay");
            for(String command: cmd){
                System.out.println("=> " + command + " : " + CommandFactory.get(command).getDescription());
            }
            System.out.println("");
            System.out.println("===================================");

        }

    }
}
