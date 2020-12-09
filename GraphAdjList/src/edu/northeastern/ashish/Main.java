package edu.northeastern.ashish;

import java.util.LinkedList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.isHamiltonian();
//
///       graph.initialize();
//
//        Graph clone = cloneGraph(graph);
//
//        System.out.println();

       // System.out.println(graph.isCyclicColor());


       // boolean test = graph.isReachable("1", "4", true);
        //graph.printAllPath("A", "G");
       // System.out.println(graph.containsCycleUnionFind());

       // System.out.println( graph.isReachable("D", "A") );

//        LinkedList<Node> motherNodes = graph.findMotherNode();
//
//        if(motherNodes.size() != 0){
//            for (Node node:motherNodes) {
//                System.out.println(node.name);
//            }
//        }else{
//            System.out.println("No Mother Node");
//        }


      //  System.out.println(graph.numberOfTreesInGraph());

//        int[][] graph = new int[][]{
//                {0,1,1,0},
//                {0,0,1,0},
//                {1,0,0,1},
//                {0,0,0,0}
//        };
//
//        boolean[][] reach = transtiveClosure(graph);
//        printSolution(reach);


//        Integer inf = 99999;
//        Integer[][] graph = new Integer[][]{
//                {0,     3,      inf,    5},
//                {2,     0,      inf,    4},
//                {inf,   1,      0,      inf},
//                {inf,   inf,    2,      0}
//        };
//
//        floydWarshall(graph);
//
//
//
//
//
//        System.out.println("");
    }


    public static Graph cloneGraph(Graph origGraph){

        Graph clone = new Graph();

        for (Map.Entry<String, Node> entry : origGraph.nodes.entrySet()) {
            Node origNode = entry.getValue();
            Node cloneNode = new Node(origNode.name);

            for (Edge origEdge : origNode.listEdges) {
                cloneNode.addEdge(origEdge.endNode);
            }
            clone.nodes.put(cloneNode.name, cloneNode);
        }

        return  clone;

    }

    private static boolean[][] transtiveClosure(int[][] graph){
        int length = graph.length;

        boolean[][] reach = new boolean[length][length];

        for(int i = 0 ; i < length; i ++){
            for(int j = 0 ; j < length ; j ++){
                if(i == j ){
                    reach[i][j] = true;
                    continue;
                }
                if(graph[i][j] == 0 ){
                    reach[i][j] = false;
                }else{
                    reach[i][j] = true;
                }
            }
        }

        for(int i = 0 ; i < length; i ++){
            for(int j = 0 ; j < length ; j ++){
                for(int k = 0; k < length; k ++){
                    reach[i][j] = reach[i][j] || ( reach[i][k] && reach[k][j] );
                }
            }
        }

        return  reach;

    }

    private static void printSolution(boolean[][] reach){
        int length = reach.length;
        for(int i = 0 ; i < length; i ++){
            for(int j = 0 ; j < length ; j ++){
                if( reach[i][j] == true) {
                    System.out.print( " T ");
                }else {
                    System.out.print( " F ");
                }
            }
            System.out.println();
        }
    }

    private static  void floydWarshall(Integer[][] graph){
        int length = graph.length;
        Integer[][] distance = new Integer[length][length];

        for(int i = 0 ; i < length; i ++){
            for(int j = 0 ; j < length ; j ++){
                distance[i][j] = graph[i][j];
            }
        }

        for(int k = 0 ; k < length ; k ++){
            for(int i = 0 ; i < length; i ++){
                for(int j = 0 ; j < length ; j ++){
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j] );
                }
            }
        }

        for(int i = 0 ; i < length; i ++){
            for(int j = 0 ; j < length ; j ++){
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }

    }




}
