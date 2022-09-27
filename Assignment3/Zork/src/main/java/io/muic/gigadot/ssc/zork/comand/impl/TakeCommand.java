package io.muic.gigadot.ssc.zork.comand.impl;

import io.muic.gigadot.ssc.zork.Game;
import io.muic.gigadot.ssc.zork.Player;
import io.muic.gigadot.ssc.zork.comand.Command;
import io.muic.gigadot.ssc.zork.item.Item;
import io.muic.gigadot.ssc.zork.map.Room;

import java.util.List;
import java.util.Locale;

public class TakeCommand implements Command {
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "take";
    }

    @Override
    public String getDescription() {
        return "Take command is use to pick up the item that in the room. The command will be take [item]";
    }

    @Override
    public void execute(Game game, List<String> argument) {
        Player player = game.getPlayer();
        Room room = game.getCurrentRoom();

        String itemTake = argument.get(0).toLowerCase(Locale.ROOT).trim();

        if(argument.size() < 1 || itemTake.isEmpty()){
            System.out.println("");
            System.out.println("You take nothing? Please specific the item that you want to pick it up.");
            System.out.println("");
        } else {
            for(Item item: room.getAllItem()){
                if(item.getName().toLowerCase(Locale.ROOT).equals(itemTake)){
                    player.pickUpItem(item);
                    room.removeItem(item);
                    System.out.println("");
                    System.out.println("You picked up the " + item.getName() + "!!!");
                    System.out.println("");
                    return;

                }
            }
            System.out.println("");
            System.out.println("Look's like that item is not in that room.");
            System.out.println("");
        }

    }
}
