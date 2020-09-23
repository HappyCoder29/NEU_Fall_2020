package edu.northeastern.ashish;

public class StackUsingQueues {
    Queue<Integer> q1, q2;

    public StackUsingQueues(){
        q1 = new Queue<>();
        q2 = new Queue<>();
    }

    public void push(int data){
        q1.enqueue(data);
    }

    public int pop(){
        if( q1.isEmpty() && q2.isEmpty()){
            return Integer.MIN_VALUE;
        }
        while(q1.length() != 1){
            System.out.println(q1.length());
            int val = q1.dequeue();
           q2.enqueue(val);
        }

        int data = q1.dequeue();
        while( !q2.isEmpty()){
            q1.enqueue(q2.dequeue());
        }

        return data;

    }

    public boolean isEmpty(){
        return q1.isEmpty() && q2.isEmpty() ? true : false;
    }

    public int length(){
        return  q1.length();
    }

}
