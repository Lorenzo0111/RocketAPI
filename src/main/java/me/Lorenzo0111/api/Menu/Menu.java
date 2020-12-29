package me.Lorenzo0111.api.Menu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public abstract class Menu implements InventoryHolder {


    protected MenuUtility menuUtility;
    protected Inventory inventory;
    protected ItemStack FILLER_GLASS = makeItem(Material.STAINED_GLASS_PANE,(short) 8, " ");


    /**
     * @param menuUtility menu informations
     */
    public Menu(MenuUtility menuUtility) {
        this.menuUtility = menuUtility;
    }

    /**
     * @return menu name
     */
    public abstract String getMenuName();

    /**
     * @return slot amounts
     */
    public abstract int getSlots();


    /**
     * @param e handle click event
     */
    public abstract void handleMenu(InventoryClickEvent e);

    /**
     * add menu items
     */
    public abstract void setMenuItems();

    //When called, an inventory is created and opened for the player
    public void open() {
        //The owner of the inventory created is the Menu itself,
        // so we are able to reverse engineer the Menu object from the
        // inventoryHolder in the MenuListener class when handling clicks
        inventory = Bukkit.createInventory(this, getSlots(), getMenuName());

        //grab all the items specified to be used for this menu and add to inventory
        this.setMenuItems();

        //open the inventory for the player
        menuUtility.getOwner().openInventory(inventory);
    }

    //Overridden method from the InventoryHolder interface
    @Override
    public Inventory getInventory() {
        return inventory;
    }

    //Helpful utility method to fill all remaining slots with "filler glass"
    public void setFillerGlass(){
        for (int i = 0; i < getSlots(); i++) {
            if (inventory.getItem(i) == null){
                inventory.setItem(i, FILLER_GLASS);
            }
        }
    }

    public ItemStack makeItem(Material material, String displayName, String... lore) {

        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(displayName);

        itemMeta.setLore(Arrays.asList(lore));
        item.setItemMeta(itemMeta);

        return item;
    }

    public ItemStack makeItem(Material material, short id, String displayName, String... lore) {

        ItemStack item = new ItemStack(material, id);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(displayName);

        itemMeta.setLore(Arrays.asList(lore));
        item.setItemMeta(itemMeta);

        return item;
    }

    public ItemStack getFILLER_GLASS() {
        return FILLER_GLASS;
    }
}