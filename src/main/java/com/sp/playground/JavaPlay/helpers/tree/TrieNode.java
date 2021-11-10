package com.sp.playground.JavaPlay.helpers.tree;

class TrieNode {
    /** Initialize your data structure here. */
    public TrieNode[] edges = new TrieNode[26];
    //OR
    // private Map<Character, TrieNode> edgesMap = new HashMap<>();
    public boolean isLast = false;

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode trie = this;
        for(char c : word.toCharArray()){
            TrieNode[] trieEdges = trie.edges;
            if(trieEdges[c-'a'] == null)
                trieEdges[c-'a'] = new TrieNode();
            trie = trieEdges[c-'a'];
        }
        trie.isLast = true;
    }

    public TrieNode getLastNode(String word){
        TrieNode trie = this;
        for(char c : word.toCharArray()){
            TrieNode[] trieEdges = trie.edges;
            if(trieEdges[c-'a'] == null)
                return null;
            trie = trieEdges[c-'a'];
        }
        return trie;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode lastNode = getLastNode(word);
        return lastNode != null ? lastNode.isLast : false;
    }


    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode lastNode = getLastNode(prefix);
        return lastNode != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
