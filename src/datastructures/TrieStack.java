package datastructures;

import java.util.ArrayDeque;

/**
 * A composite data structure for word break problem!
 * https://leetcode.com/problems/word-break-ii/
 * Adds more specific functionalites to trie ds.
 */
public class TrieStack {
    Trie trie;
    ArrayDeque<Trie.TrieNode> stack;

    public TrieStack() {
        trie = new Trie();
        stack = new ArrayDeque<>();
        // correct way to start is with root already pushed
        stack.push(trie.getRoot());
    }

    public boolean peekAhead(char character) {
        if(stack.isEmpty()) return false;

        Trie.TrieNode topNode = stack.peek();
        return topNode.childNodes.containsKey(character);
    }

    public boolean peekRoot(char character) {
        return trie.contains(character);
    }

    /* Push a trie node on top of stack.
        '.' implies you are pushing root node on stack.
    * */
    public void push(char character) {
        if(character == '.') {
            stack.push(trie.getRoot());
            return;
        }

        if(stack.isEmpty())
            throw new IllegalStateException("Stack is empty, cannot push new nodes on it!");

        Trie.TrieNode topNode = stack.peek();
        if(!topNode.childNodes.containsKey(character)) {
            throw new IllegalStateException("The character cannot be pushed since it has no valid parent!.");
        }

        stack.push(topNode.childNodes.get(character));
    }

    public char pop() {
        Trie.TrieNode node = stack.pop();
        return node.value;
    }

    /** Wrapper method for exposing trie related functions! */
    public void addWord(String word) {
        trie.addWord(word);
    }

    public boolean isValidWord() {
        if(stack.isEmpty()) return false;
        return stack.peek().isTerminalNode;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Trie.TrieNode node : stack) {
            char toAppend = (node.value == '.' ? ' ' : node.value);
            builder.insert(0, toAppend);
        }

        if (!builder.isEmpty()) {
            builder.deleteCharAt(0);
        }

        return builder.toString();
    }
}
