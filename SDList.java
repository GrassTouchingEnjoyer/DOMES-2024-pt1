package org.tuc;

/**
 * @author Thanasis Karvouniaris
 * Basically, the big picture of this class is that the insert() method
 * iterates through the list to find the appropriate position to place
 * the new node (until it finds a node whose key is greater than the new elements key).
 * Then the new node is inserted right before this node. And, if the insertion is happened
 * at the end of the list, the tail pointer is updated to point to the new node.
 */

public class SDList extends DList{
    //We Override, the insert method from the DList class in order to insert ordered elements
    @Override
    public boolean insert(Element element){
        Node newNode = new Node(element);
        if(head == null){
            //In case, the list is empty we set the head and tail to the new node
            head = newNode;
            tail = newNode;
        }
        else if(head.data.getKey() >= element.getKey()){
            //If the new node should be placed before the current head
            newNode.next = head;
            head = newNode;
        }
        else{
            //Do a pass to the list and find the correct position to place the new node
            Node current = head;
            while(current.next != null && current.next.data.getKey() < element.getKey()){
                current = current.next;
            }
            //We are inserting the new node
            newNode.next = current.next;
            current.next = newNode;

            //If the new node is inserted at the end, update the tail
            if(newNode.next == null){
                tail = newNode;
            }
        }
        return true;
    }
}
