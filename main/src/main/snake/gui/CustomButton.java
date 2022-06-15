package main.snake.gui;

import main.snake.settings.Settings;

import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton implements Settings {

    public CustomButton(String name){

        super(name);
        this.setText("Test");
    }

    @Override
    public void paintComponent(Graphics graphics){

        this.setSize(new Dimension(INITIAL_BUTTON_WIDTH, INITIAL_BUTTON_HEIGHT));

        setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.setContentAreaFilled(true);

        this.setMargin(new Insets(20, 200, 20, 20));



        this.setBackground(Color.PINK);
        this.setForeground(Color.orange);
    }
}
