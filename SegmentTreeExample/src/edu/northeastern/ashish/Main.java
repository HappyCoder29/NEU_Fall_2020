package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1,5,3,7,8,3,2,9};
        SegmentTree tree = new SegmentTree(arr);
        int val = tree.getSumInRange(3,5);
        System.out.println(val);
        tree.update(3, 11);
        val = tree.getSumInRange(3,5);
        System.out.println(val);



    }
}
