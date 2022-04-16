package main.snake;

import javax.swing.*;
import main.snake.gui.GameWindow;

public class Runner {

    public static void main(String[] args){

        SwingUtilities.invokeLater(GameWindow::new);
    }
}
