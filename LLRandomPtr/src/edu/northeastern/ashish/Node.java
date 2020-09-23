package edu.northeastern.ashish;

public class Node {
    public int data;
    public Node next;
    public Node random;

    private Node(){}
    public Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }

}
