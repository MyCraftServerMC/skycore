package hu.skyvillage.skycore.paper;

import hu.skyvillage.skycore.SkyCore;
import hu.skyvillage.skycore.menu.InventoryManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

/**
 * Main Class for the Plugin
 */
public class PaperCorePlugin extends JavaPlugin {

    public static final String VERSION = "0.1";
    public static final String PREFIX = "[SkyCore] ";
    public static InventoryManager inventoryManager = new InventoryManager();

    @Override
    public void onEnable() {
        try {
            new SkyCore().getInstance().init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bukkit.getPluginManager().registerEvents(inventoryManager,this);
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        System.out.println(command.getName());
        System.out.println(command.getLabel());
        if(command.getLabel().contains("skycore")) {
            System.out.println("rdhgfh");
            inventoryManager.createTestMenu("dgfd");
            return true;
        }
        return false;
    }
}
