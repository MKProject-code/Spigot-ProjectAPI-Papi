package com.mkproject.ProjectAPI.PapiEntity.Player.Model;

import com.mkproject.ProjectAPI.PapiEntity.Player.PapiPlayerData;
import org.bukkit.entity.Player;

final class PapiPlayerDataModel implements PapiPlayerData {
    private Player player;

    PapiPlayerDataModel(Player player) {
        this.player = player;
    }

    @Override
    public void setAllowInteract(boolean interact) {

    }
}
