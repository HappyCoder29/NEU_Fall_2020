package edu.northeastern.ashish;

import java.util.LinkedList;

public class BSTIterator {
    int index;
    private LinkedList<Integer> list;
    private BSTIterator(){}

    public BSTIterator(Node node){
        list = new LinkedList<>();
        getListFromBinTree(node, list);
        index = -1;

    }

    private void getListFromBinTree(Node node, LinkedList<Integer> list){
        if(node != null){
            getListFromBinTree(node.left, list);
            list.addLast(node.data);
            getListFromBinTree(node.right, list);
        }
    }

    public boolean hasNext(){
        return  index == list.size() -1 ? false : true;
    }

    public Integer next(){

        if(index == list.size()){
            return  Integer.MIN_VALUE;
        }

        index ++;
        return list.get(index);

    }

}
