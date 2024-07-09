package week06;

public class App {

	public static void main(String[] args) {
		// Instantiate a deck and two players
		Deck deck = new Deck();
		Player player1 = new Player("Player 1");
		Player player2 = new Player("Player 2");
		
		// Shuffle the deck
		deck.shuffle();
		
		// Deal the cards
		for (int i = 0; i < 52; i++) {
			if (i %2 == 0) {
				player1.draw(deck);
			} else {
				player2.draw(deck);
			}
		}
		// Play the game
		for (int i = 0; i < 26; i++) {
			Card card1 = player1.flip();
			Card card2 = player2.flip();
			
			System.out.println("Player 1 plays: " + card1.getName());
			System.out.println("Player 2 plays: " + card2.getName());
			
			if (card1.getValue() > card2.getValue()) {
				player1.incrementScore();
				System.out.println("Player 1 wins this round!");
			} else if (card2.getValue() > card1.getValue()) {
				player2.incrementScore();
				System.out.println("Player 2 wins this round!");
			} else {
				System.out.println("It's a tie! No points awarded.");
			}
			System.out.println("Current score - Player 1: " + player1.getScore() + ", Player 2: " + player2.getScore());
			System.out.println();
		
		}
		// Determine the winner
		System.out.println("Final score - Player 1: " + player1.getScore() + " " + "Player 2: " + player2.getScore());
		System.out.println();
		
		if (player1.getScore() > player2.getScore()) {
		    System.out.println("Player 1 wins the game!");
		} else if (player2.getScore() > player1.getScore()) {
		    System.out.println("Player 2 wins the game!");
		} else {
		    System.out.println("It's a draw!");
		}

	}

}
