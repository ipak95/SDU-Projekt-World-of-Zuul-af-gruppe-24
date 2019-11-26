package Domain;

import java.util.ArrayList;

public class Player {

    // creates an ArrayList for a new player
    private ArrayList<Item> inventory = new ArrayList<>();

    // adds item to inventory
    public void addItem(Item item) {
        this.inventory.add(item);
    }

    // Used when command word 'BUILD' is used
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    // Returns items in inventory when used
    public void displayInventory() {
        String returnString = "Inventory: |";

        for (Item item : inventory) {
            returnString += item.getName() + " | ";
        }

        System.out.print(returnString);
        System.out.println();
        if (inventory.size() < 1) {
            System.out.print("Empty");
            System.out.println();
        }
    }
}

