package snake.snake;

public abstract class Cell {
    /**
     * The Cell class type is the one which engenders the following classes: Empty, GameObject and SnakePart, thus
     * enabling the creation of a matrix representation of the position of all possible game object that might appear
     * and be interacted with during the lifespan of the game.
     *
     * The class has no parameters, nor specific constructors of any kind, for its role is to represent an abstract
     * holder which depending on the required game objected needed, it can be modified and altered by upper-casting
     * to the desired type.
     *
     * @Author: Andrei-Paul Ionescu
     * @Version: 0.1
     */


    // Methods of the class.
    public abstract String toString();

}
