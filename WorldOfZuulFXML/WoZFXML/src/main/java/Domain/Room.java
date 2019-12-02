package Domain;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


public class Room 
{
    private String name;
    private String description;
    private String longDescription;
    private String question;
    private final String answers;
    private final char correctAnswer;
    private HashMap<String, Room> exits;
    private boolean roomHasPerson;
    private boolean talk = false;
    

    public Room(String name, String description, boolean hasPerson, String longDescription, String question, String answers, char correctAnswer)
    {
        this.name = name;
        this.description = description;
        this.longDescription = longDescription;
        exits = new HashMap<String, Room>();
        this.roomHasPerson = hasPerson;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.answers = answers;
    }

    public String getName() {
        return name;
    }

    public String getAnswers() {
        return answers;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setTalk(boolean talk) {
        this.talk = talk;
    }

    public boolean isTalk() {
        return talk;
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

