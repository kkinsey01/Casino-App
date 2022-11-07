package com.project.casino;

/*
 Name: Kyler Kinsey
 Email: kylerkinsey01@gmail.com
 Date: October 22, 2022
 This HighLowGame class simulates a user playing the High Low Card Game
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

// Uses stacks to organize deck, top of the stack is top of the deck. Makes sure that a card isn't used more than once
// Play Traditional Blackjack. Player and dealer gets deal two cards and the goal is to get a value of 21.
// Player can choose to hit, to add cards to their hand, or stand to hold on their card values
// Dealer plays with respect to player hand determining whether to hit or stand
// If neither hit Blackjack (21), then the highest valued hand < 21 wins
// The only element not considered is Ace. In this Blackjack implementation, Ace is considered 1 and not 1 or 10 depending on the hand


public class Blackjack {
    Scanner sc = new Scanner(System.in);
    private CardDeck cd = new CardDeck();
    private ArrayList<Card> tempDeck = new ArrayList<>();
    private Stack<Card> deck = new Stack<>();
    private Card[] playerHand = new Card[10];
    private int numPlayerCards = 0;
    private Card[] dealerHand = new Card[10];
    private int numDealerCards = 0;


    public Blackjack () {
        play();
    }
    public void createStack() {
        tempDeck = cd.shuffleDeck();
        for(int i = 0; i < 52; i++) {
            deck.push(tempDeck.get(i));
        }
    }
    public int countPlayerValue() {
        int handValue = 0;
        String currValue = "";
        for(int i = 0; i < numPlayerCards; i++) {
            currValue = playerHand[i].getValue();
            if(currValue.equals("J") || currValue.equals("Q") || currValue.equals("K"))
                handValue += 10;
            else if(currValue.equals("A"))
                handValue += 1;
            else {
                handValue += Integer.parseInt(currValue);
            }
        }
        return handValue;
    }
    public int countDealerValue() {
        int handValue = 0;
        String currValue = "";
        for(int i = 0; i < numDealerCards; i++) {
            currValue = dealerHand[i].getValue();
            if(currValue.equals("J") || currValue.equals("Q") || currValue.equals("K"))
                handValue += 10;
            else if(currValue.equals("A"))
                handValue += 1;
            else {
                handValue += Integer.parseInt(currValue);
            }
        }
        return handValue;
    }
    public void play() {
        String playAgain = "";
        System.out.println("Welcome to Blackjack!");
        do {
            createStack();
            numPlayerCards = 0;
            numDealerCards = 0;
            Card playerCard1 = addCardToPlayerHand();
            Card dealerCard1 = addCardToDealerHand();
            Card playerCard2 = addCardToPlayerHand();
            Card dealerCard2 = addCardToDealerHand();
            System.out.println("The dealer has " + dealerCard1.toString() + " (face up)");
            System.out.println("You have " + playerCard1.toString() + " and " + playerCard2.toString());
            askAnotherCard();
            while (countDealerValue() < countPlayerValue()) {
                addCardToDealerHand();
            }
            if (checkPlayerWin(countPlayerValue(), countDealerValue()))
                System.out.println("Congrats, you win this hand. The dealer had " + countDealerValue());
            else if (countPlayerValue() > 21) {

            }
            else {
                System.out.println("You lost. The dealer had " + countDealerValue());
            }
            System.out.println("Would you like to play again? (Yes or No)");
            playAgain = sc.nextLine().toUpperCase();
        } while (!playAgain.equals("NO"));
        System.out.println("Thank you for playing Blackjack");

    }
    public Card addCardToPlayerHand() {
        playerHand[numPlayerCards] = deck.pop();
        Card card = playerHand[numPlayerCards];
        numPlayerCards++;
        return card;
    }
    public Card addCardToDealerHand() {
        dealerHand[numDealerCards] = deck.pop();
        Card card = dealerHand[numDealerCards];
        numDealerCards++;
        return card;
    }
    public void askAnotherCard() {
        String input;
        while (!checkBlackJack(countPlayerValue()) && countPlayerValue() < 21) {
            System.out.println("Hit or stand? Your hand value is " + countPlayerValue());
            input = sc.nextLine().toUpperCase();
            switch (input) {
                case "HIT":
                    System.out.println("Your next card is " + addCardToPlayerHand());
                    break;
                case "STAND":
                    while (countDealerValue() < 21 && !checkPlayerWin(countPlayerValue(), countDealerValue())) {
                        addCardToDealerHand();
                    }
                    break;
                default:
                    System.out.println("Invalid input, try again");
                    break;
            }
            if (input.equals("STAND"))
                break;
        }
        if (!checkBlackJack(countPlayerValue()) && countPlayerValue() < 21){

        }
        else if (checkBlackJack(countPlayerValue())) {
            System.out.println("Congrats, you win this hand!");
        }
        else {
            System.out.println("You bust, dealer wins!");
        }
    }
    public boolean checkBlackJack(int handValue) {
        return handValue == 21;
    }
    public boolean checkPlayerWin(int playerValue, int dealerValue) {
        if (checkBlackJack(playerValue))
            return true;
        else if (checkBlackJack(dealerValue))
            return false;
        else if (playerValue > 21)
            return false;
        else if (dealerValue > 21)
            return true;
        else if (playerValue > dealerValue)
            return true;
        else {
            return false;
        }
    }

}
