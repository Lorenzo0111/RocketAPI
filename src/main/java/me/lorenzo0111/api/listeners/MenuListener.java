package me.lorenzo0111.api.listeners;

import me.lorenzo0111.api.menu.Menu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class MenuListener implements Listener {

    @EventHandler
    public void handle(InventoryClickEvent event) {
        InventoryHolder holder = event.getInventory().getHolder();

        if (holder instanceof Menu) {
            if (event.getCurrentItem() == null) {
                return;
            }

            Menu menu = (Menu) holder;

            if (event.getCurrentItem().equals(menu.getFiller().getFiller())) {
                event.setCancelled(true);
                return;
            }

            menu.handleMenu(event);
        }

    }
}
