package DSA.GRAPH.Single_Sourece_Shortest_Path;
import java.util.*;


class DJ_Node implements Comparable<DJ_Node>{
    String name;
    ArrayList<DJ_Node> neighbours = new ArrayList<>();
    HashMap<DJ_Node,Integer> weightMap = new HashMap<>(); // to store the weight of the edge for weighted graph //
    boolean visited= false;
    DJ_Node parent;
    int distance;
    int index;
    DJ_Node(String data , int index){
        this.name = data;
        this.index = index;
        this.distance = Integer.MAX_VALUE;
    }

    @Override
    public String toString() {
        return name;
    }
    // implementing compareTo method to use this object in priority queue //
    // this will sort the priority queue based on the distance of the node //
    // it will return the node with minimum distance //
    @Override
    public int compareTo(DJ_Node o) {
        return this.distance - o.distance;
    }
}

class DJ_Graph{
    ArrayList<DJ_Node> nodeList  = new ArrayList<>();
    DJ_Graph(ArrayList<DJ_Node> nodes){
        this.nodeList = nodes;
    }

    void addUndirectedEdge(int i, int j, int d) {
        DJ_Node first = nodeList.get(i);
        DJ_Node second = nodeList.get(j);
        first.neighbours.add(second);
        first.weightMap.put(second,d);
    }
    void PathPrint(DJ_Node node){
        if(node.parent!=null){
            PathPrint(node.parent);
            System.out.print("-->");
        }
        System.out.print(node.name );
    }
    void dijkstras_algo(DJ_Node node){
        PriorityQueue<DJ_Node> queue = new PriorityQueue<>();
        node.distance = 0;
        queue.addAll(nodeList);
        while(!queue.isEmpty()){
            DJ_Node curr = queue.remove();
            for(DJ_Node neighbour : curr.neighbours){
                if(queue.contains(neighbour)){
                    if(neighbour.distance > curr.distance + curr.weightMap.get(neighbour)){
                        neighbour.distance = curr.distance + curr.weightMap.get(neighbour);
                        neighbour.parent = curr;
                        // refresh the priority queue //
                        queue.remove(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
        }

        for (DJ_Node nodeToCheck : nodeList) {
            System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.distance + ", Path: ");
            PathPrint(nodeToCheck);
            System.out.println();
        }
    }
}
public class Dijkstras_Algo {
    public static void main(String[] args) {
        ArrayList<DJ_Node> nodeList = new ArrayList<>();
        nodeList.add(new DJ_Node("A",0));
        nodeList.add(new DJ_Node("B",1));
        nodeList.add(new DJ_Node("C",2));
        nodeList.add(new DJ_Node("D",3));
        nodeList.add(new DJ_Node("E",4));
        nodeList.add(new DJ_Node("F",5));
        nodeList.add(new DJ_Node("G",6));
        DJ_Graph g = new DJ_Graph(nodeList);
        g.addUndirectedEdge(0,1,2);
        g.addUndirectedEdge(0,2,5);
        g.addUndirectedEdge(1,2,6);
        g.addUndirectedEdge(1,3,1);
        g.addUndirectedEdge(1,4,3);
        g.addUndirectedEdge(2,5,8);
        g.addUndirectedEdge(3,4,4);
        g.addUndirectedEdge(4,5,9);
        g.addUndirectedEdge(5,6,7);
        g.addUndirectedEdge(4,6,9);
        g.dijkstras_algo(nodeList.get(0));
    }
}
