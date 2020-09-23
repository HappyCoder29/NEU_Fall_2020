package edu.northeastern.ashish;

public class Queue<T>{
    private Node<T> head;
    private Node<T> tail;

    public Queue(){
        head = null;
        tail = null;
    }

    public void enqueue(T data){
        Node<T> add = new Node<>(data);
        if(head == null){
            head = add;
            tail = add;
            return;
        }

        head.next = add;
        add.prev = head;
        head = add;

    }

    public T dequeue(){
        if(tail == null){
            return null;
        }
        T data = tail.data;
        Node<T> temp = tail;
        tail = tail.next;
        if(tail == null){
            head = null;
        }
        temp = null;
        return data;

    }

    public boolean isEmpty(){
        return head == null? true: false;
    }

    public int length(){
        if(head == null){
            return 0;
        }
        int count = 0 ;

        Node<T> temp = head;
        while(temp != null){
            temp = temp.prev;
            count++;
        }
        return count;
    }
    public T peek(){
        return tail == null? null: tail.data;
    }



}
