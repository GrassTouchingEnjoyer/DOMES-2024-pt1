package tools;

import class_implimentations.simple_Element;
//_____________________________________

public class binary_Search {

	private      simple_Element data[];
	private 	 int operations;

//_____________________________________
	


//____________________________________________________________________________________________
/**
	 * Constructor. Given newData must be sorted!
	 * @param newData
	 */
	public binary_Search(simple_Element newData[], int operation) {
		this.data = newData;
		this.operations = operation;
	}
//____________________________________________________________________________________________	






//____________________________________________________________________________________________	
/**
	 * Given newData must be sorted!
	 * @param newData
	 */
	public void setData(simple_Element newData[]) {
		this.data = newData;
	}
//____________________________________________________________________________________________	
	





//____________________________________________________________________________________________
	/**
	 * Searches data array for given key. Returns the key if found, otherwise Integer.MIN_VALUE
	 * @param key
	 * @return
	 */
	public int search(int key) {
		if (data == null) {
			return Integer.MIN_VALUE;
		}

		if(this.operations == 0){return doSearch_0(0, data.length - 1, key);}

		else if(this.operations == 1){return doSearch_1(0, data.length - 1, key);}

	return -1;

	}	
//____________________________________________________________________________________________	
	





//____________________________________________________________________________________________
	/**
	 * Searches the indexes for the data array, for when the element we want to insert, based on its key
	 * it is lower or equal && bigger or equal to, the elements of the search
	 * 	
	 * @param leftIndex
	 * @param rightIndex
	 * @param key
	 * @return key if found or Integer.MIN_VALUE otherwise
	 */
    private int doSearch_0(int leftIndex, int rightIndex, int key) 
    { 
        if (rightIndex >= leftIndex) { 
            int mid = leftIndex + (rightIndex - leftIndex) / 2; 
  
			//--------------------------------------------------------------

            if (data[mid].getKey() <= key && data[mid+1].getKey() >= key){  // this was modified for insert so that when we found the key when 
																			// it is inbetween values of keys we want, then get that mid+1
				shift_right(mid);	
                return mid+1; 											    // mid+1 is the spot to place the element after the one	that is either smaller or equal to it  										
			}
			//--------------------------------------------------------------	

			// If element is smaller than mid, then 
            // it can only be present in left subarray 
            if (data[mid].getKey() > key) 
                return doSearch_0(leftIndex, mid - 1, key); 
  
            // Else the element can only be present 
            // in right subarray 
            return doSearch_0(mid + 1, rightIndex, key); 
        } 
  
        // We reach here when element is not present in array. 
        // We return Integer.MIN_VALUE in this case, so the data array can not contain this value!
        return Integer.MIN_VALUE; 
    } 

		//---------------------------|only part of this function to make the list ready for insert|

			public void shift_right (int mid){

				for(int index = data.length-2 ; index > mid ; index--){ // -1 because number of elements compared to adress space is -1 & 
																		// another -1 because we already check the last element with the +1 below

					data[index+1] = data[index];						// moves elements to the right to leave empty the spot for insert

				}
			}
		//-----------------------------------------------------------------------------------------

//____________________________________________________________________________________________   







//____________________________________________________________________________________________
/**
 * Searches data array from leftIndex to rightIndex for given key. 
* Returns the key if found, otherwise Integer.MIN_VALUE
* @param leftIndex
* @param rightIndex
* @param key
 * @return key if found or Integer.MIN_VALUE otherwise
*/
private int doSearch_1(int leftIndex, int rightIndex, int key) 
    { 
        if (rightIndex >= leftIndex) { 
            int mid = leftIndex + (rightIndex - leftIndex) / 2; 
  
            // Check if the middle is the key we search for 
            if (data[mid].getKey() == key) 
                return mid; 
  
            // If element is smaller than mid, then 
            // it can only be present in left subarray 
            if (data[mid].getKey() > key) 
                return doSearch_1(leftIndex, mid - 1, key); 
  
            // Else the element can only be present 
            // in right subarray 
            return doSearch_1(mid + 1, rightIndex, key); 
   		} 
		// We reach here when element is not present in array. 
        // We return Integer.MIN_VALUE in this case, so the data array can not contain this value!
        return Integer.MIN_VALUE; 
	}
//____________________________________________________________________________________________ 


}


