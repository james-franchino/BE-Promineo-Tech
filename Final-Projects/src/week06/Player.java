package week06;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Card> hand;
    private int score;
    private final String name;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.hand = new ArrayList<>();
    }

    public void describe() {
        System.out.println("Player " + name + " score: " + score);
        for (Card card : hand) {
            card.describe();
        }
    }
    public Card flip() {
        if (!hand.isEmpty()) {
            return hand.removeFirst();
        }
        return null;
    }
    public void draw(Deck deck) {
        Card card = deck.draw();
        if (card != null) {
            hand.add(card);
        }
    }
    public void incrementScore() {
        score++;
    }

	public int getScore() {
		return this.score;
	}
}
