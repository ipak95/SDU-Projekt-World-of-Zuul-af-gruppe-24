package worldofzuul;

public enum CommandWord {

    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"),
    GRAB("grab"), TALK("talk"), LOOK("look"), VIEW("view"),
    ANSWER("answer"), BUILD("build");

    private String commandString;
    
    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    public String toString() {
        return commandString;
    }
}
