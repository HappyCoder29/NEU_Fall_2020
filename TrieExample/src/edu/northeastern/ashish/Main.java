package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        SuffixTrie trie = new SuffixTrie();
        trie.addToSuffixTree("abaaba");
        System.out.println(trie.isSubstring("abb"));
        System.out.println(trie.findNumOfTimes("a"));

        System.out.println("");
    }
}
