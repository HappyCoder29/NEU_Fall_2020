package edu.northeastern.ashish;

import java.util.LinkedList;
import java.util.List;

public class Node {

    public char ch;
    public boolean isTerminatingChar;
    public List<Node> children;

    private Node(){}

    public Node(char ch) {
        this.ch = ch;
        this.isTerminatingChar = false;
        this.children = new LinkedList<Node>();
    }
}
