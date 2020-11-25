package com.sp.playground.JavaPlay.helpers;

public class DatatypeConversion {

    public void DatatypeConversion(){
        int aInt =0;
        // int->char, convert int to char i.e 2 int to -> '2' char
        char charInt = '0' + 2; // add 2 to ascii value of '0', as ascii representation of numbers in sequence this becomes '2'
        // char->int
        int intVal = '2' - '0'; // returns 2
        // int to char representing that ascii value i.e 65 -> 'A'
        char c=(char)aInt;

        // float/double to int by rounding lower
        int roundedInt = (int) 11/2; //5

        // converting operation on int to double
        double result = ((double) 1+ 2)/2;
    }

    public void charToInt(){
        // Add / Subtract char '0' to convert to int / char

        // int -> char
        char ch2 = (char)  ('0' + 2);

        // char -> int
        int chInt = '2' - '0';
    }

    public static void main(String[] args) {
        System.out.println((char)65);
        System.out.println((char)('0' + 2));
        System.out.println(Character.getNumericValue('2'));
        System.out.println(Character.isLetterOrDigit('-'));
        Integer.compare(1,3);
    }

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

    // Check if string is integer
    public static boolean isInteger(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static boolean isIntegerOptimal(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }


}
