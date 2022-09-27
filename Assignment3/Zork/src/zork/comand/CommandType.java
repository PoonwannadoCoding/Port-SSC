package io.muic.gigadot.ssc.zork.comand;

import io.muic.gigadot.ssc.zork.comand.impl.*;

public enum CommandType {
    INFO(InfoCommand.class, "info",false, true),
    EXIT(ExitCommand.class, "exit",true, false),
    PLAY(PlayCommand.class, "play", true,false),
    MAP(MapCommand.class,"map",false,true),
    GO(GoCommand.class, "go", false, true),
    TAKE(TakeCommand.class, "take", false, true),
    ATTACK(AttackWithCommand.class,"attack with", false, true),
    USE(UseCommand.class, "use",false,true),
    DROP(DropCommand.class,"drop",false,true),
    HELP(HelpCommand.class, "help", true, true),
    SAVE(SaveCommand.class, "save", false, true),
    LOAD(LoadCommand.class, "load", true,false),
    QUIT(QuitCommand.class, "quit", false, true),
    EQUIP(EquipCommand.class, "equip",false,true),
    WEAR(WearCommand.class, "wear", false, true);



    private Class<? extends Command> commandClass;
    private String commandWord;
    private boolean mainMenu;
    private boolean inGame;

    CommandType(Class<? extends Command> commandClass, String commandWord, boolean mainMenu, boolean inGame) {
        this.commandClass = commandClass;
        this.commandWord = commandWord;
        this.mainMenu = mainMenu;
        this.inGame = inGame;
    }

    public boolean isMainMenu() {
        return mainMenu;
    }

    public boolean isInGame() {
        return inGame;
    }

    public Class<? extends Command> getCommandClass(){
        return commandClass;
    }



    public String getCommandWord() {
        return commandWord;
    }
}
