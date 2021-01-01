package me.Lorenzo0111.api.Menu;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/*

This code is from https://gitlab.com/kodysimpson/menu-manager-spigot/

 */
public abstract class MultiPageMenu extends Menu {

    protected int page = 0;
    protected int maxItemsPerPage = 28;
    protected int index = 0;
    protected String left = ChatColor.GREEN + "Left";
    protected String close = ChatColor.RED + "Close";
    protected String right = ChatColor.GREEN + "Right";
    protected ItemStack leftItem = makeItem(Material.DARK_OAK_BUTTON, left);
    protected ItemStack closeItem = makeItem(Material.BARRIER, close);
    protected ItemStack rightItem = makeItem(Material.DARK_OAK_BUTTON, right);

    public MultiPageMenu(MenuUtility menuUtility) {
        super(menuUtility);
    }

    public void addMenuBorder(){
        inventory.setItem(48, leftItem);

        inventory.setItem(49, closeItem);

        inventory.setItem(50, rightItem);

        for (int i = 0; i < 10; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, super.FILLER);
            }
        }

        inventory.setItem(17, super.FILLER);
        inventory.setItem(18, super.FILLER);
        inventory.setItem(26, super.FILLER);
        inventory.setItem(27, super.FILLER);
        inventory.setItem(35, super.FILLER);
        inventory.setItem(36, super.FILLER);

        for (int i = 44; i < 54; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, super.FILLER);
            }
        }
    }

    public int getMaxItemsPerPage() {
        return maxItemsPerPage;
    }

    public String getClose() {
        return close;
    }

    public String getRight() {
        return right;
    }

    public String getLeft() {
        return left;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public ItemStack getCloseItem() {
        return closeItem;
    }

    public ItemStack getLeftItem() {
        return leftItem;
    }

    public ItemStack getRightItem() {
        return rightItem;
    }
}
