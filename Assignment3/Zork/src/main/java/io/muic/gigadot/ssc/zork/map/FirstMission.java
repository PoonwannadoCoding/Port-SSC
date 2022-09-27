package io.muic.gigadot.ssc.zork.map;

import io.muic.gigadot.ssc.zork.item.ItemFactory;
import io.muic.gigadot.ssc.zork.item.potion.Potion;
import io.muic.gigadot.ssc.zork.item.shield.Shield;
import io.muic.gigadot.ssc.zork.item.weapon.Weapon;
import io.muic.gigadot.ssc.zork.mob.Monster;
import io.muic.gigadot.ssc.zork.mob.MonsterFactory;

import java.util.ArrayList;
import java.util.List;

public class FirstMission extends Map {

    private List<Room> roomList = new ArrayList<>();

    public FirstMission(){
        setName("Dungeon");
        setDescription("Welcome the stranger to the Dungeon");
        setObjective("Purge the unclean!!!");

        ItemFactory itemFactory = new ItemFactory();
        MonsterFactory monsterFactory = new MonsterFactory();

        Room room1 = new Room("Entrance");
        roomList.add(room1);
        Room room2 = new Room("Armory");
        roomList.add(room2);
        Room room3 = new Room("Hall way");
        roomList.add(room3);
        Room room4 = new Room("Monster Room");
        roomList.add(room4);
        Room room5 = new Room("Boss Room");
        roomList.add(room5);

        room1.setNorth(room3);
        room3.setSouth(room1);

        room3.setNorth(room4);
        room4.setSouth(room3);

        room4.setNorth(room5);
        room5.setSouth(room4);


        room2.setEast(room3);
        room3.setWest(room2);

        setStartRoom(room1);


        Weapon sword = itemFactory.createWeapon("sword");
        room3.setAllItem(sword);


        Potion healPotion = itemFactory.createPotion("healing potion");
        room2.setAllItem(healPotion);

        Shield woodenShield = itemFactory.createShield("wooden shield");
        room2.setAllItem(woodenShield);



        Monster skeleton = monsterFactory.generateMosnter("Skeleton");
        Monster ricardo = monsterFactory.generateMosnter("Ricardo");


        room4.setMonster(skeleton);
        room5.setMonster(ricardo);


    }



    @Override
    public boolean objectiveComplete() {
        for(Room room: roomList){
            if(room.containsMonster()){
                return false;
            }
        }
        return true;
    }

    @Override
    public void printMap() {





        System.out.println("                    |==============|");
        System.out.println("                    |              |");
        System.out.println("                    |     BOSS     |");
        System.out.println("                    |     ROOM     |");
        System.out.println("                    |              |");
        System.out.println("                    |=====    =====|");
        System.out.println("                         |    |     ");
        System.out.println("                         |    |     ");
        System.out.println("                         |    |     ");
        System.out.println("                    |=====    =====|");
        System.out.println("                    |              |");
        System.out.println("                    |   MONSTER    |");
        System.out.println("                    |    ROOM      |");
        System.out.println("                    |              |");
        System.out.println("                    |=====    =====|");
        System.out.println("                         |    |     ");
        System.out.println("                         |    |     ");
        System.out.println("                         |    |     ");
        System.out.println("                    |=====    =====|");
        System.out.println("|==========|        |              |");
        System.out.println("|          |========|   HALL WAY   |");
        System.out.println("|                                  |");
        System.out.println("| ARMORY                           |");
        System.out.println("|          |========|              |");
        System.out.println("|==========|        |=====    =====|");
        System.out.println("                         |    |     ");
        System.out.println("                         |    |     ");
        System.out.println("                         |    |     ");
        System.out.println("                    |=====    =====|");
        System.out.println("                    |              |");
        System.out.println("                    |   ENTRANCE   |");
        System.out.println("                    |              |");
        System.out.println("                    |              |");
        System.out.println("                    |              |");




    }



}
