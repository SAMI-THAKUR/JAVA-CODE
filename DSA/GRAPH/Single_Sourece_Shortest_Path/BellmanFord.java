package DSA.GRAPH.Single_Sourece_Shortest_Path;
import java.util.ArrayList;
import java.util.HashMap;

class BF_Node{
    String name;
    int index;
    boolean visited= false;
    BF_Node parent;
    ArrayList<BF_Node> neighbours = new ArrayList<>();
    HashMap<BF_Node,Integer> weightMap = new HashMap<>(); // to store the weight of the edge for weighted graph //
    long distance ;
    BF_Node(String data , int index){
        this.name = data;
        this.index = index;
        this.distance = Integer.MAX_VALUE;
    }
}

class BF_Graph{
    ArrayList<BF_Node> nodeList  = new ArrayList<>();
    BF_Graph(ArrayList<BF_Node> nodes){
        this.nodeList = nodes;
    }

    void addDirected(int i , int j, int d){
        BF_Node first = nodeList.get(i);
        BF_Node second = nodeList.get(j);
        first.weightMap.put(second,d);
        first.neighbours.add(second);
    }
    void PathPrint(BF_Node node){
        if(node.parent!=null){
            PathPrint(node.parent);
            System.out.print("-->");
        }
        System.out.print(node.name );
    }

    void Bellman_Ford(BF_Node node){
        node.distance = 0;
        for(int i=0 ; i<nodeList.size() ; i++){
            for(BF_Node curr : nodeList){
                for(BF_Node neighbour : curr.neighbours){
                    if(neighbour.distance > curr.distance + curr.weightMap.get(neighbour)){
                        neighbour.distance = curr.distance + curr.weightMap.get(neighbour);
                        neighbour.parent = curr;
                    }
                }
            }
        }
        // check for negative cycle  in the Vth iteration //
        for(BF_Node curr : nodeList){
            for(BF_Node neighbour : curr.neighbours){
                if(neighbour.distance > curr.distance + curr.weightMap.get(neighbour)){
                    System.out.println("Negative Cycle Found");
                    System.out.println("Vertex Name : " + neighbour.name);
                    System.out.println("Old Distance : " + neighbour.distance);
                    neighbour.distance = curr.distance + curr.weightMap.get(neighbour);
                    System.out.println("New Distance : " + neighbour.distance);
                    return;
                }
            }
        }

        for(BF_Node curr : nodeList){
            System.out.print("Node " + curr.name + " , distance : " + curr.distance + " , Path : ");
            PathPrint(curr);
            System.out.println();
        }
    }
}
public class BellmanFord {
    public static void main(String[] args) {
        ArrayList<BF_Node> nodeList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            nodeList.add(new BF_Node("" + (char) (65 + i), i));
        }
        BF_Graph graph = new BF_Graph(nodeList);
        graph.addDirected(0, 2, 6); //Add A-> C , weight 6
        graph.addDirected(0, 3, 6); //Add A-> D , weight 6
        graph.addDirected(1, 0, 3); //Add B-> A , weight 3
        graph.addDirected(2, 3, 1); //Add C-> D , weight 2
        graph.addDirected(3, 2, 2); //Add D-> C , weight 1
        graph.addDirected(3, 1, 1); //Add D-> B , weight 2
        graph.addDirected(4, 1, 4); //Add E-> B , weight 4
        graph.addDirected(3, 4, 2); //Add E-> D , weight 2
        System.out.println("Printing Bellman Ford from source: A");
        graph.Bellman_Ford(nodeList.get(0));

    }
}
