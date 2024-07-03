package week05;


// Card class
class Card {
    private String name;
    private String suit;
    private int value;

    // Constructor
    public Card(String name, String suit, int value) {
        this.name = name;
        this.suit = suit;
        this.value = value;

        // Getters and setters

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // Describe card information
    public void describe() {
        System.out.println("Card: " + name + " of " + suit + " (Value: " + value + ")");
    }
}
