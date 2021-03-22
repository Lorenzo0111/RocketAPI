package me.lorenzo0111.api.menu;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

/**
 * ItemStack Builder
 */
@SuppressWarnings("unused")
public final class ItemBuilder {

    private final ItemStack itemStack;
    private final ItemMeta meta;

    public ItemBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.meta = this.itemStack.getItemMeta();
    }

    public ItemBuilder(Material material) {
        this.itemStack = new ItemStack(material);
        this.meta = this.itemStack.getItemMeta();
    }

    /**
     * @param material Material
     * @return Item Builder
     */
    public static ItemBuilder createItem(Material material) {
        return new ItemBuilder(material);
    }

    /**
     * @param itemStack ItemStack
     * @return Item Builder
     */
    public static ItemBuilder createItem(ItemStack itemStack) {
        return new ItemBuilder(itemStack);
    }

    /**
     * @param name Item Name
     * @return Item Builder
     */
    public ItemBuilder setName(String name) {
        meta.setDisplayName(name);
        return this;
    }


    /**
     * @param lore Item Lore
     * @return Item Builder
     */
    public ItemBuilder setLore(String... lore) {
        meta.setLore(Arrays.asList(lore));
        return this;
    }


    /**
     * @param data Custom Model Data
     * @return Item Builder
     */
    public ItemBuilder setCustomModelData(int data) {
        meta.setCustomModelData(data);
        return this;
    }
    /**
     * @return Item
     */
    public ItemStack build() {
        itemStack.setItemMeta(meta);
        return itemStack;
    }
}
