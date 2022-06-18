package com.sp.playground.JavaPlay.helpers.tree;

/**
 Trie is multi children/key Tree structure used for searching or locating sequence
    Root represents empty string or value
 Edges stores the key & not the node
 Tries mainly used for Character String, also can be used for any ordered list of any type
    Permutation of digits or shapes
    Bitwise trie with individual bit as key, can represent fixed length binary data like integer or memory address
 Use:
    Prefix tries allows to store large words with similar prefixes store efficiently and minimise storage space
    Replacement for Hash Maps
    More efficient/compact storage space, no need to store each value separately like in HashMap, there is single path for same prefix
    Does not require hash function and no hash collisions
    Can also used for sorting
    Fulltext search using suffix trees
    Web search engines with leaf nodes storing URL list
    Internet Routing: IP address prefixes used in router and bridges for prefix lookup to resolve mask operations in IP routing
 */
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
