package hu.skyvillage.skycore.menu;

import hu.skyvillage.skycore.menu.event.ButtonClickListner;
import hu.skyvillage.skycore.paper.PaperCorePlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class InventoryMenu {
    private int id;
    private String name;
    private int height;
    private int width;
    private Inventory inv;
    private ArrayList<InventoryButton> buttons = new ArrayList<InventoryButton>();
    private HashMap<Slot,InventoryElement> slots = new HashMap<Slot,InventoryElement>();

    public InventoryMenu(int id, String name) {
        this.id = id;
        this.name = name;
        inv = Bukkit.createInventory(null, height*9,name);
        PaperCorePlugin.inventoryManager.menus.add(this);
    }

    public InventoryMenu(int id, String name, int height) {
        this.id = id;
        this.name = name;
        this.height = height;
        inv = Bukkit.createInventory(null, height*9,name);
        PaperCorePlugin.inventoryManager.menus.add(this);
    }

    public InventoryMenu(int id, String name, int height, int width) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.width = width;
        inv = Bukkit.createInventory(null, height*9,name);
        PaperCorePlugin.inventoryManager.menus.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public HashMap<Slot, InventoryElement> getSlots() {
        return slots;
    }

    public ArrayList<InventoryButton> getButtons() {
        return buttons;
    }

    public void addButton(int id, int x, String name, int y, ItemStack icon, ButtonClickListner listner) {
        buttons.add(new InventoryButton(x,y,name,null,icon.getType(),icon.getAmount(),listner));
        inv.setItem((x*9)+y,icon);
    }

    public void open(Player p) {
        p.openInventory(inv);
    }
}
