package DSA.GRAPH.All_Source_Shortest_Path;

import java.util.*;

class FW_Node{
    String name;
    int index;
    boolean visited= false;
    FW_Node parent;
    ArrayList<FW_Node> neighbours = new ArrayList<>();
    HashMap<FW_Node,Integer> weightMap = new HashMap<>(); // to store the weight of the edge for weighted graph //
    long distance ;
    FW_Node(String data , int index){
        this.name = data;
        this.index = index;
        this.distance = Integer.MAX_VALUE;
    }
}

class FW_Graph{
    ArrayList<FW_Node> nodeList  = new ArrayList<>();
    FW_Graph(ArrayList<FW_Node> nodes){
        this.nodeList = nodes;
    }

    void addDirected(int i , int j, int d){
        FW_Node first = nodeList.get(i);
        FW_Node second = nodeList.get(j);
        first.weightMap.put(second,d);
        first.neighbours.add(second);
    }
    void PathPrint(FW_Node node){
        if(node.parent!=null){
            PathPrint(node.parent);
            System.out.print("-->");
        }
        System.out.print(node.name );
    }

    void Floyd_Warshall(){
        int size = nodeList.size();
        long [][] matrix = new long[size][size];
        for(int i=0 ; i<nodeList.size() ; i++){
            FW_Node first = nodeList.get(i);
            for(int j=0 ; j<size ; j++){
                FW_Node second = nodeList.get(j);
                if(i==j){
                    matrix[i][j] = 0;
                } else if (first.neighbours.contains(second)) {
                    matrix[i][j] = first.weightMap.get(second);
                }else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int k=0 ; k<nodeList.size() ; k++){
            for(int i=0 ; i<nodeList.size() ; i++){
                for(int j=0 ; j<nodeList.size() ; j++){
                    if(matrix[i][j] > matrix[i][k] + matrix[k][j]){
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }

        for(int i=0 ; i<nodeList.size() ; i++){
            System.out.println("Printing distance list for node " + nodeList.get(i).name);
            for(int j=0 ; j<nodeList.size() ; j++){
                System.out.println(nodeList.get(i).name + " --> " + nodeList.get(j).name + ": "  + matrix[i][j]);
            }
            System.out.println();
        }


    }
}
public class Floyd_Warshall {
    public static void main(String[] args) {
        ArrayList<FW_Node> nodeList = new ArrayList<>();
        nodeList.add(new FW_Node("A",0));
        nodeList.add(new FW_Node("B",1));
        nodeList.add(new FW_Node("C",2));
        nodeList.add(new FW_Node("D",3));
        FW_Graph graph = new FW_Graph(nodeList);
        graph.addDirected(0, 3, 1); //Add A-> D , weight 1
        graph.addDirected(0, 1, 8); //Add A-> B , weight 8
        graph.addDirected(1, 2, 1); //Add B-> C , weight 1
        graph.addDirected(2, 0, 4); //Add C-> A , weight 4
        graph.addDirected(3, 1, 2); //Add D-> B , weight 2
        graph.addDirected(3, 2, 9); //Add D-> C , weight 9
        graph.Floyd_Warshall();


    }
}
