package io.muic.gigadot.ssc.zork.comand;

import io.muic.gigadot.ssc.zork.Game;

import java.util.List;

public interface Command {

    int numArgs();

    String getCommand();

    String getDescription();

    void execute(Game game, List<String> argument);


}
