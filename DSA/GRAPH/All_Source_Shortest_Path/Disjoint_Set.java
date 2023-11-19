package DSA.GRAPH.All_Source_Shortest_Path;


import javax.xml.xpath.XPath;
import java.util.*;

class DS_Node implements Comparable<DS_Node> {
    int index;
    String name;

    DS_Node parent;
    int distance;
    ArrayList<DS_Node> neighbours = new ArrayList<>();
    HashMap<DS_Node,Integer> weightMap = new HashMap<>(); // to store the weight of the edge for weighted graph //
    DisjointSet set;
    DS_Node(String data , int index){
        this.name = data;
        this.index = index;
        this.distance = Integer.MAX_VALUE;
    }
    @Override
    public int compareTo(DS_Node o) {
        return this.distance - o.distance;
    }
}



class DisjointSet{
    ArrayList<DS_Node> nodeList  = new ArrayList<>();
    public void makeSet(ArrayList<DS_Node> nodeList){
        for(DS_Node node : nodeList){
            DisjointSet set = new DisjointSet();
            set.nodeList.add(node);
            node.set = set;
        }
    }

    public DisjointSet findSet(DS_Node node){
        return node.set;
    }

    public DisjointSet union(DS_Node first , DS_Node second){
        if(first.set.equals(second.set)){
            return null;
        } else {
            DisjointSet firstSet = first.set;
            DisjointSet secondSet = second.set;
           if (firstSet.nodeList.size() > secondSet.nodeList.size()){
               ArrayList<DS_Node> secondSetList = secondSet.nodeList;
               for(DS_Node node : secondSetList){
                   node.set = firstSet;
                   firstSet.nodeList.add(node);
               }
               return firstSet;
           } else {
               ArrayList<DS_Node> firstSetList = firstSet.nodeList;
               for(DS_Node node : firstSetList){
                   node.set = secondSet;
                   secondSet.nodeList.add(node);
               }
               return secondSet;
           }
        }
    }

    public void printSet(){
        System.out.println("Printing Disjoint Set");
        for(DS_Node node : nodeList){
            System.out.print(node.name + " ");
        }
        System.out.println();
    }

    // Kruskal's Algorithm //
    // --> A minimum spanning tree (MST) or minimum weight spanning tree for a weighted,
    // --> in Kruskal's algorithm we sort the edges based on their weight and then we pick the edges one by one
    // --> and check if it forms a cycle or not , if it does not form a cycle then we add it to the MST //
}
class Undirected_Edge{
    DS_Node first;
    DS_Node second;
    int weight;
    Undirected_Edge(DS_Node first , DS_Node second , int weight){
        this.first = first;
        this.second = second;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Undirected_Edge{" +
                "first=" + first.name +
                ", second=" + second.name +
                ", weight=" + weight +
                '}';
    }
}
class Kruskal_Algo{
    ArrayList<DS_Node> nodeList = new ArrayList<>();
    ArrayList<Undirected_Edge> edgeList = new ArrayList<>();

    Kruskal_Algo(ArrayList<DS_Node> node){
        this.nodeList = node;
    }

    public void addUndirectedEdge(int i , int j , int w){
        DS_Node first = nodeList.get(i);
        DS_Node second = nodeList.get(j);
        Undirected_Edge edge = new Undirected_Edge(first,second,w);
        first.neighbours.add(second);
        first.weightMap.put(second,w);
        second.neighbours.add(first);
        second.weightMap.put(first,w);
        edgeList.add(edge);
    }

    void Kruskal(){
        DisjointSet ds = new DisjointSet();
        ds.makeSet(nodeList);
        Comparator<Undirected_Edge> cmp = new Comparator<Undirected_Edge>() {
            @Override
            public int compare(Undirected_Edge o1, Undirected_Edge o2) {
                return o1.weight - o2.weight;
            }
        };

        Collections.sort(edgeList,cmp);
        int cost = 0;
        for(Undirected_Edge edge : edgeList){
            DS_Node first = edge.first;
            DS_Node second = edge.second;
            if(ds.findSet(first)!=ds.findSet(second)){
                ds.union(first,second);
                cost += edge.weight;
                System.out.println("Taken " + edge);
            }
        }

        System.out.println("Total Cost : " + cost);

    }



}

class Prism{
    ArrayList<DS_Node> nodeList = new ArrayList<>();

    Prism(ArrayList<DS_Node> node){
        this.nodeList = node;
    }

    public void addUndirectedEdge(int i , int j , int w){
        DS_Node first = nodeList.get(i);
        DS_Node second = nodeList.get(j);
        Undirected_Edge edge = new Undirected_Edge(first,second,w);
        first.neighbours.add(second);
        first.weightMap.put(second,w);
        second.neighbours.add(first);
        second.weightMap.put(first,w);
    }

    void path(DS_Node node){
        if(node.parent!=null){
            path(node.parent);
            System.out.print("-->");
        }
        System.out.print(node.name);
    }
    void prism_algo(DS_Node node){
        for(DS_Node curr : nodeList){
            curr.distance = Integer.MAX_VALUE;
        }

        node.distance = 0;
        PriorityQueue<DS_Node> queue = new PriorityQueue<>();
        queue.addAll(nodeList);
        while (!queue.isEmpty()){
            DS_Node curr = queue.remove();
            for(DS_Node neighbour : curr.neighbours){
                if(queue.contains(neighbour)){
                    if(neighbour.distance > curr.weightMap.get(neighbour)){
                        neighbour.distance = curr.weightMap.get(neighbour);
                        neighbour.parent = curr;
                        // refresh the priority queue //
                        queue.remove(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
        }

        int cost = 0;
        for(DS_Node curr : nodeList){
            System.out.print("Node " + curr.name + " , distance : " + curr.distance + " , Path : ");
            path(curr);
            cost += curr.distance;
            System.out.println();
        }
        System.out.println("Total Cost : " + cost);
    }
}
public class Disjoint_Set {
    public static void main(String[] args) {
        // Minimum Spanning Tree //
        // -->  A spanning tree of a graph is a tree that contains all the vertices of the graph.
        // -->  A minimum spanning tree (MST) or minimum weight spanning tree for a weighted,
        // connected and undirected graph is a spanning tree with weight less than or equal to the weight of every other spanning tree.
        // --> The weight of a spanning tree is the sum of weights given to each edge of the spanning tree.
        // --> it should not contain any cycle //
        // --> it should be connected //
        ArrayList<DS_Node> nodeList = new ArrayList<>();
        nodeList.add(new DS_Node("A",0));
        nodeList.add(new DS_Node("B",1));
        nodeList.add(new DS_Node("C",2));
        nodeList.add(new DS_Node("D",3));
        nodeList.add(new DS_Node("E",4));

        DisjointSet set = new DisjointSet();
        set.makeSet(nodeList);
        DisjointSet out = set.findSet(nodeList.get(1));
        out.printSet();

        set.union(nodeList.get(0),nodeList.get(1));
        out.printSet();

        set.findSet(nodeList.get(0)).printSet();

        Kruskal_Algo ka = new Kruskal_Algo(nodeList);
        ka.addUndirectedEdge(0,1,10);
        ka.addUndirectedEdge(0,2,20);
//      ka.addUndirectedEdge(0,4,15);
        ka.addUndirectedEdge(1,3,5);
        ka.addUndirectedEdge(1,2,30);
        ka.addUndirectedEdge(3,2,15);
        ka.addUndirectedEdge(3,4,8);
        ka.addUndirectedEdge(2,4,6);

        ka.Kruskal();

        Prism p = new Prism(nodeList);
        p.addUndirectedEdge(0,1,10);
        p.addUndirectedEdge(0,2,20);
//      p.addUndirectedEdge(0,4,15);
        p.addUndirectedEdge(1,3,5);
        p.addUndirectedEdge(1,2,30);
        p.addUndirectedEdge(3,2,15);
        p.addUndirectedEdge(3,4,8);
        p.addUndirectedEdge(2,4,6);

        p.prism_algo(nodeList.get(0));


    }
}
