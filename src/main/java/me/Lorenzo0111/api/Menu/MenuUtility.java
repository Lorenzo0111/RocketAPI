package me.Lorenzo0111.api.Menu;

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

