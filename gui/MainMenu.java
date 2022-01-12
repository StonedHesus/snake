package snake.gui;

import java.awt.*;
import javax.swing.*;

public class MainMenu extends JFrame{
    /**
     * This class models and enables the creation of the main menu of the game.
     *
     * @author: Andrei-Paul Ionescu
     * @version: 0.1
     */

    // Constructor of the class.
    public MainMenu(){

        initialiseTheWindow();
        addExitButton();
    }

    // Methods of the class.
    private boolean addExitButton(){
        /**
         * Adds an exit button in the top left corner of the frame, whilst also disabling the standard exit button.
         *
         * @author: Andrei-Paul Ionescu
         * @version: 0.1
         */

        JButton exitButton = new JButton("X");
        exitButton.setBounds(30, 30, 60, 60);

        exitButton.setFocusable(false);

        exitButton.addActionListener((event) ->{

            System.exit(0);

        });

        this.getContentPane().add(exitButton);

        return true;
    }

    private boolean initialiseTheWindow(){
        /**
         * This here method initialises the window in which the main menu is bound to be nested.
         *
         * @author: Andrei-Paul Ionescu
         * @version: 0.1
         */

        setTitle("Snake");
        setSize(1600, 800);
        setLayout(null);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        return true;
    }

}
