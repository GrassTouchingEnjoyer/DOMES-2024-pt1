package org.tuc;

//@author Thanasis Karvouniaris

public class AAList implements List{
    private final int[][] listArray; //The reference to this array cannot be changed after it's set
    private int head;
    private int tail;
    private int nextFree;

    //The constructor initialize the list with a fixed size
    public AAList(int maxSize){
        listArray = new int[maxSize][2];//Each line has two integers
        head = -1; // If we start with -1 this indicates that the list is empty
        tail = -1;
        nextFree = 0; //The first free index


        //We are initializing the stack of free indices
        for(int i = 0; i < maxSize; i++){
            listArray[i][1] = i + 1; //Point to the next line as the next free spot

        }
        //The list line points to -1 to indicate the end of the free stack
        listArray[maxSize-1][1] = -1;
    }

    //Inserts a new element into the list in unordered manner
    @Override
    public boolean insert(Element element){
        if(nextFree == -1)
            return false; //The array is full, no more insertions are possible

        //Find the next free index
        int insertIndex = nextFree;
        nextFree = listArray[nextFree][1];//Update nextFree to the next free index

        //Insert the new element
        listArray[insertIndex][0] = element.getKey(); //Store the element's key
        listArray[insertIndex][1] = -1; //By default, this node does not point to another node

        if(head == -1){
            //If the list is empty, this new element is both head and tail
            head = insertIndex;
            tail = insertIndex;
        }
        else{
            //If the list isn't empty, append to the end and update the tail's pointer
            listArray[tail][1] = insertIndex;
            tail = insertIndex; //Update the tail index
        }

        return true;
    }

    //Deletes the first element with the specified key
    @Override
    public boolean delete(int key){
        if(head == -1)
            return false; //The list is empty

        int current = head;
        int prev = -1;

        while(current != -1){
            if(listArray[current][0] == key){
                if(prev == -1){
                    //The element for deletion is the head
                    head = listArray[current][1];
                }
                else{

                    //Skip over the deleted element in the array
                    listArray[prev][1] = listArray[current][1];
                }

                //If the deleted element was the tail, update the tail
                if(tail == current) {
                    tail = prev;
                }

                //Add the current index back to the free index stack
                listArray[current][1] = nextFree;
                nextFree = current;
                return true;
            }
            prev = current;
            current = listArray[current][1];
        }
        return false; //Element with the specified key not found
    }

    //Searches for an element with the specified key
    @Override
    public Element search(int key){
        int current = head;
        while(current != -1){
            if(listArray[current][0] == key){
                //Found the element. Normally, we would return an Element object,
                //but for simplicity, let's just return the key wrapped in a SimpleElement
                return new SimpleElement(listArray[current][0]);
            }
            current = listArray[current][1];
        }
        return null;
    }

    @Override
    public String toString(){
        if(head == -1)
            return "The list is empty";

        StringBuilder sb = new StringBuilder();
        sb.append("List: ");

        //Start from the head and follow the next indices
        int currentIndex = head;
        while(currentIndex != -1){
            sb.append(listArray[currentIndex][0]); //Append the element's value
            currentIndex = listArray[currentIndex][1]; //Move to the next element
            if(currentIndex != -1)
                sb.append(" -> "); //Separator between elements
        }
        return sb.toString();
    }

}
