package TreesAndGraphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Node{
    int val = 0;
    boolean visited = false;
    ArrayList<Node> adjacentNodes = new ArrayList<>();

    public Node(int val) {
        this.val = val;
    }

    public Node() {

    }

    public boolean addAdjacentNodes(Node n1, Node n2){
        return n1.adjacentNodes.add(n2);
    }
}
class Graph{
    ArrayList<Node> nodesInAGraph = new ArrayList<>();

    public ArrayList<Node> createAGraph() throws FileNotFoundException {
        File file = new File("src/TreesAndGraphs/graph.txt");
        Scanner sc = new Scanner(file);
        String[] temp = sc.nextLine().split(" ");
        int[] nodes = getArray(temp);
        //created all the nodes mentioned in first line of file.
        nodesInAGraph = getNodes(nodes);

        //update adjacency list of each node as per connections given from line 2 onwards.
        while (sc.hasNextLine()){
            temp = sc.nextLine().split(" ");
            nodes = getArray(temp);
            updateAdjacencyList(nodes, nodesInAGraph);
        }
        return nodesInAGraph;
    }

    private static void updateAdjacencyList(int[] nodes, ArrayList<Node> nodesInAGraph) {
        int val = nodes[0];
        Node nodeObject = new Node();
        Node n1 = null;
        for(Node node: nodesInAGraph){
            if(node.val == val){
                n1 = node;
            }
        }
        ArrayList<Node> addTheseNodes = new ArrayList<>();
        for(int i = 1; i<nodes.length; i++){
            for(Node node : nodesInAGraph){
                if(node.val == nodes[i]){
                    addTheseNodes.add(node);
                }
            }
        }
        for(Node n2 : addTheseNodes){
            nodeObject.addAdjacentNodes(n1, n2);
        }
    }

    private static ArrayList<Node> getNodes(int[] nodes) {
        ArrayList<Node> nodesOfAGraph = new ArrayList<>();
        for(int i : nodes){
            nodesOfAGraph.add(new Node(i));
        }
        return nodesOfAGraph;
    }

    private static int[] getArray(String[] temp) {
        int[] nodes = new int[temp.length];
        for(int i = 0 ; i<temp.length; i++){
            nodes[i] = Integer.parseInt(temp[i]);
        }
        return nodes;
    }
}

public class Question1 {
    public static void main(String[] args) throws IOException {
        Graph g = new Graph();
        ArrayList<Node> graph = g.createAGraph();

        for(Node node : graph){
            System.out.println(node.val+"\t"+node.adjacentNodes);
        }
    }
}
