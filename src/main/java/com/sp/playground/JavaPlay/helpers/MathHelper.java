package com.sp.playground.JavaPlay.helpers;

public class MathHelper {
    public void permeutationCombination(){

        // Total Combination, when order is required : different ways to select 3 chocolates of different color
        // n! i.e 3! = 3 * 2 * 1 = 6


    }

    public void mathFunctions(){
        // Math round off, ceil etc
        // Cast data types

        float f = 9.3f;
        java.lang.Math.round(f); //Output is 9 : int
        java.lang.Math.ceil(f); //Output is 10 : double
        java.lang.Math.floor(f); //Output is 9 : double
        java.lang.Math.abs(-1);
        int floorInt = (int) f; // Output is 9
    }

    public static void main(String[] args) {
        System.out.println(Math.floorMod(2, 3));    //2
        System.out.println(Math.floorMod(-2, 3));   //1
        System.out.println(-2%3);                   //-2
        System.out.println(Math.floorMod(2, -3));   //-1
        System.out.println(Math.floorMod(-2, -3));  //-2
        System.out.println(Math.floorMod(-4, -3));  //-1

/*
Problem with %
    Doesn't handle -ve numbers correctly
    e.g -2%3 = -2 where as it should be +2 as per math
Whats the solution?
    Using Math.floorMod(-2, 3)
Where is it useful in coding?
    In matrix making sure rows & cols are in bounds, when moving across cells by adding/subtracting from row/col index
    Specially in case of indexes < 0 e.g -2 mod 3 this method gives 2 or 2%3 will give -2 which is not valid index

2 % 3
    == What do we need to add, to the multiples of 3(devisor) to get value 2?
    == (3*mul?)+(x?)=2 //x is the answer
    == (3*0)+(2) //2 is the answer

If one of the values is -ve then multiplier has to be -ve
If both values are -ve or both are +ve then multiplier has to be +ve
If Divisor is -ve then mod value(result) is always -ve
e.g
2%3 :: 3*0+(2)=2        =>2
-2%3:: 3*-1+(1)=-2      =>1
2%-3:: -3*-1+(-1)=2    =>-1
-2%-3::-3*0+(-2)=-2     =>-2
 */

    }
}
