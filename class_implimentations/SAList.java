package class_implimentations;

public class SAList extends AList{ // sorted array list 
    
    private static final int defaultSize = 100;

    private final int         msize;           // Maximum size of list
    private int               tail;            // End size            
    private int               numInList;       // Actual list size
    private simple_Element[]  listArray;       // Array holding list



//_________________________________________________________________|Constructing AList|

public SAList(){        // Constructor

    this.msize = defaultSize;
    this.numInList = 0;
    this.tail = -1;
    this.listArray = new simple_Element[defaultSize];
}    

public SAList(int sz){  // Constructor
    
    this.msize = sz;
    this.numInList = 0;
    this.tail = -1;
    this.listArray = new simple_Element[sz];
}  

//____________________________________________________________________________________|








}
