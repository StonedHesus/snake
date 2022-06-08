// The package in which the current Java compilation unit is to be found.
package main.snake.gui;

// Imports from custom libraries, classes and interfaces.
import com.sun.tools.javac.Main;
import main.snake.settings.Settings;

// Imports from existing Java libraries, classes and interfaces.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends View implements Settings{
    /*
     *  This here class models the main menu view of the application, this is the initial view with which
     *  the user is presented upon launching the application and its role is to allow the user to easily
     *  manipulate certain settings regarding the program and its functionality such as selecting to play
     *  the game themselves as opposed to letting the AI do that task, or simpler task as tinkering
     *  with the settings and thus enabling or disabling the sound.
     *
     * @author Andrei-Paul Ionescu.
     */

    // Attributes of the class.

    // Constructors of the class.
    public MainMenu(){
        /*
         * @param none; this here method takes no arguments upon invocation.
         *
         * This is the main constructor of the class which properly instantiates a MainMenu object and sets
         * the various functionalities of the view.
         *
         * @author Andrei-Paul Ionescu.
         */

        // Call the constructor of the class from which MainMenu inherits.
        super();

        // Call the helper method which deals with the initialisation of the current view.
        this.initialise();
    }

    // Private/helper methods of the class.
    private void addButtons(){
        /*
         * @param none; this here methods takes no arguments upon invocation.
         *
         * This here function achieves one thing, it adds to the centre of the current view the
         * buttons which the app requires, at this point in time those buttons are PLAY, OPTIONS and EXIT,
         * which are present in the view in this exact order, each button has a listener attached to it
         * which deals with onclick events and which triggers different actions to be taken, action
         * which are further explained in the method.
         *
         * @author Andrei-Paul Ionescu.
         */

        // Create and instantiate the play button.
        JButton button = new JButton("Play");

        // Create a new ActionListener and instantiate it using the nested class JButtonActionListener.
        ActionListener listener = new JButtonActionListener(button){

            @Override
            public void actionPerformed(ActionEvent event){
                /*
                 * @param event; an ActionEvent object.
                 *
                 * If the user clicks on the play button then, for now, the response to this action is that
                 * the current window/ view will be terminated and a GameWindow will be instantiated.
                 *
                 * @author Andrei-Paul Ionescu.
                 */

                MainMenu.this.setVisible(false); // Make current JFrame invisible so as to create a smoother transition.
                MainMenu.this.dispose(); // Get rid of the current Frame.
                SwingUtilities.invokeLater(GameWindow::new); // Instantiate a new GameWindow object.
            }
        };

        // Link the ActionListener with the JButton object.
        button.addActionListener(listener);

        // Size the button in accordance with the current size.
        button.setPreferredSize(new Dimension(INITIAL_BUTTON_WIDTH, INITIAL_SCREEN_HEIGHT));

        // Make the button visible.
        button.setVisible(true);

        // Add the current button to the frame.
        this.add(button);

    }

    private void initialise(){
        /*
         * @param none; this here methods takes no arguments upon invocation.
         *
         * This method deals with the initialisation and creation of the basic functionalities which our
         * menu requires to have such as a system of buttons which alter the current view, or they entirely
         * get rid of it and instantiate a new one, i.e. the play button. Either way this here method
         * deals with these tasks, and it accomplishes them with the aid of other helper methods.
         *
         * @author Andrei-Paul Ionescu.
         */

        // Call the method which creates and properly displays the buttons of the menu.
        this.addButtons();
    }

    // Nested class.
    class JButtonActionListener implements ActionListener{
        /*
         * This here class is designed to be utilised only within the scope of the MainMenu class and its
         * role is to model the action listener of a JButton in such a way that it will enable us to
         * easily respond to changes and events without constantly keeping a reference to the buttons.
         *
         * @author Andrei-Paul Ionescu.
         */

        // Attributes of the class.
        private final JButton button;

        // Constructors of the class.
        public JButtonActionListener(JButton button){this.button = button;}

        @Override
        public void actionPerformed(ActionEvent event) {
            /*
             * @param event; an ActionEvent object.
             *
             * This method is to be overridden by the caller, this feat enables us to maintain an abstract
             * class which can be 'customised' to the needs of the caller.
             *
             * @author Andrei-Paul Ionescu.
             */
        }

        // Getters of the class.
        public JButton getButton(){return this.button;}
    }

}
