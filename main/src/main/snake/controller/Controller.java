package main.snake.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.awt.event.*;

import main.snake.graphics.Display;
import main.snake.components.GameObjects;

public class Controller implements ActionListener, KeyListener {
    /**
     *
     * @version 0.0.2
     * @author Andrei-Paul Ionescu
     */

    // Attributes of the class.
    private Display display;
    private Timer timer;
    private final int delay = 15;

    // Constructor of the class.
    public Controller(Display display){

        this.display = display;

        this.timer = new Timer(delay, this);
        timer.start();
    }

    // Methods of the class.
    @Override
    public void keyTyped(KeyEvent event) {

    }

    @Override
    public void keyPressed(KeyEvent event){

        GameObjects.snake.keyPressed(event);
    }

    @Override
    public void keyReleased(KeyEvent event) {

        GameObjects.snake.keyReleased(event);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        GameObjects.snake.paint(display);
        display.revalidate();
        display.repaint();
    }
}
