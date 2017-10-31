package com.example.allymcgilloway.high_low_solution;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

import static android.media.CamcorderProfile.get;



/**
 * Created by allymcgilloway on 17/10/2017.
 */

public class Game {

    Scanner scanner = new Scanner( System.in );


    private Deck deck;
    private Dealer dealer;
    private ArrayList<Participant> players;
    private Ui ui;

    public Game(Deck deck, Ui ui) {
        this.deck = deck;
        this.dealer = new Dealer("Dealer");
        this.players = new ArrayList<>();
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
        this.ui = ui;
    }

    public ArrayList<Participant> getPlayers() {
        return players;
    }

    public void play() {
        Participant player1 = players.get(0);
        Participant player2 = players.get(1);
        dealer.startDealing(this.players, this.deck);
        ui.showDealtCards(this.players);
        hitOrStay(player1);
        System.out.println(player1.getHandValue());
        hitOrStay(player2);
        System.out.println(player2.getHandValue());
        Participant winner = checkWinner(players);
        ui.showWinner(winner);

    }
    public void playerIsBust(Player player){
        if (player.getHandValue() > 21) {
            boolean gameOver = true;
        }
    }

    public void hitOrStay(Participant player) {

        System.out.println("Player, do you want to hit or stay?: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input == "H"){
            dealer.dealCard(player, deck);
        }
    }





    public Participant checkWinner(ArrayList<Participant> players){
        Participant player1 = players.get(0);
        Participant player2 = players.get(1);
        if (player1.getHandValue() == player2.getHandValue()){
            return null;
        }
        return player1.getHandValue() > player2.getHandValue() ?player1 : player2;

    }
}
