package main.snake.components;

import java.awt.*;
import main.snake.settings.Settings;

public class SPart implements Settings{
    /**
     * This class contains the model of the cells used to represent the snake's body fragments.
     *
     * @version 0.0.2
     * @author Andrei-Paul Ionescu
     */

    // Attributes of the class.
    private Color colour;
    private SPart next;

    // Constructors of the class.
    public SPart(){

        this.colour = SNAKE_COLOUR;
        this.next   = null;
    }

    // Getters of the class.
    public SPart getNext() {return this.next;}

    // Setters of the class.
    public void setNext(SPart next) {this.next = next;}

    // Methods of the class.
    @Override
    public String toString() {return "S";}

}
