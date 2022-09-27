package io.muic.gigadot.ssc.zork.comand.impl;

import io.muic.gigadot.ssc.zork.Game;
import io.muic.gigadot.ssc.zork.Player;
import io.muic.gigadot.ssc.zork.comand.Command;
import io.muic.gigadot.ssc.zork.item.Item;
import io.muic.gigadot.ssc.zork.item.ItemFactory;
import io.muic.gigadot.ssc.zork.item.shield.Shield;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class EquipCommand implements Command {
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "equip";
    }

    @Override
    public String getDescription() {
        return "Use this command to equip shield";
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
            Shield shield = itemFactory.createShield(input);

            if(shield == null){
                System.out.println("");
                System.out.println("You can't equip that item with yourself!!!");
                System.out.println("");
            } else if(!player.hasSpecificItem(input)) {
                System.out.println("");
                System.out.println("That item is not located in your inventory");
                System.out.println("");
            } else {
                Iterator<Item> itemIterator = inventory.iterator();
                while(itemIterator.hasNext()){
                    Item item = itemIterator.next();
                    if(item.getName().toLowerCase(Locale.ROOT).equals(input)){
                        player.setHaveShield(true);
                        player.setCounter(0);//reset counter
                        player.setDuration(shield.getDuration());
                        player.setReduceDmg(shield.getReduceDmg());
                        itemIterator.remove();
                        System.out.println("");
                        System.out.println("You have equip " + item.getName());
                        System.out.println("");
                        return;
                    }
                }
            }
        }

    }
}
