package io.muic.gigadot.ssc.zork.comand.impl;

import io.muic.gigadot.ssc.zork.Game;
import io.muic.gigadot.ssc.zork.Player;
import io.muic.gigadot.ssc.zork.comand.Command;
import io.muic.gigadot.ssc.zork.item.Item;
import io.muic.gigadot.ssc.zork.item.ItemFactory;
import io.muic.gigadot.ssc.zork.item.armor.Armor;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class WearCommand implements Command {
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "wear";
    }

    @Override
    public String getDescription() {
        return "Use this command to wear the armor to increase your MaxHp";
    }

    @Override
    public void execute(Game game, List<String> argument) {
        Player player = game.getPlayer();
        List<Item> inventory = player.getInventory();
        String input = argument.get(0).toLowerCase(Locale.ROOT).trim();

        if(argument.size() < 1 || input.equals("")){
            System.out.println("");
            System.out.println("Please specify your item !!!");
            System.out.println("Use command [info] to check the inventory");
            System.out.println("");
        }

        else {
            ItemFactory itemFactory = new ItemFactory();
            Armor armor = itemFactory.createArmor(input);

            if(armor == null){
                System.out.println("");
                System.out.println("You can't wear that item !!!");
                System.out.println("");
            }
            else if(!player.hasSpecificItem(input)){
                System.out.println("");
                System.out.println("That item is not located in your inventory");
                System.out.println("");
            }
            else {
                Iterator<Item> itemIterator = inventory.iterator();
                while(itemIterator.hasNext()){
                    Item item = itemIterator.next();
                    if(item.getName().toLowerCase(Locale.ROOT).equals(input)){
                        player.increseMaxHp(armor.getAdditionMaxHp());
                        player.heal(armor.getAdditionMaxHp());
                        itemIterator.remove();
                        System.out.println("");
                        System.out.println("You just wear " + armor.getName()+".");
                        System.out.println("HP: " + player.getHp() + "/" + player.getMaxHp());
                        System.out.println("");
                        return;
                    }
                }
            }


        }

    }
}
