package me.lorenzo0111.api.menu;

import org.bukkit.entity.Player;

public class MenuUtility {

    private final Player owner;

    public MenuUtility(Player p) {
        this.owner = p;
    }

    public Player getOwner() {
        return owner;
    }

}

