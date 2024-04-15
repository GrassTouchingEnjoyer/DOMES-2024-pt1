package class_implimentations;

import class_signatures.List;
import tools.print;

/*
 * msize is the final 
 */
//____________________________________________________________________|AList|

    public class AList implements List{

        private static final int defaultSize = 100;

        private final int         msize;           // Maximum size of list
        private int               tail;            // End size            
        private int               numInList;       // Actual list size
        private simple_Element[]  listArray;       // Array holding list

//__________________________________________________________________________|





//_________________________________________________________________|Constructing AList|

public AList(){        // Constructor

    this.msize = defaultSize;
    this.numInList = 0;
    this.tail = -1;
    this.listArray = new simple_Element[defaultSize];
}    

public AList(int sz){  // Constructor
    
    this.msize = sz;
    this.numInList = 0;
    this.tail = -1;
    this.listArray = new simple_Element[sz];
}  

//____________________________________________________________________________________|





//_________________________________|Insert at curr pos|________________________________|Complexity: O(n)|3a|

public boolean insert(simple_Element new_item){


   if(is_array_full()==true){print.is("\ninsert operation failed"); return false;} // check if array is full since it is a finite set
    
    else
    {

        this.listArray[this.tail+1] = new_item;                 // set in tail + 1 position the new_item

        
        this.tail = this.tail+1;                                // increment tail + 1
        this.numInList = this.numInList+1;                      // increment numInList + 1

        return true;                                            // return true since all is well                                

    }
}
//________________________________________________________________________________________________________|






//______________________________|Delete Element from AList|___________________________|Complexity: O(n^2)|3a| 

public boolean delete(int key){

    if(is_array_empty()==true){print.is("nothing to delete");}   // check if there are elements to delete

    else
    {

        for(int index=0 ; index <= this.tail ; index++)   // search for an element with selected key
        {

            //-----------------------------------------------------
            if(this.listArray[index].getKey()==key)                // if keys match
            {                                                      
                this.listArray[index] = null;                      // element is deleted

                print.is("\nDeletion done in ["+index+"]: ");      // print out notification, but are not done yet.

            //----------------------------------------------------  

                
                //------------------------------------------------------------------
                int del_index = index;                                              // take the position of the deleted element in the list

                while(del_index < this.tail)                                        // while this variable starting from the deleted element is smaller than the tail
                {   
                                                                                    // move null like a bubble upwards and beyond the tail
                    listArray[del_index] = listArray[del_index+1];                  // the idea is listArray[del_index]==null then it's free to take in a value
                    listArray[del_index+1] = null;                                  // takes listArray[del_index+1]'s value and then that instance is deleted

                    del_index++;                                                    // increment del_index for next loop, to move the null value once more                                        
                }
                //------------------------------------------------------------------
                
                    
            //-------------------------------------------------
            this.tail = this.tail-1;                           // tail is cut by 1                           
            this.numInList = this.numInList-1;                 // num of active elements in array list cut by 1
            return true;                                       // here it finishes if deletion is sucessful    
            //-------------------------------------------------      
            }

        }
    }
    print.is("\nElement for deletion not found");
    return false;    // here it finishes if deletion was unsucessful                                       

}
//________________________________________________________________________________________________________|





//_______________________________|Search Element from AList|__________________________|Complexity: O(n)|3a| 

public simple_Element search(int key){

    if(is_array_empty()==true){        // check if array is empty

        print.is("nothing to search");     
        return null;
    }

    else{

        for(int index = 0 ; index <= this.tail ; index++)           // linear search since it's unsorted
        { 

            if(this.listArray[index].getKey()==key)                 // if we locate the key 
            {
                print.is("Element located in ["+ index +"]: ");     // print location
                return this.listArray[index];                       // return element
            }

        }
        print.is("Element NOT found!"); // not found
        return null;
    }
}
//_________________________________________________________________________________________________________| 



/*
________________________________________________________________________________________________________________________________________________________________________
|                                                                                                        ______________________________________________________________|
|-------------------------|  █▀▀ █▀▀ █▄░█ █▀▀ █▀█ ▄▀█ █░░   █░█ █▀▀ █░░ █▀█ |---------------------------|   these functions are for general uses                       |
|-------------------------|  █▄█ ██▄ █░▀█ ██▄ █▀▄ █▀█ █▄▄   █▀█ ██▄ █▄▄ █▀▀ |---------------------------|   so that these uses won't be repeated into important code   |
|                                                                                                       |______________________________________________________________|
|______________________________________________________________________________________________________________________________________________________________________|                                                                                                        
*/

//_________________|Check if list is full|____________________

public boolean is_array_full(){

    if(this.numInList == this.msize){
        print.is("Array is full ");
        return true;
    
    }else if(this.numInList < this.msize){return false;}

    return false;
}
//____________________________________________________________|



//_________________|Check if list is empty|____________________

public boolean is_array_empty(){

    if(this.numInList==0){
        print.is("Array is empty ");
        return true;
    }
    else{return false;}
}
//____________________________________________________________|




/*
 * changed from IF to TRY-CATCH
 */

//_________________|prints an element in the list|________________

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



//______________|getters and setters|________________

public static int getDefaultsize() {
    return defaultSize;
}

public int getMsize() {
    return msize;
}

public int getTail() {
    return tail;
}

public int getNumInList() {
    return numInList;
}

public simple_Element[] getListArray() {
    return listArray;
}
//___________________________________________________|

}

