package main;

import class_implimentations.AList;
import class_implimentations.SAList;
import class_implimentations.simple_Element;
import tools.RandomNumberGenerator;
import tools.loading_bar;
import tools.print;


public class App {
    public static void main(String[] args) throws Exception
    {

//__________________________________________________________________________________________________

        SAList array = new SAList(20); 


        for(int index=0; index <= 19; index++){

            array.sorting_insert(new simple_Element(array.getMsize(),array.getMsize()));

        }

        print.is("______________________________________________");
        for(int index=0; index <= array.getMsize()-1; index++){

            array.print_element(index);
            print.is("["+index+"]");

        }
        print.is("______________________________________________");



        print.is("______________________________________________");
        array.insert(new simple_Element(23, 111111111));
        print.is("______________________________________________");
        


        array.delete(0);
        array.delete(6);
        array.delete(9);
        array.delete(3);
        array.delete(2);
        array.delete(5);

        print.is("______________________________________________");
        array.insert(new simple_Element(23, 111111111));
        print.is("______________________________________________");

        try{

        print.is(""+array.search(4));
        
        }catch(NullPointerException e ){
            print.is("element not found");;
        }


        print.is("______________________________________________");
        print.is("num: "+array.getNumInList());
        print.is("tail: "+array.getTail());
        print.is("______________________________________________");


        print.is("______________________________________________");
        for(int index=0; index <= array.getMsize()-1; index++){

            array.print_element(index);
            print.is("["+index+"]");

        }
        print.is("______________________________________________");
//__________________________________________________________________________________________________


AList array2 = new AList(RandomNumberGenerator.with_random_ten()); 

print.is(""+array2.getMsize());

for(int index=0; index <= array2.getMsize()-1; index++){

    array2.insert(new simple_Element(array2.getMsize(),array2.getMsize()));

    array2.print_element(index);
    print.is("["+index+"]");

}



long StartTime = System.nanoTime();

print.is("______________________________________________");
print.is("before delete");
print.is("______________________________________________");
print.is("inlistnum: "+array2.getNumInList());
print.is("tail: "+array2.getTail());
print.is("______________________________________________");

print.is("______________________________________________");
print.is("Delete: "+array2.delete(541));
print.is("Delete: "+array2.delete(575));
print.is("Delete: "+array2.delete(753));

print.is("______________________________________________");
loading_bar.loading_time(StartTime);
print.is("______________________________________________");

try{
print.is("Search: "+array2.search(3));
}catch(NullPointerException e ){
    print.is("element not found");;
}
print.is("______________________________________________");


print.is("inlistnum: "+array2.getNumInList());
print.is("tail: "+array2.getTail());
print.is("______________________________________________");

array2.print_element(array2.getMsize());
array2.print_element(array2.getMsize()-1);
array2.print_element(array2.getMsize()-2);
array2.print_element(array2.getMsize()-3);

print.is("______________________________________________");




    }

}

