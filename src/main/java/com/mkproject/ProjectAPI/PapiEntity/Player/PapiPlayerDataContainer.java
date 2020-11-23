package com.mkproject.ProjectAPI.PapiEntity.Player;

import java.util.HashMap;
import java.util.Map;

final class PapiPlayerContainer {
    private static Map<PapiPlayer, PapiPlayerData> playersDataMap = new HashMap<>();

    private PapiPlayerContainer() {}

    protected static PapiPlayerData getPapiPlayerData(PapiPlayer papiPlayer) {
        PapiPlayerData papiPlayerData = playersDataMap.get(papiPlayer);
        if(papiPlayerData == null) {
            papiPlayerData = new PapiPlayerDataModel(papiPlayer);
            playersDataMap.put(papiPlayer, papiPlayerData);
        }
        return papiPlayerData;
    }
}
