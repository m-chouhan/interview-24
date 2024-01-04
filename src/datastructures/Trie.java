package datastructures;

import java.util.HashMap;

/**
 * Modified Trie Data structure for word break problem!
 * https://leetcode.com/problems/word-break-ii/
 */
public class Trie {

    public class TrieNode {
        char value;
        boolean isTerminalNode;
        HashMap<Character, TrieNode> childNodes;
        TrieNode(char value) {
            this.value = value;
            this.childNodes = new HashMap<>();
            this.isTerminalNode = false;
        }
    }
    private final TrieNode rootNode;

    Trie() {
        rootNode = new TrieNode('.');
    }

    void addWord(String word) {
        addWord(word.toLowerCase(), 0, rootNode);
    }

    private void addWord(String word, int index, TrieNode parentNode) {
        if(index > word.length()) {
            throw new IndexOutOfBoundsException("Given Index "+ index + " is out of bounds in " + word);
        }

        if(index == word.length()) {
            parentNode.isTerminalNode = true;
            return;
        }

        char character = word.charAt(index);
        if(!parentNode.childNodes.containsKey(character)) {
            TrieNode childNode = new TrieNode(character);
            parentNode.childNodes.put(character, childNode);
        }

        addWord(word, index + 1, parentNode.childNodes.get(character));
    }

    boolean contains(String word) {
        return contains(word.toLowerCase(), 0, rootNode);
    }

    private boolean contains(String word, int index, TrieNode parentNode) {
        if(index == word.length()) return parentNode.isTerminalNode;

        char character = word.charAt(index);
        if(parentNode.childNodes.containsKey(character)) {
            return contains(word, index + 1, parentNode.childNodes.get(character));
        }
        return false;
    }
}
