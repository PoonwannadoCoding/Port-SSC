package io.muic.gigadot.ssc.zork.comand.impl;

import io.muic.gigadot.ssc.zork.Game;
import io.muic.gigadot.ssc.zork.Player;
import io.muic.gigadot.ssc.zork.comand.Command;
import io.muic.gigadot.ssc.zork.item.Item;
import io.muic.gigadot.ssc.zork.item.ItemFactory;
import io.muic.gigadot.ssc.zork.item.armor.Armor;
import io.muic.gigadot.ssc.zork.item.potion.Potion;
import io.muic.gigadot.ssc.zork.item.weapon.Weapon;
import io.muic.gigadot.ssc.zork.map.Map;
import io.muic.gigadot.ssc.zork.map.Room;
import io.muic.gigadot.ssc.zork.mob.Monster;

import java.util.List;
import java.util.Locale;
import java.util.Random;

public class AttackWithCommand implements Command {
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "attack with";
    }

    @Override
    public String getDescription() {
        return "Use to attack the enemy in that room by attaco with [weapon].";
    }



    @Override
    public void execute(Game game, List<String> argument) {
        Player player = game.getPlayer();
        Room currentRoom = game.getCurrentRoom();
        Map currentMap = game.getCurrentLevel();
        Monster monster = currentRoom.getMonster();


        final Random RANDOM = new Random();
        final Random CRITICALRANDOM = new Random();

        String input = argument.get(0).toLowerCase(Locale.ROOT);

        if(argument.size() < 1 || input.equals("")){
            System.out.println("Please specify your weapon.");
            System.out.println("Check your inventory by type [ info ]");
            System.out.println("");
        } else {
            ItemFactory itemFactory = new ItemFactory();
            Weapon weapon = itemFactory.createWeapon(input);


            if(weapon == null){
                System.out.println("Check the item name again !!!");
                System.out.println("");
            }

            else if(!player.hasSpecificItem(input)){
                System.out.println("Look like you don't have that Item in your inventory");
            } else {


                if(!currentRoom.containsMonster()){
                    System.out.println("Cool down brother!!! There is no Monster here.");
                    System.out.println("");
                }
                else {
                    monster.printPic();


                        if (monster.isAlive()) {
                            int damage = weapon.getAttackDamage() + player.getAttackDmg();
                            if(player.getHp() <= (player.getMaxHp()/2)) {
                                if (CRITICALRANDOM.nextDouble() >= 1 - (player.getCriticalRate()*2)) {
                                    damage = damage * 2;
                                    System.out.println("Critical Hit !!!!");
                                }
                                if(CRITICALRANDOM.nextDouble() >= 1 - player.getCriticalRate()){
                                    damage = damage*2;
                                    System.out.println("Critical Hit!!!");
                                }
                            }

                            monster.getDamage(damage);
                            System.out.println(monster.getName() + " get damage " + damage + " damage!!! by " + weapon.getName());
                            System.out.println("[" + monster.getName() + "] HP:" + monster.getHp() + "/" + monster.getMaxHp());
                            System.out.println("");
                        }
                        if (!monster.isAlive()) {
                            player.setAttackDmg(player.getAttackDmg() + 5);
                            //System.out.println(monster.getName());
                            if(monster.getName().toLowerCase(Locale.ROOT).equals("wizard")){
                                Potion healingPotion = itemFactory.createPotion("healing potion");
                                System.out.println("Monster Drop item: " + healingPotion.getName());
                                currentRoom.setAllItem(healingPotion);
                            }

                            if(monster.getName().toLowerCase(Locale.ROOT).equals("skeleton") && currentMap.getName().toLowerCase(Locale.ROOT).equals("underground kingdom")){
                                Armor helmet = itemFactory.createArmor("helmet");
                                System.out.println("Monster Drop item: " + helmet.getName());
                                currentRoom.setAllItem(helmet);
                            }

                            if(monster.getName().toLowerCase(Locale.ROOT).equals("daemon")){
                                Weapon axe = itemFactory.createWeapon("axe");
                                System.out.println("Monster Drop item: " + axe.getName());
                                currentRoom.setAllItem(axe);

                            }

                            currentRoom.setMonster(null);
                            System.out.println("");
                            System.out.println("The " + monster.getName() + " has been defeated!!!");
                            System.out.println("Very good stranger. Your attack damage will increase by 5 units");
                            return;
                        }

                        if (RANDOM.nextDouble() <= monster.getProbability()) {
                            int monsterDamage = monster.getAttackDmg();

                            if(CRITICALRANDOM.nextDouble() >= 1-monster.getCriticalRate()){
                                monsterDamage = monsterDamage*2;
                                System.out.println("Critical Hit !!!!");
                            }
                            player.getDamage(monsterDamage);

                            System.out.println("!!!!! Warning " + monster.getName() + " strike back !!!!!!!!");
                            System.out.println("");
                            System.out.println("You got " + monsterDamage + " damage !!!");
                            System.out.println("[Your current HP]" + player.getHp() + " / " + player.getMaxHp());
                            System.out.println("");


                            if (!player.isAlive()) {
                                System.out.println("      YOU DEAD     ");
                                System.out.println("Return to main menu");
                                System.out.println("");
                                game.setMainMenu(true);
                                game.setInGame(false);
                            } else {
                                System.out.println("");
                                System.out.println("Quick it's your chance!!!");
                                System.out.println("");
                            }
                        } else {
                            System.out.println("");
                            System.out.println(monster.getName() + " missed the attack.");
                            System.out.println("Quick it's your chance!!!");
                            System.out.println("");

                        }
                }
            }
        }

    }
}
