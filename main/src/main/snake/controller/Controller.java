// The package in which the current Java compilation unit is to be found.
package main.snake.controller;

// Imports from existing Java libraries, classes and interfaces.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

// Imports from custom libraries, classes and interfaces.
import main.snake.graphics.Display;
import main.snake.components.GameObjects;

public class Controller implements ActionListener, KeyListener{
    /**
    * *param display; a Display object who serves the View role for the current application/game.
    *
    * This here record class has one field which is a Display object which represents the current View; the class was 
    * instantiated as a record class so as to save some space this being achieved by not having to write the accessor for the 
    * field of the class, which we will need. The class also inherits from the ActionListener and KeyListener classes which 
    * enables us to deal with events which are passed to the game with the aid of the keyboard.
    *
    *
    * @author Andrei-Paul Ionescu.
    */

    // Attributes of the class.
    private Display currentView;

    // Constructor of the class.
    public Controller(Display currentView) {
        /*
        * @param display; a Display object which represents the current View of the application.
        *
        * This is the main constructor of the Controller class whose role is to properly set up the class' field and to initialise 
        * a timer whose role is ... 
        */

        // Link the argument of the constructor with the variable attribute of the class.
        this.currentView = currentView;
    }

    // Methods of the class.
    @Override
    public void keyTyped(KeyEvent event) {
        /*
        * @param event; a KeyEvent object which represents an object intercepted after the user interacted with the program with the aid of its keyboard.
        *
        * This here method is inherited from KeyListener class and it is subsequently invoked every frame/milisecond and its 
        * role is to intercept events which were broadcasted by the user and they consist of the user typing a specific character constant 
        * and or string, subsequently for the core functionality of this game this event net will not be utilised.
        *
        * @author Andrei-Paul Ionescu.
        */
    }

    @Override
    public void keyPressed(KeyEvent event) {
        /*
        * @param event; a KeyEvent object which represents an object intercepted after the user interacted with the program with the aid of its keyboard.
        *
        * This here method is inherited from the KeyListener class and it is subsequently invoked every frame/milisecond and its 
        * role is to intercept events which were broadcasted by the user by its interactions with the keyboard; the type of events 
        * which the method intercepts are key presses. After encountering such an event the method invokes the Snake's game object 
        * keyPressed method whose role is to deal with the event and manipulate the game object in accordance with the key which was 
        * pressed. 
        *
        * @author Andrei-Paul Ionescu.
        */

        // Invoke the current snake's keyPressed method and pass to it the intercepted event.
        GameObjects.snake.keyPressed(event);
    }

    @Override
    public void keyReleased(KeyEvent event) {
        /*
        * @param event; a KeyEvent object which represents an object intercepted after the user interacted with the program with the aid of its keyboard.
        *
        * This here method is inherited from the KeyListener class and it is subsequently invoked every frame/milisecond and its role is
        * to intercept events which were broadcasted by the user by its interactions with the keyboard; the type of events which this 
        * method intercepts are key releases. After encountering such an event the method invokes the current Snake game object 
        * keyReleased method whose role is to deal with the event and manipulate the game object in accordance witht they key which was 
        * released.
        *
        * @author Andrei-Paul Ionescu.
        */

        // Invoke the current snake's keyReleased method and pass to it the intercepted event.
        GameObjects.snake.keyReleased(event);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        /*
        * @param event; an ActionEvent object which indicates whether or not an internal action took place or not.
        *
        * This here method is inherited from the ActionListener class, and it is subsequently invoked every frame/millisecond and its role is
        * to intercept internal events which are broadcast by Swing/ AWT components or from within the architecture of the current game.
        * The method responds to such events by repainting the snake game object after an internal event was triggered and by 
        * revalidating and repainting the current display a feat which will trigger the paintComponent function which is found 
        * within the Display class.
        */

        // Paint the current state of the snake game object.
        GameObjects.snake.paint(this.currentView.getGraphics());


        this.currentView.getGraphics().setColor(Color.white);
        this.currentView.getGraphics().drawRect(0, 0, 32, 32);

        // Revalidate the View and repaint it so as to keep it updated.
        currentView.revalidate();
        currentView.repaint();
    }
}
