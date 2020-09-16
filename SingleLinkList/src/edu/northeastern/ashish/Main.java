package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {

        LinkList<Integer> list = new LinkList<>();

        list.addTail(5);
        list.addTail(10);
        list.addTail(3);
        list.addTail(8);
        list.addTail(9);
        list.addTail(3);
        list.addTail(2);
        list.deleteNodesWhichHaveGreaterElementsOnRight();
        list.printList();



//        Node<Integer> node1 = new Node<Integer>(5);
//        node1.next = new Node<Integer>(1);
//        node1.next.next = new Node<Integer>(3);
//        node1.next.next.next = new Node<Integer>(7);
//
//        Node<Integer> node2 = new Node<Integer>(20);
//        node2.next = new Node<Integer>(11);
//        node2.next.next = new Node<Integer>(8);
//        node2.next.next.next = new Node<Integer>(0);
//
//        Node<Integer> node3 = new Node<Integer>(90);
//        node3.next = new Node<Integer>(6);
//        node3.next.next = new Node<Integer>(-12);
//        node3.next.next.next = new Node<Integer>(55);
//
//        Node[] arr = {node1, node2, node3};
//
//        Node result = list.sortedMergeKLists(arr);
//
//        printList(result);
//
//



//
//        list.head = list.mergeSort(node);
//        list.printList();



//
//        list.addTail(1);
//        list.addTail(2);
//        list.addTail(3);
//        list.addTail(4);
//        list.addTail(5);
//        list.addTail(6);
//
//        list.zipMerge();
//
//        list.printList();


//        Node<Integer> node1 = new Node<>(1);
//        node1.next = new Node<>(3);
//        node1.next.next = new Node<>(5);
//        node1.next.next.next = new Node<>(7);
//
//        Node<Integer> node2 = new Node<>(2);
//        node2.next = new Node<>(4);
//        node2.next.next = new Node<>(6);
//        node2.next.next.next = new Node<>(8);
//
//        Node<Integer> node =  list.sortedMerge(node1, node2);
//
//        printList(node);




//        list.addTail(1);
//        list.addTail(2);
//
//        list.addTail(3);
//        list.addTail(4);
//
//        list.moveLastToHead();
//
//        list.printList();


//       Node<Integer> node1 = new Node<>(9);
//       node1.next = new Node<>(9);
//    //   node1.next.next = new Node(3);
//
////
//        Node<Integer> node2 = new Node<>(9);
//        node2.next = new Node<>(9);
//
//        Node<Integer > add = addTwoNodes(node1, node2);
//        printNodeList(add);
//
//        System.out.println("");
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

    public static Node reverse(Node node){
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

    public static Node<Integer> addTwoNodes(Node<Integer> node1, Node<Integer> node2){
        Node<Integer> result = null;

        if(node1 == null && node2 == null){
            return null;
        }

        // If node 2 is empty
        if(node2 == null){
            Node<Integer> temp = node1.next;
            result = new Node<Integer>(node1.data);
            Node<Integer> temp2 = result;
            while(temp != null){
                temp2.next = new Node<>(temp.data);
                temp = temp.next;
                temp2 = temp2.next;
            }
            return result;
        }

        // if node1 is empty
        if(node1 == null){
            Node<Integer> temp = node2.next;
            result = new Node<Integer>(node2.data);
            Node<Integer> temp2 = result;
            while(temp != null){
                temp2.next = new Node<>(temp.data);
                temp = temp.next;
                temp2 = temp2.next;
            }
            return  result;
        }

        // we have both the nodes

        node1 = reverse(node1);
        node2 = reverse(node2);

        Node<Integer> temp1 = node1;
        Node<Integer> temp2 = node2;
        int carry = 0 ;

        Node<Integer> tempResult = null;

        while(temp1 != null && temp2 != null){
            int sum = temp1.data + temp2.data + carry;
            if(sum > 9 ){
                sum = sum %10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            if(result == null){
                result = new Node<Integer>(sum);
                tempResult = result;
            }
            else{
                tempResult.next = new Node<>(sum);
                tempResult = tempResult.next;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        // if there are remaining elements in node1

        while(temp1 != null){
            int sum = temp1.data + carry;
            if(sum > 9 ){
                sum = sum %10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            if(result == null){
                result = new Node<Integer>(sum);
                tempResult = result;
            }
            else{
                tempResult.next = new Node<>(sum);
                tempResult = tempResult.next;
            }
            temp1 = temp1.next;
        }

        while(temp2 != null){
            int sum = temp2.data + carry;
            if(sum > 9 ){
                sum = sum %10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            if(result == null){
                result = new Node<Integer>(sum);
                tempResult = result;
            }
            else{
                tempResult.next = new Node<>(sum);
                tempResult = tempResult.next;
            }
            temp2 = temp2.next;
        }
        if(carry == 1){
            tempResult.next = new Node<>(1);
            tempResult = tempResult.next;

        }

        result = reverse(result);


        return result;

    }

    public static void sortedInsert(LinkList<Integer> list, int data){
        Node<Integer> node = new Node<>(data);
        if(list.head == null){
            list.head = node;
            return;
        }

        if(data < list.head.data){
            node.next = list.head;
            list.head = node;
            return;
        }

        Node<Integer> temp = list.head;
        while(temp.next != null &&  (int)temp.next.data < data){
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;
    }





}
