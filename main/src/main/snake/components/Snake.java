// The package in which the current Java compilation unit is to be found.
package main.snake.components;

// Imports from existing Java libraries, classes and interfaces.
import main.snake.graphics.Display;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;

// Import from custom libraries, classes and interfaces.
import main.snake.settings.Settings;


public class Snake implements Settings {
    /**
     * This here class models the Snake game object, which, due to the fact that one sole snake object exists during each
     * execution of the game, the class is constructed on the footprint of a Single design pattern; thus the class
     * stores the one and sole instance of the Snake game object, and it utilises lazy instantiations so as to only
     * materialise the Snake game object only when required. The class does not allow outside instantiation, unless it
     * is a member of the class' hierarchy.
     *
     * The initial value of the snake class is the pointer null.
     *
     * @author Andrei-Paul Ionescu.
     */

    // Static values/constants of the class.
    private static Snake snake = null; // By default, the snake variable points to the null reference.

    // Fields/attributes of the class.
    private ArrayList<SPart> parts = null; // By default, the parts variable points to the null reference.
    private double xMovement;
    private double yMovement;
    private boolean moving = false;

    // Constructor(s) of the class.
    protected Snake(){

        int length = Settings.INITIAL_SNAKE_LENGTH;

        this.parts = new ArrayList<>(length);

        int position = 0;

        while(length > 0){

            this.parts.add(new SPart(Settings.INITIAL_SNAKE_POSITION_X,
                    Settings.INITIAL_SNAKE_POSITION_Y + position * Settings.SPART_LENGTH));

            length -= 1;
            position += 1;
        }

        this.xMovement = 0;
        this.yMovement = 0;
    }

    // Getters of the class.
    public ArrayList<SPart> getParts() {return this.parts;}

    public static Snake getSnake() {

        // If the snake object was not initialise then do it now.
        if(Snake.snake == null)
            Snake.snake = new Snake();

        // Then return to the caller a pointer to the current snake object.
        return Snake.snake;
    }

    // Setters of the class.

    // Public non-static methods of the unit.
    public void move(){
        /**
         *
         * @since 0.0.3
         * @version 0.0.1
         * @author Andrei-Paul Ionescu
         */

    }

    public void keyReleased(KeyEvent keyEvent){
        /**
         *
         * @since 0.0.3
         * @version 0.0.1
         * @author Andrei-Paul Ionescu
         */

        assert keyEvent != null;

        this.moving = false;

        if(keyEvent.getKeyCode() == KeyEvent.VK_W || keyEvent.getKeyCode() == KeyEvent.VK_S){

            this.updateYPosition();
        }

        if(keyEvent.getKeyCode() == KeyEvent.VK_A || keyEvent.getKeyCode() == KeyEvent.VK_D){

            this.updateXPosition();
        }
    }
    public void keyPressed(KeyEvent keyEvent){
        /**
         * This function is responding to keyboard event according to the game's rules.
         *
         * @since 0.0.3
         * @version 0.0.1
         * @author Andrei-Paul Ionescu
         */

        assert keyEvent != null;

        this.moving = true;

        if(keyEvent.getKeyCode() == KeyEvent.VK_W){

            while(this.moving) {this.yMovement += SNAKE_VELOCITY;}
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_D){

            while(this.moving) {this.xMovement += SNAKE_VELOCITY;}

        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_S){

            while(this.moving) {this.yMovement -= SNAKE_VELOCITY;}
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_A){

            while(this.moving) { this.xMovement -= SNAKE_VELOCITY; }
        }
    }

    @Override
    public String toString(){

        // Declare a new StringBuilder object which will store the String representation of the current snake game element.
        StringBuilder representation = new StringBuilder();

        // Iterate through the ArrayList parts object and append to the StringBuilder object all current SParts'
        // string representations.
        for(SPart part : this.parts) {representation.append(part.toString());}

        // Return the value of the StringBuilder object.
        return String.valueOf(representation);
    }

    // Public static methods of the unit.

    // Private methods of the unit.
    private void updateXPosition(){

        for(SPart part : parts) {part.updateXPosition(this.xMovement);}

        this.xMovement = 0;
    }

    private void updateYPosition() {

        for(SPart part : parts) {part.updateYPosition(this.yMovement);}

        this.yMovement = 0;
    }
}
