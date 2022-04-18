package main.snake.settings;

import java.awt.*;

public interface Settings {
    /**
     * This here interface contains a collection of constants which serve as the settings for the project.
     *
     *
     * @version 0.0.1
     * @author Andrei-Paul Ionescu
     */

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

}
