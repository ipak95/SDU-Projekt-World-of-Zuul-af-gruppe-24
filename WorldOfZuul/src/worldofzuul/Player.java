/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import java.util.ArrayList;

public class Player {
    
    public ArrayList<Item> inventory = new ArrayList<Item>();

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return "Player{" + "inventory=" + inventory + '}';
    }

    
}

