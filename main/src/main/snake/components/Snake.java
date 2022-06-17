package main.snake.components;

import main.snake.graphics.Display;
import main.snake.settings.Settings;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Snake implements Settings {
    /**
     * This class models the snake game object which is represented as ...
     *
     *
     */

    // Attributes of the class.
    private SPart head;
    private Point position;

    private double xMovement;
    private double yMovement;

    // Constructors of the class.
    public Snake(){

        this.position = new Point(INITIAL_SNAKE_POSITION_X, INITIAL_SNAKE_POSITION_Y);

        int length = INITIAL_SNAKE_LENGTH;

        while(length > 0){

            this.addBack();
            length -= 1;
        }

        this.xMovement = 0;
        this.yMovement = 0;
    }

    // Methods of the class.
    public void move(){
        /**
         *
         * @since 0.0.3
         * @version 0.0.1
         * @author Andrei-Paul Ionescu
         */

        this.position.x += this.xMovement;
        this.position.y += this.yMovement;
    }

    public void keyReleased(KeyEvent keyEvent){
        /**
         *
         * @since 0.0.3
         * @version 0.0.1
         * @author Andrei-Paul Ionescu
         */

        assert keyEvent != null;

        if(keyEvent.getKeyCode() == KeyEvent.VK_W || keyEvent.getKeyCode() == KeyEvent.VK_S){

            this.yMovement = 0;
        }

        if(keyEvent.getKeyCode() == KeyEvent.VK_A || keyEvent.getKeyCode() == KeyEvent.VK_D){

            this.xMovement = 0;
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

        if(keyEvent.getKeyCode() == KeyEvent.VK_W){

            this.yMovement += SNAKE_VELOCITY;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_D){

            this.xMovement += SNAKE_VELOCITY;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_S){

            this.yMovement -= SNAKE_VELOCITY;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_A){

            this.xMovement -= SNAKE_VELOCITY;
        }
    }
    public void paint(Graphics2D graphics){

        assert graphics != null;


        SPart pointer = this.head;

        int offset = 0;

        while(pointer != null){

            pointer.paint(graphics, this.position.x + offset, this.position.y + offset);

            offset += SPART_LENGTH;
            pointer = pointer.getNext();
        }
    }

    public void addBack(){
        /**
         * Add a cell( SPart object) to the end of the list( snake object).
         *
         * @since 0.0.2
         * @version 0.0.1
         * @author Andrei-Paul Ionescu
         */

        if(this.head == null)
            this.head = new SPart();
        else{

            SPart pointer = this.head;

            while(pointer.getNext() != null){

                pointer = pointer.getNext();
            }

            pointer.setNext(new SPart());
        }
    }

    @Override
    public String toString(){

        StringBuilder representation = new StringBuilder();

        SPart pointer = this.head;

        while(pointer != null){

            representation.append(pointer.toString());
            pointer = pointer.getNext();
        }

        return String.valueOf(representation);
    }
}

