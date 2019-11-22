package hu.skyvillage.skycore.menu;

import hu.skyvillage.skycore.menu.event.ButtonClickListner;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class InventoryButton extends InventoryElement {
    private ItemStack icon;
    private ButtonClickListner list;
    public static final Type type = Type.BUTTON;

    public static Type getType() {
        return type;
    }

    public ButtonClickListner getList() {
        return list;
    }

    public InventoryButton(int x, int y, String name, List<String> desc, Material mat, int count, ButtonClickListner listener) {
        ItemStack i = new ItemStack(mat,count);
        i.getItemMeta().setDisplayName(name);
        i.getItemMeta().setLore(desc);
        icon = i;
        this.list = listener;
    }
}
