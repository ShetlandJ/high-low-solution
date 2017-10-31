package com.example.allymcgilloway.high_low_solution;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public interface Participant {

    public void addCardToHand(Card card);

    public int getHandValue();

    public String describeHand();

    public String getName();

    public Hand getHand();



}
