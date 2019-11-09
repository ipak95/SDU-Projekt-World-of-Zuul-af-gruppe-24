package worldofzuul;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import static worldofzuul.CommandWord.HELP;

public class Game {

    private Player player;
    private Parser parser;
    private Room currentRoom;
    private boolean talk;
    private ArrayList<Room> rooms = new ArrayList<>();
    private HashMap<String, Item> items = new HashMap<>();

    public Game() {
        createRooms();
        parser = new Parser();
        player = new Player();
        createItems();
    }

    private void createRooms() {
        Room home, downtown, beach, harbour, station, park, mall, university, rooftop;

        home = new Room("home", "In your home, where it's all calm and safe", false,
                "It is your room. The radio is on with your favorite song. The light from your light bulb is shining bright" + "\n"
                + ", almost blinding you. The coffee is almost done and you sit and turns on the tv. This is when you" + "\n"
                + "realize that all these electronics are using electricity. Maybe there is a better source than fossil" + "\n"
                + " fuels to power all of these electronics. Lets go downtown and find out!",
                "", "", "");

        downtown = new Room("downtown", "Downtown, with lots of people, traffic and noise. Not a calm at all", true, "Insert Long Description here",
                "What alternative fuel source could help provide electricity to this town, instead of using fossil fuels?",
                "A: Solar panels" + "\n" + "B: Just use more coal" + "\n" + "C: --INSERT OPTION C--" + "\n" + "D: --INSERT OPTION D--", "a");

        beach = new Room("beach", "At the beach, where the calming sound of the waves embraces you", false, "", "", "", "");

        harbour = new Room("harbour", "At the harbour, where ships and seagulls come in all shapes and sizes", false, "insert long description please", "question here", "Answers to question here", "");

        station = new Room("station", "At the station, where it's just as noisy as downtown", true, "insert long description please",
                "Hello sir, what type of transportation method would you like to use today?" + "\n"
                + " If you choose our most environmentally friendly choice, I'll give you a reward!",
                "A: Taxe" + "\n" + "B: El-bus" + "\n" + "C: Steam engine locomotive" + "\n" + "D: Rent a motercycle", "b");

        park = new Room("park", "In the park, a small oasis in the middle of this concrete jungle", false, "insert long description please", "question here", "Answers to question here", "");

        mall = new Room("mall", "At the mall, a good place to spend your hard earned money", false, "insert long description please", "question here", "Answers to question here", "");

        rooftop = new Room("rooftop", "On top of the mall, where the sun is always shining, ready to be 'harvested'", false, "insert long description please", "question here", "Answers to question here", "");

        university = new Room("university", "In the university, where knowledge is acquired and used", true, "insert long description please", "question here", "Answers to question here", "d");

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

        // adding rooms to ArrayList rooms
        rooms.add(home);
        rooms.add(downtown);
        rooms.add(beach);
        rooms.add(harbour);
        rooms.add(station);
        rooms.add(park);
        rooms.add(mall);
        rooms.add(rooftop);
        rooms.add(university);
    }

    public void createItems() {
        Item part1, part2, part3;

        part1 = new Item("Name of first part 1");
        part2 = new Item("Name of first part 2");
        part3 = new Item("Name of first part 3");

        items.put("downtown", part1);
        items.put("station", part2);
        items.put("university", part3);
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

            case ANSWER:
                answer(command);
                break;

            default:
                System.out.println("I don't know what you mean...");
                System.out.println();
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
            System.out.println();
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
            System.out.println();
        } else {
            currentRoom = nextRoom;
            System.out.println();
            System.out.println(currentRoom.getShortDescription());
        }
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            System.out.println();
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
            System.out.println();
        }
    }

    private void talkTo(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("What are you trying to do?   (Hint: Talk)");
            System.out.println();
        } else {
            if (currentRoom.doesRoomHasPerson()) {
                currentRoom.setTalk(true);
                System.out.println(currentRoom.getQuestion());
                System.out.println("");
                System.out.println(currentRoom.getAnswers());
                System.out.println("(Type answer a, answer b, answer c or answer d to answer)");
                System.out.println();
            } else {
                System.out.println("There's no one to talk to");
                System.out.println();
            }
        }
    }

    private void viewInventory(Command command) {
        if (command.hasSecondWord() && command.getSecondWord().equals("inventory")) {
            player.displayInventory();
        } else {
            System.out.println("What you wanna view?  (Hint: Your inventory)");
            System.out.println();
        }
    }

    // this command checks if the answer given by the player is equal to the String value from correctAnswer
    private void answer(Command command) {
        // If answer "this letter" is the same as the argument correctAnswer value
        // This makes it so the player can only type an answer if the "talkTo" method has been used in the room
        if (currentRoom.isTalk() == true && command.hasSecondWord() && command.getSecondWord().equals(currentRoom.getCorrectAnswer())) {
            System.out.println("You answered correct!");
            System.out.println("A part has been added to your inventory");
            System.out.println();
            player.addItem(items.get(currentRoom.getName()));
            currentRoom.setRoomHasPerson(false);
            currentRoom.setTalk(false);
            //Checks for a person in the room. No reason in printing wrong/correct answer if no person exist in room
        } else if (currentRoom.doesRoomHasPerson() == false) {
            System.out.println("No question's or answer's in here");
            System.out.println();
            // Hinting the player about talking to the person before answering the question or typing in the answer
        } else if (currentRoom.isTalk() == false && command.hasSecondWord()) {
            System.out.println("You can't answer anything yet..");
            System.out.println("(Hint: Try and talk to a person first)");
            System.out.println();
        } else {
            System.out.println("Wrong answer. Try again!");
            System.out.println();
        }
    }
}
