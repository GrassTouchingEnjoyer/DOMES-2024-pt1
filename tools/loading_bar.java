package tools;

public class loading_bar {
    
    public static void loading_time(long StartTime){

        long endTime = System.nanoTime();
        long elapsedTime = endTime - StartTime;

        print.is("Time elapsed: "+elapsedTime+" nanoseconds");

    }

}
