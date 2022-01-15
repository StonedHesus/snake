package snake.game;

import snake.snake.Cell;
import snake.snake.Empty;
import snake.snake.SnakePart;
import snake.snake.GameObject;

import java.util.Random;

public class Board {

    /**
     * This here compilation unit models the board on which the game elements are being placed and on which the
     * logical aspects of the playability of the game are being assessed and determined utilising the sole field
     * of the class, board, which is of the abstract type Cell.
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


    // Constructor of the class.
    public Board(){

        this.initialiseBoard(8);
        this.fillWithEmpty();
        this.placeHead();
    }


    // Methods of the class.
    private boolean addGameObject(){
        /**
         *
         *
         * @Author: Andrei-Paul Ionescu
         * @Since: 0.1
         */

        Point point = pickARandomValidPosition();
        this.board[point.getX()][point.getY()] = new GameObject();

        return true;
    }

    private Point pickARandomValidPosition(){
        /**
         *
         *
         * @Author: Andrei-Paul Ionescu
         * @Since: 0.1
         */

        int x = (int)(Math.random() * this.board.length);
        int y = (int)(Math.random() * this.board[0].length);

        if(this.board[x][y] instanceof Empty)
            return new Point(x, y);
        else
            do {

                x = (int)(Math.random() * this.board.length);
                y = (int)(Math.random() * this.board[0].length);
            } while(!(this.board[x][y] instanceof Empty));

        return new Point(x, y);
    }

    private boolean addObjectAt(Cell newObject, int x, int y){
        /**
         *
         * @Author: Andrei-Paul Ionescu
         * @Since: 0.1
         */

        if(this.board[x][y] instanceof SnakePart)
            return false;

        if(this.board[x][y] instanceof GameObject)
            return false;

        this.board[x][y] = newObject;
        return true;
    }

    private boolean placeHead(){
        /**
         *
         * @Author: Andrei-Paul Ionescu
         * @Since: 0.1
         */

        // After visualising the placement of the head of the snake on the board, I had come to the striking
        // realisation that there might be need for a subtype of SnakePart which will be labeled SnakeHead
        // so as to properly, clearly and non-ambiguously portray the distinction between this two different
        // components of the Snake game object, which serve different functions and thus affect the game in
        // completely different manners.

        this.board[(this.board.length - 1) / 2][(this.board[0].length - 1) / 2] = new SnakePart();
        return true;
    }

    private void fillWithEmpty(){
        /**
         *
         * @Author: Andrei-Paul Ionescu
         * @Since: 0.1
         */

        for(int i = 0 ; i < this.board.length ; ++i){

            for(int j = 0 ; j < this.board[i].length ; ++j){

                this.board[i][j] = new Empty();
            }
        }
    }

    public void printBoard(){
        /**
         *
         * @Author: Andrei-Paul Ionescu
         * @Since: 0.1
         */

        for(int i = 0 ; i < this.board.length; ++i){

            for(int j = 0 ; j < this.board[i].length ; ++j){

                System.out.print(this.board[i][j].toString());
            }

            System.out.print("\n");
        }
    }

    private boolean initialiseBoard(int size){
        /**
         *
         * @Author: Andrei-Paul Ionescu
         * @Since: 0.1
         */

        this.board = new Cell[size][size];
        return true;
    }

}
