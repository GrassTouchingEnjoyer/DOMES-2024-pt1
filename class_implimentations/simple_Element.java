package class_implimentations;

import class_signatures.Element;
import tools.RandomNumberGenerator;



/*
*
* Key is an integer that works as an ID for the elemenets in (3A) 
* we don't mind having elements with the same one.
*
* Value is just an integer value.
*
*/
//_______________________________________________________|element|

public class simple_Element implements Element{

    int key;
    int value;

//_______________________________________________________________|






/*
 * this Constructor makes an element with random key and random value based within a 
 * finite given limit, used in main.
 */
//_______________________________________________________________|Random Constructor|

public simple_Element(int up_limit_key,int up_limit_value){         

    key = RandomNumberGenerator.WITH_limit_given_here(up_limit_key);
    value = RandomNumberGenerator.WITH_limit_given_here(up_limit_value);

}
//__________________________________________________________________________________|





//___________________________________|element.key getters_setters|

    public int getKey() {return key;}

    public void setKey(int key) {this.key = key;}
//_______________________________________________________________|






//__________________________________|element.value getters_setters|

    public int getValue() {return value;}

    public void setValue(int value) {this.value = value;}
//_______________________________________________________________|





/*
 * Used to provide information for a specific element, used in all elements.
 */
//_________________________________________________________________________________|toString|
@Override
public String toString() {
    return "simple_Element [key=" + key + ", value=" + value +"]";
}
//__________________________________________________________________________________________|
}


