package snake.gui;

import java.awt.*;
import javax.swing.*;

public abstract class Menu extends JPanel{

    /**
     * An abstract representation of a menu window, this here class is designed in such a way that it will easily
     * enable one to utilise it so at to create all sorts of menus, from main ones to particular ones such as settings,
     * etc.
     *
     * @author: Andrei-Paul Ionescu
     * @version: 0.1
     */

    // Constructor of the class.
    public Menu(){}

    // Methods of the class.
    public boolean addExitButton(){
        /**
         * This here function adds an exit button in the top left corner of the screen.
         *
         * @author: Andrei-Paul Ionescu
         * @since: 0.1
         */



        return true;
    }
}
