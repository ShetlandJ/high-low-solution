package com.example.allymcgilloway.high_low_solution;

/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class Runner {

    public static void main(String[] args) {
        Ui ui = new Ui();
        Deck deck = new Deck();
        Game game = new Game(deck, ui);
        game.play();

    }
}
