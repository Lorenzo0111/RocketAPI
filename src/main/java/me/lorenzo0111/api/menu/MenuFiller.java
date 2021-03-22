package me.lorenzo0111.api.menu;

import org.bukkit.inventory.ItemStack;

public final class MenuFiller {

    private final Menu menu;
    private ItemStack filler;

    public MenuFiller(Menu menu, ItemStack filler) {
        this.menu = menu;
        this.filler = filler;
    }

    public void fill() {
        for (int i = 0; i < menu.getSlots(); i++) {
            if (menu.getInventory().getItem(i) == null){
                menu.getInventory().setItem(i, filler);
            }
        }
    }

    public void setFiller(ItemStack filler) {
        this.filler = filler;
    }

    public ItemStack getFiller() {
        return filler;
    }
}
