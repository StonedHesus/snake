package snake.snake;

public class Snake {
    /**
     * This here class models the snake game element, which so far it is designed to be represented by a chained list,
     * which retains both its head, which is sedentary, and its tail which adjust in accordance with the size of the
     * structure.
     *
     * @Autor: Andrei-Paul Ionescu.
     * @Version: 0.1
     */

    // We might have to implement this game object as a Stack structure.

    // Attributes of the class.
    private final SnakePart head;
    private  SnakePart tail;

    // Constructors of the class.
    public Snake() {this.head = new SnakePart(); this.tail = this.head;}

    // Methods of the class.
    public boolean removeSnakePart(){
        /**
         * This here methods takes no arguments upon invocation, but does return a boolean signifying whether or not
         * the operation of removal has been successful or not, this operation is done by removing the current tail
         * value and replace it with the one preceding it.
         *
         * @Author: Andrei-Paul Ionescu
         * @Since: 0.1
         */

        if(this.tail.equals(null) || this.tail.equals(this.head))
            return false;

        SnakePart tmp = this.head;

        while(!tmp.getNext().equals(this.tail))
            tmp = tmp.getNext();

        this.tail = tmp;
        this.tail.setNext(null);

        return true;
    }

    public boolean addSnakePart(){
        /**
         * This here method takes no arguments upon invocation but does return a boolean value which signifies whether
         * or not the operation has been successful. The addition of a snake part is pretty straight forward, a new
         * Cell of type SnakePart is being added to the end of either the head, if the tail is equal to the head, which
         * is a convention which signifies that the snake objects has but just been initialised, or it adds it to the
         * tail, and changes this variable accordingly so that it points to the newly added cell.
         *
         * @Author: Andrei-Paul Ionescu
         * @Since: 0.1
         */

        if(this.head.equals(null))
            return false;

        if(this.tail.equals(this.head)){

            this.head.setNext(new SnakePart());
            this.tail = this.head.getNext();
        } else{

            this.tail.setNext(new SnakePart());
            this.tail = this.tail.getNext();
        }

        return true;
    }

    public String toString(){

        /**
         * This here functions build and returns a String representation of the snake object, taking no arguments upon
         * invocation, and it does facilitate interpretation by showcasing the head using the capital letter H and the
         * rest of the snake's body by using the letter S, added to the string using the toString() method of the
         * SnakePart component.
         *
         * @Author: Andrei-Paul Ionescu
         * @Since: 0.1
         */

        String result = "";

        if(this.head.equals(null))
            return result;

        // I would want to utilise an iterator as opposed to a temporary variable.
        SnakePart tmp = this.head.getNext();
        result += "H ";

        try{
            while(!tmp.equals(null)){

                result += tmp.toString();
                tmp     = tmp.getNext();
            }

        } catch(NullPointerException exception){}



        return result;
    }
}
