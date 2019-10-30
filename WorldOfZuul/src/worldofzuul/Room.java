package worldofzuul;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private boolean roomHasPerson;

    public Room(String description, boolean hasPerson) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        this.roomHasPerson = hasPerson;
    }

    public boolean doesRoomHasPerson() {
        return roomHasPerson;
    }
    

    public void setRoomHasPerson(boolean roomHasPerson) {
        this.roomHasPerson = roomHasPerson;
    }
    

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

