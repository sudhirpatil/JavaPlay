package com.sp.playground.JavaPlay.helpers.graph;

/**
 Disjoint sets is optimal way in Graph to determine,
    * IF 2 nodes are connected?
    * Number of disconnected sub graphs/sets
 */
public class DisjointSets {
    int[] root;
    public DisjointSets(int size){
        root = new int[size];
        //Initialize each node with value same as index
        for(int i=0;i<size;i++)
            root[i] = i;
    }

    /**
     * Finds root node of vertex, by visiting parent nodes till root[index] == index
     */
    public int findRoot(int x){
        if(root[x] == x)
            return x;
        //Path Compression
        //Every child node will point to root node as parent with "root[x]=".
        //Makes finding root node lot faster, as it doesn't have to go through all the parents
        return root[x] = findRoot(root[x]);
    }

    /**
     * Adds vertices link to Graph, by finding root of each vertex
     */
    public int union(int x, int y){
        int rootX = findRoot(x);
        int rootY = findRoot(y);
        if(rootX != rootY)
            root[rootY] = rootX;
        return rootX;
    }

    public boolean isConnected(int x, int y){
        return findRoot(x) == findRoot(y);
    }
}
