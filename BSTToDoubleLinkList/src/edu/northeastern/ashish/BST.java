package edu.northeastern.ashish;

public class BST {
    public Node root;


    public BST(){
        //createTree();
    }

    private void createTree(){

        root = new Node(8);

        root.left = new Node(3);
        root.right = new Node(10);

        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
    }

}
