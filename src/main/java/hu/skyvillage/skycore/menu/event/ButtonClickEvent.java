package hu.skyvillage.skycore.menu.event;

import org.bukkit.entity.Player;

public class ButtonClickEvent {
    private int id;
    private ClickMode mode;
    private Player p;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClickMode getMode() {
        return mode;
    }

    public void setMode(ClickMode mode) {
        this.mode = mode;
    }

    public Player getP() {
        return p;
    }

    public void setP(Player p) {
        this.p = p;
    }
}
