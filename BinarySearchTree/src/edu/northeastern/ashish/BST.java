package edu.northeastern.ashish;

import java.lang.reflect.Array;
import java.util.*;

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

//        root.left.right.left = new Node(4);
//        root.left.right.right = new Node(7);
//
//        root.right.right.left = new Node(13);



//        root = new Node(3);
//
//        root.left = new Node(2);
//        root.right = new Node(4);
//
//        root.left.left = new Node(1);
//        root.left.right = new Node(3);
//
//        root.right.right = new Node(5);

//
//        root.left = new Node(2);
//        root.right = new Node(29);
//
//        root.left.left = new Node(1);
//        root.left.right = new Node(7);
//
//        root.right.left  = new Node(15);
//        root.right.right  = new Node(40);
//        root.right.right.left  = new Node(35);

//
//
//
//        root = new Node(1);
//
//
//        root.left = new Node(2);
//        root.right = new Node(3);
//
//        root.left.left = new Node(4);
//        root.left.right  = new Node(5);
//        root.right.right = new Node(6);
//
//        root.left.left.left = new Node(7);
//        root.left.right.left  = new Node(8);
//        root.left.right.right  = new Node(9);
//        root.right.right.left = new Node(10);
    }

    public void preOrder(){
        preOrder(root);
        System.out.println();
    }
    public void preOrder(Node node){

        if(node != null){
            System.out.print(node.data + ", ");
            preOrder(node.left);
            preOrder(node.right);

        }
    }

    public void inOrder(){
        inOrder(root);
        System.out.println();
    }
    public void inOrder(Node node){

        if(node != null){
            inOrder(node.left);
            System.out.print(node.data + ", ");
            inOrder(node.right);
        }
    }


    public void reverseInOrder(){
        reverseInOrder(root);
        System.out.println();
    }
    public void reverseInOrder(Node node){

        if(node != null){
            reverseInOrder(node.right);
            System.out.print(node.data + ", ");
            reverseInOrder(node.left);
        }
    }

    public void postOrder(){
        postOrder(root);
        System.out.println();
    }
    public void postOrder(Node node){

        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + ", ");
        }
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

    public int size(){
        return  size(root);
    }
    private int size(Node node){
        if(node == null)
            return  0;

        return  1 + size(node.left) + size(node.right);
    }

    private Node getMin(Node node){
        if(node == null)
            return null;

        Node current = node;

        while(current.left != null){
            current = current.left;
        }
        return  current;
    }

    private Node getMax(Node node){
        if(node == null)
            return null;

        Node current = node;

        while(current.right != null){
            current = current.right;
        }
        return  current;
    }

    public void insert(int data){
        Node node = new Node(data);
        if(root == null){
            root = node;
            return;
        }

        Node current = root;
        Node parent = root;

        while(current != null){
            parent = current;
            if(current.data < data){
                current = current.right;
            }
            else{
                current = current.left;
            }
        }
        if(parent.data < data){
            parent.right = node;
        }else{
            parent.left = node;
        }
    }

    public void deleteNode(int data){
        root = deleteNode(root, data);
    }

    private Node deleteNode(Node node, int data){

        if(node == null){
            return node;
        }
        if(data < node.data){
            node.left = deleteNode(node.left, data);
        }else if( data > node.data){
            node.right = deleteNode(node.right, data);
        }
        else{
            if( node.left == null){
                return  node.right;
            }else if (node.right == null){
                return node.left;
            }

            // we have a nide with 2 children
            node.data = getMin(node.right).data;
            node.right = deleteNode(node.right, node.data);

        }
        return  node;
    }

    public int[] getSortedArrayFromBST(){
        if(root == null)
            return null;

        int[] arr = new int[size()];
        IntPointer ptr = new IntPointer();
        getSortedArrayFromBST(root, arr, ptr);

        return arr;


    }
    private void getSortedArrayFromBST(Node node, int[] arr, IntPointer ptr){
        if(node != null){
            getSortedArrayFromBST(node.left, arr, ptr);
            arr[ptr.value] = node.data;
            ptr.value ++;
            getSortedArrayFromBST(node.right, arr, ptr);
        }
    }


    public LinkedList<Integer> getListFromBinaryTree(){
        if(root == null)
            return null;

        LinkedList<Integer> list = new LinkedList<>();
        getListFromBinTree(root, list);

        return list;


    }
    private void getListFromBinTree(Node node, LinkedList<Integer> list){
        if(node != null){
            getListFromBinTree(node.left, list);
            list.addLast(node.data);
            getListFromBinTree(node.right, list);
        }
    }

    public void convertBinTreeToBST(){
        LinkedList<Integer> list = getListFromBinaryTree();
        Integer[] arr = list.toArray(new Integer[list.size()]);
        Arrays.sort(arr);
        Collections.sort(list);

        convertBinTreeToBST(root, list );


    }

    private void convertBinTreeToBST(Node node, LinkedList<Integer> list){
        if(node != null){
            convertBinTreeToBST(node.left, list);
            node.data = list.removeFirst();
            convertBinTreeToBST(node.right, list);
        }
    }

    public Node LCAOfBST(int x, int y){
        return LCAOfBST(root, x, y);
    }

    private Node LCAOfBST(Node node, int x, int y){
        if(node == null){
            return  null;
        }

        if(node.data > x && node.data > y){
            return  LCAOfBST(node.left, x, y);
        }

        if(node.data < x && node.data < y){
            return  LCAOfBST(node.right, x, y);
        }

        return node;
    }



    public boolean isBST(){
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node node, int min, int max){
        if(node == null)
            return  true;
        if(node.data < min || node.data > max ){
            return false;
        }
        return  isBST(node.left, min, node.data -1) &&
                isBST(node.right, node.data +1, max);
    }

    public Node LCA(int x, int y ){
        return  LCA(root, x, y);
    }

    private Node LCA(Node node, int x, int y ){

        if(node == null)
            return  null;

        if(node.data == x || node.data == y ){
            return  node;
        }

        Node left_LCA = LCA(node.left, x, y);
        Node right_LCA = LCA(node.right, x, y);

        if(left_LCA != null && right_LCA != null){
            return  node;
        }

        if(left_LCA != null)
            return  left_LCA;

        return  right_LCA;

    }


    public boolean search(int val){
        return  search(root, val);
    }

    private boolean search(Node node, int val){
        if(node == null){
            return false;
        }

        if(node.data == val){
            return true;
        } else if( node.data < val){
            return search(node.right, val);
        }
        return  search(node.left, val);
    }


    public void balanceTree(){
        LinkedList<Integer> list = getListFromBinaryTree();
        Integer[] arr =  list.toArray(new Integer[list.size()]);
        root = sortedArrayToBST(arr, 0, arr.length -1);

    }



    private  Node sortedArrayToBST(Integer[] arr, int start, int end){
        if(start > end){
            return  null;
        }

        int mid = (start + end)/2;
        Node node = new Node(arr[mid]);

        node.left = sortedArrayToBST(arr, start, mid -1);
        node.right = sortedArrayToBST(arr, mid + 1, end);
        return node;

    }

    public void trimTree(int low, int high){
        root = trimTree(root, low, high);
    }
    private Node trimTree(Node node, int low, int high){
        if(node == null){
            return null;
        }

        if(node.data > high){
            return trimTree(node.left, low, high);
        }

        if(node.data < low){
            return trimTree(node.right, low, high);
        }

        node.left = trimTree(node.left, low, high);
        node.right = trimTree(node.right, low, high);

        return node;


    }

    public boolean areIdentical(Node node1, Node node2){
        if(node1 == null && node2 == null){
            return true;
        }

        if(node1 == null){
            return false;
        }
        if(node2 == null){
            return false;
        }

        return node1.data ==  node2.data &&
                areIdentical(node1.left, node2.left) &&
                areIdentical(node1.right, node2.right);
    }


    public boolean areIsomorphic(Node node1, Node node2){
        if(node1 == null && node2 == null){
            return true;
        }

        if(node1 == null){
            return false;
        }
        if(node2 == null){
            return false;
        }

        return  areIsomorphic(node1.left, node2.left) &&
                areIsomorphic(node1.right, node2.right);
    }


    public void convertToGreaterSumTree(){
        convertToGreaterSumTree(root, new IntPointer());
    }

    private void convertToGreaterSumTree(Node node, IntPointer sum){

        if(node != null){
            convertToGreaterSumTree(node.right, sum);
            int temp = node.data;
            node.data = sum.value;
            sum.value += temp;
            convertToGreaterSumTree(node.left, sum);

        }

    }

    public boolean isContiniousTree(){
        return  isContiniousTree(root);
    }

    private boolean isContiniousTree(Node node){
        if(node == null){
            return  true;
        }

        if(node.left == null && node.right == null){
            return  true;
        }

        if(node.left == null){
            return Math.abs(node.data - node.right.data) <= 1 && isContiniousTree(node.right);
        }

        if(node.right == null){
            return Math.abs(node.data - node.left.data) <= 1 && isContiniousTree(node.left);
        }

        return  Math.abs(node.data - node.right.data) <= 1 &&
                Math.abs(node.data - node.left.data) <= 1 &&
                isContiniousTree(node.right) &&
                isContiniousTree(node.left);
    }

    public void printAllRootToLeaf(){

        ArrayList<Integer> list = new ArrayList<>();
        printAllRootToLeaf(root, list, 0);
    }

    private void printAllRootToLeaf(Node node , ArrayList<Integer> list,int ptr ){

        if(node != null){
            list.add(ptr, node.data);
            if(node.left == null && node.right == null){
                for(int i = 0 ; i <= ptr; i ++){
                    System.out.print(list.get(i) + "->");
                }
                System.out.println("NULL");
            }
            else{
                printAllRootToLeaf(node.left, list, ptr + 1);
                printAllRootToLeaf(node.right, list, ptr + 1);

            }
        }
    }


    public void sumAllRootToLeaf(){

        ArrayList<Integer> list = new ArrayList<>();
        sumAllRootToLeaf(root, list, 0);
    }

    private void sumAllRootToLeaf(Node node , ArrayList<Integer> list,int ptr ){

        if(node != null){
            list.add(ptr, node.data);
            if(node.left == null && node.right == null){
                int sum = 0 ;
                for(int i = 0 ; i <= ptr; i ++){
                    sum += list.get(i);
                }
                System.out.println(sum);
            }
            else{
                sumAllRootToLeaf(node.left, list, ptr + 1);
                sumAllRootToLeaf(node.right, list, ptr + 1);
            }
        }
    }

    public boolean hasPathSum(int sum){
        return  hasPathSum(root, sum);
    }

    private boolean hasPathSum(Node node, int sum){

        if(node == null){
            return  sum == 0 ;
        }
        int subsum = sum - node.data;
        return  hasPathSum(node.left, subsum) || hasPathSum(node.right, subsum);


    }


    public boolean areAllLeavesAtSameLevel(){
        return  areAllLeavesAtSameLevel(root, new IntPointer(), 1);
    }

    private  boolean areAllLeavesAtSameLevel(Node node, IntPointer maxLevel, int level){
        if(node == null){
            return  true;
        }

        // we have reached the leaf node
        if(node.left == null && node.right == null){
            // has the maxLevel been initialized
            if(maxLevel.value == 0){
                maxLevel.value = level;
            }else{
                return  maxLevel.value == level ? true : false;
            }
        }

        return  areAllLeavesAtSameLevel(node.left, maxLevel, level +1) &&
                areAllLeavesAtSameLevel(node.right, maxLevel, level +1);

    }





}
