package main.snake.components;

public class Snake {
    /**
     * This class models the snake game object which is represented as ...
     *
     * @version 0.0.2
     * @author Andrei-Paul Ionescu
     */

    // Attributes of the class.
    private SPart head;

    // Constructors of the class.
    public Snake(int length){

        while(length >= 0){

            this.addBack();
            length -= 1;
        }
    }

    // Methods of the class.
    public void addBack(){
        /**
         * Add a cell( SPart object) to the end of the list( snake object).
         *
         * @since 0.0.2
         * @version 0.0.1
         * @author Andrei-Paul Ionescu
         */

        if(this.head == null)
            this.head = new SPart();
        else{

            SPart pointer = this.head;

            while(pointer.getNext() != null){

                pointer = pointer.getNext();
            }

            pointer.setNext(new SPart());
        }
    }

    @Override
    public String toString(){

        StringBuilder representation = new StringBuilder();

        SPart pointer = this.head;

        while(pointer != null){

            representation.append(pointer.toString());
            pointer = pointer.getNext();
        }

        return String.valueOf(representation);
    }
}

