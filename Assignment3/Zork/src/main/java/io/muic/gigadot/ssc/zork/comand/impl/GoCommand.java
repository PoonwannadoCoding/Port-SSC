package io.muic.gigadot.ssc.zork.comand.impl;

import io.muic.gigadot.ssc.zork.Game;
import io.muic.gigadot.ssc.zork.Player;
import io.muic.gigadot.ssc.zork.comand.Command;
import io.muic.gigadot.ssc.zork.map.Room;

import java.util.List;
import java.util.Locale;

public class GoCommand implements Command {
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "go";
    }

    @Override
    public String getDescription() {
        return "Move player to the other room by specify the direction, e.g. north, south, east, west.";
    }

    @Override
    public void execute(Game game, List<String> argument) {
        Player player = game.getPlayer();
        Room room = game.getCurrentRoom();
        Room currentRoomn = game.getCurrentRoom();
        String direction = argument.get(0).toLowerCase(Locale.ROOT).trim();

        if (argument.size() < 1 || direction.isEmpty()){
            System.out.println("Please input the direction that you want to move");
        }
        else {
            if(!currentRoomn.containsMonster()) {
                if (room.getAllDoor().contains(direction)) {
                    if (direction.equals("north")) {
                        game.moveRoom(room.getNorth());
                        currentRoomn = room.getNorth();
                    } else if (direction.equals("south")) {
                        game.moveRoom(room.getSouth());
                        currentRoomn = room.getSouth();
                    } else if (direction.equals("east")) {
                        game.moveRoom(room.getEast());
                        currentRoomn = room.getEast();
                    } else if (direction.equals("west")) {
                        game.moveRoom(room.getWest());
                        currentRoomn = room.getWest();
                    }
                    player.heal(25);
                    System.out.println("");
                    System.out.println("You have sucessfully moved to the room at " + direction + ".");
                    System.out.println("Now, you are at " + currentRoomn.getDescription() + ".");
                    System.out.println("Your HP will recover by 25 HP");
                    System.out.println("");

                } else {
                    System.out.println("");
                    System.out.println("There is no exit at that direction!");
                    System.out.println("Type map to see the map of this level.");
                    System.out.println("");
                }
            }
            else {
                System.out.println("");
                System.out.println("You have to kill monster first!");
                System.out.println("");
            }
        }

    }
}
