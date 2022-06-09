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
    private void createTheSettingsMenu(){
        /*
         * @param none; this here method takes no formal arguments upon invocation.
         *
         * This method is responsible for creating a new JPanel object which contains the settings menu options,
         * those include the ability to alter the volume, mute entirely the sound, toy with the brightness, etcetera.
         * The method deals with the creation and the formatting of the view but does not ensure the liberation/removal
         * of any existing JPanel, thus the caller is supposed to prepare the environment before invoking this procedure.
         *
         * @author Andrei-Paul Ionescu.
         */

        // Create a new JPanel on which we will display the new options.
        JPanel settingsPanel = new JPanel();

        // Set the layout manager of the panel object.
        settingsPanel.setLayout(new GridBagLayout());

        // Create and instantiate a new JSlider which is used to control the volume of the sound of the program.
        JSlider slider = new JSlider(MINIMUM_VOLUME, MAXIMUM_VOLUME, INITIAL_VOLUME);

        // Set the orientation of the slider object to horizontal.
        slider.setOrientation(SwingConstants.HORIZONTAL);

        // Paint the ticks of the slider.
        slider.setPaintTicks(true);

        // Set the spacing for the ticks.
        slider.setMajorTickSpacing(50);

        // Paint a label for the current slider object.
        slider.setPaintLabels(true);

        // Set the text for the label.
        // TODO: properly link the label and the slider so as to show the percentage of the current selection.
        // Make the slider visible.
        slider.setVisible(true);

        // Add the slider object to the current panel.
        settingsPanel.add(slider);

        // Create and instantiate the PREVIOUS button.
        JButton button = new JButton("PREVIOUS");

        // Create a new ActionListener and instantiate it using the nested class JButtonActionListener.
        ActionListener listener = new JButtonActionListener(button){

            @Override
            public void actionPerformed(ActionEvent event){
                /*
                 * @param event; an ActionEvent object.
                 *
                 * If the user clicks upon this button it will cause the current panel to be disposed and a new
                 * main menu one to be instantiated thus reverting to the state in which the view was prior to the
                 * user accessing the settings menu.
                 *
                 * @author Andrei-Paul Ionescu.
                 */

                // Remove the current JPanel object.
                MainMenu.this.remove(settingsPanel);

                // Add the initial JPanel object to the frame, this is done by calling the method addButtons().
                MainMenu.this.addButtons();

                // Ensure a flawless transition by invoking the revalidate and repaint method on the current frame.
                MainMenu.this.revalidate(); // Revalidate the current frame.
                MainMenu.this.repaint(); // Repaint the current frame.
            }
        };

        // Link the ActionListener with the JButton object.
        button.addActionListener(listener);

        // Make the button visible.
        button.setVisible(true);

        // Add the current button to the JPanel object.
        settingsPanel.add(button);

        // Add the new JPanel object to the current frame.
        MainMenu.this.add(settingsPanel);
    }

    private void addButtons(){
        /*
         * @param none; this here method takes no arguments upon invocation.
         *
         * This here function achieves one thing, it adds to the centre of the current view the
         * buttons which the app requires, at this point in time those buttons are PLAY, OPTIONS and EXIT,
         * which are present in the view in this exact order, each button has a listener attached to it
         * which deals with onclick events and which triggers different actions to be taken, action
         * which are further explained in the method.
         *
         * @author Andrei-Paul Ionescu.
         */

        // Create a new JPanel upon which we will collate our buttons.
        JPanel buttonsPanel = new JPanel();

        // Set the layout manager of the panel object.
        buttonsPanel.setLayout(new GridBagLayout());

        // Create and instantiate the PLAY button.
        JButton button = new JButton("PLAY");

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
        //button.setPreferredSize(new Dimension(INITIAL_BUTTON_WIDTH, INITIAL_SCREEN_HEIGHT));

        // Make the button visible.
        button.setVisible(true);

        // Add the current button to the JPanel.
        buttonsPanel.add(button);

        // Create and instantiate the SETTINGS button.
        button = new JButton("SETTINGS");

        // Create a new ActionListener and instantiate it using the nested class JButtonActionListener.
        listener = new JButtonActionListener(button){

            @Override
            public void actionPerformed(ActionEvent event){
                /*
                 * @param event; an ActionEvent object.
                 *
                 * If the user clicks on this particular object then this will trigger a chain of events which will
                 * mutate the aspect of the current view by switching the JPanel from the one which serves as the
                 * main menu view to the one which serves as the option menu in which different buttons and sliders
                 * are present so as to allow the user to manipulate various game settings, such as sound, brightness,
                 * etcetera.
                 *
                 * @author Andrei-Paul Ionescu.
                 */



                MainMenu.this.remove(buttonsPanel); // Remove the buttonsPanel JPanel object from the current frame.

                MainMenu.this.createTheSettingsMenu(); // Invoke the method which deals with the creation of the settings menu.
                MainMenu.this.revalidate(); // Revalidate the current frame.
                MainMenu.this.repaint(); // Repaint the current frame.
            }
        };

        // Link the ActionListener with the JButton object.
        button.addActionListener(listener);

        // Make the button visible.
        button.setVisible(true);

        // Add the current button to the JPanel.
        buttonsPanel.add(button);

        // Create and instantiate the EXIT button.
        button = new JButton("EXIT");

        // Create a new ActionListener and instantiate it using the nested class JButtonActionListener.
        listener = new JButtonActionListener(button){

            @Override
            public void actionPerformed(ActionEvent event){
                /*
                 * @param event; an ActionEvent object.
                 *
                 * If the user click on this particular button then it will trigger the termination of the lifespan
                 * of the program, much alike with what happens when the user presses down the combo command + e.
                 * The response to this event is broken down in the following stages, first the current frame is
                 * made invisible then the various objects which are utilised are liberated and then finally the whole
                 * program is shutdown with the aid of the System unit.
                 *
                 * @author Andrei-Paul Ionescu.
                 */

                MainMenu.this.setVisible(false); // Make the current invisible so as to make the transition smoother.
                MainMenu.this.dispose(); // Get rid of the current frame by freeing the processes which are link to its existence.
                System.exit(0); // Exit the program with the status 0.
            }
        };

        // Link the ActionListener with the JButton object.
        button.addActionListener(listener);

        // Make the button visible.
        button.setVisible(true);

        // Add the current button to the JPanel.
        buttonsPanel.add(button);

        // Add the JPanel to the current frame.
        this.add(buttonsPanel);
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
