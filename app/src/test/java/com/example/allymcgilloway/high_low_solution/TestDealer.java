package com.example.allymcgilloway.high_low_solution;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class TestDealer {

    Player player;
    Dealer spyDealer;
    Deck deck;
    Deck spyDeck;
    Card card1;
    Card card2;

    @Before
    public void setup(){
        deck = new Deck();
        player = new Player("Player1");
        spyDeck = Mockito.spy(deck);
        spyDealer = new Dealer("Dealer");
        card1 = new Card(Suit.HEARTS, Rank.ACE);
        card2 = new Card(Suit.CLUBS, Rank.QUEEN);
    }

    @Test
    public void dealerCanDeal(){
        Mockito.when(spyDeck.getCard()).thenReturn(new Card(Suit.CLUBS, Rank.ACE));
        spyDealer.dealCard(player, spyDeck);
        assertEquals(1, player.getHand().getNumberOfCards());
        assertEquals(Suit.CLUBS, player.getHand().getCards().get(0).getSuit());
        assertEquals(Rank.ACE, player.getHand().getCards().get(0).getRank());

    }

}
