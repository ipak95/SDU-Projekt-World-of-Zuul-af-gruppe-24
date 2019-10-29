package worldofzuul;

public enum CommandWord
{
<<<<<<< HEAD
    GO, QUIT, HELP, UNKNOWN, PICKUP; 
=======
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), PICKUP("pickup"), TALK("talk"), A("a"), B("b"), C("c"), D("d");
>>>>>>> 1a7d488cca9a92376142c23b4280e64fbdb4e7d5
    
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
