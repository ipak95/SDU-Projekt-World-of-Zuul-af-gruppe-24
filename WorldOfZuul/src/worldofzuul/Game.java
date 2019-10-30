package worldofzuul;

import static worldofzuul.CommandWord.HELP;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        

    public Game() 
    {
        createRooms();
        parser = new Parser();
    }


    private void createRooms()
    {
        Room outside, theatre, pub, lab, office;
      
        outside = new Room("outside the main entrance of the university", false);
        theatre = new Room("in a lecture theatre", true);
        pub = new Room("in the campus pub", false);
        lab = new Room("in a computing lab", true);
        office = new Room("in the computing admin office", false);
        
        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theatre.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside;
    }

    public void play() 
    {            
        printWelcome();

                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to our game");
        System.out.println("In this game you will learn about solar cells and how ecofriendly energi-sources can help save the environment.");
        System.out.println("Throughout this game you will learn about ecofriendly energy and how you can help fight the disasters that");
        System.out.println("coal and other co2 emission energy-sources is creating.");
        System.out.println("You will have to collect parts which ultimately allows you to create a working solar cell and thous ");
        System.out.println(" winning this game.");
        System.out.println(" ");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();
        
        switch (commandWord) {

            case HELP:
                printHelp();
                break;
            
            case GO:
                goRoom(command);
                break;
            
            case QUIT:
                wantToQuit = quit(command);
                break;
            
            case PICKUP:
                // ADD CODE
                break;
            
            case TALK:
                // ADD CODE
                break;
                
            case A:
                // ADD CODE
                break;
            
            case B:
                // ADD CODE
                break;
                
            case C:
                // ADD CODE
                break;
                
            case D:
                // ADD CODE
                break;
                
            default:
                System.out.println("I don't know what you mean...");
        }
        
        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
}
