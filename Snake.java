package snake;

import snake.gui.MainMenu;

import java.awt.EventQueue;

public class Snake {

    public static void main(String[] args) {
	// write your code here

        EventQueue.invokeLater(() ->{

            MainMenu menu = new MainMenu();
        });



    }
}
