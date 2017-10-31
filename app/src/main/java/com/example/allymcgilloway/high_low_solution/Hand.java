package com.example.allymcgilloway.high_low_solution;

import java.util.ArrayList;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class Hand {

    private ArrayList<Card> cards;
    private int value;


    public Hand() {
        this.cards = new ArrayList<Card>();
        value = 0;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getHandValue() {
        return this.value;
    }

    public int getNumberOfCards() {
        return this.cards.size();
    }

    public void addCard(Card card) {
        this.cards.add(card);
        this.value += card.getValue();
    }

    public String describeHand() {
        String handText = "";
        for (Card card : getCards()) {
            handText += "\n" + card.prettyName();
        }
        return handText;
    }

}