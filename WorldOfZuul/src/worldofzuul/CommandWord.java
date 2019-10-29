package worldofzuul;

public enum CommandWord
{
    GO, QUIT, HELP, UNKNOWN, PICKUP; 
    
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
