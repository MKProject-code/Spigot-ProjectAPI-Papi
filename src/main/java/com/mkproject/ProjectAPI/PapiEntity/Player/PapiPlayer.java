package com.mkproject.ProjectAPI.PapiPlayer;

import com.mkproject.ProjectAPI.PapiPlugin.PapiUtils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.net.InetSocketAddress;
import java.util.Objects;
import java.util.Set;

public interface PapiPlayer extends Player {

//    public default void kill() {
//        this.damage(10000);
//    };
//    public default void kill(Entity source) {
//        this.damage(10000, source);
//    };

    public default void sendMessageColor(@NotNull String message) {
        Objects.requireNonNull(this.getPlayer()).sendMessage(PapiUtils.getColoredString(message));
    }

    public default void kickPlayerColor(@NotNull String message) {
        Objects.requireNonNull(this.getPlayer()).kickPlayer(PapiUtils.getColoredString(message));
    }

    public default Set<Player> getHiddenPlayers() {
        return Objects.requireNonNull(this.getPlayer()).spigot().getHiddenPlayers();
    }

    public default InetSocketAddress getRawAddress() {
        return Objects.requireNonNull(this.getPlayer()).spigot().getRawAddress();
    }

    public default void respawn() {
        Objects.requireNonNull(this.getPlayer()).spigot().respawn();
    }

    public default void sendMessage(@NotNull BaseComponent component) {
        Objects.requireNonNull(this.getPlayer()).spigot().sendMessage(component);
    }

    public default void sendMessage(@NotNull BaseComponent... components) {
        Objects.requireNonNull(this.getPlayer()).spigot().sendMessage(components);
    }

    public default void sendMessage(@NotNull ChatMessageType position, @NotNull BaseComponent component) {
        Objects.requireNonNull(this.getPlayer()).spigot().sendMessage(position, component);
    }

    public default void sendMessage(@NotNull ChatMessageType position, @NotNull BaseComponent... components) {
        Objects.requireNonNull(this.getPlayer()).spigot().sendMessage(position, components);
    }

    public default PapiPlayerData getPapiPlayerData() {
        return new PapiPlayerDataModel(this.getPlayer());
    }

}
