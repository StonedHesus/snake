package main.snake.graphics;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;


public class Display extends JPanel {
    /**
     * This class models the graphical components which are bound to be portrayed on the JFrame.
     *
     *
     * @version 0.01
     * @author Andrei-Paul Ionescu
     * @location Home office.
     */

    // Attributes of the class.
    private int width;
    private int height;
    private final int blockLength = 30;

    // Constructor of the class.
    public Display(int width, int height){

        this.width = width;
        this.height = height;

        this.setPreferredSize(new Dimension(this.blockLength * this.width, this.blockLength * this.height));

    }

    // Private methods of the class.
    private void drawBackground(Graphics graphics){

        for(int i = 0 ; i < this.width/this.blockLength ; ++i){
            for(int j = 0 ; j < this.height/this.blockLength ; ++j){

                graphics.setColor(Color.BLACK);
                graphics.drawRect(i*this.blockLength, j*this.blockLength, this.blockLength, this.blockLength);
                graphics.fillRect(i*this.blockLength, j*this.blockLength, this.blockLength, this.blockLength);
            }
        }
    }

    // Public methods of the class.
    @Override
    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);
        this.drawBackground(graphics);

        Toolkit.getDefaultToolkit().sync();
    }

}
