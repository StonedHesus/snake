// The package in which the current Java compilation unit is to be found.
package main.snake.graphics;

// Imports from existing Java libraries, classes and interfaces.
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

// Imports from custom libraries, classes and interfaces.
import main.snake.components.GameObjects;
import main.snake.components.SPart;
import main.snake.controller.Controller;
import main.snake.settings.Settings;
import main.snake.components.Snake;

public class Display extends JPanel implements Settings {
    /*
     * This class models the graphical components which are bound to be displayed on the JFrame object GameWindow.
     *
     *
     * @version 0.0.1
     * @author Andrei-Paul Ionescu
     */

    // Attributes of the class.
    private int width; // The width of the current JPanel.
    private int height; // The height of the current JPanel.
    private final int blockLength = 30; // The length of a block, a square block which will be drawn on the current JPanel.
    private double growthFactorX = 1.0; // The growth factor determines by how much we ought to increase the graphics in accordance to the screen size on the x-axis.
    private double growthFactorY = 1.0; //The growth factor determines by how much we ought to increase the graphics in accordance to the screen size on the y-axis.

    // Constructor of the class.
    public Display(){
        /*
        * @param none; this method takes no formal arguments upon invocation.
        * 
        * This here method is the constructor which will be used by the user, for it deals with selecting the desired size of the 
        * current display automatically, this being achieved by selecting the values from within the Settings interface.
        * This constructor uses the previously declared one, a feat which keeps the code clean and readable.
        *
        * @author Andrei-Paul Ionescu
        */

        new Display(INITIAL_SCREEN_WIDTH, INITIAL_SCREEN_HEIGHT);
    }

    public Display(int width, int height){
        /*
        * @param width; an intenger value which represents the desired width of the current display as specified by the caller.
        * @param height; an integer value which represents the desired height of the current display as specified by the caller.
        *
        * This is the main constructor of the Display class, whose role is to initialise the width and height fields and to 
        * set the preferred size of the current JPanel in accordance to these values and the constant value blockLength. 
        *
        * @author Andrei-Paul Ionescu.
        */

        this.width = width;
        this.height = height;

        this.setPreferredSize(new Dimension(this.blockLength * this.width, this.blockLength * this.height));

    }

    // Private methods of the class.
    private void drawSnakeGameObjectInCurrentState(Graphics graphics){
        /**
         * @param graphics; a Graphics object, which contains the graphics for the current JPanel.
         *
         * This here routine is responsible for the drawing of the snake object. This operation happens once a frame.
         *
         * @author Andrei-Paul Ionescu.
         */

        // Set the colour of the board to SNAKE_COLOUR which is the default colour for the snake game object.
        graphics.setColor(Settings.SNAKE_COLOUR);

        for(SPart part : Snake.getSnake().getParts()) {

            graphics.drawRect(part.getX(), part.getY(), Settings.SPART_LENGTH, Settings.SPART_LENGTH);
            graphics.fillRect(part.getX(), part.getY(), Settings.SPART_LENGTH, Settings.SPART_LENGTH);
        }

    }

    private void updateGrowthFactor(){
        /*
         * @param none; this method takes no formal arguments upon invocation.
         *
         * Compute the amount we ought to increase the growth factor by based on the current size of the screen when
         * compared with the initial/default one.
         *
         * @author Andrei-Paul Ionescu.
         */

        this.growthFactorX += (double) (Toolkit.getDefaultToolkit().getScreenSize().width - this.width) / this.blockLength;
        this.growthFactorY += (double) (Toolkit.getDefaultToolkit().getScreenSize().height - this.height) / this.blockLength;
    }

    private void drawBackground(Graphics graphics){
        /*
        * @param graphics; a Graphics object which contains the current frame's graphics.
        * 
        * This here method draws the background to the current JPanel's graphics, thus initialising the board. In the case of this 
        * here game, the background will remain constant and all the other game components such as the snake or the bonuses will be 
        * superimposed on this background.
        * 
        * @author Andrei-Paul Ionescu.
        */

        // Iterated through the matrix whose size is the couple (this.width, this.height) and instantiate the blocks within the
        // current graphics.
        for(int i = 0 ; i < this.width/this.blockLength ; ++i){
            for(int j = 0 ; j < this.height/this.blockLength ; ++j){

                graphics.setColor(Color.BLACK); // Set the colour of the board to black which is the default background colour.
                graphics.drawRect(i * this.blockLength, j*this.blockLength,
                        (int) (this.blockLength * this.growthFactorX), (int)(this.blockLength * this.growthFactorY)); // Draw the margins of the block which we want to draw.
                graphics.fillRect(i * this.blockLength,  j*this.blockLength,
                        (int) (this.blockLength * this.growthFactorX), (int) (this.blockLength * this.growthFactorY)); // Fill the rect so as to achieve a solid black background.
            }
        }

    }

    // Public methods of the class.
    @Override
    public void paintComponent(Graphics graphics){
        /*
        * @param graphics; a Graphics object which contains the current frame's graphics.
        *
        * This method is inherited from the JPanel class and is subsequently invoked every frame by the Controller class; 
        * its role is to keep the current JPanel updated, thus for each particular frame the method redraws the background 
        * and all the components which might have changed since the previous frame thus ensuring that the game's front-end 
        * are responsive to both internal events and external ones such as player command.
        *
        * @author Andrei-Paul Ionescu.
        */



        super.paintComponent(graphics); // Call the JPanel's paintComponent method and pass to it the current frame's graphics.
        this.drawBackground(graphics); // Call the drawBackground method and pass the current frame's graphics.


        this.drawSnakeGameObjectInCurrentState(graphics);

        this.updateGrowthFactor(); // Update the growth factor after each Frame so as to ensure that the graphics are properly scaled.

        Toolkit.getDefaultToolkit().sync(); // Call the sync method whose role is to ensure a smooth transition from frame to frame.
    }

}
