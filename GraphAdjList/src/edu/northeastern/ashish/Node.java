package edu.northeastern.ashish;

import java.util.LinkedList;
import java.util.List;

public class Node {
    public String name;
    public boolean visited;
    public List<Edge> listEdges = null;

    public Node parent;

    public int rank;

    public COLOR color;

    private Node(){}

    public Node(String name){
        this.name = name;
        this.visited = false;
        this.listEdges = new LinkedList<>();
        this.parent = this;
        this.rank = 0;
        this.color = COLOR.WHITE;
    }


    public void addEdge(String endNode, int weight){
        // check if there is already an ende to the end node
        if( edgeAlreadyExists(endNode)) { return; }
        Edge edge = new Edge(this.name, endNode, weight);
        listEdges.add(edge);
    }

    private boolean edgeAlreadyExists(String endNode){
        // check if there is already an ende to the end node
        for (Edge edge : listEdges) {
            if(edge.endNode.toLowerCase() == endNode.toLowerCase() ){
                return true;
            }
        }
        return  false;
    }

    public void addEdge(String endNode){
        if(edgeAlreadyExists(endNode)) { return; }
        Edge edge = new Edge(this.name, endNode);
        listEdges.add(edge);
    }

    public List<String> getNeighbours(){
        List<String> neighbours = new LinkedList<>();
        for (Edge edge : listEdges) {
            neighbours.add(edge.endNode);
        }
        return  neighbours;
    }

    public void setVisited(boolean visited){
        this.visited = visited;
    }


}
