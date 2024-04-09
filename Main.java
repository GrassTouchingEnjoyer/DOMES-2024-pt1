package org.tuc;

public class Main{
    public static void main(String[] args){
        //At first, we create a DList instance
        DList myList = new DList();
        //We are creating an SDList instance
        SDList list = new SDList();

        //Secondly we insert some elements
        myList.insert(new SimpleElement(1));
        myList.insert(new SimpleElement(3));
        myList.insert(new SimpleElement(2));
        myList.insert(new SimpleElement(4));

        //We insert some elements at the SDList
        list.insert(new SimpleElement(19));
        list.insert(new SimpleElement(6));
        list.insert(new SimpleElement(12));
        list.insert(new SimpleElement(12));
        list.insert(new SimpleElement(1));
        list.insert(new SimpleElement(-45));
        list.insert(new SimpleElement(112));

        System.out.println("After insertion: " +myList);
        System.out.println("After insertion: " +list);

        //Now we are going to  search for an element
        Element found = myList.search(4);
        System.out.println(found);

        //Now we are going to  search for an element in SDList instance
        Element isFound = list.search(-45);
        System.out.println(isFound);
        isFound = list.search(12);
        System.out.println(isFound);

        //Now we are going to test the delete method
        boolean deleted = myList.delete(3);
        System.out.println(deleted);
        System.out.println("After deletion: " +myList);

        //Now we are going to test the delete method of the SDList instance
        boolean isDeleted = list.delete(19);
        System.out.println(isDeleted);
        System.out.println("After deletion: " +list);

        //But what happens if we try to delete a non-existing key? It will return simply false
        deleted = myList.delete(5); //We don't have a key = 5 we have only 1-4 as above
        System.out.println(deleted);


    }
}