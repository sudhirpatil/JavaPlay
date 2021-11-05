package com.sp.playground.JavaPlay.helpers.graph;

import java.util.*;

public class UndirectedGraphAdjacencylist {
    private List<List<Integer>> adjacencyList = new ArrayList<>();
    private Set<Integer> visited = new HashSet<>();

    public void createGraph(int n, int[][] edges){
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            // Remember to add reverse edge also, since it's undirected graph
            adjacencyList.get(edge[1]).add(edge[0]);
        }
    }

    /**
     * DFS with cycle detection, using visited set
     * Avoid going back to parent node, by passing parent to DFS & checking it
     */
    public boolean dfs(int node, int parent) {
        if (visited.contains(node)) 
            return false;
        visited.add(node);
        for (int neighbour : adjacencyList.get(node)) {
            if (parent != neighbour) {
                boolean result = dfs(neighbour, node);
                if (!result) return false;
            }
        }
        return true;
    }

    /**
     * BFS using queue
     * Check visited size to determine if all nodes can be reached
     */
    public boolean bfs(int n){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.offer(0);
        seen.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbour : adjacencyList.get(node)) {
                if (seen.contains(neighbour)) continue;
                seen.add(neighbour);
                queue.offer(neighbour);
            }
        }

        return seen.size() == n;
    }

    /*
    Graph is valid Tree, if
    1. has exactly n-1 unique edges connecting nodes
    2. No cycles (other than parent <-> child , since it's undirected graph)
    3. All nodes are reachable & no disconnected nodes/graphs
     */
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        createGraph(n, edges);
        
        // Check if cycles detected &
        // If all the nodes are reachable i.e when all the nodes are visited
        return dfs(0, -1) && visited.size() == n;
    }


}
