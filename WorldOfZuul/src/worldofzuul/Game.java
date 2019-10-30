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
        Room home, downtown, beach, harbour, station, park, mall, university, rooftop;
        
        home = new Room("In your home, where it's all calm and safe", false, 1);
        downtown = new Room("Downtown, with lots of people, trafic and noise. Not a calm at all", true, 2);
        beach = new Room("At the beach, where the calming sound of the waves embraces you", false, 3);
        harbour = new Room("At the harbour, where ships and seagulls come in all shapes and sizes", false, 4);
        station = new Room("At the station, where it's just as noisy as downtown", false, 5);
        park = new Room("In the park, a small oasis in the middle of this concrete jungle", false, 6);
        mall = new Room("At the mall, a good place to spend your hard earned money", false, 7);
        rooftop = new Room("On top of the mall, where the sun is always shining, ready to be 'harvested'", false, 8);
        university = new Room("In the university, where knowledge is aquired or used", false, 9);
        
        //"Mapping out" all the rooms and how the are connected (setExit)
        home.setExit("north", downtown);

        downtown.setExit("west", beach);
        downtown.setExit("east", harbour);
        downtown.setExit("north", park);
        downtown.setExit("south", home);

        beach.setExit("east", downtown);

        harbour.setExit("north", station);
        harbour.setExit("west", downtown);
        
        station.setExit("south", harbour);

        park.setExit("south", downtown);
        park.setExit("north", mall);
        
        mall.setExit("south", park);
        mall.setExit("north", rooftop);
        mall.setExit("west", university);
        
        rooftop.setExit("south", mall);
        
        university.setExit("east", mall);

        currentRoom = home;
    }

    public void play() 
    {            
        printWelcome();

                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Goodbye.");
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
            case LOOK:
                lookAround(command);
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
        private void lookAround(Command command) {
        if(!command.hasSecondWord()) {
            System.out.println("Look where?  (Hint: around)");
    } else {
        String description = command.getSecondWord(); 
        
            System.out.println(currentRoom.getLongDescription());
        }  
        
}
}
