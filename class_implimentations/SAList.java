package class_implimentations;

import tools.binary_Search;
import tools.print;


//____________________________________________________________________|SAList|
public class SAList extends AList{ // sorted array list 

    private final int         msize;           // Maximum size of list
    private int               tail;            // End size            
    private int               numInList;       // Actual list size
    private simple_Element[]  listArray;       // Array holding list
//___________________________________________________________________________|










//_________________________________________________________________|Constructing AList|  

public SAList(int size){                          

    this.msize = size;
    this.numInList = 0;
    this.tail = -1;
    this.listArray = new simple_Element[size];
}  
//____________________________________________________________________________________|






/*

  This operation only takes place only to make the array sorted not anywhere else, it is easier to make it O(2n), but with 
  more thought in it, we can make it O(n).
_________________________________________________________________________________________________|Insert_starter_Operation||Complexity: O(n)|  
*/
public boolean sorting_insert(simple_Element new_item){

    if(is_array_full()==true){print.is("\ninsert operation failed"); return false;} // check if array is full since it is a finite set
    
    else
    {   

            this.listArray[this.tail+1] = new_item;                 // set in tail + 1 position the new_item
            this.tail = this.tail+1;                                // increment tail + 1
            this.numInList = this.numInList+1;                      // increment numInList + 1


            for(int index = this.tail ; index >= 1 ; index--){

                if(this.listArray[index].getKey() <= this.listArray[index-1].getKey()){

                    simple_Element temp = this.listArray[index];

                    this.listArray[index] = this.listArray[index-1];

                    this.listArray[index-1] = temp;
                }

           }
        
    }
    
    return true;
}                              
//___________________________________________________________________________________________________________________________________________| 









/*

  This is the actual insert to an already sorted array, the binary search was given by our professors nad modified to make it suit 
  my implimentation, it was nice and easy code, ++comments why I made changed in binary_Search.java

  ~ I love it when a plan comes together!!!
___________________________________________________________________________________________________________|Insert_Operation||Complexity: O(n)|  
*/
public boolean insert(simple_Element new_item){

    if(is_array_full()==true){print.is("\ninsert operation failed"); return false;} // check if array is full since it is a finite set

    binary_Search find = new binary_Search(this.listArray,0);                   

    int place_to_put = find.search(new_item.getKey());    // Call to binary_Search.java 

    place_to_put = place_to_put+1;

    this.listArray[place_to_put] = new_item;
    this.tail = this.tail+1;                                
    this.numInList = this.numInList+1;  
    print.is("Insert complete");  
    return true;
    
}
//___________________________________________________________________________________________________________________________________________| 











//___________________________________________________________________________________________________________|Delete_Operation||Complexity: O(n)|

public boolean delete(int key){

    if(is_array_empty()==true){print.is("nothing to delete");}       // check if there are elements to delete

    else                                                                    // if elements are more than 0
    {   
        int del_index = -1;                                          

        binary_Search find = new binary_Search(this.listArray,1); // make a binary search object with OpCode 1 for deletion

        try{   
            
            del_index = find.search(key);                                // Call to binary_Search.java 
            listArray[del_index] = null;                                 // ELEMENT DELETION HERE!!!

        }
        catch(NullPointerException e){                                     
            print.is("\nElement for deletion not found");
            return false;
        }
        catch(ArrayIndexOutOfBoundsException e ){
            print.is("\nElement for deletion not found"); 
            return false;
            
        }//catch... place here anymore possible excemption if you need 

        //------------------------------------------------------------------

        while(del_index < this.tail)                                     // while this variable starting from the deleted element is smaller than the tail
        {   
                                                                         // move null like a bubble upwards and beyond the tail
            this.listArray[del_index] = this.listArray[del_index+1];     // the idea is listArray[del_index]==null then it's free to take in a value
            this.listArray[del_index+1] = null;                          // takes listArray[del_index+1]'s value and then that instance is deleted

            del_index++;                                                 // increment del_index for next loop, to move the null value once more                                        
        }
        //------------------------------------------------------------------
    
        this.tail = this.tail-1;                           // tail is cut by 1                           
        this.numInList = this.numInList-1;                 // num of active elements in array list cut by 1
        print.is("Deletion complete");
        return true;                                       // here it finishes if deletion is sucessful    
        
    }
    print.is("\nElement for deletion not found");
    return false;    // here it finishes if deletion was unsucessful                                       

}
//___________________________________________________________________________________________________________________________________________| 










//___________________________________________________________________________________________________________________________________________|  
public simple_Element search(int key){

    int search_index;

        binary_Search find = new binary_Search(this.listArray,1);   

        search_index = find.search(key);                                    // Call to binary_Search.java 

        print.is("Search Complete");

    try{

        return listArray[search_index];

    }catch(NullPointerException e){
        print.is("\nElement for deletion not found");
        return null;
    }
    catch(ArrayIndexOutOfBoundsException e ){
        print.is("\nElement for deletion not found"); 
        return null;
    }   

}
//_________________________________________________________________________________________________________________________________________| 












/* 
________________________________________________________________________________________________________________________________________________________________________
|                                                                                                        ______________________________________________________________|
|-------------------------|  █▀▀ █▀▀ █▄░█ █▀▀ █▀█ ▄▀█ █░░   █░█ █▀▀ █░░ █▀█ |---------------------------|   these functions are for general uses                       |
|-------------------------|  █▄█ ██▄ █░▀█ ██▄ █▀▄ █▀█ █▄▄   █▀█ ██▄ █▄▄ █▀▀ |---------------------------|   so that these uses won't be repeated into important code   |
|                                                                                                       |______________________________________________________________|
|______________________________________________________________________________________________________________________________________________________________________|                                                                                                        
*/




//______________________________________|Check if list is full|

public boolean is_array_full(){

    if(this.numInList == this.msize){
        print.is("Array is full ");
        return true;
    
    }else if(this.numInList < this.msize){return false;}

    return false;
}
//____________________________________________________________|







//_____________________________________|Check if list is empty|

public boolean is_array_empty(){

    if(this.numInList==0){
        print.is("Array is empty ");
        return true;
    }
    else{return false;}
}
//____________________________________________________________|






//_______________________________________________________________|prints an element in the list|

public void print_element(int index){                               

    try{

        print.is("Element is: "+this.listArray[index].toString());

    }catch (NullPointerException e){

        print.is("no element found to print");

    }catch (ArrayIndexOutOfBoundsException e){

        print.is("Element out of index, it does not exist");
    }

}
//________________________________________________________________|









//_________________________________________________________|GETTERS - SETTERS|

public int getMsize() {
    return msize;
}

public int getTail() {
    return tail;
}

public void setTail(int tail) {
    this.tail = tail;
}

public int getNumInList() {
    return numInList;
}

public void setNumInList(int numInList) {
    this.numInList = numInList;
}

public simple_Element[] getListArray() {
    return listArray;
}

public simple_Element getSimple_Element(int index) {

    return this.listArray[index];
}

public void setListArray(simple_Element[] listArray) {
    this.listArray = listArray;
}
//________________________________________________________________________

     





}





