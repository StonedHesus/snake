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
    private Color colour; // Each Snake part keeps a reference to the colour that is assigned to it.
    private SPart next; // Since the Snake game object is seen as a single-chained list, each part will

    // Constructors of the class.
    public SPart(){
        /**
         * @param none; this constructor takes no arguments upon invocation.
         *
         * This is the default constructor of the SPart class which instantiates the current object's attribute
         *
         */

        this.colour = SNAKE_COLOUR;
        this.next   = null;
    }

    // Getters of the class.
    public SPart getNext() {return this.next;}

    // Setters of the class.
    public void setNext(SPart next) {this.next = next;}

    // Methods of the class.
    public void paint(Graphics graphics, int xCoordinates, int yCoordinates){

        assert graphics != null;

        graphics.setColor(SNAKE_COLOUR);
        graphics.drawRect(xCoordinates*SPART_LENGTH, yCoordinates*SPART_LENGTH,
                SPART_LENGTH, SPART_LENGTH);
        graphics.fillRect(xCoordinates*SPART_LENGTH, yCoordinates*SPART_LENGTH,
                SPART_LENGTH, SPART_LENGTH);
    }
    @Override
    public String toString() {return "S";}

}
