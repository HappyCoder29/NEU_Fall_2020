package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {

        LinkList<Integer> ll = new LinkList<Integer>();

        ll.addTail(1);
        ll.addTail(2);
        ll.addTail(3);
        ll.addTail(4);
        ll.addTail(5);
        ll.addTail(6);
        //ll.addTail(7);
        ll.printList();
        ll.pairwiseSwap();
        ll.printList();

//        System.out.println(ll.isPalindrome());
//        ll.printList();
//
//        Node second = ll.breakInHalf();
//
//        ll.printList();
//        printList(second);


        // ll.printList();
//        Node startCycle = ll.findStartOfCycle();
//
//        if(startCycle != null ){
//            System.out.println(startCycle.data);
//        }

//        Node<Integer> node1 = new Node<Integer>(1);
//        node1.next = new Node<Integer>(3);
//        node1.next.next = new Node<Integer>(5);
//        node1.next.next.next= new Node<Integer>(7);
//
//        Node<Integer> node2 = new Node<Integer>(2);
//        node2.next = new Node<Integer>(4);
//        node2.next.next = new Node<Integer>(6);
//        node2.next.next.next= new Node<Integer>(8);
//
//        Node merged = sortedMerge(node1, node2);
//
//        printNodeList(merged);

    }

    public static void printList(Node node){
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

    public static Node<Integer> sortedMerge (    Node<Integer> node1,
                                                 Node<Integer>node2)
    {
        Node result = null;
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

        return result;

    }

    public static void printNodeList(Node<Integer>node){
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
}
