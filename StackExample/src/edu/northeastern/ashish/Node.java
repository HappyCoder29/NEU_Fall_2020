package edu.northeastern.ashish;

public class Node<T> {
    public T data;
    public Node next;

    private Node(){}

    public Node(T data){
        this.data = data;
        this.next = null;
    }

}
