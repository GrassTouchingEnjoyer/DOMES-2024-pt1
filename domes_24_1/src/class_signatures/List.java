package class_signatures;

import class_implimentations.simple_Element;

public interface List{               

//_________________________________________________________________________________________
    /**
	 * Inserts an element into the list
	 * @param simple_Element
	 * @return true if the insertion was successful. Otherwise false
	 */     
        public boolean  insert(simple_Element item);  // insert as the end of the list   
//________________________________________________________________________________________|



//______________________________________________________________________________________________________________________________
    /**
	 * Deletes the first element found in the list with key equal to the given key
	 * @param key
	 * @return true if a deletion is made. Otherwise false
	 */     
        public boolean  delete(int key);       // Deletes the first element found in the list with key equal to the given key
//_____________________________________________________________________________________________________________________________|



//_________________________________________________________________________________________
    /**
	 * Returns the first element found in the list with key equal to the given key
	 * @param key
	 * @return The first matched element, otherwise null
	 */
        public simple_Element search(int key);       
//________________________________________________________________________________________| 

}