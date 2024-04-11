package org.tuc;

public class Node{
    /**
     * The Node class holds the data and a reference to
     * the next element
     */
    public Element data; // The data the node holds
    public Node next; // Reference to the next node in the list

    public Node(Element data){
        this.data = data;
        this.next = null; //Initially, the next node is not known (null)
    }

}