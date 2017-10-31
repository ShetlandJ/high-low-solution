package com.example.allymcgilloway.high_low_solution;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class TestPlayer {

    Player player;
    Card card;
    Card card2;

    @Before
    public void setup(){
        player = new Player("Ally");
        card = new Card(Suit.DIAMONDS, Rank.ACE);
        card2 = new Card(Suit.SPADES, Rank.FOUR);
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
}
