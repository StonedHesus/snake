package snake.game;

import snake.snake.Snake;

public class Game {

    /**
     *
     *
     * @Author: Andrei-Paul Ionescu
     * @Version: 0.1
     */

    // Attributes of the class.
    private Board board;
    private Snake snake;

    // Constructor of the class.
    public Game(){

        this.board = new Board();
        this.snake = new Snake();
    }

    // Methods of the class.
    public void play(){

        while(true){

            board.printBoard();
            board.placeTemporarily(); // The problem here is that the code is successful in placing the object, and then
                                      // it is capable to remove it, though due to the fact that we freeze the thread
                                      // we are not able to properly visualise the process. This can be solved
                                      // by placing two distinct print calls inside the placeTemporary() function
                                      // but if I wish to keep using the Thread function I might want to look into
                                      // asynchronous programming.
            board.printBoard();
        }
    }
}
