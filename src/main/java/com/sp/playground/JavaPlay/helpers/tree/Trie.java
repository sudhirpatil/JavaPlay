package com.sp.playground.JavaPlay.helpers.tree;

class Trie {

    /** Initialize your data structure here. */
    public Trie[] edges;
    public boolean isLast;
    public Trie() {
        edges = new Trie[26];
        isLast = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie trie = this;
        for(char c : word.toCharArray()){
            Trie[] trieEdges = trie.edges;
            if(trieEdges[c-'a'] == null)
                trieEdges[c-'a'] = new Trie();
            trie = trieEdges[c-'a'];
        }
        trie.isLast = true;
    }

    public Trie getLastNode(String word){
        Trie trie = this;
        for(char c : word.toCharArray()){
            Trie[] trieEdges = trie.edges;
            if(trieEdges[c-'a'] == null)
                return null;
            trie = trieEdges[c-'a'];
        }
        return trie;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie lastNode = getLastNode(word);
        return lastNode != null ? lastNode.isLast : false;
    }


    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie lastNode = getLastNode(prefix);
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
