package io.muic.gigadot.ssc.zork.comand.impl;

import io.muic.gigadot.ssc.zork.Game;
import io.muic.gigadot.ssc.zork.Player;
import io.muic.gigadot.ssc.zork.comand.Command;
import io.muic.gigadot.ssc.zork.item.Item;
import io.muic.gigadot.ssc.zork.item.ItemFactory;
import io.muic.gigadot.ssc.zork.item.potion.Potion;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class UseCommand implements Command {
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "use";
    }

    @Override
    public String getDescription() {
        return " use command is used to use the item that is not weapon in the current room";
    }

    @Override
    public void execute(Game game, List<String> argument) {
        Player player = game.getPlayer();
        List<Item> inventory = player.getInventory();
        String input = argument.get(0).toLowerCase(Locale.ROOT).trim();

        if(argument.size() < 1 || input.equals("")){
            System.out.println("");
            System.out.println("Please specify your item!!!");
            System.out.println("use [info] to check the inventory");
            System.out.println("");
        }
        else {
            ItemFactory itemFactory = new ItemFactory();

            Potion potion = itemFactory.createPotion(input);


            if(potion == null){
                System.out.println("");
                System.out.println("You can't use that item with yourself!!!");
                System.out.println("");
            }
            else if(!player.hasSpecificItem(input)){
                System.out.println("");
                System.out.println("That item is not located in your inventory");
                System.out.println("");
            }
            else if(player.getHp() == player.getMaxHp()){
                System.out.println("");
                System.out.println("You should save that for emergency");
                System.out.println("");
            }
            else {
                Iterator<Item> itemIterator = inventory.iterator();
                while (itemIterator.hasNext()){
                    Item item = itemIterator.next();
                    if(item.getName().toLowerCase(Locale.ROOT).equals(input)){
                        player.heal(potion.increaseHp());
                        itemIterator.remove();
                        System.out.println("");
                        System.out.println("You just used " + potion.getName() + " to yourself.");
                        System.out.println("HP: " + player.getHp() + "/" + player.getMaxHp());
                        System.out.println("");
                        return;
                    }
                }
            }
        }

    }
}
