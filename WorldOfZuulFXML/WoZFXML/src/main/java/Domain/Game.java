package Domain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.nio.file.Path;

public class Game {

    private Player player;
    private static Room currentRoom;

    private boolean talk;
    private ArrayList<Room> rooms = new ArrayList<>();
    private HashMap<String, Item> items = new HashMap<>();

    Room home, downtown, beach, harbour, station, park, mall, university, rooftop;

    public Game() {
        createRooms();
        player = new Player();
        createItems();
    }

    public void createRooms() {

        home = new Room("home", "In your home, where it's all calm and safe", false,
                "It is your room. The radio is on with your favourite song. The light from your lightbulb is shining" + "\n"
                + "bright, almost blinding you. The coffee is almost done, and you sit down in your recliner. You" + "\n"
                + "turn on the tv and this is when you realise that all these electronics are using electricity. Maybe" + "\n"
                + "there is a better source than fossil fuels to power all of it. Let’s go on an adventure to find out!",
                "", "", 'p');

        downtown = new Room("downtown", "Downtown, with lots of people, traffic and noise. Not a calm place at all", true,
                "You look around. You see a lot of burning light, even though it’s not dark. You wonder why all" + "\n"
                + "the stores keep their light turned on when it’s not needed. A random person approaches you;" + "\n"
                + "he’s willing to talk.",
                "Maybe we can’t control when the stores have their lights turned on, but maybe we can change how they" + "\n"
                + "get the electricity needed? Don’t you think?",
                "A: Why are you talking to me?" + "\n"
                + "B: You think? I’m not sure actually" + "\n"
                + "C: Yes! We could use something like solar panels" + "\n"
                + "D: It’s not possible", 'c');

        beach = new Room("beach", "At the beach, where the calming sound of the waves embraces you", false,
                "You walk along the beach, sniffs in the fresh air. You are almost alone, only some seagulls" + "\n"
                + "screams in the distance. You suddenly spot a bottle with what seems to be a note inside. It" + "\n"
                + "could be fun to see what is says.",
                "", "", 'p');

        harbour = new Room("harbour", "At the harbour, where ships and seagulls come in all shapes and sizes", true,
                "You see plenty of old people. Relaxing at the pier, just admiring the beautiful ships. There are a" + "\n"
                + "few youngsters who skate. You then decide to sit beside an older gentleman who seems grumpy. As he" + "\n"
                + "starts to talk, you listen. He tells you he is having a hard time adjusting to the new technologies" + "\n"
                + "because they just installed solar panels on his ship to be more environmentally friendly. Apparently" + "\n"
                + "when you use coal, you pollute the air around the globe and ships are responsible for around 18% of" + "\n"
                + "air pollution around the world. He does not believe it and want to use more coal, because why change" + "\n"
                + "something you know works. Maybe you can change his mind about solar panels?",
                "How will you change his mind about solar panels?",
                "A: Make him understand your points through harsh words" + "\n"
                + "B: You can’t teach an old dog new tricks. Just leave and let him be grumpy." + "\n"
                + "C: Talk about how you can reduce the pollution to a minimum by using solar panels and by that helping save the planet" + "\n"
                + "D: Do a flip", 'c');

        station = new Room("station", "At the station, where it's just as noisy as downtown", true,
                "You are at the station. People seem to be in a rush to get wherever they need to be. There is a" + "\n"
                + "vending machine, maybe you can grab a snack. Beside the vending machine is a poster for an " + "\n"
                + "upcoming movie: The Solarman! It seems like he is a superhero who uses solar energy to create" + "\n"
                + "a better environment inside towns, by installing solar panels on the rooftops. They could" + "\n"
                + "probably use that downtown." + "\n"
                + "As you look around you see a ticket seller being idle, just begging for customers. Maybe you" + "\n"
                + "should buy a ticket home for later?",
                "Counter lady: Hello sir, what type of transportation method would you like to use today? If you" + "\n"
                + "choose our most environmentally friendly choice, I'll give you a reward!",
                "A: A taxi" + "\n" + "B: An electric bus" + "\n" + "C: A steam locomotive" + "\n" + "D: Rent a scooter", 'b');

        park = new Room("park", "In the park, a small oasis in the middle of this concrete jungle", true,
                "You are standing in the middle of the park. The place seems to be quiet and peaceful. Suddenly" + "\n"
                + "the peace is disturbed by a group of activists that seem to be angry about something! Maybe you should" + "\n"
                + "go check it out / look around to see if they have anything useful to say?",
                "Activist asks with an angry voice: Do you know what the cleanest form for energy is",
                "A: Solar power station " + "\n" + "B: Coal-fired power station" + "\n"
                + "C: Fuel power station" + "\n" + "D: Nuclear power station", 'a');

        mall = new Room("mall", "At the mall, a good place to spend your hard earned money", true,
                "In your quest to find the remaining pieces for your solar panel you find yourself at the mall. Next" + "\n"
                + "to the food stalls you see two men advertising clean and sustainable energy. They might have the missing" + "\n"
                + "pieces in stock.",
                "Sellers: Hello good sir! The good people from SolarGale want to make your life cleaner and" + "\n"
                + "better! Therefor we are giving away parts for a solar panel to all that can answer our very " + "\n"
                + "important question about clean energy. Why use solar panels?",
                "A: Because it with help reducing CO2 emission and you can make money of it" + "\n" + "B: Because it increases global warming" + "\n"
                + "C: Because you can make money" + "\n" + "D: It will look good on your house",
                'a');

        rooftop = new Room("rooftop", "On top of the mall, where the sun is always shining, ready to be 'harvested'", true,
                "You find yourself on the roof of the mall. You see a man with a glass container in his hand. On" + "\n"
                + "the container you notice a label saying, \"Fossil Fuel”. You might be able to convince him to use solar" + "\n"
                + "energy instead.",
                "Buddy, I’m not buying this speech about your solar crap! Give me a good reason why I should invest in" + "\n"
                + "a solar solution.",
                "A: It’s a smarter choice" + "\n" + "B: Save the children!" + "\n"
                + "C: Because, you know, just do it!" + "\n" + "D: Save thousands of dollars and increase property value",
                'd');

        university = new Room("university", "In the university, where knowledge is acquired and used", true,
                "You enter the university. People are sitting at tables, studying and talking. A lector is working on" + "\n"
                + "some electronics inside a lab. He looks knowledgeable. Maybe he can help you with assembling the solar panel?",
                "", "", 'p');

        currentRoom = home;
        // Sets the first room to home, so once you start the game, the Setter method (Switch at line 150 to 190) does not 
        // require you to leave home and then go back in to set the first rooms value of "currentRoom" and by that
        // allowing showMap switch method to work at home in the beginning of the game
    }

    // items are created here 
    public void createItems() {
        Item part1, part2, part3, part4, part5, part6;

        // Part 1 to 6 are created here and named
        part1 = new Item("wires");
        part2 = new Item("glass panel");
        part3 = new Item("crystalline cells");
        part4 = new Item("battery");
        part5 = new Item("frame");
        part6 = new Item("junction box");

        // Items are put into a hashmap and given a certain key
        // The key is defined as the room name
        items.put("downtown", part1);
        items.put("harbour", part2);
        items.put("station", part3);
        items.put("park", part4);
        items.put("mall", part5);
        items.put("rooftop", part6);
    }

    // Look around that sets currentRoom.setTalk to true
    // and returns the long description for the current room
    public String lookAround() {
        currentRoom.setTalk(true);
        return currentRoom.getLongDescription();
    }

    // Method used to talk to NPC's
    public String talkTo() {

        // Checks if room has a person and if talk is true
        if (currentRoom.doesRoomHasPerson() && currentRoom.isTalk()) {
            
            // "Talking with the professor"
            // If currentRoom is university and player has less than 6 parts
            // return text
            if (currentRoom.getName().equals("university") && player.getInventory().size() < 6) {
                return "Hello there! \n"
                        + "I think you need more parts to build the solar panel. \n"
                        + "Go out and find the remaining parts!";
            
            // "Talking with the professor"
            // If currentRoom is university and player has 6 or more parts
            // return text
            } else if (currentRoom.getName().equals("university") && player.getInventory().size() >= 6) {
                return "Fantastic! \n"
                        + "You found all the parts for the solar panel, let's build it!";
                
            // Adds a hint to the player, that quistions are answered with the buttons
            } else {
                return currentRoom.getQuestion() + "\n" + currentRoom.getAnswers()
                        + "\n (Press answer a, answer b, answer c or answer d to answer)";
            }
            
        // If there's no person in the room and talk is false
        // return text
        } else {
            return "There's no one to talk to";
        }
    }

    // Switch that enables travling between rooms
    public void setCurrentRoom(String Room) {
        switch (Room) {

            case "Downtown":
                currentRoom = downtown;
                break;

            case "Beach":
                currentRoom = beach;
                break;

            case "Harbour":
                currentRoom = harbour;
                break;

            case "Home":
                currentRoom = home;
                break;

            case "Mall":
                currentRoom = mall;
                break;

            case "Park":
                currentRoom = park;
                break;

            case "Rooftop":
                currentRoom = rooftop;
                break;

            case "Station":
                currentRoom = station;
                break;

            case "University":
                currentRoom = university;
                break;

        }
    }

    // Method that returns the correct map image for the current room
    public static String ShowMap() throws FileNotFoundException {

        switch (currentRoom.getName()) {

            case "downtown":
                return "src/main/resources/com/mycompany/wozfxml/pics/Map_Downtown.png";

            case "beach":
                return "src/main/resources/com/mycompany/wozfxml/pics/Map_Beach.png";

            case "harbour":
                return "src/main/resources/com/mycompany/wozfxml/pics/Map_Harbour.png";

            case "home":
                return "src/main/resources/com/mycompany/wozfxml/pics/Map_Home.png";

            case "mall":
                return "src/main/resources/com/mycompany/wozfxml/pics/Map_Mall.png";

            case "park":
                return "src/main/resources/com/mycompany/wozfxml/pics/Map_Park.png";

            case "rooftop":
                return "src/main/resources/com/mycompany/wozfxml/pics/Map_Rooftop.png";

            case "station":
                return "src/main/resources/com/mycompany/wozfxml/pics/Map_Station.png";

            case "university":
                return "src/main/resources/com/mycompany/wozfxml/pics/Map_University.png";

        }
        return "Map not found";
    }

    // Method that displays inventory
    public String viewInventory() {
        return player.displayInventory();
    }

    // This method checks if the answer given by the player is equal to the Char value from correctAnswer
    public String answer(char answer) {

        // If answer is the same as the argument correctAnswer value
        // This makes it so the player can only type an answer if the "talkTo" method has been used in the room
        if (currentRoom.isTalk() == true && currentRoom.getCorrectAnswer() == answer) {
            currentRoom.setRoomHasPerson(false);
            currentRoom.setTalk(false);

            player.addItem(items.get(currentRoom.getName()));

            return "You answered correct! \n A part has been added to your inventory";

            // Checks for a person in the room. No reason in printing wrong/correct answer if no person exist in room
        } else if (currentRoom.doesRoomHasPerson() == false) {
            return "No questions or answers in here";

            // Hinting the player about talking to the person before answering the question or typing in the answer
        } else if (currentRoom.isTalk() == false) {
            return "You can't answer anything yet.. \n (Hint: Try and talk to a person first)";

        } else {
            return "Wrong answer. Try again!";

        }
    }

    // Method that enables a player to win the game
    public String buildToWin() {

        // If current room isnt university then return text
        if (!currentRoom.getName().equals("university")) {
            return "You should do this in the University instead of here";

            // If current room is univeristy and the player has less then 6 parts 
            // return text
        } else if (currentRoom.getName().equals("university")) {
            if (player.getInventory().size() < 6) {
                return "You need more parts to complete this game";

                // If player has 6 or more parts return text
            } else if (player.getInventory().size() >= 6) {
                return "Congratulations, you have won the game! \n"
                        + "You gathered all the solar panel pieces "
                        + "and assembled it. You have contributed to a better "
                        + "future and gathered knowledge along the way. \n\n"
                        + "Use the knowledge wisely and make a change where you can!";
            }
        }
        return null;
    }
}
