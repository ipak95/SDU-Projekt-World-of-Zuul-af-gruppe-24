package worldofzuul;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


public class Room 
{
    private String description;
    private String longDescription;
    private String question;
    private final int correctAnswer;
    private HashMap<String, Room> exits;
    private boolean roomHasPerson;
    

    public Room(String description, boolean hasPerson, String longDescription, String question, int correctAnswer) 
    {
        this.description = description;
        this.longDescription = longDescription;
        exits = new HashMap<String, Room>();
        this.roomHasPerson = hasPerson;
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public String getQuestion() {
        return question;
    }
    

    public boolean doesRoomHasPerson() {
        return roomHasPerson;
         //True = Yes / False = No
    }
    

    public void setRoomHasPerson(boolean roomHasPerson) {
        this.roomHasPerson = roomHasPerson; 
    }
    

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getLongDescription()
    {
        return longDescription;
    }

    public String getShortDescription()
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

