package io.muic.gigadot.ssc.zork.map;

public enum MapTypes {
    DUNGEON(FirstMission.class,"dungeon"),
    KINGDOM(UndergroundKingdom.class,"underground kingdom");

    private String mapName;
    private Class<? extends Map> mapClass;

    MapTypes(Class<? extends Map> mapClass, String mapName){
        this.mapClass = mapClass;
        this.mapName = mapName;
    }

    public String getMapName() {
        return mapName;
    }

    public Class<? extends Map> getMapClass() {
        return mapClass;
    }
}
