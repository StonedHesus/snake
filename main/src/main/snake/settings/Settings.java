// The package in which the current Java compilation unit is to be found.
package main.snake.settings;

// Imports from existing Java libraries, classes and interfaces.
import java.awt.*;

public interface Settings {
    /**
     * This here interface contains a collection of constants which serve as the settings for the project.
     *
     *
     * @version 0.0.1
     * @author Andrei-Paul Ionescu
     */

    // Game title 
    final String GAME_TITLE = "Snake";

    // Initial screen settings.
    final int INITIAL_SCREEN_WIDTH  = 600;
    final int INITIAL_SCREEN_HEIGHT = 600;
    Color BACKGROUND_COLOUR         = Color.BLACK;

    // Snake settings.
    Color SNAKE_COLOUR = Color.GREEN;
    final double SNAKE_VELOCITY = 2.5;
    final int INITIAL_SNAKE_LENGTH = 4;
    final int INITIAL_SNAKE_POSITION_Y = 300;
    final int INITIAL_SNAKE_POSITION_X = 300;
    final int SPART_LENGTH = 32;

    // MainMenu settings.
    final int NUMBER_OF_BUTTON = 3;
    final int INITIAL_BUTTON_WIDTH = 250;
    final int INITIAL_BUTTON_HEIGHT = 100;

    // Settings menu setting/preferences.
    final int INITIAL_VOLUME = 85;
    final int MINIMUM_VOLUME = 0;
    final int MAXIMUM_VOLUME = 100;

}
