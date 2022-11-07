package com.project.casino;

/*
 Name: Kyler Kinsey
 Email: kylerkinsey01@gmail.com
 Date: October 19, 2022
 This CardDeck class creates a CardDeck using ArrayList of Card objects
*/

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
    private String[] values = {"2", "3", "4", "5", "6", "7", "8", "9","10", "J", "Q", "K", "A"};
    private String[] suits = {"Spades", "Clubs", "Diamonds", "Hearts"};
    private ArrayList<Card> deck = new ArrayList<Card>();

    public CardDeck() {
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < values.length; j++) {
                Card c = new Card(values[j], " of ", suits[i]);
                deck.add(c);
            }
        }
    }
    public void getDeck() {
        for (int i = 0; i < deck.size(); i++) {
            System.out.println(deck.get(i));
        }
    }
    public ArrayList<Card> shuffleDeck() {
        Collections.shuffle(deck);
        return deck;
    }
}
