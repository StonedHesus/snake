package snake.snake;

public class SnakePart {
    /**
     *
     *
     * @Author: Andrei-Paul Ionescu
     * @Version: 0.1
     */

    // Attributes of the class.
    private SnakePart next;

    // Constructors of the class.
    public SnakePart() {this.next = null;}

    // Getter methods of the class.
    public SnakePart getNext() {return this.next;}

    // Setter methods of the class.
    public void setNext(SnakePart next) {this.next = next;}

    // Methods of the class.
    public String toString() {return "S ";}
}
