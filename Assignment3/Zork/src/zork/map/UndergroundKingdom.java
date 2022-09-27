package io.muic.gigadot.ssc.zork.map;

import io.muic.gigadot.ssc.zork.item.ItemFactory;
import io.muic.gigadot.ssc.zork.item.armor.Armor;
import io.muic.gigadot.ssc.zork.item.potion.Potion;
import io.muic.gigadot.ssc.zork.item.shield.Shield;
import io.muic.gigadot.ssc.zork.item.weapon.Weapon;
import io.muic.gigadot.ssc.zork.mob.Monster;
import io.muic.gigadot.ssc.zork.mob.MonsterFactory;

import java.util.ArrayList;
import java.util.List;

public class UndergroundKingdom extends Map{

    private List<Room> roomList = new ArrayList<>();


    public UndergroundKingdom(){
        setName("Underground Kingdom");
        setDescription("Welcome to the Underground Kingdom the dangerous place on Earth. The home of monster.");
        setObjective("Purge the unclean!!!");

        ItemFactory itemFactory = new ItemFactory();
        MonsterFactory monsterFactory = new MonsterFactory();

        Room room1 = new Room("Entrance");
        roomList.add(room1);

        Room room2 = new Room("Desperate Square");
        roomList.add(room2);

        Room room3 = new Room("Wizard Sanctuary");
        roomList.add(room3);

        Room room4 = new Room("Market");
        roomList.add(room4);

        Room room5 = new Room("Skeleton Hive");
        roomList.add(room5);

        Room room6 = new Room("Storage Room");
        roomList.add(room6);

        Room room7 = new Room("Palace Hall");
        roomList.add(room7);


        Room room8 = new Room("Palace Med  Bay");
        roomList.add(room8);

        Room room9 = new Room("Royal Guard Armory");
        roomList.add(room9);

        Room room10 = new Room("Throne Room");
        roomList.add(room10);

        room1.setNorth(room2);
        room2.setSouth(room1);

        room2.setWest(room3);
        room3.setEast(room2);

        room3.setNorth(room4);
        room4.setSouth(room3);

        room4.setEast(room5);
        room5.setWest(room4);

        room5.setNorth(room6);
        room6.setSouth(room5);

        room6.setWest(room7);
        room7.setEast(room6);

        room7.setNorth(room8);
        room8.setSouth(room7);

        room8.setEast(room9);
        room9.setWest(room8);

        room9.setNorth(room10);
        room10.setSouth(room9);

        Weapon sword = itemFactory.createWeapon("sword");
        room1.setAllItem(sword);

        Armor chestArmor = itemFactory.createArmor("chest armor");
        room2.setAllItem(chestArmor);


        Monster wizard = monsterFactory.generateMosnter("wizard");
        room3.setMonster(wizard);


        Shield woodenShield = itemFactory.createShield("wooden shield");
        room4.setAllItem(woodenShield);



        Monster skeleton = monsterFactory.generateMosnter("skeleton");
        room5.setMonster(skeleton);

        Shield ironShield = itemFactory.createShield("iron shield");
        room6.setAllItem(ironShield);

        Monster daemon = monsterFactory.generateMosnter("daemon");
        room7.setMonster(daemon);


        Potion superPotion = itemFactory.createPotion("super potion");
        room8.setAllItem(superPotion);

        Armor pantArmor = itemFactory.createArmor("pant armor");
        room9.setAllItem(pantArmor);

        Monster gigaChad = monsterFactory.generateMosnter("gigachad");
        room10.setMonster(gigaChad);

        setStartRoom(room1);



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
        System.out.println(
                "    |==========================================|\n" +
                "    |                                          |\n" +
                "    |                                          |\n" +
                "    |                                          |\n" +
                "    |              THRONE ROOM                 |\n" +
                "    |                                          |\n" +
                "    |                                          |\n" +
                "    |===================|  |===================|\n" +
                "                        |  |\n" +
                "                        |  |\n" +
                "                        |  |\n" +
                " ____________       ____|  |____ \n" +
                "|            |_____|   ROYAL    |\n" +
                "|  PALACE              GUARD    |\n" +
                "|  MED-BAY    _____   ARMORY    |\n" +
                "|____    ____|     |____________|\n" +
                "     |  |\n" +
                "     |  |\n" +
                "     |  |\n" +
                " ____|  |____       ____________\n" +
                "|            |_____|            |\n" +
                "|   PALACE             STORAGE  |\n" +
                "|    HALL     _____     ROOM    |\n" +
                "|____________|     |____    ____|\n" +
                "                        |  |\n" +
                "                        |  |\n" +
                "                        |  |\n" +
                " ____________       ____|  |____\n" +
                "|            |_____|            |\n" +
                "|   MARKET            SKELETON  |\n" +
                "|             _____     HIVE    |\n" +
                "|____    ____|     |____________|\n" +
                "     |  |\n" +
                "     |  |\n" +
                " ____|  |____       ____________\n" +
                "|            |_____|            |\n" +
                "|   WIZARD            DESPERATE |\n" +
                "|  SANCTUARY  _____    SQUARE   |\n" +
                "|____________|     |____    ____|\n" +
                "                        |  |\n" +
                "                        |  |\n" +
                "                        |  |\n" +
                "                    ____|  |____      \n" +
                "                   |            |\n" +
                "                   |  ENTRANCE  |                  \n" +
                "                   |            |             \n" +
                "                   |____________|\n");

    }
}
