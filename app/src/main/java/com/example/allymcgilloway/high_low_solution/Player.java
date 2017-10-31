package com.example.allymcgilloway.high_low_solution;

import java.util.ArrayList;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class Player implements Participant {
    private Hand hand;
    private String name;


    public Player(String name) {
        this.name = name;
        this.hand = new Hand();

    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

//    public ArrayList<Hand> getHandArray(){
//        return this.hand;
//    }


    @Override
    public int getHandValue() {
        return this.hand.getHandValue();
    }


    @Override
    public void addCardToHand(Card card) {
        if (card.getRank() == Rank.ACE && hand.getHandValue() >= 11) {
            card.getRank().setValue(1);
            this.hand.addCard(card);
        } else {
            this.hand.addCard(card);
        }
    }

    @Override
    public String describeHand() {
        String cardsInHand = "\n" + this.name + " ";
        return cardsInHand + hand.describeHand();
    }

//
//    public void handChecker(Participant player, Rank cardRank) {
//        for (Card card : player.getHand().getCards()) {
//            if (card.getRank() == cardRank) {
//                card.getRank().setValue(1);
//            }
//        }
//    }

}