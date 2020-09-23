package edu.northeastern.ashish;

public class StackGetMax {
    Stack<Integer> main;
    Stack<Integer> max;

    public StackGetMax(){
        main = new Stack<>();
        max = new Stack<>();
    }

    public void push(Integer data){
        if( main.isEmpty() ){
            main.push(data);
            max.push(data);
            return;
        }

        main.push(data);
        max.push( max.peek() < data ? data : max.peek() );

    }

    public int pop(){
        int data = main.pop();
        max.pop();
        return data;
    }

    public int getMax(){
        return  max.isEmpty()? Integer.MIN_VALUE : max.peek();
    }

    public boolean isEmpty(){
        return  max.isEmpty()? true : false;
    }

}
