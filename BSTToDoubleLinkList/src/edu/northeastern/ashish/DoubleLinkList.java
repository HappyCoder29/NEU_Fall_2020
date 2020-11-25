package edu.northeastern.ashish;

public class DoubleLinkList {
    Node head;
    Node tail;

    public DoubleLinkList(){
        head = tail = null;
    }
    public void insert(int data){
        Node node = new Node(data);
        if(head == null ){
            head = node;
            tail = node;
            return;
        }
        if(head == tail){
            if(head.data < data){
                tail = node;
                head.right = tail;
                tail.right = head;
                return;
            }
        }

    }
}
