package DSA.GRAPH;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class L_Node{
    String name;
    int index;
    boolean visited= false;
    L_Node(String data , int index){
        this.name = data;
        this.index = index;
    }
    ArrayList<L_Node> neighbours = new ArrayList<>();
}

class L_Graph{
    ArrayList<L_Node> nodeList  = new ArrayList<>();
    L_Graph(ArrayList<L_Node> nodes){
        this.nodeList = nodes;
    }
    void addUndirectedEdge(int i, int j) {
        L_Node first = nodeList.get(i);
        L_Node second = nodeList.get(j);
        first.neighbours.add(second);
    }

    void printGraph(){
        for (int i = 0; i < nodeList.size(); i++) {
            System.out.print(nodeList.get(i).name + ": ");
            for (int j = 0; j < nodeList.get(i).neighbours.size(); j++) {
                System.out.print(" -> " + nodeList.get(i).neighbours.get(j).name);
            }
            System.out.println();
        }
    }

    void bfsVisit(L_Node node){
        Queue<L_Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            L_Node currentNode = queue.remove();
            currentNode.visited = true;
            System.out.print(currentNode.name + " ");
            for (int i = 0; i < currentNode.neighbours.size(); i++) {
                L_Node neighbour = currentNode.neighbours.get(i);
                if (!neighbour.visited){
                    queue.add(neighbour);
                    neighbour.visited = true;
                }
            }
        }
    }

    void bfs(){
        for (int i = 0; i < nodeList.size(); i++) {
            if (!nodeList.get(i).visited){
                bfsVisit(nodeList.get(i));
            }
        }
    }

    void dfsVisit(L_Node node){
        Stack<L_Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            L_Node currentNode = stack.pop();
            currentNode.visited = true;
            System.out.print(currentNode.name + " ");
            for (int i = 0; i < currentNode.neighbours.size(); i++) {
                L_Node neighbour = currentNode.neighbours.get(i);
                if (!neighbour.visited){
                    stack.push(neighbour);
                    neighbour.visited = true;
                }
            }
        }
    }

    void dfs(){
        for (int i = 0; i < nodeList.size(); i++) {
            if (!nodeList.get(i).visited){
                dfsVisit(nodeList.get(i));
            }
        }
    }

    void markUnvisited(){
        for (int i = 0; i < nodeList.size(); i++) {
            nodeList.get(i).visited = false;
        }
    }

    void topologicalsort(L_Node node , Stack<L_Node> stack){
        for(L_Node neighbour : node.neighbours){
            if(!neighbour.visited){
                topologicalsort(neighbour , stack);
            }
        }
        node.visited = true;
        stack.push(node);
    }

    void topo(){
        Stack<L_Node> stack = new Stack<>();
        for(L_Node node : nodeList){
            if(!node.visited){
                topologicalsort(node , stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop().name + " ");
        }
    }

}

public class LIST {
    public static void main(String[] args) {
        ArrayList<L_Node> nodeList = new ArrayList<>();
        nodeList.add(new L_Node("A", 0));
        nodeList.add(new L_Node("B", 1));
        nodeList.add(new L_Node("C", 2));
        nodeList.add(new L_Node("D", 3));
        nodeList.add(new L_Node("E", 4));
        nodeList.add(new L_Node("F", 5));
        nodeList.add(new L_Node("G", 6));
        L_Graph g = new L_Graph(nodeList);
        g.addUndirectedEdge(0,1);
        g.addUndirectedEdge(0,2);
        g.addUndirectedEdge(1,3);
        g.addUndirectedEdge(1,4);
        g.addUndirectedEdge(2,5);
        g.addUndirectedEdge(2,6);
        g.printGraph();
        System.out.println("BFS");
        g.bfs();
        g.markUnvisited();
        System.out.println("\nDFS");
        g.dfs();
        g.markUnvisited();
        System.out.println("\nTopological Sort");
        g.topo();
    }
}
