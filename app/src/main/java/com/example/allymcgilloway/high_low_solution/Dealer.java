package com.example.allymcgilloway.high_low_solution;

import java.util.ArrayList;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class Dealer extends Player {


    public Dealer(String name) {
        super(name);
    }


    public void dealCard(Participant player, Deck deck) {
        Card dealtCard = deck.getCard();
        player.addCardToHand(dealtCard);
    }


    public void startDealing(ArrayList<Participant> players, Deck deck) {
        for (Participant player : players) {
            for (int i = 0; i < 2; i++) {
                dealCard(player, deck);
            }
        }
    }


}
