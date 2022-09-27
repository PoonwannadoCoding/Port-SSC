package io.muic.gigadot.ssc.zork;

import io.muic.gigadot.ssc.zork.comand.Command;
import io.muic.gigadot.ssc.zork.comand.CommandFactory;
import io.muic.gigadot.ssc.zork.comand.CommandParser;
import io.muic.gigadot.ssc.zork.map.FirstMission;
import io.muic.gigadot.ssc.zork.map.Map;
import io.muic.gigadot.ssc.zork.map.MapFactory;
import io.muic.gigadot.ssc.zork.map.Room;
import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Game {


    private boolean exit = false;

    private Player player = new Player();
    private boolean mainMenu = true;
    private boolean inGame = false;


    //private StringBuilder saveGame = new StringBuilder();


    public void exit() {
        this.exit = true;
        System.exit(0);
    }

    public boolean isExit() {
        return exit;
    }


    public void load(String path) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        
        player = (Player) objectInputStream.readObject();
        fileInputStream.close();
        objectInputStream.close();

        
        /*
        while (scanner.hasNextLine()){
            String in = scanner.nextLine();

            if(in.contains("counter:")){

                player.setCounter(Integer.parseInt(in.replaceAll("counter:","")));
            }
            if(in.contains("maxHealth:")){
                player.setMaxHp(Integer.parseInt(in.replaceAll("maxHealth:","")));
            }
            if(in.contains("health:")){
                player.setHp(Integer.parseInt(in.replaceAll("health:","")));

            }

            if(in.contains("map:")){
                currentLevel(in.replaceAll("map:",""));
            }
            if(in.contains("room:")){
                currentLevel.setStartRoom(in.replaceAll("room:",""));

            }

 

        }
        */

        setInGame(true);
        setMainMenu(false);

        System.out.println("");
        System.out.println("Load save complete");
        System.out.println("");
    }



    public void run(){

        while(!isExit()){
            if(isMainMenu()){
                showMainMenu();
            }
            else{
                    Scanner scanner = new Scanner(System.in);
                    String rawInput = scanner.nextLine();

                    List<String> commandLine = CommandParser.parse(rawInput, isInGame());

                    if(commandLine != null){
                        Command command = CommandFactory.get(commandLine.get(0));

                        if(command != null){
                            command.execute(this, commandLine.subList(1,commandLine.size()));
                            if(!command.equals("save") && !command.equals("load") && !command.equals("quit")){
                                //addSaveGame(rawInput);
                            }
                        }

                        if(this.getCurrentLevel().objectiveComplete()){
                            System.out.println("");
                            System.out.println("================================");
                            System.out.println("=                              =");
                            System.out.println("=       Objective Complete     =");
                            System.out.println("=                              =");
                            System.out.println("================================");
                            System.out.println("");
                            setInGame(false);
                            setMainMenu(true);
                        }

                    }
                    else{
                        System.out.println( rawInput + " valid command.");
                    }


            }

        }

    }





    public void showMainMenu(){
        System.out.println("\n"+
                        " ________    ______   .______       __  ___ \n" +
                        "|       /   /  __  \\  |   _  \\     |  |/  / \n" +
                        "`---/  /   |  |  |  | |  |_)  |    |  '  /  \n" +
                        "   /  /    |  |  |  | |      /     |    <   \n" +
                        "  /  /----.|  `--'  | |  |\\  \\----.|  .  \\  \n" +
                        " /________| \\______/  | _| `._____||__|\\__\\ \n" +
                        "                                            ");
        System.out.println("            [MAP AVALIABLE]     ");
        System.out.println("");
        System.out.println("               [Dungeon]");
        System.out.println("");
        System.out.println("         [Underground Kingdom]");


        while (isMainMenu()){
            Scanner scanner = new Scanner(System.in);
            String rawInput = scanner.nextLine();

            List<String> commandLine = CommandParser.parse(rawInput,isInGame());

            //createNewSaveGame();//save game


            if(commandLine != null){
                Command command = CommandFactory.get(commandLine.get(0));
                if(command != null){
                    command.execute(this, commandLine.subList(1,commandLine.size()));

                    if(command.getCommand().equals("play")){
                        if(isInGame() && !command.equals("save") && !command.equals("load") && !command.equals("quit")){
                            //addSaveGame(rawInput);
                        }
                    }

                }




            }
            else{
                System.out.println("We are not understand "+ rawInput);
            }
        }
    }


    public void setCurrentRoom(Room currentRoom) {
        player.setCurrentRoom(currentRoom);
    }

    public Map getCurrentLevel() {
        return player.getCurrentMap();
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public void setCurrentLevel(String currentLevel) {
        for(String map : MapFactory.getAvaliableMap().keySet()){
            if(currentLevel.toLowerCase(Locale.ROOT).equals(map.toLowerCase(Locale.ROOT))){
                MapFactory mapFactory = new MapFactory();
                player.setCurrentMap(mapFactory.createMap(map));
                player.setCurrentRoom(getCurrentLevel().getStartRoom());

            }
        }
    }




    public void start(String map){
        player = new Player();
        setCurrentLevel(map);

    }
/*
    public void addSaveGame(String input){
        saveGame.append(input);
        saveGame.append("\n");
    }

    public void createNewSaveGame(){
        saveGame = new StringBuilder();
    }

    public String getSaveGameAsString(){
        return saveGame.toString();
    }

 */



    public boolean isMainMenu() {
        return mainMenu;
    }


    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setMainMenu(boolean mainMenu) {
        this.mainMenu = mainMenu;
    }



    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void moveRoom(Room room){
        player.setCurrentRoom(room);
    }


    public Player getPlayer() {
        return player;
    }






}
