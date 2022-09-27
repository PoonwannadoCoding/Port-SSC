package io.muic.gigadot.ssc.zork.comand.impl;

import io.muic.gigadot.ssc.zork.Game;
import io.muic.gigadot.ssc.zork.Player;
import io.muic.gigadot.ssc.zork.comand.Command;
import io.muic.gigadot.ssc.zork.map.Room;
import io.muic.gigadot.ssc.zork.mob.Monster;

import java.io.*;
import java.util.List;

//save game logic
// save player Hp and MaxHp
// save map name
// save monster status alive or not alive
// save inventory

public class SaveCommand implements Command {
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "Load game state from saved point, this command only available while playing game. \n" +
                "If you save it for first time you can save it in anyname. \n" +
                "But, if you would like to save your current session !!!PLEASE use the same name as your last save point !!!";
    }

    @Override
    public void execute(Game game, List<String> argument) {
        String fileName = argument.get(0);
        String path = "C:\\Users\\Worawit\\Desktop\\saveGame\\" + fileName + ".txt";

        File file = new File(path);

        if(argument.size() < 1 || fileName.equals("")){
            System.out.println("");
            System.out.println("Please name the file save!!!");
            System.out.println("");
        }
        else {
            try{

                    Player player = game.getPlayer();
                    Room currentRoom = game.getCurrentRoom();

                    FileOutputStream fileOutputStream = new FileOutputStream(path);

                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                    objectOutputStream.writeObject(player);
                    objectOutputStream.writeObject(currentRoom);


                    System.out.println("Saving Process ....");



                    fileOutputStream.close();
                    objectOutputStream.close();

                    System.out.println("");
                    System.out.println("Save Completed");
                    System.out.println("");
                } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
