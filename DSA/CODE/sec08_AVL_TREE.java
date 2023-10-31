package DSA.CODE;

import java.util.LinkedList;
import java.util.Queue;


class AVL_NODE   {
    int data;
    AVL_NODE    left;
    AVL_NODE    right;
    int height;
    public AVL_NODE   (int data) {
        this.data = data;
        this.height = 0;
    }
}
class AVL_TREE
{
    AVL_NODE    root;
    AVL_TREE() {
        root = null;
    }

    //-----------PREORDER TRAVERSAL----------------//
    public void preorder(AVL_NODE    node) {
        if(node == null)
        {
            return;
        }
        System.out.print(node.data+" ");
        preorder(node.left);
        preorder(node.right);
    }

    //-----------INORDER TRAVERSAL----------------//
    public void inorder(AVL_NODE    node) {
        if(node == null)
        {
            return;
        }
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }

    //-----------POSTORDER TRAVERSAL----------------//
    public void postorder(AVL_NODE    node) {
        if(node == null)
        {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+" ");
    }

    //-----------LEVEL ORDER----------------//
    public void levelorder() {
        Queue<AVL_NODE   > q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty())
        {
            AVL_NODE    temp = q.remove();
            System.out.print(temp.data+" ");
            if(temp.left != null)
            {
                q.add(temp.left);
            }
            if(temp.right != null)
            {
                q.add(temp.right);
            }
        }
    }

    //-----------SEARCh----------------//
    public AVL_NODE    search(AVL_NODE    node , int data) {
        if(node == null)
        {
            System.out.println("NOT FOUND");
            return null;
        }
        else if(node.data == data)
        {
            System.out.println("FOUND");
            return node;
        }
        else if(node.data > data)
        {
            return search(node.left , data);
        }
        else
        {
            return search(node.right , data);
        }
    }

    //-----------INSERT----------------//
// CASE 1 : LEFT LEFT CASE --> RIGHT ROTATION // --> disbalance at left of left

// CASE 2 : LEFT RIGHT CASE --> LEFT THEN RIGHT ROTATION // --> disbalance at right of left

// CASE 3 : RIGHT RIGHT CASE // --> LEFT ROTATION // --> disbalance at right of right

// CASE 4 : RIGHT LEFT CASE // --> RIGHT THEN LEFT ROTATION // --> disbalance at left of right

// RIGHT ROTATION :-
/*
 * new = disbalanced node left
 * disbalanced node left = disbalanced node left right
 * new right = disbalanced node
 * update height of both nodes
 */

 // LEFT ROTATION :-
/*
* new = disbalanced node right
* disbalanced node right = disbalanced node right left
* new left = disbalanced node
* update height of both nodes
*/

    //------------------INSERT----------------//
    //------------------HELPERS---------------//
    public int getHeight(AVL_NODE   node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // rotateRight
    private AVL_NODE rotateRight(AVL_NODE   disbalancedNode) {
        AVL_NODE   newRoot = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // rotateLeft
    private AVL_NODE rotateLeft(AVL_NODE disbalancedNode) {
        AVL_NODE newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // getBalance
    public int getBalance(AVL_NODE   node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // insertNode Method
    private AVL_NODE insertNode(AVL_NODE   node, int nodeValue) {
        if (node == null) {
            AVL_NODE   newNode = new AVL_NODE(nodeValue);
            newNode.data = nodeValue;
            newNode.height = 1;
            return newNode;
        } else if (nodeValue < node.data) {
            node.left = insertNode(node.left, nodeValue);
        } else {
            node.right = insertNode(node.right, nodeValue);
        }
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);
        if (balance > 1 && nodeValue < node.left.data) {
            return rotateRight(node);
        }
        if (balance > 1 && nodeValue > node.left.data) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && nodeValue > node.right.data) {
            return rotateLeft(node);
        }
        if (balance < - 1 && nodeValue < node.right.data) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;

    }

    public void insert(int value) {
        root = insertNode(root, value);
    }

    //------DELETE-------//
    public AVL_NODE findMin(AVL_NODE node){
        if(node.left==null){
            return node;
        }
        else {
            return findMin(node.left);
        }
    }

    public AVL_NODE deleteNode(AVL_NODE node,int data){
        if(node==null){
            System.out.println("NOT FOUND");
            return node;
        }
        if(node.data>data){
            node.left = deleteNode(node.left,data);
        }
        else if(node.data<data) {
            node.right= deleteNode(node.right,data);
        }
        else {
            if(node.left!=null && node.right!=null){
                AVL_NODE temp = node;
                AVL_NODE min = findMin(node.right);
                node.data = min.data;
                node.right = deleteNode(node.right,min.data);
            }
             else if (node.left!=null) {
                node = node.left;
            } else if (node.right!=null) {
                node=node.right;
            }else{
                node = null ;
            }


            int balance = getBalance(node);
            if(balance>1 && getBalance(node.left)>=0){
                return rotateRight(node);
            }
            if(balance>1 && getBalance(node.left)<0){
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
            if(balance<-1 && getBalance(node.right)<=0){
                return rotateLeft(node);
            }
            if(balance<-1 && getBalance(node.right)>0){
                node.right=rotateRight(node.right);
                return rotateLeft(node);
            }
        }
        return node;
    }
    public void delete(int data){
        root = deleteNode(root,data);
    }


    //--------DELETE_TREE----------//
    public void deleteAVL() {
        root = null;
    }

}

public class sec08_AVL_TREE {
    public static void main(String[] args) {
        // AVL tree means Adelson-Velskii and Landis' tree.
        // It is a self-balancing binary search tree.
        // AVL left and right subtree of any node differ in height by at most 1.
        // AVL left node is smaller than the parent node and right node is greater than the parent node.
        // AVL is Binary Search Tree with additional feature of balancing the tree.

        AVL_TREE n = new AVL_TREE();
        n.insert(50);
        n.insert(40);
        n.insert(65);
        n.insert(60);
        n.insert(70);
        n.insert(63);
        n.insert(75);


        n.levelorder();
        System.out.println("");
        n.delete(65);
        n.delete(75);

        n.levelorder();



    }
}
