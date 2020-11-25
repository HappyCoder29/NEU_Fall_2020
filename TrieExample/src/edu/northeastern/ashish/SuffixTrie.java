package edu.northeastern.ashish;

public class SuffixTrie {
    Node root;

    public SuffixTrie(){
        root = new Node('\0');
    }

    public void addToSuffixTree(String str){
       // str += "$";

        for(int i = 0 ; i < str.length(); i ++){
            insert(str.substring(i));
        }
    }


    private void insert(String str){
        char[] arr = str.toLowerCase().toCharArray();
        Node curr = root;
        for(int i = 0 ; i < arr.length; i ++){
            Node child = findChild(curr, arr[i]);
            if(child == null){
                child = new Node(arr[i]);
                curr.children.add(child);
            }
            curr = child;
            if( i == arr.length -1){
                child.isTerminatingChar = true;
            }
        }

    }

    private Node findChild(Node curr, char ch){
        for (Node child : curr.children) {
            if(child.ch == ch){
                return  child;
            }
        }
        return  null;
    }

    public boolean isSubstring(String subStr){
        Node current = root;
        for(int i = 0 ; i < subStr.length(); i ++){
            Node child = findChild(current, subStr.charAt(i));
            if(child == null){
                return false;
            }
            current = child;
        }
        return  true;
    }

    public int findNumOfTimes(String str){
        Node current = root;
        for(int i = 0 ; i < str.length(); i ++){
            Node child = findChild(current, str.charAt(i));
            if(child == null){
                return 0;
            }
            current = child;
        }
        return findAllTerminal(current);

    }

    private int findAllTerminal(Node node){
        int result = node.isTerminatingChar ? 1 : 0;

        for (Node temp : node.children) {
            result += findAllTerminal(temp);
        }
        return result;
    }


}
