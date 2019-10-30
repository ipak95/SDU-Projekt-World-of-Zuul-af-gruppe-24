package worldofzuul;

public enum CommandWord
{

    GO, QUIT, HELP, UNKNOWN, PICKUP, TALK, A, B, C, D; 

    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), PICKUP("pickup"), TALK("talk"), A("a"), B("b"), C("c"), D("d");

    
    private String commandString;
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    public String toString()
    {
        return commandString;
    }
}
