package org.tuc;

public class DList implements List{
    protected Node head;
    protected Node tail;

    public DList(){
        this.head = null;
        this.tail = null;
    }

    /**
     * @author Thanasis Karvouniaris
     * Inserts a new node at the end of the list.
     * @param element The element is going to  be inserted at the end of the list must not be null
     * @return true if we completed with success the insertion.
     * @throws IllegalArgumentException if the provided element is null.
     */
    @Override
    public boolean insert(Element element){
        if(element == null)
            throw new IllegalArgumentException("The insertion of a null element into the list is not allowed");
        Node newNode = new Node(element);
        if(head == null){
            head = newNode; // Basically we initialize the whole list
            tail = newNode;
        }
        else{
            /**
             * If the head is already exists then we simply add
             * a new node at the end.And the tail now becomes the
             * new node.
             */
            tail.next = newNode; 
            tail = newNode; 
        }
        return true; 
    }

    //Deletes the first node with the given key
    @Override
    public boolean delete(int key){
        /**We will break deletion at three parts
         * 1)If the node to be deleted is the head
         * 2)If the node to be deleted is in the middle
         * 3)If the node to be deleted is in the end (tail)
         * In all three parts we are keeping updated the head and tail
         */
        Node current = head;
        Node previous = null;

        while(current != null){
            if(current.data.getKey() == key){
                if(previous == null){ //If the node to be deleted is the head
                   head = head.next;
                if(head == null) //Practically, if the list is empty
                    tail = null;
                } else{
                    previous.next = current.next;
                    if(current.next == null){ //If the node to be deleted is the tail
                        tail = previous;
                    }
                }
                return true; //Deletion succesful
            }
            previous = current;
            current = current.next;
        }

        return false; // In the case the key is not found
    }

    //Searches for an element with it's key
    @Override
    public Element search(int key){
        Node current = head;
        while(current != null){
            if(current.data.getKey() == key)
                return current.data;
            current = current.next;
        }

        return null; //If the element not found
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Node current = head; current != null; current = current.next){
            sb.append(current.data.getKey()).append(" -> ");
        }
        sb.append("NULL");
        return sb.toString();
    }
}
