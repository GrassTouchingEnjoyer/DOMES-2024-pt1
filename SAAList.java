package org.tuc;

/**
 * @author Thanasis Karvouniaris
 * The insert() method keeps the list sorted by finding the right spot
 * for the new element based on it's key. Starting from the head, it looks
 * for the place where the key of the current node is larger than the key of
 * the new element. Once the correct spot is found, it adjusts the pointers to
 * insert the new element in that spot.
 *
 * If the new element needs to be placed at the start of the list, head is updated.
 * If it needs to be placed at the end, tail is updated. Now , if the insertion needs to
 * be at the middle, the method links the previous node to the new one, and the new node
 * to the current one. After inserting the new element, the method then updates the nextFree
 * index to the next free spot in the 2d array.
 */

public class SAAList extends AAList{

    public SAAList(int maxSize){
        super(maxSize); // The constructor of the superclass(AAList)
    }

    //Override, the insert method to maintain the list in a sorted order
    @Override
    public boolean insert(Element element){
        if(element == null)
            throw new IllegalArgumentException("Cannot insert null element");

        //If the list is full
        if(nextFree == -1)
            throw new IllegalStateException("The list is full, cannot insert more elements");

        int insertIndex = nextFree;
        int current = head;
        int prev = -1;
        int key = element.getKey();

        /**
         * current != -1: This condition ensures that the loop continues as
         * long as there are more nodes to check. If current becomes -1, it
         * means we've reached the end of the list.
         *
         * listArray[current][0] < key: This condition checks if the key of
         * the current node is less than the key of the element we're trying to insert.
         * The loop only continues if this is true.
         *
         * On each iteration, the loop looks at the current node (element) and compares its
         * key with the key of the new element we want to insert.
         * If the current node's key is less than the new element's key, it means we haven't found
         * the right spot yet (since we need to insert the new element in a sorted manner), and we need
         * to move forward in the list.
         * We update prev to current because if we move current forward, prev will now be the node we just examined.
         * Then, we update current to the index of the next node in the list, which we obtain from listArray[current][1].
         * This value is the index of the next node as it's the way we're simulating the next pointer of a linked list.
         */

        //We are trying to find the correct spot for the new element
        while(current != -1 && listArray[current][0] < key){
            prev = current;
            current = listArray[current][1];
        }

        //If the element needs to be placed at the head
        if(prev == -1)
            head = insertIndex;
        else{
            listArray[prev][1] = insertIndex;
        }

        //If the element needs to be placed at the tail or somewhere in the middle
        if(current == -1)
            tail = insertIndex;

        //We then, update nextFree to the next available spot
        nextFree = listArray[nextFree][1];

        //Finally, we insert the new element
        listArray[insertIndex][0] = key;
        listArray[insertIndex][1] = current;

        return true;

    }
}
