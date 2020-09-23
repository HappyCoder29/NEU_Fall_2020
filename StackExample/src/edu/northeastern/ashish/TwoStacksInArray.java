package edu.northeastern.ashish;

public class TwoStacksInArray {
    private int size;
    private  int top1, top2;
    private int[] arr;

    private TwoStacksInArray(){}

    public TwoStacksInArray(int size){
        arr = new int[size];
        this.size = size;
        this.top1 = -1;
        this.top2 = size;
    }

    public void push1(int data){
        if(top1 < top2 -1){
            top1 ++;
            arr[top1] = data;
        }else{
            System.out.println("Stack Overflow");
        }
    }
    public void push2(int data){
        if(top1 < top2 -1){
            top2 --;
            arr[top2] = data;
        }else{
            System.out.println("Stack Overflow");
        }
    }

    public int pop1(int data){
         if(top1 >= 0){
             int x = arr[top1];
             top1 --;
             return x;
         }
         return Integer.MIN_VALUE;

    }
    public int pop2(int data){
        if(top2 < size){
            int x = arr[top2];
            top2 ++;
            return x;
        }
        return Integer.MIN_VALUE;
    }

    public void print1(){
        for(int i = top1; i >=0 ; i --){
            System.out.println(arr[i]);
        }
    }

    public void print2(){
        for(int i = top2; i < size ; i ++){
            System.out.println(arr[i]);
        }
    }
}
