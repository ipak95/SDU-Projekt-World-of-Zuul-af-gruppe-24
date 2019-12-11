package Domain;

public class Item {
   
    private String name;

    // Constructor to add items inside Game class
    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
