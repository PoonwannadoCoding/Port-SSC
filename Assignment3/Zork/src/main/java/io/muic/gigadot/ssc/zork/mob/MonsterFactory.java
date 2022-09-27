package io.muic.gigadot.ssc.zork.mob;

import java.util.Locale;

public class MonsterFactory {
    public Monster generateMosnter(String in){
        String monster = in.toLowerCase(Locale.ROOT);
        if(monster.equals("skeleton")){
            return new Skeleton();
        }
        if(monster.equals("ricardo")){
            return new Ricardo();
        }
        if(monster.equals("wizard")){
            return new Wizard();
        }

        if(monster.equals("daemon")){
            return new Daemon();
        }

        if(monster.equals("gigachad")){
            return new GigaChad();
        }


        return null;
    }
}
