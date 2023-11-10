package DSA.GRAPH.Single_Sourece_Shortest_Path;


import java.util.*;

class BFS_Node{
    String name;
    int index;
    boolean visited= false;
    BFS_Node parent;
    BFS_Node(String data , int index){
        this.name = data;
        this.index = index;
    }
}

class BFS_Graph{
    ArrayList<BFS_Node> nodeList  = new ArrayList<>();
    int [][] adj_matrix;
    BFS_Graph(ArrayList<BFS_Node> nodes){
        this.nodeList = nodes;
        adj_matrix = new int[nodes.size()][nodes.size()];
    }

    void addUndirectedEdge(int i, int j) {
        adj_matrix[i][j] = 1;
        adj_matrix[j][i] = 1;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + " ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j : adj_matrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
    void pathPrint(BFS_Node node){
        if(node.parent!=null){
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }
    void bfsVisit(BFS_Node node){
        LinkedList<BFS_Node> queue = new LinkedList<BFS_Node>();
        queue.add(node);
        while(!queue.isEmpty()){
            BFS_Node currentNode = queue.remove(0);
            currentNode.visited = true;
            System.out.print(currentNode.name + " :");
            pathPrint(currentNode);
            System.out.println();
            for (int i = 0; i < adj_matrix.length; i++) {
                if (adj_matrix[currentNode.index][i] == 1){
                    BFS_Node neighbour = nodeList.get(i);
                    if (!neighbour.visited){
                        queue.add(neighbour);
                        neighbour.visited = true;
                        neighbour.parent = currentNode;
                    }
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

}

public class BFS_Matrix {
    public static void main(String[] args) {
        ArrayList<BFS_Node> nodeList = new ArrayList<>();
        nodeList.add(new BFS_Node("A", 0));
        nodeList.add(new BFS_Node("B", 1));
        nodeList.add(new BFS_Node("C", 2));
        nodeList.add(new BFS_Node("D", 3));
        nodeList.add(new BFS_Node("E", 4));
        nodeList.add(new BFS_Node("F", 5));
        nodeList.add(new BFS_Node("G", 6));
        BFS_Graph g = new BFS_Graph(nodeList);
        g.addUndirectedEdge(0,1);
        g.addUndirectedEdge(0,2);
        g.addUndirectedEdge(1,3);
        g.addUndirectedEdge(2,5);
        g.addUndirectedEdge(2,6);
        g.addUndirectedEdge(3,4);
        g.addUndirectedEdge(5,6);
        System.out.println(g.toString());
        System.out.println("Single Source Shortest Path using BFS");
        g.bfs();
    }
}
