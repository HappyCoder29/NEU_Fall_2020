package edu.northeastern.ashish;

public class Stack<T> {
    Node<T> head;

    public Stack(){
    }

    public void push(T data){
        Node<T> add = new Node(data);
        if(head == null){
            head = add;
            return;
        }
        add.next = head;
        head = add;
    }

    public T pop(){
        if(head == null){
            return null;
        }
        T data = head.data;
        Node<T> temp = head;
        head = head.next;
        temp = null;

        return data;
    }

    public boolean isEmpty(){
        return  head == null ? true : false ;
    }

    public int length(){
        if(head == null){
            return 0;
        }
        int count = 0;
        Node<T> temp = head;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }
    public T peek(){
        return head == null ? null : head.data ;
    }
}
