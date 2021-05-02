package com.sp.playground.JavaPlay.helpers;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayHelper {
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
        // Sort multidimensional array, based on first element
        int[][] arr = {{6,4},{1,2},{4,5} };
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        // Sorting Objects, using comparator
//        Arrays.sort(T[]a , Comparator<T> b);
        Arrays.binarySearch(intArr, 3);

        // Increase size of array with same contents
        int[] biggerArray = Arrays.copyOf(intArr, intArr.length *2);
        // Get copy of sub array
        int[] subArray = Arrays.copyOfRange(intArr, 2,3 + 1);

        // print array contents
        Arrays.toString(intArr);
        // print nested string array
        String[][] nested = {{"row1col1", "row1col2"}, {"row2col1", "row2col2"}};
        Arrays.deepToString(nested);
        // Convert Array to list, list is backed by array (not copy to list) so it is fixed size.
        List<String> listStr = Arrays.asList(nested[0]);
        // So all of the collections operation like max, min etc can be applied on array also

        // Array rotation (circular) , replaces array elements in place
        Collections.rotate(Arrays.asList(intArr),  -2); // moves back [2] to [0]
        Collections.rotate(Arrays.asList(intArr),  2); // moves ahead [0] to [2] & [length-2] to [0]

        //Merge 2 arrays
        int[] first = {1,2,3}, second = {6,7};
        int[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
    }

	public static void main(String[] args){
        boolean[] bool = new boolean[4];

        List<Integer> diffs = new ArrayList<>();
        diffs.add(11);
        diffs.set(0, 22);
        System.out.println(diffs.get(0));
//        Set<Integer> intList = new HashSet<>();
//        intList.add(10);
//        intList.add(20);
//        intList.add(30);
//
////        Integer[] intArray = new Integer[intList.size()];
//        Integer[] intArray  = intList.toArray(new Integer[0]);
//
//        for(Integer i : intArray)
//            System.out.println(i);
    }

}
