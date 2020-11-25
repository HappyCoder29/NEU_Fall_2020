package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        AVL avl = new AVL();

        avl.insert(8);

        avl.insert(5);
        avl.insert(12);
        avl.insert(11);
        avl.insert(13);

        avl.levelOrder();

        System.out.println("***********");

        avl.insert(10);

        avl.levelOrder();











    }
}
