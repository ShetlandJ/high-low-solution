package com.example.allymcgilloway.high_low_solution;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

import static android.media.CamcorderProfile.get;


/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class Game {

    Scanner scanner = new Scanner(System.in);


    private Deck deck;
    private Dealer dealer;
    private ArrayList<Participant> players;
    private Ui ui;
    private boolean isBust;

    public Game(Deck deck, Ui ui) {
        this.deck = deck;
        this.dealer = new Dealer("Dealer");
        this.players = new ArrayList<>();
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
        this.ui = ui;
        this.isBust = false;
    }

    public ArrayList<Participant> getPlayers() {
        return players;
    }

    public void play() {
        Participant player1 = players.get(0);
        Participant player2 = players.get(1);
        dealer.startDealing(this.players, this.deck);
        ui.showDealtCards(this.players);

        while (hitOrStay(player1)) {
            dealer.dealCard(player1, this.deck);
            System.out.println("player1's hand is " + player1.getHandValue());
            aceChecker(player1);
            if (playerIsBust(player1)) {
                ui.showWinner(player2);
            }
        }

        while (hitOrStay(player2)) {
            dealer.dealCard(player2, this.deck);
            System.out.println("player2's hand is " + player2.getHandValue());
            aceChecker(player2);
            if (playerIsBust(player2)) {
                ui.showWinner(player1);
            }
        }

        Participant winner = checkWinner(players);
        ui.showWinner(winner);

    }

    public boolean playerIsBust(Participant player) {
        if (player.getHandValue() > 21) {
            System.out.println(player.getName() + " is out");
            return true;
        }
        return false;
    }

    public boolean hitOrStay(Participant player) {

        System.out.println(player.getName() + ", do you want to hit or stay?: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.equals("H")) {
            return true;
        }
        return false;
    }

    public Participant checkWinner(ArrayList<Participant> players) {
        Participant player1 = players.get(0);
        Participant player2 = players.get(1);
        if (player1.getHandValue() == player2.getHandValue()) {
            return null;
        }
        return player1.getHandValue() > player2.getHandValue() ? player1 : player2;

    }

    public boolean handChecker(Participant player, Rank cardRank) {
        for (Card card : player.getHand().getCards()) {
            if (card.getRank() == cardRank) ;
            return true;
        }
        return false;
    }

    public void aceChecker(Participant player) {
        if (handChecker(player, Rank.ACE)) {
            Rank.ACE.setValue(1);
        }

    }

}
//            "if hand value > 21 && hand contains CardType.ACE then first cardtype.ace value = 1"

