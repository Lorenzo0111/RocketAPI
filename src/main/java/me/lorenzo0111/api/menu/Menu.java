package me.lorenzo0111.api.menu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("unused")
public abstract class Menu implements InventoryHolder {


    protected MenuUtility menuUtility;
    protected Inventory inventory;
    protected MenuFiller filler;

    /**
     * @param menuUtility menu information
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


    /**
     * Open the GUI
     */
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


    /**
     * @return inventory
     */
    @Override
    public Inventory getInventory() {
        return inventory;
    }

    public MenuFiller getFiller() {
        if (filler == null) {
            filler = new MenuFiller(this, ItemBuilder.createItem(Material.GRAY_STAINED_GLASS_PANE).setName("§7").build());
        }

        return filler;
    }

    /**
     * @param index item position
     * @param item item
     */
    public void setItem(int index, ItemStack item) {
        inventory.setItem(index, item);
    }

    /**
     * @param item item
     */
    public void addItem(ItemStack item) {
        inventory.addItem(item);
    }

}
