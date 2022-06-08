// The package in which the current Java compilation unit is to be found.
package main.snake;

// Imports from existing Java libraries, classes and interfaces.
import javax.swing.*;

// Imports from custom libraries, classes and interfaces.
import com.sun.tools.javac.Main;
import main.snake.gui.GameWindow;
import main.snake.gui.MainMenu;

public class Runner {
    /**
     * This Java compilation unit is designed to be the one which is invoked so as to instantiate a new GameWindow
     * object which in turn will deal with the instantiation of the game objects and game environment.
     *
     * @version final
     * @author Andrei-Paul Ionescu.
     */

    public static void main(String[] args){
        /**
         * @param args; an array of string arguments which can be optionally passed to the java class upon execution.
         *
         * This is the main method of the Runner, a method whose sole role is to instantiate a new GameWindow object,
         * achieving this with the aid of the SwingUtilities' ivokeLater method which ensures that the thread upon
         * which the invocation/instantiation is made is safe and thus will not cause further problems.
         *
         * @author Andrei-Paul Ionescu
         */

        SwingUtilities.invokeLater(MainMenu::new);
    }
}
