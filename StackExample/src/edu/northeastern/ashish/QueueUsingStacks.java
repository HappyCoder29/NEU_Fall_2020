package edu.northeastern.ashish;

public class QueueUsingStacks {
    Stack<Integer> s1, s2;

    public QueueUsingStacks(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void enqueue(int data){

        s1.push(data);

    }

    public int dequeue(){
        if(s1.isEmpty() && s2.isEmpty()){
            return Integer.MIN_VALUE;
        }
        if(s2.isEmpty()){
            while(! s1.isEmpty()){
                s2.push( s1.pop() );
            }

        }

        return s2.pop();

    }

    public boolean isEmpty(){
        return  s1.isEmpty() && s2.isEmpty() ? true : false;
    }

    public int length(){
        return  s1.length() + s2.length();

    }
    public int peek(){
        if ( isEmpty() ) {
            return Integer.MIN_VALUE;
        }
        return s2.peek();
    }

}
