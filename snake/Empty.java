package snake.snake;

public class Empty extends Cell{
    /**
     *
     * This here class is an hereditary ancestor of the abstract class Cell and it is used to represent the portions
     * of the matrix that are accessible, or in other words are unoccupied, thus enabling other the placement of a game
     * object there or of a snake body, the former being placed randomly by a method within the game logic portion of
     * the package, whilst the latter is relative to the current position of the snake, the choice of direction by
     * the user and the length of the reptile.
     *
     * @Author: Andrei-Paul Ionescu
     * @Version: 0.1
     */

    // Methods of the class.
    @Override
    public String toString() {return "0 ";}
}
