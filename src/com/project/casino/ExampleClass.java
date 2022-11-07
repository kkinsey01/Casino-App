package com.project.casino;
/*
Name: Kyler Kinsey
        Email: kylerkinsey01@gmail.com
 Date: October 04, 2022
         Example main of running the casino
*/

import java.util.Scanner;

public class ExampleClass {
    public static void main(String[] args) {
        System.out.println("Welcome to Kyler's Casino!");
        Scanner sc = new Scanner(System.in);
        char input;
        do {
            System.out.println("We currently have two card games available to play."
                + "\n(1) High-Low and (2) Blackjack"
                + "\nType the corresponding number to the game you would like to play, or press X to exit");
            input = sc.nextLine().charAt(0);
            switch (input) {
                case '1':
                    HighLowGame game1 = new HighLowGame();
                    break;
                case '2':
                    Blackjack game2 = new Blackjack();
                    break;
                case 'X':
                    break;
                default:
                    System.out.println("Invalid input, try again.");
                    break;
            }
        } while(input != 'X');
        System.out.println("Thank you for playing at Kyler's Casino! Come back soon!");
    }
}
