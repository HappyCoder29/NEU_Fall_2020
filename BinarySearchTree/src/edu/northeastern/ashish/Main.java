package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {

        int[] arr = {8,3,1,6,4,7,10,14, 13};

        Node node = constructBSTFromPreorder(arr);
        System.out.println();

        BST bst = new BST();
        bst.root = node;

       // bst.levelOrder();

        BSTIterator iterator = new BSTIterator(bst.root);

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());

        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());





        // BST tree = new BST();

       // System.out.println(tree.areAllLeavesAtSameLevel());

//        tree.insert(1);
//        tree.insert(2);
//        tree.insert(3);
//        tree.insert(4);
//        tree.insert(5);
//        tree.insert(6);
//        tree.insert(7);
//        tree.insert(8);
//        tree.balanceTree();

        //tree.convertToGreaterSumTree();
        //tree.levelOrder();


        //   System.out.println(tree.isContiniousTree());


        // System.out.println(tree.search(22));
//        //System.out.println(tree.isBST());
//        tree.convertBinTreeToBST();
//        System.out.println(tree.isBST());
////
//        Node node = tree.LCAOfBST(3, 9);
//        System.out.println(node.data);


        //tree.inOrder();

//        int[] arr = {1,2,3,4,5,6,7,8,9,10};
//        Node node = sortedArrayToBST(arr, 0, arr.length -1);

//        BST bst = new BST();
//        LinkedList<Integer> list = bst.getSortedListFromBST();
//        Integer[] arr = list.toArray(new Integer[list.size()]);
//        int[] arr = bst.getSortedArrayFromBST();
//        for(int i = 0 ; i < arr.length; i ++){
//            System.out.print(arr[i] + ", ");
//        }
        System.out.println();

        // System.out.println(bst.size());
    }

    public static Node sortedArrayToBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);

        node.left = sortedArrayToBST(arr, start, mid - 1);
        node.right = sortedArrayToBST(arr, mid + 1, end);
        return node;

    }


    public static Node constructBSTFromPreorder(int[] arr) {
        return constructBSTFromPreorder(arr, 0, arr.length - 1, new IntPointer());
    }

    public static Node constructBSTFromPreorder(int[] arr, int low, int high, IntPointer index) {
        if(index.value >= arr.length || low > high){
            return null;
        }

        Node node = new Node(arr[index.value]);
        index.value ++;

        if(low == high){
            return  node;
        }

        int biggerIndex = getFirstBiggerNode(arr, low, high, arr[index.value-1]);

        if(biggerIndex == -1){
            biggerIndex = index.value + 1;
        }

        if(node.data == 14){
            System.out.println();
        }

        node.left = constructBSTFromPreorder(arr, index.value, biggerIndex -1, index );
        node.right = constructBSTFromPreorder(arr, biggerIndex, high, index);

        return node;
    }

    private static int getFirstBiggerNode(int[] arr, int low, int high, int val){
        for(int i = low; i <= high; i ++){
            if(arr[i] > val){
                return i;
            }
        }
        return  -1;
    }
}
