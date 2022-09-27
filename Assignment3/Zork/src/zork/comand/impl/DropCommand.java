package io.muic.gigadot.ssc.zork.comand.impl;

import io.muic.gigadot.ssc.zork.Game;
import io.muic.gigadot.ssc.zork.Player;
import io.muic.gigadot.ssc.zork.comand.Command;
import io.muic.gigadot.ssc.zork.item.Item;
import io.muic.gigadot.ssc.zork.map.Room;

import java.util.List;
import java.util.Locale;

public class DropCommand implements Command {
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "drop";
    }

    @Override
    public String getDescription() {
        return "Drop item of choice that the player currently carries";
    }

    @Override
    public void execute(Game game, List<String> argument) {
        Player player = game.getPlayer();
        Room currentRoom = game.getCurrentRoom();
        List<Item> inventory = player.getInventory();

        String input = argument.get(0).toLowerCase(Locale.ROOT).trim();

        if(argument.size() < 1 || input.equals("")){
            System.out.println("Please specific the item that you want to drop.");
        }
        else {
            for(Item item : inventory){
                if(item.getName().toLowerCase(Locale.ROOT).equals(input)){
                    currentRoom.setAllItem(item); // Drop to the room floor
                    inventory.remove(item);
                    System.out.println("");
                    System.out.println("You drop " + item.getName() + ".");
                    System.out.println("");
                    return;
                }
                else{
                    System.out.println("That item is not in your inventory");
                }
            }
        }

    }
}
