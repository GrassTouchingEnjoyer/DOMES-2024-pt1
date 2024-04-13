package main;

import class_implimentations.AList;
import class_implimentations.simple_Element;
import tools.RandomNumberGenerator;
import tools.loading_bar;
import tools.print;


public class App {
    public static void main(String[] args) throws Exception
    {

        AList array = new AList(RandomNumberGenerator.with_random_ten()); 

        print.is(""+array.getMsize());

        for(int index=0; index <= array.getMsize()-1; index++){

            array.insert(new simple_Element(array.getMsize(),array.getMsize()));

            array.print_element(index);
            print.is("["+index+"]");

        }

        long StartTime = System.nanoTime();

        print.is("______________________________________________");
        print.is("before delete");
        print.is("______________________________________________");
        print.is("inlistnum: "+array.getNumInList());
        print.is("tail: "+array.getTail());
        print.is("______________________________________________");

        print.is("______________________________________________");
        print.is("Delete: "+array.delete(541));
        print.is("Delete: "+array.delete(575));
        print.is("Delete: "+array.delete(753));
       
        print.is("______________________________________________");
        loading_bar.loading_time(StartTime);
        print.is("______________________________________________");
        
        try{
        print.is("Search: "+array.search(3));
        }catch(NullPointerException e ){
            print.is("element not found");;
        }
        print.is("______________________________________________");


        print.is("inlistnum: "+array.getNumInList());
        print.is("tail: "+array.getTail());
        print.is("______________________________________________");

        array.print_element(array.getTail());
        array.print_element(array.getTail()-1);
        array.print_element(array.getTail()-2);
        array.print_element(array.getTail()-3);

        print.is("______________________________________________");


    }
}
