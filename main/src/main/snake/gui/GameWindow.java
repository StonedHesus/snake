// The package in which the current Java compilation unit is to be found.
package main.snake.gui;

// Imports from existing Java libraries, classes and interfaces.
import javax.swing.*;
import java.awt.*;

// Imports from custom libraries, classes and interfaces.
import main.snake.components.GameObjects;
import main.snake.components.Snake;
import main.snake.controller.Controller;
import main.snake.graphics.Display;
import main.snake.settings.Settings;

public class GameWindow extends JFrame implements Settings{
    /**
     *
     * This here method models the game window on which the game information will be displayed.
     *
     * @version 0.0.2
     * @author Andrei-Paul Ionescu
     */

    // Attributes of the class.
    Display display;

    // Constructors of the class.
    public GameWindow(){

        // Invoke the initialise method which deals with initialisation of the current JFrame.
        this.initialise();
    }

    // Private methods of the class.
    private void initialise(){
        /**
         * Initialise the JFrame object to the desired specifications.
         *
         *
         * @since 0.0.1
         * @version 0.0.1
         * @author Andrei-Paul Ionescu
         * @location Home office.
         */

        // Instantiate the display field of the current object which called the initialise method, by passing to it the
        // initial screen dimensions which are stored within constants in the Settings interface.
        this.display = new Display(INITIAL_SCREEN_WIDTH, INITIAL_SCREEN_HEIGHT);

        // Instantiate a new Controller which is linked with the current view/JFrame.
        new Controller(this.display);
        
        // Set the dimensions of the JFrame to the initial ones which are stored within the Settings interface.
        this.setSize(new Dimension(INITIAL_SCREEN_WIDTH, INITIAL_SCREEN_HEIGHT));

        // Set the title of the JFrame to String object stored within the GAME_TITLE constant which is to be found 
        // within the Settings interface.
        this.setTitle(GAME_TITLE);

        // Make the JFrame visible, set it to the centre of the screen by passing null as the argument of setLocationRelativeTo(),
        // and add the display object to the current JFrame, which is currently manipulated object.
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.add(this.display);

        // Set the default closing operation with the aid of the Swing constant EXIT_ON_CLOSE.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
