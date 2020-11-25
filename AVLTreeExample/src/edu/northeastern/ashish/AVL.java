package edu.northeastern.ashish;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {

    public Node root;
    public AVL(){

    }

    // Level order iterative which prints every level at one line
    public void levelOrder(){
        if(root == null)
            return;

        // Take a queue and enqueue root and null
        // every level ending is signified by null
        // since there is just one node at root we enqueue root as well as null
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);


        while(queue.size() != 0){

            Node node = queue.remove();
            // If the node is not null print it and enqueue its left and right child
            // if they exist
            if(node != null){
                System.out.print(node.data + " ,");
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }else{
                // We have reached a new level
                // Check is queue is empty, if yes then we are done
                // otherwise print a new line and enqueue a new null for next level
                System.out.println();
                if(queue.size() == 0)
                    break;
                queue.add(null);
            }
        }
    }

    public int height(Node node){
        if(node == null){
            return  0;
        }
        return  node.height;
    }

    public Node rotateRight(Node A){
        Node temp1 = A.left;
        Node temp2 = temp1.right;

        temp1.right = A;
        A.left = temp2;
        A.height = Math.max(height(A.left), height(A.right)) + 1;
        temp1.height = Math.max(height(temp1.left), height(temp1.right)) +1;
        return temp1;
    }

    public Node rotateLeft(Node A){
        Node temp1 = A.right;
        Node temp2 = temp1.left;

        temp1.left = A;
        A.right = temp2;
        A.height = Math.max(height(A.left), height(A.right)) + 1;
        temp1.height = Math.max(height(temp1.left), height(temp1.right)) +1;
        return temp1;
    }

    private int getBalance(Node node){
        if(node == null){
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    public void insert(int data){
        root = insert(root, data);
    }
    private Node insert(Node node, int data){
        if(node == null){
            return (new Node(data));
        }
        if(data < node.data){
            node.left = insert(node.left, data);
        }else if( data > node.data){
            node.right = insert(node.right, data);
        }else{
            return  node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // if data went to left -> left
        if(balance > 1 && data < node.left.data){
            return rotateRight(node);
        }

        /// data went to right -> right
        if(balance < -1 && data > node.right.data){
            return rotateLeft(node);
        }

        // data went to left -> right
        if(balance > 1 && data > node.left.data){
            node.left = rotateLeft(node.left);
            return  rotateRight(node);
        }

        // data went to left -> right
        if(balance < -1 && data < node.right.data){
            node.right = rotateRight(node.right);
            return  rotateLeft(node);
        }

        return  node;
    }


}
