package io.muic.gigadot.ssc.zork.comand.impl;

import io.muic.gigadot.ssc.zork.Game;
import io.muic.gigadot.ssc.zork.Player;
import io.muic.gigadot.ssc.zork.comand.Command;
import io.muic.gigadot.ssc.zork.comand.CommandFactory;
import io.muic.gigadot.ssc.zork.comand.CommandParser;
import io.muic.gigadot.ssc.zork.map.MapFactory;
import io.muic.gigadot.ssc.zork.map.Room;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LoadCommand implements Command {



    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "load";
    }

    @Override
    public String getDescription() {
        return "Load game state from saved point, this command only available at when start the game.";
    }

    @Override
    public void execute(Game game, List<String> argument) {
        String fileName = argument.get(0);
        String path = "C:\\Users\\Worawit\\Desktop\\saveGame\\" + fileName + ".txt";

        if(argument.size() < 1 || fileName.equals("")){
            System.out.println("");
            System.out.println("Please write your save file!!!");
            System.out.println("");
        }
        else {
            File file = new File(path);
            try{
                game.load(path);


                CommandParser commandParser = new CommandParser();
                Player player = game.getPlayer();
                //player.load(path);
/*
                while(scanner.hasNextLine()){
                    String in = scanner.nextLine();
                    List<String> words = commandParser.parse(in);
                    if(words != null){
                        Command command = CommandFactory.get(words.get(0));
                        if(command != null){
                            if(command.getCommand().equals("play") && MapFactory.get(words.get(1)) != null){
                                game.setCurrentLevel(words.get(1));
                            }

                            command.execute(game, words.subList(1, words.size()));
                        }
                    }



                    game.setInGame(true);
                    game.setMainMenu(false);


                }

 */





            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }

    }
}
