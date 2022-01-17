package snake.snake;

public class SnakeHead extends SnakePart{

    /**
     * This here class is an extension of the SnakePart class and it provides the representation in memory of
     * the particular instance of the aforementioned class, that being the head component of the snake, which
     * despite being a SnakePart in behaviour is meant to be treated differently since it cannot be removed; plus
     * this here hereditary scheme will enable a more easier representation of the Snake game object.
     *
     * @Author: Andrei-Paul Ionescu
     * @Version: 0.1
     */


    // Methods of the class.
    @Override
    public String toString() {return "H ";}
}
