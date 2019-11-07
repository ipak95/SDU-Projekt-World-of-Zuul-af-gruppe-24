package worldofzuul;

import java.util.Scanner;
import static worldofzuul.CommandWord.HELP;

public class Game extends Player {

    private Parser parser;
    private Room currentRoom;

    public Game() {
        createRooms();
        parser = new Parser();
    }

    private void createRooms() {
        Room home, downtown, beach, harbour, station, park, mall, university, rooftop;
// If room value is false, then there is no need to add a String for the second last arguemnt.

        home = new Room("In your home, where it's all calm and safe", false,
                "It is your room. The radio is on with your favorite song. The light from your lightbulb is shining bright" + "\n"
                + ", almost blinding you. The coffee is almost done and you sit and turns on the tv. This is when you" + "\n"
                + "realize that all these eletrocnics are using electricity. Maybe there is a better source than fossil" + "\n"
                + " fuels to power all of these eletronics. Lets go downtown and find out!",
                "", 0);

        downtown = new Room("Downtown, with lots of people, trafic and noise. Not a calm at all", true, "Insert Long Desprition here",
                "What alternative fuelsource could provide eletricity to this town, instead of using fossilfuels?", 2);

        beach = new Room("At the beach, where the calming sound of the waves embraces you", false, "", "", 3);
        harbour = new Room("At the harbour, where ships and seagulls come in all shapes and sizes", false, "insert long description please", "question here", 4);
        station = new Room("At the station, where it's just as noisy as downtown", true, "insert long description please", "", 2);
        park = new Room("In the park, a small oasis in the middle of this concrete jungle", false, "insert long description please", "question here", 6);
        mall = new Room("At the mall, a good place to spend your hard earned money", false, "insert long description please", "question here", 7);
        rooftop = new Room("On top of the mall, where the sun is always shining, ready to be 'harvested'", false, "insert long description please", "question here", 8);
        university = new Room("In the university, where knowledge is aquired or used", true, "insert long description please", "question here", 9);

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

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Goodbye.");
    }

    private void printWelcome() {
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
        System.out.println(currentRoom.getShortDescription());
    }

    private boolean processCommand(Command command) {
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
            case GRAB:
                // ADD CODE
                break;
            case VIEW:
                viewInventory(command);
                break;

            case TALK:
                talkTo(command);
                break;
            case A:
                answerA(command);
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

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getShortDescription());
        }
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

    private void lookAround(Command command) {
        if (command.hasSecondWord() && command.getSecondWord().equals("around")) {
            System.out.println(currentRoom.getLongDescription());
        } else {
            System.out.println("Look where?  (Hint: around)");
        }
    }

    private void talkTo(Command command) {
        CommandWord commandWord = command.getCommandWord();
        Scanner reader2 = new Scanner(System.in);
        if (command.hasSecondWord()) {
            System.out.println("What are you trying to do?   (Hint: Talk)");
        } else {
            if (currentRoom.doesRoomHasPerson() == true) {
                System.out.println(currentRoom.getQuestion());
                System.out.println("");
                System.out.println("(Type A, B, C or D to answer)");
                /*switch (commandWord) {
                    case A:
                        answerA(command);
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
                }*/

            } else {
                System.out.println("There's no one to talk to");
            }
        }

    }

    private void answerA(Command command) {
        if (currentRoom.getCorrectAnswer() == 1) {
            System.out.println("You answered correct!");
            Item solarPanelPart = new Item("Solar panel part");
            System.out.println("A part has been added to your inventory" + inventory.add(solarPanelPart));
        } else {
            System.out.println("Wrong answer");
        }
    }

    private void viewInventory(Command command) {
        if (command.hasSecondWord() && command.getSecondWord().equals("inventory")) {
            System.out.println(getInventory().toString());
        } else {
            System.out.println("What you wanna view?  (Hint: Your inventory)");

    }
}
}
