package snake.snake;

public class SnakePart extends Cell{
    /**
     * This here class is an hereditary ancestor of the abstract Cell class and it is used so as to represent and
     * discern the component of the Snake game object, which is but a chained list when implemented in memory, and
     * this here class implements and depicts the cellular integration and implementation of each specific instance
     * that is to be found within the list and that thus defines the mentioned structure.
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
