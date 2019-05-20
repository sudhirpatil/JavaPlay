package com.sp.playground.JavaPlay.helpers;

public class DatatypeConversion {
    public void fromString(){
        // String -> Integer
        Integer.parseInt("100");    //returns 100
        // String in hex or binary -> Integer
        Integer.parseInt("-FF", 16);    //returns -255
        Integer.parseInt("1100110", 2); //returns 102

    }

    public void convertPrimitiveTypes(){
        // Float -> Int
        int i =  (int) 0.3;

        // int -> double
        double j = (double) i;
    }
}
