package com.example.allymcgilloway.high_low_solution;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by allymcgilloway on 26/10/2017.
 */

public class TestGame {

    private Game game;
    private Deck deck;
    private Deck spyDeck;
    private Player player1;
    private Player player2;
    private ArrayList<Participant> players;
    private Ui ui;
    private Card card1;
    private Card card2;

    @Before
    public void before(){
        deck = new Deck();
        spyDeck = Mockito.spy(deck);
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        ui = mock(Ui.class);
        game = new Game(spyDeck, ui);
        card1 = new Card(Suit.DIAMONDS, Rank.FOUR);
        card2 = new Card(Suit.CLUBS, Rank.NINE);
    }

    @Test
    public void gameCanStart(){
        game.play();
        assertEquals(2, game.getPlayers().get(0).getHand().getNumberOfCards());
    }

    @Test
    public void gameHasWinner(){
        player1.addCardToHand(card1);
        player2.addCardToHand(card2);
        Participant player = game.checkWinner(players);
        assertEquals("Player 2", player.getName());

    }
}
