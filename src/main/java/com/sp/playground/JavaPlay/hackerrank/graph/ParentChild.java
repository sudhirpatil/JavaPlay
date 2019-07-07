package com.sp.playground.JavaPlay.hackerrank.graph;




/*
Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

For example, in this diagram, 6 and 8 have a common ancestor of 4.

1   2   4
 \ /   / \
  3   5   8
   \ / \   \
    6   7   10

parentChildPairs1 = [
    (1, 3), (2, 3), (3, 6), (5, 6),
    (5, 7), (4, 5), (4, 8), (8, 10)
]

Write a function that takes the graph, as well as two of the individuals in our dataset, as its inputs and returns true if and only if they share at least one ancestor.

Sample input and output:

hasCommonAncestor(parentChildPairs1, 3, 8) => false
hasCommonAncestor(parentChildPairs1, 5, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 8) => true
hasCommonAncestor(parentChildPairs1, 1, 3) => false
hasCommonAncestor(parentChildPairs1, 6, 5) => true

Additional example: In this diagram, 4 and 8 have a common ancestor of 10.

      10
     /  \
1   2    5
 \ /    / \
  3    6   7
   \        \
    4        8

parentChildPairs2 = [
    (10, 2), (10, 5), (1, 3), (2, 3),
    (3, 4), (5, 6), (5, 7), (7, 8)
]

hasCommonAncestor(parentChildPairs2, 4, 8) => true
hasCommonAncestor(parentChildPairs2, 1, 6) => false

 */
import java.io.*;
import java.util.*;

public class ParentChild {

    public static Map<Integer, Set<Integer>> getFamilyTree(int[][] pairs){
        Map<Integer, Set<Integer>> relations = new HashMap<Integer,Set<Integer>>();

        for(int[] pair: pairs){
            int parent = pair[0];
            int child = pair[1];

            // Set<Integer> parents = relations.getOrDefault(child, new HashSet<Integer>());
            // parents.add(parent);
            // relations.put(child, parents);
            relations.putIfAbsent(child, new HashSet<Integer>());
            relations.get(child).add(parent);
        }
        return relations;
    }

    public static List<Set<Integer>> getNoParentNSingle(int[][] pairs){
        Map<Integer, Set<Integer>> relations = getFamilyTree(pairs);

        // System.out.println(relations);

        Set<Integer> singleParentSet = new HashSet<>();
        for(Map.Entry<Integer, Set<Integer>> entry : relations.entrySet()){
            if(entry.getValue().size() == 1){
                singleParentSet.add(entry.getKey());
            }
        }

        Set<Integer> noParent = new HashSet<>();
        for(Map.Entry<Integer, Set<Integer>> entry : relations.entrySet()){
            for(int parent: entry.getValue()){
                if(!relations.containsKey(parent)){
                    noParent.add(parent);
                }
            }
        }

        List<Set<Integer>> list = new ArrayList<>();
        list.add(singleParentSet);
        list.add(noParent);
        return list;
    }

    public static boolean hasCommonAncestor(int[][] pairs,int node1, int node2){
        Map<Integer, Set<Integer>> relations = getFamilyTree(pairs);

        Map<Integer, Integer> node1Parents = new HashMap<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(node1);
        while(!queue.isEmpty()){
            int node = queue.poll();

            node1Parents.put(node,1);
            if(relations.containsKey(node)){
                for(int i: relations.get(node)){
                    queue.add(i);
                }
            }

        }
        node1Parents.remove(node1);
        System.out.println(node1Parents);

        queue.offer(node2);
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(node1Parents.containsKey(node)){
                return true;
            }

            if(relations.containsKey(node)){
                for(int i: relations.get(node)){
                    queue.add(i);
                }
            }
        }
        return false;
    }

//    @Test
//    public void commonAncestorTest(){
//        int[][] parentChildPairs1 = new int[][] {
//                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
//                {4, 5}, {4, 8}, {8, 10}
//        };
//
//        Assert.assertEquals(false, hasCommonAncestor(parentChildPairs1, 3, 8));
//        Assert.assertEquals(true, hasCommonAncestor(parentChildPairs1, 5, 8));
//        Assert.assertEquals(true, hasCommonAncestor(parentChildPairs1, 6, 8));
//        Assert.assertEquals(false, hasCommonAncestor(parentChildPairs1, 1,3));
//        Assert.assertEquals(true, hasCommonAncestor(parentChildPairs1, 6,5));
//    }
//
//    @Test
//    public void cmTest2(){
//        int[][] parentChildPairs2 = {
//                {10, 2}, {10, 5},{1, 3}, {2, 3},
//                {3, 4}, {5, 6}, {5, 7}, {7, 8}
//        };
//
//        Assert.assertEquals(true, hasCommonAncestor(parentChildPairs2, 4, 8));
//        Assert.assertEquals(false, hasCommonAncestor(parentChildPairs2, 1, 6));
//    }

    public static void main(String[] args) {
//        JUnitCore.main("Solution");
    }
}