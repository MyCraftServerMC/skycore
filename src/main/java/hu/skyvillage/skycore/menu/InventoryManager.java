package hu.skyvillage.skycore.menu;

import hu.skyvillage.skycore.menu.event.ButtonClickEvent;
import hu.skyvillage.skycore.menu.event.ButtonClickListner;
import hu.skyvillage.skycore.menu.event.ClickMode;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Objects;

public class InventoryManager implements Listener {

    public ArrayList<InventoryMenu> menus = new ArrayList<>();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        e.setCancelled(true);
        for (InventoryMenu m : menus) {
            if (e.getInventory() == m.getInv()) {

                Slot s = new Slot((int)e.getSlot()/9,e.getSlot()%9);
                InventoryElement el = m.getSlots().get(s);
                if (el.getType() == Type.BUTTON) {
                    InventoryButton btn = (InventoryButton)el;
                    ButtonClickEvent event = new ButtonClickEvent();
                    event.setP((Player) e.getWhoClicked());
                    event.setMode(ClickMode.CLICK);
                    System.out.println("tregr");
                    btn.getList().onClick(event);
                    e.setCancelled(true);
                }
            }
        }
        e.setCancelled(false);
    }

    public void createTestMenu(String name) {
        InventoryMenu menu = new InventoryMenu(0,"Teszt",2);
        menu.addButton(0, 0, "Asd", 0, new ItemStack(Material.ACACIA_BOAT), new ButtonClickListner() {
            @Override
            public void onClick(ButtonClickEvent event) {
                System.out.println("btn01");
            }
        });
        menu.addButton(1, 1, "Asd2", 1, new ItemStack(Material.BLACK_BED), new ButtonClickListner() {
            @Override
            public void onClick(ButtonClickEvent event) {
                System.out.println("btn02");
            }
        });
        menu.open(Objects.requireNonNull(Bukkit.getPlayer("Bendimester23")));
        menus.add(menu);
    }

}
