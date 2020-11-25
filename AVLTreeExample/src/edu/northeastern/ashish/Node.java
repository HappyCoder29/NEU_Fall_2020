package edu.northeastern.ashish;

public class Node {
    public Node left;
    public Node right;
    public int data;
    public int height;
    private Node(){}
    public Node(int data){
        this.data = data;
        this.height =1;
    }
}
