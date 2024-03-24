package DSA.TREES;

import java.util.ArrayList;

class TREE_NODE{
    String data ;
    ArrayList<TREE_NODE> child ;
    public TREE_NODE(String data) {
        this.data = data ;
        child = new ArrayList<>();
    }

    public void Child(TREE_NODE n)
    {
        this.child.add(n);
    }

    public String print(int level)
    {
        String re ;
        re = "  ".repeat(level)+data+"\n";
        for(TREE_NODE n : child)
        {
            re += n.print(level+1);
        }
        return  re ;
    }

}
public class sec06_BASIC_TREE {
    public static void main(String[] args) {
        // @@ TREE --> non linear data structure
        //         --> quicker and easy access to data eg .  hierarchical in folder in PC

        // @@ TERMINOLOGY @@ //
        /*
         *  ROOT --> TOP NODE WITHOUT A PARENT NODE
         * EDGE --> link between PARENT AND CHILD
         * LEAF --> NODE with no children
         * SIBLINGS --> children of same parent NODE
         * ANCESTORS --> parent , grandparents of a NODE
         * DEPTH OF NODE --> length of path from ROOT to NODE
         * HEIGHT OF NODE --> length of path from NODE to deep est NODE
         * DEPTH OF TREE --> depth of ROOT NODE { depth of tree is zero }
         * HEIGHT OF TREE --> height of ROOT NODE
         * LEVEL OF NODE --> depth of NODE + 1
         * */


        TREE_NODE tn = new TREE_NODE("SAMI");
        TREE_NODE tn1 =  new TREE_NODE("S");
        TREE_NODE tn2 = new TREE_NODE("SA");
        TREE_NODE tn3 = new TREE_NODE(("SAM"));
        tn.Child(tn1);
        tn1.Child(tn2);
        tn.Child(tn3);

        System.out.println(tn.print(0));
    }
}
