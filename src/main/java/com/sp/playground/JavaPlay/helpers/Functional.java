package com.sp.playground.JavaPlay.helpers;

import com.sp.playground.JavaPlay.helpers.tree.BinaryTreeNode;

import java.util.Arrays;
import java.util.List;

public class Functional {
    public static void main(String[] args){

        /*
         Reduce operator takes 3 params
         Initializer : initial value for accumulator
         Accumulator : function with 2 params, partial result from previous & current index value, passes result to next action
         Combiner : function to combine partial results, When parallelized or if type of parameter passed is different than return value of function
         */

        //reduce to convert string to int
        "123".chars().
                reduce(0, (sum, c) -> sum * 10 + (c - '0')); // only initializer & accumulator function passed to reducer

        List<BinaryTreeNode<Integer>> objList = Arrays.asList(new BinaryTreeNode(1), new BinaryTreeNode(2), new BinaryTreeNode(3));
        objList.stream().
                reduce(0, (sum, node) -> sum + node.data, Integer::sum);
        // data type of node is different than return type integer, so have to add combiner function to combine results

    }
}
