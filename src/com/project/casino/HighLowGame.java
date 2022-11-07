package com.project.casino;

/*
 Name: Kyler Kinsey
 Email: kylerkinsey01@gmail.com
 Date: October 19, 2022
 This HighLowGame class simulates a user playing the High Low Card Game
*/


import java.util.ArrayList;
import java.util.Scanner;
// The player will place a bet on the table and the dealer will deal a card face up.
// The player must decide whether the next card to be dealt will be higher or lower in value to the face-up card.
// If you guess correctly, you win the displayed payout.
// If you lose, your wager is lost.

public class HighLowGame {
    static Scanner sc = new Scanner(System.in);
    private CardDeck cd = new CardDeck();
    private ArrayList<Card> deck;

    public HighLowGame() {
        play();
    }

    public String guess(String s) {
        int firstCardValue = getFirstCard().getValue().charAt(0);
        int secondCardValue = getSecondCard().getValue().charAt(0);
        String result = "";
        if (s.equals("1")) {
            if (firstCardValue < secondCardValue) {
                result = "win";
            }
            else if (firstCardValue > secondCardValue) {
                result = "lose";
            }
            else {
                result = "draw";
            }
        }
        else if (s.equals("2")) {
            if (firstCardValue > secondCardValue) {
                result = "win";
            }
            else if (firstCardValue < secondCardValue) {
                result = "lost";
            }
            else {
                result = "draw";
            }
        }
        return result;
    }
    public void play() {
        String input;
        boolean exit = false;
        System.out.println("Welcome to our High/Low card game!");
        System.out.println("The rules are simple. The dealer will deal a card, and you place a bet to determine if the next card is going to be higher or lower.");
        System.out.println("If you decide to stop playing, type 'X' to exit");
        do {
            deck = cd.shuffleDeck();
            System.out.println();
            System.out.println("The first card is " + getFirstCard());
            System.out.println("Place bet: \n"
                    + "1) Higher \n"
                    + "2) Lower \n"
                    + "3) Type X or 3 to exit");
            input = sc.nextLine();
            switch(input) {
                case "1": case "2":
                    if(guess(input).equals("win")) {
                        System.out.println("You win! The second card was " + getSecondCard());
                    }
                    else if(guess(input).equals("lost")) {
                        System.out.println("You lose! The second card was " + getSecondCard());
                    }
                    else {
                        System.out.println("It's a draw! The second card was " + getSecondCard());
                    }
                    break;
                case "X": case "3":
                    System.out.println("Thank you for playing");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input, please type 1 for higher, 2 for lower, or X to exit");
                    break;
            }
        } while (!exit);

    }
    public Card getFirstCard(){
        return deck.get(0);
    }
    public Card getSecondCard() {
        return deck.get(1);
    }
}
