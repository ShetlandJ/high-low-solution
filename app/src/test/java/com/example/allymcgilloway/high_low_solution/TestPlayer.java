package com.example.allymcgilloway.high_low_solution;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class TestPlayer {

    Player player;
    Card card;
    Card card2;
    private Player player1;
    private Player player2;
    private Card card3;
    private Card card4;
    private Card card5;


    @Before
    public void setup(){
        player = new Player("Ally");
        card = new Card(Suit.DIAMONDS, Rank.ACE);
        card2 = new Card(Suit.SPADES, Rank.FOUR);
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        card3 = new Card(Suit.DIAMONDS, Rank.KING);
        card4 = new Card(Suit.DIAMONDS, Rank.ACE);
        card5 = new Card(Suit.HEARTS, Rank.ACE);

    }

    @Test
    public void playerHasName(){
        assertEquals("Ally", player.getName());
    }

    @Test
    public void playerCanTakeCard(){
        player.addCardToHand(card);
        assertEquals(1, player.getHand().getNumberOfCards());
    }

    @Test
    public void playerHandValueIs5(){
        player.addCardToHand(card);
        player.addCardToHand(card2);
        assertEquals(5, player.getHandValue());
    }


//    @Test
//    public void handCanBeChecked() {
//        player1.addCardToHand(card3);
//        player1.addCardToHand(card4);
//        assertEquals(false, player1.handChecker(player1, Rank.JACK));
//    }

    @Test
    public void acesAreLow() {
        player1.addCardToHand(card3);
        player1.addCardToHand(card3);
        player1.addCardToHand(card4);
        assertEquals(21, player1.getHandValue());
    }

    @Test
    public void latterAcesAreLow() {
        player1.addCardToHand(card4);
        player1.addCardToHand(card4);
        assertEquals(12, player1.getHandValue());
    }
}
