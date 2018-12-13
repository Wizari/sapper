package com.gmail.wizaripost.game.saper.view;

import com.gmail.wizaripost.game.saper.logic.IClickListener;

import java.awt.event.ActionListener;

public interface IGameView {

    void addBackground(int[][] calculateField);

    void restartButtonRestart(String title);

    void addRestartListener(ActionListener listener);

    void clearBackground();

    void addListener(IClickListener listener);

    void addRigthClickListener(IClickListener listener);

    void openBox(int y, int x);

    void closeBox();

    void closeBox(int y, int x);


    void setVisible(boolean visible);
}
