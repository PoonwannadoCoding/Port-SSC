package io.muic.gigadot.ssc.zork.comand;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class CommandFactory {

    private static final Set<String> COMMANDS = new HashSet<>();
    private static final Set<String> MAINMENU_COMMAND = new HashSet<>();

    private static final Map<String, Command> COMMAND_MAP = new HashMap<>() {{
        CommandType[] commandTypes = CommandType.values();
        for(int i = 0; i < commandTypes.length; i++){

            if(commandTypes[i].isInGame()) {
                COMMANDS.add(commandTypes[i].getCommandWord());
            }
            if(commandTypes[i].isMainMenu()){
                MAINMENU_COMMAND.add(commandTypes[i].getCommandWord());
            }

            try{
                Command command = commandTypes[i].getCommandClass().getDeclaredConstructor().newInstance();
                put(commandTypes[i].getCommandWord(), command);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }};

    public static List<String> getInGameCommand(){
        List<String> cmdList = new ArrayList<>(COMMANDS);
        return cmdList;
    }

    public static List<String> getMainManuCommand(){
        List<String> cmdList = new ArrayList<>(MAINMENU_COMMAND);
        return cmdList;
    }

    public static Command get(String commandType){
        return COMMAND_MAP.getOrDefault(commandType,null);
    }

    public static List<String> getAll(){
        return COMMAND_MAP.keySet().stream().collect(Collectors.toList());
    }
}
