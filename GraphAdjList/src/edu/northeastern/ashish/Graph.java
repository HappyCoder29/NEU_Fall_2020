package edu.northeastern.ashish;

import javax.naming.LinkLoopException;
import java.util.*;
import java.util.function.BiConsumer;

enum COLOR { WHITE, GRAY, BLACK}

public class Graph {


    public HashMap<String, Node> nodes ;
    public Node startNode;
    public Graph(){
        nodes = new HashMap<>();
        //initialize();
    }

    public void initialize(){
//       // Node zero = new Node("0");
//        Node one = new Node("1");
//        Node two = new Node("2");
//        Node three = new Node("3");
//        Node four = new Node("4");
//        Node five = new Node("5");
//        Node six = new Node("6");
//        Node seven = new Node("7");
//        Node eight = new Node("8");
//
//       // addNodeToGraph(zero);
//        addNodeToGraph(one);
//        addNodeToGraph(two);
//        addNodeToGraph(three);
//        addNodeToGraph(four);
//        addNodeToGraph(five);
//        addNodeToGraph(six);
//        addNodeToGraph(seven);
//        addNodeToGraph(eight);
//
//        addEdge(one, two);
//        addEdge(one, three);
//
//        addEdge(two, four);
//        addEdge(three, four);
//        addEdge(four, five);
//
//       // addEdge(six, seven);
//        addEdge(six, eight);
//






//
//        addEdge(zero, one);
//        addEdge(zero, two);
//
//        addEdge(one, three);
//
//        addEdge(four, one);
//
//        addEdge(five, two);
//        addEdge(five, six);
//
//        addEdge(six, zero);
//        addEdge(six,four);

//
//        addEdge(zero, two);
//        addEdge(zero, three);
//
//        addEdge(one, zero);
//
//        addEdge(two, one);
//
//        addEdge(three, four);


        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
      //  Node E = new Node("E");
     //   Node F = new Node("F");
     //   Node G = new Node("G");

        addNodeToGraph(A);
        addNodeToGraph(B);
        addNodeToGraph(C);
        addNodeToGraph(D);
        addEdge(A, D);
        addEdge(D, A);

        addEdge(A, B);
        addEdge(B, A);

        addEdge(A, C);
        addEdge(C, A);


        addEdge(B, C);
        addEdge(C, B);

        addEdge(D, C);
        addEdge(C, D);

        addEdge(D, B);
        addEdge(B, D);
        //  addNodeToGraph(E);
      //  addNodeToGraph(F);
      //  addNodeToGraph(G);
//
//        addEdge(A, B);
//
//        addEdge(B, C);
//
//        addEdge(C, E);
//
//        addEdge(D, G);
//        addEdge(D, B);
//
//        addEdge(E, D);
//        addEdge(E, F);
//
//        addEdge(F, G);
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

    public void resetColor(){
        nodes.forEach( (k,v)->{
            v.color = COLOR.WHITE;
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

    public boolean isReachable(String startNode, String endNode, boolean reset){
        if(! nodes.containsKey(startNode) || !nodes.containsKey(endNode)){
            return false;
        }

        if(reset){
            resetVisited();
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(nodes.get(startNode));
       // nodes.get(startNode).visited = true;

        while(queue.size() != 0 ){
            Node node = queue.remove();
            if(!node.visited){
                //System.out.println("Visiting node " + node.name);
                node.setVisited(true);
            }

            for (Edge edge : node.listEdges) {
                Node neighbour = nodes.get(edge.endNode);

                if(neighbour.name == endNode){
                  //  System.out.println("Reached Destination " + endNode);
                    return true;
                }
                if(neighbour.visited == false){
                  //  System.out.println("Visiting node " + neighbour.name);
                    neighbour.setVisited(true);
                    queue.add(neighbour);
                }
            }
        }
        return false;
    }

    public LinkedList<Node> findMotherNode(){

        LinkedList<Node> motherNodes = new LinkedList<>();
        for ( Map.Entry<String, Node> startEntry: nodes.entrySet() ) {

            Node startNode = startEntry.getValue();
            boolean reachable = true;
            for ( Map.Entry<String, Node> endEntry: nodes.entrySet() ){
                Node endNode = endEntry.getValue();

                if(startNode == endNode){
                    continue;
                }

                if( !isReachable(startNode.name, endNode.name, true) ){
                    reachable = false;
                    break;
                }
            }

            if(reachable == true){
                motherNodes.add(startNode);
            }
        }
        return motherNodes;
    }


    public int numberOfTreesInGraph(){

        int numTrees = 0;
        resetVisited();

        for(Map.Entry<String, Node> entry : nodes.entrySet()){
            Node startNode = entry.getValue();
            if(startNode.visited == true){
                continue;
            }
            startNode.visited = true;
            for ( Map.Entry<String, Node> endEntry: nodes.entrySet() ){
                Node endNode = endEntry.getValue();
                System.out.println("Start Node " + startNode.name );
                System.out.println("end Node " + endNode.name );
                if(endNode.visited == true){
                    continue;
                }
                if(endNode.name == "4"){
                    System.out.println();
                }
                if(isReachable(startNode.name, endNode.name, false  )){
                    System.out.println("Setting Visited to true " + endNode.name);
                    endNode.visited = true;
                }
            }

            numTrees ++;
        }

        return numTrees;

    }


    public boolean isCyclicColor(){

        resetColor();

        for(Map.Entry<String, Node> entry: nodes.entrySet()){
            Node node = entry.getValue();
            if(node.color == COLOR.WHITE){
                if (dfsColor(node) == true){
                    return true;
                }
            }
        }
        return  false;
    }

    private boolean dfsColor(Node node){
        node.color = COLOR.GRAY;
        for (Edge edge : node.listEdges) {
            Node endNode = nodes.get(edge.endNode);
            if(endNode.color == COLOR.GRAY){
                return true;
            }
            if(endNode.color == COLOR.WHITE && dfsColor(endNode) == true){
                return  true;
            }
        }
        node.color = COLOR.BLACK;
        return  false;

    }

    public boolean isHamiltonian(){
        RefClass<List<String>> result = new RefClass<List<String>>();
        result.value = new LinkedList<>();

        boolean bHamil = hamiltonianCycle(result);
        if(bHamil){
            for (String str : result.value) {
                System.out.print( str + "->" );
            }
            System.out.println();
        }
        return bHamil;

    }

    private boolean hamiltonianCycle(RefClass<List<String>> result){

        Map.Entry<String, Node> entry = nodes.entrySet().iterator().next();
        String startNode = entry.getKey();
        HashSet<String> visited = new HashSet<>();
        return hamiltonianUtil(startNode, startNode, result, visited);
    }

    private boolean hamiltonianUtil(String startNode, String currentNode, RefClass<List<String>> result, HashSet<String> visited ){
        visited.add(currentNode);
        result.value.add(currentNode);

        List<Edge> edges = nodes.get(currentNode).listEdges;

        for (Edge edge : edges) {
            if(startNode == edge.endNode && nodes.size() == result.value.size()){
                result.value.add(startNode);
                return true;
            }
            if(! visited.contains(edge.endNode)){
                boolean isHamil = hamiltonianUtil(startNode, edge.endNode, result, visited);
                if(isHamil){
                    return  true;
                }
            }

        }

        result.value.remove(result.value.size() -1);
        visited.remove(currentNode);
        return  false;


    }



}
