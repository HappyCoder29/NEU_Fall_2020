package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {

        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());


        // System.out.println(makeGood("s"));

//        StackGetMax stackMax = new StackGetMax();
//        stackMax.push(4);
//        System.out.println(stackMax.getMax());
//        stackMax.push(3);
//        System.out.println(stackMax.getMax());
//        stackMax.push(7);
//        System.out.println(stackMax.getMax());
//        stackMax.push(5);
//        System.out.println(stackMax.getMax());
//        stackMax.push(8);
//        System.out.println(stackMax.getMax());
//        stackMax.push(2);
//        System.out.println(stackMax.getMax());






//        TwoStacksInArray twoStack = new TwoStacksInArray(10);
//
//        twoStack.push1(1);
//        twoStack.push1(2);
//        twoStack.push1(3);
//        twoStack.push1(4);
//        twoStack.push1(5);
//
//
//        twoStack.push2(6);
//        twoStack.push2(7);
//        twoStack.push2(8);
//        twoStack.push2(9);
//
//        twoStack.push2(10);
//
//        twoStack.print1();
//        twoStack.print2();


//        Queue<Integer> queue = new Queue<>();
//        queue.enqueue(1);
//        queue.enqueue(2);
//        queue.enqueue(3);
//        queue.enqueue(4);
//        queue.enqueue(5);
//
//        while(! queue.isEmpty()){
//            System.out.println(queue.dequeue());
//        }


//        Stack<Integer> stack = new Stack<>();
//        stack.push(5);
//        stack.push(-3);
//
//        stack.push(7);
//
//        stack.push(4);
//
//        while(! stack.isEmpty()){
//            System.out.println(stack.pop().toString());
//        }

    }

    public static String removeAdjacentDuplicates(String str){
        Stack<Character> stack = new Stack<>();
        for (Character ch : str.toLowerCase().toCharArray()) {
            if(stack.isEmpty()){
                stack.push(ch);
                continue;
            }
            if(stack.peek() == ch ){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(! stack.isEmpty()){
            sb.insert(0, stack.pop().toString());
        }
        return sb.toString();
    }


    public static String makeGood(String str){
        Stack<Character> stack = new Stack<>();
        for (Character ch : str.toCharArray()) {
            if(stack.isEmpty()){
                stack.push(ch);
                continue;
            }
            if(     stack.peek() != ch &&
                    Character.toLowerCase(stack.peek() )  == Character.toLowerCase(ch) ){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(! stack.isEmpty()){
            sb.insert(0, stack.pop().toString());
        }
        return sb.toString();
    }
}
