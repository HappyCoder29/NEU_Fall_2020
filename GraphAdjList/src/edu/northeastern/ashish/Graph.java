package edu.northeastern.ashish;

import java.util.*;
import java.util.function.BiConsumer;

public class Graph {

    public HashMap<String, Node> nodes ;
    public Node startNode;
    public Graph(){
        nodes = new HashMap<>();
        initialize();
    }

    private void initialize(){
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");

        addNodeToGraph(A);
        addNodeToGraph(B);
        addNodeToGraph(C);
        addNodeToGraph(D);
        addNodeToGraph(E);
        addNodeToGraph(F);
        addNodeToGraph(G);

        addEdge(A, B);

        addEdge(B, C);



        addEdge(C, E);

        addEdge(D, G);
        addEdge(D, B);

        addEdge(E, D);
        addEdge(E, F);



        addEdge(F, G);
    }

    private void addNodeToGraph(Node node){
        if(nodes.containsKey(node.name.toLowerCase())){
            return;
        }
        nodes.put(node.name, node);
    }

    public void addEdge(Node startNode, Node endNode){
        if(     !nodes.containsKey(startNode.name) ||
                !nodes.containsKey(endNode.name)   )   {
            return;
        }

        startNode.addEdge(endNode.name);
    }

    public void resetVisited(){
        nodes.forEach( (k,v)->{
            v.setVisited(false);
        });
    }


    public void breadthFirstSearch(String startNode){

        if(! nodes.containsKey(startNode)){
            return;
        }

        resetVisited();

        Queue<Node> queue = new LinkedList<>();
        queue.add(nodes.get(startNode));
        queue.add(null);

        while(queue.size() != 0){
            Node node = queue.remove();
            if(node != null){
                if(node.visited == false){
                    System.out.printf(node.name + " ");
                }
                node.visited = true;
                for (Edge edge : node.listEdges) {
                    Node neighbour = nodes.get(edge.endNode);
                   if(!neighbour.visited){
                       queue.add(neighbour);
                   }
                }
            }else {
                // I have reached a new level
                System.out.println("");
                if(queue.size() == 0 ){
                    break;
                }
                queue.add(null);
            }// end of else
        }// end of while
    }// end of function



    public void depthFirstSearch(String startNode){
        if(! nodes.containsKey(startNode)){
            return;
        }
        resetVisited();

        Stack<Node> stack = new Stack<>();
        stack.push(nodes.get(startNode));

        while(stack.size() != 0){
            Node node = stack.pop();
            if(node.visited){
                continue;
            }
            System.out.println(node.name + " ");
            node.visited = true;
            for (Edge edge : node.listEdges) {
                Node neighbour = nodes.get(edge.endNode);
                if(neighbour.visited == false){
                    stack.push(neighbour);
                }
            }// end of for
        }// end of while stack is not empty
    }// end of function

    public void printAllPath(String source, String dest){
        if( !nodes.containsKey(source) || !nodes.containsKey(dest ) ){
            return;
        }

        LinkedList<String> visited = new LinkedList<>();
        printAllPath(visited, source, dest);


    }

    private void printAllPath(LinkedList<String> visited, String current, String dest){
        if(visited.contains(current)){
            return;
        }
        if(dest == current){
            // print the visited list
            for (String str : visited) {
                System.out.printf(str + "-> ");
            }
            System.out.println(dest);
        }
        visited.add(current);

        Node node = nodes.get(current);
        for (Edge edge: node.listEdges) {
            if( !visited.contains(edge.endNode)){
                printAllPath(visited, edge.endNode, dest);
            }
        }
        visited.remove(current);
    }


    public boolean containsCycle(){

        for (Map.Entry<String, Node> entry: nodes.entrySet()) {
            Stack<Node> stack = new Stack<>();
            Node startingNode = entry.getValue();
            if(containsCycle( startingNode, stack )){
                return true;
            }
        }
        return  false;

    }

    private boolean containsCycle(Node node, Stack<Node> stack){
        if(stack.contains(node)){
            return  true;
        }

        stack.push(node);
        for (Edge edge : node.listEdges) {
            //System.out.printf("Node name = " + node.name);
            //System.out.printf("Edge name = " + edge.endNode);
            Node neighbour = nodes.get(edge.endNode);
            if(containsCycle(neighbour, stack)){
                return true;
            }
        }
        stack.pop();
        return false;
    }


    public boolean containsCycleUnionFind(){

        // Create disjoint sets for each node
        for (Map.Entry<String, Node> entry : nodes.entrySet() ) {
            Node node = entry.getValue();
            node.parent = node;
            node.rank = 0;
        }

        // Get all the edges and add them in a list
        LinkedList<Edge> allEdges = new LinkedList<>();
        for (Map.Entry<String, Node> entry : nodes.entrySet() ) {
            Node node = entry.getValue();
            for (Edge edge: node.listEdges) {
                allEdges.add(edge);
            }
        }

        for (Edge edge : allEdges) {
            Node node1 = nodes.get(edge.startNode);
            Node node2 = nodes.get(edge.endNode);

            if(node1.parent == node2.parent){
                return true;
            }
            union(edge.startNode, edge.endNode);

        }
        return false;
    }


    private boolean union(String name1, String name2){

        Node node1 = nodes.get(name1);
        Node node2 = nodes.get(name2);

        Node parent1 = findParent(node1);
        Node parent2 = findParent(node2);

        if(parent1.name == parent2.name){
            return false;
        }
        if(parent1.rank >= parent2.rank){
            if(parent1.rank == parent2.rank) {
                parent1.rank++;
            }
            parent2.parent = parent1;
        }else{
            parent1.parent = parent2;
        }
        return true;
    }
    private Node findParent(Node node){
        Node parent = node.parent;

        if(parent == node){
            return  node;
        }

        node.parent = findParent(node.parent);
        return  node.parent;
    }

}
