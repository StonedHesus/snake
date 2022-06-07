// The package in which the current Java compilation unit is to be found.
package main.snake.gui;

// Imports from existing Java libraries, classes and interfaces.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Imports from custom libraries, classes and interfaces.
import main.snake.components.GameObjects;
import main.snake.components.Snake;
import main.snake.controller.Controller;
import main.snake.graphics.Display;
import main.snake.settings.Settings;

public class GameWindow extends JFrame implements Settings{
    /**
     *
     * This here method models the game window on which the game information will be displayed.
     *
     * @version 0.0.2
     * @author Andrei-Paul Ionescu
     */

    // Attributes of the class.
    Display display;
    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

    private boolean wasPreviouslyInFullScreenMode = false;
    private Dimension dimensionsPriorToFullScreenMode;

    // Constructors of the class.
    public GameWindow(){

        // Invoke the initialise method which deals with initialisation of the current JFrame.
        this.initialise();

        // Invoke the method which adds the other functionalities and options for the current JFrame.
        this.addOptions();
    }

    // Private methods of the class.
    private JMenuBar createMenuBar(){
        /*
        * @param none; this method takes no formal arguments upon invocation. 
        *
        * This here method creates a menu bar in accordance to the operating system upon which the software is being run.
        *
        * @author Andrei-Paul Ionescu.
        */

        String operatingSystem = System.getProperty("os.name");

        // Determine whether the user's software is a Macintosh or not, for if it is then the menubar will be displayed
        // using the default mac one.
        if(operatingSystem.startsWith("Mac")){

            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }

        final JMenuBar menuBar = new JMenuBar();

        // Create a new dropdown menu for the options which have to do with window upon which the game is displayed.
        JMenu optionsMenu = new JMenu("Options");
        optionsMenu.setMnemonic('o');

        // Add a new option which the optionsMenu menu which terminates the program when selected.
        JMenuItem item = new JMenuItem("Exit"); // Instantiate a new JMenuItem object.
        item.setMnemonic('e'); // Set its Mnemonic to the first character constant which is present in the name of the item.
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.META_DOWN_MASK)); // Set the keyboard shortcut which activates this option.

        // Create a new ActionListener object and link it with the current item so than when an internal actional is intercepted by 
        // the listener then appropriate actions will be taken by the program.
        ActionListener listener = new JMenuItemActionListener(item){

            @Override
            public void actionPerformed(ActionEvent event){
                /*
                * @param event; an ActionEvent object.
                *
                * Upon intercepting an event which triggers this class' action listener perform the action described within this method.
                *
                * @author Andrei-Paul Ionescu.
                */
                System.exit(0);
            }
        };

        // Link the newly created action listener with the current menu item.
        item.addActionListener(listener);

        // Add the menu item to the current JMenu object.
        optionsMenu.add(item);

        // Add the menu item to the current menu bar object.
        menuBar.add(optionsMenu);

        // Create a new dropdown menu for the settings which are related with the view, such as the enter full screen
        // one.
        JMenu viewOptions = new JMenu("View");
        viewOptions.setMnemonic('v');

        // Add a new option within the view option menu which automatically converts the view to full screen if
        // the view is not currently in full screen or exits the full screen is the view is currently in the
        // full screen mode.
        item = new JMenuItem("Full screen"); // Instantiate a new JMenuItem object.
        item.setMnemonic('f'); // Set the keyboard mnemonic for the current option menu.
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.META_DOWN_MASK));// Establish the keyboard shortcut which activates this option.

        // Create a new ActionListener object and link it with the current item so than when an internal actional is intercepted by
        // the listener then appropriate actions will be taken by the program.
        listener = new JMenuItemActionListener(item){

            @Override
            public void actionPerformed(ActionEvent event){
                /*
                 * @param event; an ActionEvent object.
                 *
                 * If the user selects this here option then determine whether the current screen is in a full size
                 * mode and if that is the case then resize it to the size it was prior to becoming full screen,
                 * if there is no information about that state then revert to the initial sizes which are specified
                 * within the Settings interface; else if the screen is not in full screen then enter that mode
                 * and save the dimensions of the screen prior to converting to full screen.
                 *
                 * @author Andrei-Paul Ionescu.
                 */

                // If the window was not previously in the full screen mode then set the JFrame to full
                // screen and save the dimensions to which we have to revert if the user decides to exit
                // full screen.
                if(!wasPreviouslyInFullScreenMode)
                {
                    dimensionsPriorToFullScreenMode = new Dimension(GameWindow.this.getWidth(), GameWindow.this.getHeight());
                    device.setFullScreenWindow(GameWindow.this);
                    wasPreviouslyInFullScreenMode = true;
                } else{

                    // If we were already in full screen mode then revert back to the size specified in the field
                    // dimensionsPriorToFullScreenMode and update the wasPreviouslyInFullScreenMode flag.
                    device.setFullScreenWindow(null);
                    GameWindow.this.setSize(dimensionsPriorToFullScreenMode);
                    GameWindow.this.setVisible(true);
                    wasPreviouslyInFullScreenMode = false;
                }
            }
        };
        // Link the newly created action listener with the current menu item.
        item.addActionListener(listener);

        // Add the menu item to the current menu object.
        viewOptions.add(item);

        // Add the menu object to the current menu bar object
        menuBar.add(viewOptions);

        // Finally, return the menuBar variable/object to the caller.
        return menuBar;
    }

    private void addOptions(){
        /*
        * @param none; this function takes no formal arguments upon invocation.
        *
        * This here method creates certain options for the environment, chiefly it enables one to quickly terminate the program 
        * by utilising a simple key sequence, the options for the game will be also displayed within the option bar of the JFrame. 
        *
        * @author Andrei-Paul Ionescu.
        */

        // Set the JMenuBar of the current JFrame to be equal to the one yielded by the createMenuBar subprocess.
        this.setJMenuBar(this.createMenuBar());

    }

    private void initialise(){
        /*
         * @param none; this function takes no formal arguments upon invocation.
         *
         * Initialise the JFrame object to the desired specifications.
         *
         *
         * @since 0.0.1
         * @version 0.0.1
         * @author Andrei-Paul Ionescu
         */

        // Instantiate the display field of the current object which called the initialise method, by passing to it the
        // initial screen dimensions which are stored within constants in the Settings interface.
        this.display = new Display(INITIAL_SCREEN_WIDTH, INITIAL_SCREEN_HEIGHT);

        // Instantiate a new Controller which is linked with the current view/JFrame.
        new Controller(this.display);
        
        // Set the dimensions of the JFrame to the initial ones which are stored within the Settings interface.
        this.setSize(new Dimension(INITIAL_SCREEN_WIDTH, INITIAL_SCREEN_HEIGHT));

        // Set the title of the JFrame to String object stored within the GAME_TITLE constant which is to be found 
        // within the Settings interface.
        this.setTitle(GAME_TITLE);

        // Make the JFrame visible, set it to the centre of the screen by passing null as the argument of setLocationRelativeTo(),
        // and add the display object to the current JFrame, which is currently manipulated object.
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.add(this.display);

        // Set a Minimum size for the window so as to assure ourselves that the user is using the game at a resolution
        // which enables him to properly enjoy the experience.
        this.setMinimumSize(new Dimension(INITIAL_SCREEN_WIDTH, INITIAL_SCREEN_HEIGHT));

        // Set the default closing operation with the aid of the Swing constant EXIT_ON_CLOSE.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class JMenuItemActionListener implements ActionListener {

        // Attributes of the class.
        private JMenuItem item;

        // Constructor of the class.
        public JMenuItemActionListener(JMenuItem item) {this.item = item;}

        @Override
        public void actionPerformed(ActionEvent event) {

        }

        // Getter method of the class.
        public JMenuItem getItem() {return this.item;}
    }
}
