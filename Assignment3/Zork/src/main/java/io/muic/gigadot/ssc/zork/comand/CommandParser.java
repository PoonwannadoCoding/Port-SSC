package io.muic.gigadot.ssc.zork.comand;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CommandParser {

    private static List<String> allCommand = new ArrayList<>();

    private static List<String> allMenuCommand = CommandFactory.getMainManuCommand();

    private static List<String> allInGameCommand = CommandFactory.getInGameCommand();


    private static String matchInputToCommand(String rawInput){
        allCommand.addAll(CommandFactory.getAll());
        for(String command: allCommand) {

            if (rawInput.startsWith(command)) {
                return command;
            }
        }
        return null;
    }

    private static String matchInputToCommand(String rawInput, Boolean inGame){
        if(inGame) {
            for (String command : allInGameCommand) {
                    if (rawInput.startsWith(command)) {
                        return command;
                }
            }
        } else{
            for (String command : allMenuCommand) {
                if (rawInput.startsWith(command)) {
                    return command;
                }
            }

        }
        return null;
    }

    public static List<String> parse(String rawInput, Boolean inGame){
        try{
            String cleanedInput = rawInput.toLowerCase(Locale.ROOT).trim();
            String cmd = matchInputToCommand(cleanedInput, inGame);
            String argString = cleanedInput.substring(cmd.length()).trim();
            return Arrays.asList(cmd, argString);
        }
        catch (NullPointerException e){
            return null;
        }
    }

    public static List<String> parse(String rawInput){
        try{
            String cleanedInput = rawInput.toLowerCase(Locale.ROOT).trim();
            String cmd = matchInputToCommand(cleanedInput);
            if(cmd == null){
            }
            String argString = cleanedInput.substring(cmd.length()).trim();
            return Arrays.asList(cmd, argString);
        }
        catch (NullPointerException e){
            return null;
        }
    }




}
