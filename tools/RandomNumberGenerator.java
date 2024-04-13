package tools;

import java.util.Random;


public class RandomNumberGenerator {
    

    public static int WITH_limit_given_here(int up_limit){

        Random rand = new Random();

        return rand.nextInt(up_limit);


    }

    public static int with_random_ten(){

        int num_array [] = {30, 50, 100, 200, 500, 800, 1000, 5000, 10000, 100000};

        Random rand = new Random();

        return (int)num_array[rand.nextInt(9)];

    }



    
}
