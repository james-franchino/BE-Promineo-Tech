package week05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//
// Copyright (c) 2023 Promineo Tech
// Author:  Promineo Tech Academic Team
// Subject:  Object Oriented Programming
// Java Week 05 Lab
//
    public class Week05OOPLab {
// This Lab will give you a basic look at creating an Object-Oriented Card Game.
    //		The idea here is to prepare you for your Week 6 Unit Final Project.
    //		There are many ways to implement this Lab, please use the tools that you know,
    //		and go from there.
    // These exercises are intended to be coded in order 1 through 5.


    public static void main(String[] args) {


        // A standard deck of playing cards has 52 cards as specified below
        //		i. There are 4 suits:  Clubs, Diamonds, Hearts, & Spades
        //
        //	   ii. Each suit has 13 cards:  Two, Three, Four, Five, Six, Seven,
        //									 Eight, Nine, Ten, Jack, Queen, King & Ace
        //
        //	  iii. Comparing Cards:  When comparing two cards, Ace is high and Two is low.
        //							 to make this easy, a Two will have a value of 2, a
        //							 Three will have a value of 3, ... and an Ace will have
        //							 a value of 14.
        //


        // 1. Card Class:
        //		Create a class called Card to represent a standard playing card.
        //		Fields:   The Card class should have the following fields:
        // 			a. name field
        //			b. suit field
        //			c. value field for comparing against other cards.
        //
        //		Methods:  This class can have any useful method.
        //			a. describe() to display the card information to the Console.
        //			b. Getters & Setters
        //
        System.out.println("\nQuestion 1: Card Class");
        // Add your code here to instantiate a Card
        Card card = new Card("Ace", "Spades", 14);

        // Call the describe method on the newly instantiated card.
        card.describe();





        // 2. Deck Class:
        //		Create a class called Deck.
        //		Fields:  This class should have a list of Card field called cards
        //				 that will hold all the cards in the deck.
        //			List<Card> cards = new ArrayList<Card>();
        //
        //		Constructor: The constructor for the Deck Class should
        // 			instantiate all 52 standard playing cards and add them to the cards list.
        //
        //		Methods:
        //			a.  describe() to describe the deck to the Console --
        //					print out all the cards in the deck.
        //
        System.out.println("\nQuestion 2: Deck Class");
        // Add your code here to instantiate a Deck
        Deck deck = new Deck();

        // Call the describe method on the newly instantiated deck.
        deck.describe();






        // 3. Deck shuffle() Method:
        //		Add a shuffle method within the Deck Class
        System.out.println("\nQuestion 3: Deck shuffle() method");
        // Test your method here
        deck.shuffle();

        // Call the describe method on the newly shuffled deck.
        deck.describe();



        // 4. Deck draw() Method:
        //		Add a draw method within the Deck Class
        System.out.println("\nQuestion 4: Deck draw() method");
        // Test your method here
        Card drawnCard = deck.draw();
        if (drawnCard != null) {
            System.out.println("Drawn card:");
            drawnCard.describe();
        } else {
            System.out.println("The deck is empty.");
        }

        // Describe the deck after drawing a card
        System.out.println("Deck after drawing one card:");
        deck.describe();








        // 5. Create Game Board:
        //		Create and test a method that takes an int as a parameter (representing the
        // 			number of players for a game) and returns a Map<String, List<Card>>
        // 			that represents each player (i.e. "Player 1", "Player 2", etc.)
        //			and their cards.
        //
        // 			The method should create a new instance of Deck, shuffle it,
        // 			and deal the cards out to the "players" in the Map.
        System.out.println("\nQuestion 5: Create Game");
        // Call your method here
        Map<String, List<Card>> gameBoard = createGameBoard(2); // Example with 4 players
        for (Map.Entry<String, List<Card>> entry : gameBoard.entrySet()) {
            System.out.println(entry.getKey() + "'s hand:");
            for (Card card1 : entry.getValue()) {
                card1.describe();
            }
            System.out.println();
        }



    }

    // Method 5: Create Game Board
    public static Map<String, List<Card>> createGameBoard(int numberOfPlayers) {
        Deck deck = new Deck();
        deck.shuffle();
        Map<String, List<Card>> gameBoard = new HashMap<>();

        // Initialize each player's hand
        for (int i = 1; i <= numberOfPlayers; i++) {
            gameBoard.put("Player " + i, new ArrayList<>());
        }

        // Deal cards to each player
        int currentPlayer = 1;
        while (!deck.getCards().isEmpty()) {
            Card drawnCard = deck.draw();
            if (drawnCard != null) {
                gameBoard.get("Player " + currentPlayer).add(drawnCard);
                currentPlayer = (currentPlayer % numberOfPlayers) + 1; // Move to the next player
            }
        }

        return gameBoard;
    }



}