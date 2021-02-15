package com.sp.playground.JavaPlay.helpers.tree;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private Map<Character, TrieNode> children;
    private boolean isWord;
    TrieNode(){
        children = new HashMap<>();
        isWord = false; // Last char of word, to idicate this forms path to word
    }
}
