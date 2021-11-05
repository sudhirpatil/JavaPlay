package com.sp.playground.JavaPlay.helpers;

import java.util.BitSet;

public class BitsetHelper {
    public static void main(String args[]) {
        // Bitset Special array which holds bits, supports various bit operations like and,xor etc (adv over array)
        //how to initialize?
        BitSet bits1 = new BitSet();
        BitSet bits2 = new BitSet(16);

        //how to set bit at specific index?
        bits1.set(2); //sets bit at 2nd index
        //How to get bit values at index?
        boolean bit = bits1.get(2); // true/false
        // Returns the index of the first bit that is set to true that occurs on or after the specified starting index. If no such bit exists then -1 is returned.
        int indexWith1 = bits1.nextSetBit(0); // returns -1 no bit set after
        //Get count of 1 bits in a number
        int bitCount = 0;
        for(int i=bits1.nextSetBit(0);i>=0;i = bits1.nextSetBit(i+1)){
            bitCount++;
        }
        //Reverse loop to count bits
        for(int i = bits1.length();  (i = bits1.previousSetBit(i-1)) >= 0;){}
        // Get previous index set as 1, on or previous to given index
        indexWith1 = bits1.previousSetBit(2); // return -1 if no bit is set previously

        // set bits
        for(int i = 0; i < 16; i++) {
            if((i % 2) == 0) bits1.set(i);
            if((i % 5) != 0) bits2.set(i);
        }

        System.out.println(bits1);
        // Number of bits set with 1
        System.out.println(bits1.cardinality());
        // AND bits
        bits2.and(bits1); //{2, 4, 6, 8, 12, 14}
        // OR bits
        bits2.or(bits1); //{0, 2, 4, 6, 8, 10, 12, 14}
        // XOR bits
        bits2.xor(bits1); //{}

        //Get bit representation of String
        String binaryString = Integer.toBinaryString(5); //"101"
        // Integer from bit representation of String
        int value = Integer.parseUnsignedInt(binaryString, 2); //5
        //int value with only highest-order ("leftmost") one-bit set
        Integer.highestOneBit(15); //8
        //int value with only lowest-order ("rightmost") one-bit set
        Integer.lowestOneBit(14); //2
        //count of number of bits with 1 in binary value
        Integer.bitCount(14); //3
    }
}
