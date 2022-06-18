package com.sp.playground.JavaPlay.helpers;


public class StringBuilderHelper {
    public static void main(String[] args){
        // create a StringBuilder object
        StringBuilder sb = new StringBuilder();
        // with a String pass as parameter
        StringBuilder sbCopy = new StringBuilder("string"); // create string builder from string/string buffer

        sb.append("ABCDEF");
        // replaces all between start to end-1 with X
        sb.replace(2,3, "X");
        // print string
        System.out.println("String = " + sb.toString());
        //inserts at specific offset &  shifts chars next it
        sb.insert(1, 'x');
        // reverse the characters in place & returns reference for this object
        StringBuilder reverseStr = sb.reverse();

        // print string
        System.out.println("Reverse String = " + reverseStr.toString());
        // Char at Index
        sb.charAt(0);
        // Delete char at index
        sb.deleteCharAt(0);
        // Append char using ascii code value 44 (i.e ,) to the String
        sb.appendCodePoint(44);
        // Length
        sb.length();

        // Print the modified String
        System.out.println("Modified StringBuilder = "
                + sb);

        // get capacity
        int capacity = sb.capacity(); // Max char that can be saved beyond it will go out of memory
        // print the result
        System.out.println("StringBuilder = " + sb);
        System.out.println("Capacity of StringBuilder = "
                + capacity);
        /* Diff StringBuilder with char[] array :
                StringBuilder is just wrapper over char[], with auto resizing capability for insert/delete
         */
    }
}
