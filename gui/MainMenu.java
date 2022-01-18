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

    // Attributes of the class.
    private int width;
    private int height;

    // Constructor of the class.
    public MainMenu(){

        // TODO: fix the delay that seem to appear when adding a new element on the current frame, most likely this
        //       issue has to do with the threads, so look into that.

        this.width  = Toolkit.getDefaultToolkit().getScreenSize().width;
        this.height = Toolkit.getDefaultToolkit().getScreenSize().height;

        initialiseTheWindow();
        addExitButton();
        addMuteButton();

        resize();

        while(true){

            resize();
            repaint();
        }
    }

    // Methods of the class.
    private boolean resize(){

        // There are three times of resizes which might occur, there is the one which only affects the width, the
        // one which only affects the height and the one which resizes both, this being achieved by resizing the
        // diagonal.

        if(Toolkit.getDefaultToolkit().getScreenSize().width < this.width &&
                Toolkit.getDefaultToolkit().getScreenSize().height == this.height){

            for(Component component : this.getContentPane().getComponents()){

                if(component.getAlignmentX() > Toolkit.getDefaultToolkit().getScreenSize().width){

                    component.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width -
                                    2 * Math.abs((Toolkit.getDefaultToolkit().getScreenSize().width - this.width)),
                            component.getBounds().y,
                            component.getBounds().width,
                            component.getBounds().height);
                }
            }
        }

        return true;
    }

    private JButton addMuteButton(){
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

        return muteButton;
    }

    private JButton addExitButton(){
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

        return exitButton;
    }

    private boolean initialiseTheWindow(){
        /**
         * This here method initialises the window in which the main menu is bound to be nested.
         *
         * @author: Andrei-Paul Ionescu
         * @version: 0.1
         */

        setTitle("Snake");
        setSize(this.width, this.height);
        setLayout(null);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        return true;
    }

}
