package edu.northeastern.ashish;

public class LinkListRandom {

    public Node head;

    public LinkListRandom(){
    }
    public void addNodes(){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = null;

        one.random = three;
        two.random = one;
        three.random = three;
        four.random = two;

        head = one;


    }

    public LinkListRandom copyLinkList() {
        LinkListRandom copy = new LinkListRandom();

        Node temp = head;

        // This will create a node in between 2 nodes for all the nodes
        while(temp != null){
            Node add = new Node(temp.data);
            add.next = temp.next;
            temp.next = add;
            temp = temp.next.next;
        }

        // Random Node
        temp = head;
        while(temp != null){
            temp.next.random = temp.random.next;
            temp = temp.next.next;
        }

        // Break out the copy
        temp = head;
        Node copyNode = temp.next;
        copy.head = copyNode;

        while(temp.next != null){
            temp.next = temp.next.next;
            if(copyNode.next == null){
                break;
            }
            copyNode.next = copyNode.next.next;
            temp = temp.next;
            copyNode = copyNode.next;
        }
        return copy;

    }
}
