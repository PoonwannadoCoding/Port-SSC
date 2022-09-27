package io.muic.gigadot.ssc.zork.map;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Locale;


public class MapFactory {


    private static final java.util.Map<String, Map> AVALIABLE_MAP = new HashMap<>(){{
        MapTypes[] mapTypes = MapTypes.values();
        for (MapTypes mapType : mapTypes) {
            try {
                Map map = mapType.getMapClass().getDeclaredConstructor().newInstance();
                put(mapType.getMapName(), map);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

    }};


    public static Map get(String mapName){
        for (String map: AVALIABLE_MAP.keySet()) {
            if(map.toLowerCase(Locale.ROOT).equals(mapName.toLowerCase(Locale.ROOT))){ //Clean the input
                return AVALIABLE_MAP.get(map);
            }

        }
        return null;
    }

    public static java.util.Map<String,Map> getAvaliableMap(){
        return AVALIABLE_MAP;
    }

    public io.muic.gigadot.ssc.zork.map.Map createMap(String mapName){
        for (String map: AVALIABLE_MAP.keySet()) {
            if(map.toLowerCase(Locale.ROOT).equals(mapName.toLowerCase(Locale.ROOT))){
                try {
                    return AVALIABLE_MAP.get(map).getClass().getDeclaredConstructor().newInstance();

                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }

        }
        return null;
    }


}
