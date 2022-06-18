package com.sp.playground.JavaPlay;

import java.util.Random;

public class RandomNumberHelper {
    // Create Random Object
    // Note bound/range param is not used in object creation
    Random rand = new Random();

    // Generate random integers in range 0 to 999
    // Note starts from 0 & excludes bound/end so last num is bound-1
    int rand_int1 = rand.nextInt(1000);

    // Generate Random doubles
    //Note: doesn't take any bound param
    double rand_dub1 = rand.nextDouble();
}
