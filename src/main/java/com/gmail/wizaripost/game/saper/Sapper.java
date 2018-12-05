package com.gmail.wizaripost.game.saper;

import com.gmail.wizaripost.game.saper.logic.SapperLogic;
import com.gmail.wizaripost.game.saper.view.SapperWindow;

public class Sapper {
    public static void main(String[] args) {
        SapperWindow gameWindow = new SapperWindow("Sapper");

//        Deck deck = new Deck(BlackJackHelper.shuffleDeck(BlackJackHelper.createDeck(), 1000));

//        SapperLogic logic = new SapperLogic(gameWindow);
//        SapperLogic logic = new SapperLogic(deck, gameWindow);

        gameWindow.setVisible(true);
//        logic.start();




    }
}
