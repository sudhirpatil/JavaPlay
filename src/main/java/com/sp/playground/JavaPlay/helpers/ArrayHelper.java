package com.sp.playground.JavaPlay.helpers;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayHelper {
    public void DatatypeConversion(){
        int aInt =0;

        // int -> char
        char c=(char)aInt;

        // float/double to int by rounding lower
        int roundedInt = (int) 11/2;

        // converting operation on int to double
        double result = ((double) 1+ 2)/2;


    }

    public void arrayHelp(){
        // Instantiate array with specific length
        int[] maxArr = new int[10];
        // Fill array with 0's
        Arrays.fill(maxArr, 0);

        // Convert array to List of Integer
        int[] intArr = {1, 2, 3, 4, 5, 6};
        List<Integer> intList = new ArrayList<Integer>();
        for (int i : intArr)
        {
            intList.add(i);
        }
        // java 8 : functional way
        List<Integer> list = Arrays.stream(intArr)		// IntStream
                .boxed() 		// Stream<Integer>
                .collect(Collectors.toList());

        // Sorting
        Arrays.sort(maxArr); // Sorting array of primitive type
        // Sorting Objects, using comparator
//        Arrays.sort(T[]a , Comparator<T> b);

        // Get copy of sub array
        int[] subArray = Arrays.copyOfRange(intArr, 2,3 + 1);

        // print array contents
        Arrays.toString(intArr);
        // print nested string array
        String[][] nested = {{"row1col1", "row1col2"}, {"row2col1", "row2col2"}};
        Arrays.deepToString(nested);

    }

	public static void main(String[] args){

    }

}
