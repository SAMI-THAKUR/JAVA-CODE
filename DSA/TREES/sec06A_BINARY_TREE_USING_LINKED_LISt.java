package DSA.TREES;

import java.util.*;

class TREE_BNODE{
    String data ;
    TREE_BNODE left ;
    TREE_BNODE right ;
    int height;
    public TREE_BNODE(String d){
        this.data = d;
    }
}
class BINARY_TREE{
    TREE_BNODE root ;
    public BINARY_TREE()
    {
        this.root = null;
    }

    //--------------@@ PRE_ORDER @@------------------//
    /*   ROOT
         LEFT SUBTREE
         RIGHT SUBTREE
    */
    void preorder(TREE_BNODE n)     // @ --> O(N)
    {
        if(n == null)       // @  -->  O(1)
        {
         return;          // @  -->  O(1)
        }
        System.out.print(n.data + "-->");     // @  -->  O(1)
        preorder(n.left);                     // @  -->  O(N/2)
        preorder(n.right);

        // OUTPUT OF PREORDER TRAVERSAL
        // N1-->N2-->N4-->N8-->N9-->N5-->N3-->N6-->N7--> //
    }

    //---------------------------@@ IN_ORDER @@--------------------------//
    /*   LEFT SUBTREE
         ROOT
         RIGHT SUBTREE
    */
    void inorder(TREE_BNODE n)    // @ --> O(N)
    {
        if (n==null){           // @  -->  O(1)
            return;
        }
        inorder(n.left);                   // @  -->  O(N/2)
        System.out.print(n.data + "-->");  // @  -->  O(1)
        inorder(n.right);                  // @  -->  O(N/2)
        // OUTPUT OF INORDER TRAVERSAL
        // N8-->N4-->N9-->N2-->N5-->N1-->N6-->N3-->N7--> //
    }

    //------------------------@@ POST_ORDER @@------------------------//
    /*   LEFT SUBTREE
         RIGHT SUBTREE
         ROOT
    */
    void postorder(TREE_BNODE n)      // @ --> O(N)
    {
if(n==null)
{
    return;
}
postorder(n.left);
postorder(n.right);
System.out.print(n.data + "-->");

// OUTPUT OF POSTORDER TRAVERSAL
// N8-->N9-->N4-->N5-->N2-->N6-->N7-->N3-->N1--> //
    }

    //----------------------@@ LEVEL ORDER TRAVERSAL @@--------------------//
    void levelorder()    // @ -->  O(N)
    {
      Queue<TREE_BNODE> q = new LinkedList<TREE_BNODE>(); // --> FIFO
      q.add(root);
      while (!q.isEmpty())         // @ --> O(N)
      {
          TREE_BNODE present = q.remove();
          System.out.print(present.data + "-->");
          if(present.left !=null)
          {
              q.add(present.left);
          }
          if(present.right !=null)
          {
              q.add(present.right);
          }
      }
         // OUTPUT OF LEVEL ORDER TRAVERSAL
        // N1-->N2-->N3-->N4-->N5-->N6-->N7-->N8-->N9--> //

    }

    //----------------@@ SEARCH method using LEVEL_ORDER TRAVERSAL @@-----------------//
    void Search(String value) {
        Queue<TREE_BNODE> q = new LinkedList<TREE_BNODE>();
        q.add(root);
        while (!q.isEmpty()){        // @ --> O(N)
            TREE_BNODE present = q.remove();
           if(present.data.equals(value))
           {
               System.out.println("\nfound");
               break;
           }
            if(present.left !=null)
            {
                q.add(present.left);
            }
            if(present.right !=null)
            {
                q.add(present.right);
            }
        }
    }

    //------------------@@  INSERT method in BINARY TREE  @@-----------------//
    void insert(String val)  // -->  O(N)
    {
        TREE_BNODE n = new TREE_BNODE(val);
        if(root==null){
         root = n;
         return;
        }
        Queue<TREE_BNODE> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            TREE_BNODE pre = q.remove();
            if(pre.left == null) {
                pre.left = n;
                break;
            }
            else if(pre.right ==null){
                pre.right = n;
                break;
            }
            else {
                // not checking for null because we are adding node in the last
                q.add(pre.left);
                q.add(pre.right);
            }
        }

    }
    //----------------Finding deepest NODE-------------------//
    TREE_BNODE deepest(){
        Queue<TREE_BNODE> q = new LinkedList<>();
        q.add(root);
        TREE_BNODE present = null ;
        while (!q.isEmpty()){
          present =q.remove();
          if(present.left!=null){
              q.add(present.left);
          }
          if (present.right!=null){
              q.add(present.right);
          }
        }
        return present;
    }

    //----------------------DELETE_DEEPEST_NODE-------------------//
    void delete_deepest() {  // --> level order traversal
        Queue<TREE_BNODE> q = new LinkedList<>();
        q.add(root);
        TREE_BNODE prev , present = null;
        while (!q.isEmpty()){
            prev = present ;
            present =q.remove();
            if(present.left==null){
                prev.right=null;
                return;
            }
            else if(present.right==null){
                present.left = null ;
                return;
            }
            q.add(present.left);
            q.add(present.right);
        }
    }
    void delete_NODE(String data)
            /*
            * FIND THE NODE
            * FIND THE DEEPEST NODE
            * SET NODE VALUE TO DEEPEST
            * DELETE DEEPEST NODE
            * */
    {
      Queue<TREE_BNODE> q =  new LinkedList<>();
      q.add(root);
      while (!q.isEmpty()){     // -->  O(N) time complexity
          TREE_BNODE n = q.remove();
          if(n.data.equals(data)){
              n.data = deepest().data;
              delete_deepest();
              return;
          }
          else {
             if (n.left !=null){
                 q.add(n.left);
             }
             if(n.right!=null){
                 q.add(n.right);
             }
          }
      }
    }

    // @@  DELETE BT  @@ //
    void delete_BT(){
        root = null;
        System.out.println("\nDELETED BINARY TREE");
    }
}
public class sec06A_BINARY_TREE_USING_LINKED_LISt {
    public static void main(String [] args)
    {
/*
*  --> in BINARY TREE each node has AT MOST TWO CHILDREN called the LEFT and RIGHT
*   @@ TYPES OF B.T @@
*   --> FULL : each node has either two or no children
*   --> PERFECT : ALL leaf node are at same depth  and all node have exact same two children
*   --> COMPLETE : all level are completely filled except the last
*   --> BALANCED : all leaf node are at equal dist from ROOT NODE
* */

BINARY_TREE bt = new BINARY_TREE() ;
        bt.insert("N1");
        bt.insert("N2");
        bt.insert("N3");
        bt.insert("N4");
        bt.insert("N5");
        bt.insert("N6");
        bt.insert("N7");
        bt.insert("N8");
        bt.insert("N9");

/*
                  N1
            N2         N3
         N4    N5     N6   N7
       N8  N9
* */
System.out.println("PRE_ORDER TRAVERSAL");
bt.preorder(bt.root);
        System.out.println();
System.out.println("IN_ORDER TRAVERSAL");
bt.inorder(bt.root);
        System.out.println();
System.out.println("POST_ORDER TRAVERSAL");
bt.postorder(bt.root);
        System.out.println();
System.out.println("LEVE_ORDER TRAVERSAL");
bt.levelorder();
        System.out.println();
bt.Search("N2");
bt.delete_NODE("N3"); // delete node N3 and replace it with deepest node N9
bt.delete_NODE("N2"); // delete node N2 and replace it with deepest node N8
bt.levelorder();
//bt.delete_BT();
        

    }
}

/*                         space           time
 *      Create -->          O(n)            O(1)
 *      Insert -->          O(n)            O(n)
 *      Delete -->          O(1)            O(n)
 *      Search -->          O(n)            O(n)
 *      Traversal -->       O(n)            O(n)
 *      Delete Tree -->     O(1)            O(1)
 *

 * */