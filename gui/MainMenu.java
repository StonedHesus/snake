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

        // TODO: fix the delay that seem to appear when adding a new element on the current frame, most likely this
        //       issue has to do with the threads, so look into that.

        initialiseTheWindow();
        addExitButton();
        addMuteButton();
    }

    // Methods of the class.
    private boolean addMuteButton(){
        /**
         * Appends a mute button in the top right corner of the frame, in accordance with the current screen size.
         *
         * @Author: Andrei-Paul Ionescu
         * @version: 0.1
         */

        JButton muteButton = new JButton("M");
        muteButton.setBounds(1345,
                30,60, 60); // The value for the position on the X-axis will be adjusted properly
                                            // with the aid of the current screen size, a possibility which will
                                            // arrive in future versions.

        muteButton.setFocusable(false);

        this.getContentPane().add(muteButton);

        return true;
    }

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
