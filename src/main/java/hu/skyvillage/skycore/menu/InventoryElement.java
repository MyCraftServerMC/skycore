package hu.skyvillage.skycore.menu;

public class InventoryElement {
    public static Type type;

    public static Type getType() {
        return type;
    }
}
enum Type {
    BUTTON,
    TEXT,
    PANEL,
    ITEM
}
