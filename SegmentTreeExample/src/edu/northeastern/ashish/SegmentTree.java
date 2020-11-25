package edu.northeastern.ashish;

public class SegmentTree {
    private int[] arr;
    private int[] tree;

    private SegmentTree(){}

    public SegmentTree(int[] arr){
        this.arr = arr;
        this.tree = new int[4* arr.length -1];
        buildTree(0, 0, arr.length -1 );
    }

    private void buildTree(int nodeIndex, int start, int end){
        if(start == end){
            tree[nodeIndex] = arr[start];
        }else {
            int mid = (start + end)/2;
            buildTree(2*nodeIndex +1, start, mid);
            buildTree(2*nodeIndex +2, mid +1, end);
            tree[nodeIndex] = tree[2*nodeIndex +1] + tree[2*nodeIndex +2];
        }
    }

    public int getSumInRange(int left, int right){

        return  getSumInRange(0, 0, arr.length-1, left, right);

    }

    private int getSumInRange(int nodeIndex, int start, int end, int left, int right){
        if(right < start ||end < left){
            return 0;
        }
        if(left <= start && end <= right){
            return  tree[nodeIndex];
        }

        int mid = (start + end)/2;
        int leftVal = getSumInRange(2*nodeIndex + 1, start, mid, left, right);
        int rightVal = getSumInRange(2*nodeIndex + 2, mid +1, end, left, right);
        return leftVal + rightVal;
    }

    public void  update(int arrIndex, int value){
        update(0, 0, arr.length -1, arrIndex, value);
    }

    public void  update(int nodeIndex, int start, int end, int arrIndex, int value) {

        if(start == end){
            arr[arrIndex] = value;
            tree[nodeIndex] = value;
        }else {
            int mid = (start + end)/2;
            if(start <= arrIndex && arrIndex <= mid){
                update(2*nodeIndex +1, start, mid, arrIndex, value);
            }else{
                update(2*nodeIndex +2, mid +1, end, arrIndex, value);
            }
            tree[nodeIndex] = tree[2*nodeIndex +1] + tree[2*nodeIndex +1];
        }

    }
}



