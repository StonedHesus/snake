package main.snake.components;

import java.awt.*;

import main.snake.graphics.Display;
import main.snake.settings.Settings;

public class SPart implements Settings{
    /**
     * This class contains the model of the cells used to represent the snake's body fragments.
     *
     * @version 0.0.2
     * @author Andrei-Paul Ionescu
     */

    // Attributes of the class.
    private final Color colour; // Each Snake part keeps a reference to the colour that is assigned to it.
    private Point coordinates; // The coordinates of the top left corner of the current point.

    // Constructors of the class.
    public SPart(int x, int y) {this.colour = Settings.SNAKE_COLOUR; this.coordinates = new Point(x, y);}

    public SPart() {this.colour = Settings.SNAKE_COLOUR;}

    // Getters of the class.
    public int getX() {return this.coordinates.x;}

    public int getY() {return this.coordinates.y;}

    // Public non-static methods of the unit.
    public void updateXPosition(double value) {this.coordinates.x += value;}

    public void updateYPosition(double value) {this.coordinates.y += value;}

    public void move(float value){


    }

    // TODO: ADD THIS HERE OBSERVATION TO THE SPREADSHEET : MAKE SURE THAT THE GAME KEEPS TRACK OF MOVEMENT IN FLOATS
    //       SO AS TO ALLOW FOR OVERALL SMOOTHER TRANSITION AND BETTER PLAYABILITY.

    @Override
    public String toString() {return "S";}

}
