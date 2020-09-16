package edu.northeastern.ashish;

import java.awt.*;

public class LinkList <T> {

    public Node<T> head;

    public LinkList(){
        head = null;
        //addCycle();

    }

    //Hack for adding a cycle in the Link List
    private void addCycle(){
        head = null;
        head = (Node<T>) new Node<Integer>(1);
        head.next = (Node<T>) new Node<Integer>(2);
        head.next.next = (Node<T>) new Node<Integer>(3);
        head.next.next.next = (Node<T>) new Node<Integer>(4);
        head.next.next.next.next = (Node<T>) new Node<Integer>(5);
        head.next.next.next.next.next = (Node<T>) new Node<Integer>(6);

        head.next.next.next.next.next.next = head.next.next;
    }

    //Adding a 
    public void addHead(T data) {
        Node add = new Node(data);
        add.next = head;
        head = add;
    }

    // assuming there is no cycle
    public void addTail(T data){
        Node add = new Node(data);

        if(head == null){
            head = add;
            return;
        }

        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = add;
    }

    public void printList(){
        if(head == null){
            return;
        }
        if( isCyclic()){
            System.out.println("There is a Cycle");
            return;
        }
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        System.out.println("Null");

    }

    public void printList(Node node){
        if(node == null){
            return;
        }

        Node temp = node;

        while(temp != null){
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        System.out.println("Null");

    }



    public int count(){
        if(head == null){
            return 0;
        }
        if( isCyclic()){
            System.out.println("There is a Cycle");
            return Integer.MAX_VALUE;
        }
        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }

        return count;
    }

    public int count(Node node){
        if(node == null){
            return 0;
        }

        Node temp = node;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }

        return count;
    }

    public void reverse(){
        if(head == null || head.next == null){
            return;
        }
        if( isCyclic()){
            System.out.println("There is a Cycle");
            return;
        }

        Node back = null;
        Node mid = head;
        Node front = head.next;

        while(front != null){
            mid.next = back;
            back = mid;
            mid = front ;
            front = front.next;
        }

        mid.next = back;
        head = mid;
    }


    public Node reverse(Node node){
        if(node == null || node.next == null){
            return node;
        }


        Node back = null;
        Node mid = node;
        Node front = node.next;

        while(front != null){
            mid.next = back;
            back = mid;
            mid = front ;
            front = front.next;
        }

        mid.next = back;
        node = mid;
        return node;
    }

    public boolean isCyclic(){
        if(head == null || head.next == null){
            return false;
        }

        Node fast = head;
        Node slow = head;

        while(fast != null){
            fast = fast.next;
            if(fast == null){
                return false;
            }
            fast = fast.next;
            slow = slow.next;

            // Nodes met which means there is a cycle
            if( fast == slow ){
                return  true;
            }
        }

        return false;

    }


    public Node findStartOfCycle(){

        if( head == null || head.next == null){
            return null;
        }
        Node fast = head;
        Node slow = head;

        while(fast != null){
            fast = fast.next;
            if(fast == null){
                return null;
            }
            fast = fast.next;
            slow = slow.next;

            // Nodes met which means there is a cycle
            if( fast == slow ){
                break;
            }
        }

        // There is definitely a cycle
        // Move fast or slow to head

        fast = head;

        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

    }

    public  Node nthFromTheEnd(int n){
        if(head == null || n <= 0){
            return null;
        }

        if( isCyclic()){
            System.out.println("There is a Cycle");
            return null;
        }

        Node front = head;
        Node back = head;

        for(int i= 0 ; i < n ; i ++){
            if(front == null){
                return null;
            }
            front = front.next;
        }

        while(front != null){
            front = front.next;
            back = back.next;
        }
        return  back;
    }

    public Node breakInHalf(){

        if(head == null || head.next == null){
            return null;
        }

        Node front = head;
        Node back = head;

        // Assuming there is no cycle
        while (front.next != null ) {
            front = front.next;
            if (front.next != null) {
                front = front.next;
                back = back.next;
            }
        }
        Node temp = back.next;
        back.next = null;
        return  temp;
    }


    public Node breakInHalf(Node node){

        if(node == null || node.next == null){
            return null;
        }

        Node front = node;
        Node back = node;

        // Assuming there is no cycle
        while (front.next != null ) {
            front = front.next;
            if (front.next != null) {
                front = front.next;
                back = back.next;
            }
        }
        Node temp = back.next;
        back.next = null;
        return  temp;
    }

    public boolean isPalindrome(){

        if(head == null || head.next == null){
            return true;
        }

        Node secondHalf = breakInHalf();

        secondHalf = reverse(secondHalf);

        Node temp1 = head;
        Node temp2 = secondHalf;

        boolean palindrome = true;

        while(temp1 != null && temp2 != null){
            if(temp1.data != temp2.data){
                palindrome = false;
                break;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        secondHalf = reverse(secondHalf);
        temp1 = head;
        while(temp1.next != null){
            temp1 = temp1.next;
        }
        temp1.next = secondHalf;

        return  palindrome;

    }

    public void pairwiseSwap(){
        if( head == null || head.next == null){
            return;
        }

        Node<T> temp = head;

        while(temp != null && temp.next != null){
            T swap = temp.data;
            temp.data = (T) temp.next.data;
            temp.next.data = swap;
            temp = temp.next.next;
        }
    }

    public Node intersectionOfNodes(Node node1, Node node2){

        if(node1 == null || node2 == null){
            return null;
        }
        // Assuming no cycle
        int count1 = count(node1);
        int count2 = count(node2);

        if(count1 > count2){
            for(int i = 0 ;i < count1 - count2; i ++){
                node1 = node1.next;
            }
        }
        if(count2 > count1){
            for(int i = 0 ;i < count2 - count1; i ++){
                node2 = node2.next;
            }
        }
        while(node1 != null || node2 != null){
            if(node1 == node2){
                return node1;
            }
            node1 = node1.next;
            node2 = node2.next;

        }

        return null;
    }




    // Class 2


    public  Node deleteNThFromTheEnd(int n){
        if(head == null || n <= 0){
            return null;
        }

        if( isCyclic()){
            System.out.println("There is a Cycle");
            return null;
        }

        Node front = head;
        Node back = head;

        for(int i= 0 ; i < n +1 ; i ++){
            if(front == null){
                return null;
            }
            front = front.next;
        }

        while(front != null){
            front = front.next;
            back = back.next;
        }

        Node temp = back.next;
        back.next = back.next.next;
        temp = null;


        return  back;
    }

    public void printInReverse(){
        printInReverse(head);
        System.out.println("");
    }

    private void printInReverse(Node node){

        if(node == null){
            return;
        }
        printInReverse(node.next);
        System.out.print(node.data + ", ");

    }

    public void moveLastToHead(){
        if(head == null || head.next == null){
            return;
        }

        // if there are only 2 nodes
        if(head.next.next == null){
            Node temp = head.next;
            head.next = null;
            temp.next = head;
            head = temp;
            return;
        }

        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        Node temp1 = temp.next;
        temp.next = null;

        temp1.next = head;
        head = temp1;
    }

    public Node<Integer> mergeSort(Node<Integer> node){
        if(node == null || node.next == null){
            return node;
        }

        Node<Integer> nextOfMid = breakInHalf(node);


        Node<Integer> left = mergeSort(node);
        Node<Integer> right = mergeSort(nextOfMid);

        Node<Integer> sortedList = sortedMerge(left, right);

        return sortedList;
    }

    public Node<Integer> sortedMerge(Node<Integer> node1, Node<Integer> node2){
        Node<Integer> result = null;

        if(node1 == null){
            return node2;
        }

        if(node2 == null){
            return  node1;
        }

        if(node1.data < node2.data){
            result = node1;
            result.next = sortedMerge(node1.next, node2);
        }else{
            result = node2;
            result.next = sortedMerge(node1, node2.next);
        }

        return  result;

    }

    public void zipMerge(){
        if(head == null ||head.next == null || head.next.next == null){
            return ;
        }

        Node<Integer> secondHalf = breakInHalf(head);//O(n/2)
        secondHalf = reverse(secondHalf);//O(n/2)

        head =   zipMerge( head, secondHalf, true);


    }

    private Node zipMerge(Node node1, Node node2, boolean flip){
        Node<Integer> result = null;

        if(node1 == null){
            return node2;
        }

        if(node2 == null){
            return  node1;
        }

        if(flip == true){
            result = node1;
            result.next = zipMerge(node1.next, node2, false);
        }else{
            result = node2;
            result.next = zipMerge(node1, node2.next, true);
        }


        return  result;
    }


    public Node<Integer> sortedMergeKLists(Node<Integer>[] arr){

        for(int i = 0 ; i < arr.length; i ++){
            arr[i] = mergeSort(arr[i]);
        }

        int last = arr.length -1;

        while(last != 0){
            int i = 0 ;
            int j = last;
            arr[i] = sortedMerge(arr[i], arr[j]);
            // consider next pair
            i ++;
            j --;
            if( i >= j){
                last = j;
            }
        }

        return arr[0];
    }


    public void deleteNodesLessThanSelf(){
        Node current = head;
        Node maxNode = head;

        Node temp;

        while(current != null && current.next != null){
            if((int)current.next.data < (int)current.data){
                temp = current.next;
                current.next = temp.next;
                temp = null;
            }else{
                current = current.next;
                maxNode = current;
            }
        }
    }

    public void deleteNodesWhichHaveGreaterElementsOnRight(){

        if(head == null || head.next == null){
            return;
        }

        reverse();
        deleteNodesLessThanSelf();
        reverse();



    }


}




