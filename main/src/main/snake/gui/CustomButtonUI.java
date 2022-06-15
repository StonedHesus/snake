// The package in which the current Java compilation unit is to be found.
package main.snake.gui;

// Imports from custom libraries, classes and interfaces.
import main.snake.settings.Settings;

// Imports from existing Java libraries, classes and interfaces.
import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ButtonUI;
import java.awt.*;
import java.awt.event.*;
import java.util.Set;

public class CustomButtonUI extends ButtonUI implements Settings, ActionListener {
    /*
     * This here class models the button object which will be utilised throughout the project, the choice of
     * modeling our own object class as opposed to utilising the existing solution is that it allows us to
     * impose a specific look and feel which also scales in accordance to the dimensions of the screen and
     * easily responds to theme alterations.
     *
     * @author Andrei-Paul Ionescu.
     */

    private JButton button;

    // Constructor methods of the class.
    public CustomButtonUI(JButton button){
        /*
         * This is the main constructor method of the class, which upon invocation takes one formal argument
         * which is the button to which the new UI is going to be applied.
         *
         * @author Andrei-Paul Ionescu.
         */

        // Assign the value passed to this function as an argument to its corresponding field.
        this.button = button;

        // Invoke the initialisation method.
        this.initialise();
    }

    // Public methods of the class.
    @Override
    public void actionPerformed(ActionEvent event) {
        /*
         * In order to properly respond and showcase user's interactivity with the button we have to override
         * the actionPerformed method which is to be found within the ActionListener interface, a feat
         * which will allow us to customise the appearance in accordance to the user's actions.
         *
         * @author Andrei-Paul Ionescu.
         */
        // Make sure that a valid argument had been passed to the method.
        assert(event != null);

        button.setFocusable(true);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        /*
         * We override ButtonUI paint method so as to be able to customise the appearance with which
         * the component will be rendered upon the screen.
         *
         * @author Andrei-Paul Ionescu.
         */

        // Invoke the constructor of the class from which we inherit.
        super.paint(g, c);

        // Set the background colour for the button.
        this.button.setBackground(Color.PINK);

        // Set the foreground colour for the current button.
        this.button.setForeground(DARK_THEME_BUTTON_FOREGROUND);

    }

    // Private/helper methods of the class.
    private void initialise(){
        /*
         * Initialise the UI for the button object, this operation is done with the aid of the constant
         * values which are stored within the Settings interface unit.
         *
         * @author Andrei-Paul Ionescu
         */

    }

}
