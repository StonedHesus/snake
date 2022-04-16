package main.snake.gui;

import javax.swing.*;
import java.awt.*;

import main.snake.graphics.Display;
import main.snake.settings.Settings;

public class GameWindow extends JFrame implements Settings{
    /**
     *
     * This here method models the game window on which the game information will be displayed.
     *
     * @version 0.01
     * @author Andrei-Paul Ionescu
     * @location Home office.
     */

    // Attributes of the class.
    Display display;

    // Constructors of the class.
    public GameWindow(){

        this.initialise();
    }

    // Private methods of the class.
    private void initialise(){
        /**
         * Initialise the JFrame object to the desired specifications.
         *
         *
         * @since 0.01
         * @version 0.01
         * @author Andrei-Paul Ionescu
         * @location Home office.
         */

        this.display = new Display(INITIAL_SCREEN_WIDTH, INITIAL_SCREEN_HEIGHT);

        this.setSize(new Dimension(INITIAL_SCREEN_WIDTH, INITIAL_SCREEN_WIDTH));
        this.setTitle("Snake");

        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.add(this.display);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
