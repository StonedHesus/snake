package snake.game;

import snake.snake.Cell;
import snake.snake.Empty;
import snake.snake.SnakePart;

public class Board {

    /**
     *
     * @Author: Andrei-Paul Ionescu
     * @Version: 0.1
     */

    // Note to self, based on the resolution at which the game is played, the number of available spaces in the matrix
    // will have to be adjusted in accordance, hence a method which will deal with that will have to be implemented in
    // the phase where the backend and frontend components of the game will communicate properly with each-other and
    // thus yield a playable version of the game.
    //
    // For testing purposes, whilst still a schism between the backend and frontend exists, the matrix will be
    // initialised with a set value, then upon migration to the newly delegated behaviour of the application,
    // constructors and other such methods that will have to do with the constraints of the size and boundaries of
    // the matrix will have to be modified prior to assuring that the software enables a portable and adjustable
    // functionality, depending on the machine and resolution at which the user decides to operate the software.

    private Cell[][] board; // To ensure proper playability, the matrix must always be of even size, for upon commencing
                            // iterating on it using zero as the beginning for this procedure, we will end up having
                            // an even number of rows and columns which will enable us to determine the middle, in
                            // which we will place the snake's head at the beginning of the game.



}
