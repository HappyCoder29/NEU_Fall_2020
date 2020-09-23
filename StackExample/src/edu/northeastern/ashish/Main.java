package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(-3);

        stack.push(7);

        stack.push(4);

        while(! stack.isEmpty()){
            System.out.println(stack.pop().toString());
        }

    }
}
