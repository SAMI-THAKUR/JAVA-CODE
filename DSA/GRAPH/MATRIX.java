package DSA.GRAPH;
import java.util.*;

class M_Node{
    String name;
    int index;
    boolean visited= false;
    M_Node(String data , int index){
        this.name = data;
        this.index = index;
    }

}

class M_Graph{
    ArrayList<M_Node> nodeList  = new ArrayList<>();
    int [][] adj_matrix;
    M_Graph(ArrayList<M_Node> nodes){
        this.nodeList = nodes;
        adj_matrix = new int[nodes.size()][nodes.size()];
    }

    public void addUndirectedEdge(int i, int j) {
        adj_matrix[i][j] = 1;
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

    public ArrayList<M_Node> getNeighbors(M_Node node) {
        ArrayList<M_Node> neighbours = new ArrayList<>();
        int nodeIndex = node.index;
        for (int i = 0; i < adj_matrix.length; i++) {
            if (adj_matrix[nodeIndex][i] == 1) {
                neighbours.add(nodeList.get(i));
            }
        }
        return neighbours;
    }
    // ----------------- BFS ---------------------- //
    void bfsVisit(M_Node node) {
        LinkedList<M_Node> queue = new LinkedList<M_Node>();
        queue.add(node);
        while(!queue.isEmpty()) {
            M_Node currentNode = queue.remove(0);
            currentNode.visited = true;
            System.out.print(currentNode.name + " ");
            ArrayList<M_Node> neighbors = getNeighbors(currentNode);
            for (M_Node neighbor: neighbors) {
                if (!neighbor.visited) {
                    queue.add(neighbor);
                    neighbor.visited = true;
                }
            }
        }
    }

    public void bfs() {
        for (M_Node node : nodeList) {
            if(!node.visited) {
                bfsVisit(node);
            }
        }
    }
    // ----------------- DFS ---------------------- //
    void dfsVisit(M_Node node) {
        Stack<M_Node> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()) {
            M_Node currentNode = stack.pop();
            currentNode.visited = true;
            System.out.print(currentNode.name + " ");
            ArrayList<M_Node> neighbors = getNeighbors(currentNode);
            for (M_Node neighbor : neighbors) {
                if (!neighbor.visited) {
                    stack.push(neighbor);
                    neighbor.visited = true;
                }
            }

        }
    }

    void dfs() {
        for (M_Node node : nodeList) {
            if(!node.visited) {
                dfsVisit(node);
            }
        }
    }
    // ----------------- Topological Sort ---------------------- //
    void topologicalVisit(M_Node node, Stack<M_Node> stack) {
        ArrayList<M_Node> neighbors = getNeighbors(node);
        for (M_Node neighbor : neighbors) {
            if (!neighbor.visited) {
                topologicalVisit(neighbor, stack);
            }
        }
        node.visited = true;
        stack.push(node);
    }

    void topologicalSort() {
        Stack<M_Node> stack = new Stack<>();
        for (M_Node node : nodeList) {
            if (!node.visited) {
                topologicalVisit(node, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().name + " ");
        }
    }
    public void makeUnvisited(){
        for (M_Node node : nodeList) {
            node.visited=false;
        }
    }

}

public class MATRIX {
    public static void main(String[] args) {
        ArrayList<M_Node> nodeList = new ArrayList<>();
        nodeList.add(new M_Node("A", 0));
        nodeList.add(new M_Node("B", 1));
        nodeList.add(new M_Node("C", 2));
        nodeList.add(new M_Node("D", 3));
        nodeList.add(new M_Node("E", 4));
        nodeList.add(new M_Node("F", 5));
        nodeList.add(new M_Node("G", 6));
        M_Graph g = new M_Graph(nodeList);
        g.addUndirectedEdge(0,1);
        g.addUndirectedEdge(0,2);
        g.addUndirectedEdge(1,3);
        g.addUndirectedEdge(1,4);
        g.addUndirectedEdge(2,5);
        g.addUndirectedEdge(2,6);
        System.out.println("Printing BFS from source: A");
        g.bfs();
        g.makeUnvisited();
        System.out.println("\nPrinting DFS from source: A");
        g.dfs();
        g.makeUnvisited();
        System.out.println("\nPrinting Topological Sort");
        g.topologicalSort();
    }
}

