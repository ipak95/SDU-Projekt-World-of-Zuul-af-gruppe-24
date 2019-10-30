package worldofzuul;

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
        
        home = new Room("In your home, where it's all calm and safe", false);
        downtown = new Room("Downtown, with lots of people, trafic and noise. Not a calm at all", true);
        beach = new Room("At the beach, where the calming sound of the waves embraces you", false);
        harbour = new Room("At the harbour, where ships and seagulls come in all shapes and sizes", false);
        station = new Room("At the station, where it's just as noisy as downtown", false);
        park = new Room("In the park, a small oasis in the middle of this concrete jungle", false);
        mall = new Room("At the mall, a good place to spend your hard earned money", false);
        rooftop = new Room("On top of the mall, where the sun is always shining, ready to be 'harvested'", false);
        university = new Room("In the university, where knowledge is aquired or used", false);
        
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

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        /*else if (commandWord == CommandWord.PICKUP) {
            if () 
        } */
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
