package io.muic.gigadot.ssc.zork.comand.impl;

import io.muic.gigadot.ssc.zork.Game;
import io.muic.gigadot.ssc.zork.Player;
import io.muic.gigadot.ssc.zork.comand.Command;
import io.muic.gigadot.ssc.zork.item.Item;
import io.muic.gigadot.ssc.zork.map.Room;
import io.muic.gigadot.ssc.zork.mob.Monster;

import java.util.List;

public class InfoCommand implements Command {

    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "This command will print the information of the player, monster, and environment status.";
    }

    @Override
    public void execute(Game game, List<String> argument) {

        Player player = game.getPlayer();
        Room currentRoom = game.getCurrentRoom();




        player.printStatus();

        System.out.println("=========[      ENVIRONMENT STATUS     ]========");
        System.out.println("You are in the " + currentRoom.getDescription() + " right now.");

        for (Item item : currentRoom.getAllItem()) {
            System.out.println(item.getName());
            System.out.println(item.getPicture());
            System.out.println(item.getDescription());
        }

        System.out.println("=========[      MONSTER STATUS     ]========");

        if(currentRoom.containsMonster()){
            Monster monster = currentRoom.getMonster();
            monster.printMons();
        }
        else {
            System.out.println("It's clear");
        }
        System.out.println("");

/*
        System.out.println("You are in the " + currentRoom.getDescription() + " right now.");

        for(Item item: currentRoom.getAllItem()){
            System.out.println(item.getName());
            System.out.println(item.getPicture());
            System.out.println(item.getDescription());
        }

        System.out.println("The possible way to go is " + currentRoom.getAllDoor());

 */



    }



}
