package com.project.casino;

/*
 Name: Kyler Kinsey
 Email: kylerkinsey01@gmail.com
 Date: October 19, 2022
 This card class creates a Card object
*/

public class Card {
    private String value;
    private String suit;
    private String placeholder;

    public Card() {

    }
    public Card(String value, String s, String suit) {
        this.value = value;
        this.placeholder = s;
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }

}
