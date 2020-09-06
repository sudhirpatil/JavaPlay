package com.sp.playground.JavaPlay.helpers;


public class StringBuilder {
    public static void main(String[] args){
        // create a StringBuilder object
        // with a String pass as parameter
        StringBuilder sBuilder = new StringBuilder();

        // print string
        System.out.println("String = " + sBuilder.toString());

        // reverse the string
//        StringBuilder reverseStr = sBuilder.reverse();
//
//        // print string
//        System.out.println("Reverse String = " + reverseStr.toString());
//
//        // Append ', '(44) to the String
//        sBuilder.appendCodePoint(44);
//
//        // Print the modified String
//        System.out.println("Modified StringBuilder = "
//                + sBuilder);
//
//        // get capacity
//        int capacity = sBuilder.capacity();

        // print the result
        System.out.println("StringBuilder = " + sBuilder);
//        System.out.println("Capacity of StringBuilder = "
//                + capacity);

        /* Diff StringBuilder with char[] array :
                StringBuilder is just wrapper over char[], with auto resizing capability for insert/delete
         */
    }
}
