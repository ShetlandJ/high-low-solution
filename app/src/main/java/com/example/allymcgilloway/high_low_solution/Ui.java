package com.example.allymcgilloway.high_low_solution;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class Ui {

    Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }




    public void showDealtCards(ArrayList<Participant> players) {
        for (Participant player : players) {
            System.out.println("\nThe dealer deals.....");
            pause();
            System.out.println(player.describeHand());
            pause();
            System.out.println(player.getName() + " has " + player.getHandValue());
        }
    }

    public void showWinner(Participant winner){
        System.out.println(winner.getName() + " wins all the moolah!");
        goodbye();
    }

    public void goodbye() {
        System.out.println("\nSee ya later alligator!");
        System.exit(1);

    }

    public void pause(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
