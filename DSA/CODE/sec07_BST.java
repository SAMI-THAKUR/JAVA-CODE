package DSA.CODE;


import java.util.LinkedList;
import java.util.Queue;

class BST_NODE{
    int data;
    int height;
    BST_NODE left;
    BST_NODE right;
    BST_NODE(int data){
        this.data = data;
    }
}
class BST {
    BST_NODE root;

    // initialize the Binary Search Tree //
    BST() {
        this.root = null;
    }


    //---------------------INSERT---------------------//
    private BST_NODE insert(BST_NODE current, int data) {
        if (current == null) { // if tree is empty, create a new node and return it
            BST_NODE newNode = new BST_NODE(data);
            System.out.println("Inserted: " + data);
            return newNode;
        } else if (data <= current.data) { // if data is less than root, insert in left subtree
            current.left = insert(current.left, data);
            return current;
        } else {  // if data is greater than root, insert in right subtree
            current.right = insert(current.right, data);
            return current;
        }
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    //---------------------PREORDER---------------------//
    public void preorder(BST_NODE node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + "-->");
        preorder(node.left);
        preorder(node.right);
    }

    //---------------------INORDER---------------------//
    public void inorder(BST_NODE node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + "-->");
        inorder(node.right);
    }

    //---------------------POSTORDER---------------------//
    public void postorder(BST_NODE node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + "-->");
    }

    //---------------------LEVEL_ORDER---------------------//
    public void levelorder(BST_NODE node) {
        if (node == null) {
            return;
        }
        Queue<BST_NODE> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            BST_NODE current = q.remove();
            System.out.print(current.data + "-->");
            if (current.left != null) {
                q.add(current.left);
            }
            if (current.right != null) {
                q.add(current.right);
            }
        }
    }

    //---------------------SEARCH---------------------//
    public BST_NODE search(BST_NODE node, int data) {
        if (node == null) {
            System.out.println("Not Found");
            return null;
        }
        if (node.data == data) {
            return node;
        }
        else if (data < node.data) {
            return search(node.left, data);
        }
        else {
            return search(node.right, data);
        }
    }


    //---------------------DELETE_NODE---------------------//
    public BST_NODE deleteNode(BST_NODE node, int data) {
        if (node == null) {
            System.out.println("Not Found");
            return null;
        }
        if (data < node.data) {
            node.left = deleteNode(node.left, data);
        }
        else if (data > node.data) {
            node.right = deleteNode(node.right, data);
        }
        else {
            if (node.left == null && node.right == null) { // if node is leaf node //
                System.out.println("Deleted: " + node.data);
                node = null;
            }
            // if node has only one child //
            else if (node.left == null) {
                System.out.println("Deleted: " + node.data);
                node = node.right;
            }
            else if (node.right == null) {
                System.out.println("Deleted: " + node.data);
                node = node.left;
            }
            // if node has two children //
            else {
                System.out.println("Deleted: " + node.data);
                BST_NODE temp = findMin(node.right); // find minimum value in right subtree or successor
                node.data = temp.data;               // replace node with successor
                node.right = deleteNode(node.right, temp.data); // delete successor node
            }
        }
        return node;
    }

    private BST_NODE findMin(BST_NODE root) {
        if(root.left == null){
            return root;
        }
        else{
            return findMin(root.left);
        }

    }

    //---------------------DELETE---------------------//
    public void delete(){
        root= null;
        System.out.println("Tree Deleted");
    }
}
public class sec07_BST {
    public static void main(String[] args) {
        // Binary Search Tree
        // left subtree is less than or equal to the root
        // right subtree is greater than the root
        // left and right subtree are also BST
        // perform faster search, insert, delete than normal binary tree
        // O(log n) time complexity


        /*
        *                   50
        *           40                60
        *      30      42         58       70
        *   20   35                 59        80
        *
        * */
      BST bst = new BST();

      bst.insert(50);
      bst.insert(40);
      bst.insert(60);
      bst.insert(30);
      bst.insert(70);
      bst.insert(20);
      bst.insert(80);
      bst.insert(35);
      bst.insert(42);
      bst.insert(58);
      bst.insert(59);


        System.out.println("Preorder Traversal: ");
        bst.preorder(bst.root);
        System.out.println("\nInorder Traversal: ");
        bst.inorder(bst.root);
        System.out.println("\nPostorder Traversal: ");
        bst.postorder(bst.root);
        System.out.println("\nLevelorder Traversal: ");
        bst.levelorder(bst.root);

        System.out.println("\nSearch: ");
        System.out.println(bst.search(bst.root, 35));

        System.out.println("\nDelete Node: ");
        bst.deleteNode(bst.root, 70);
        bst.deleteNode(bst.root, 50);
        bst.deleteNode(bst.root, 70);
        bst.levelorder(bst.root);


    }
}

/*              TIME & SPACE COMPLEXITY
*                                     TIME           SPACE
*   Create                              O(1)           O(1)
*   Insert                              O(log n)       O(1)
*   Delete                              O(log n)       O(1)
*   Search                              O(log n)       O(1)
*   Traversal                           O(n)           O(n)
*   Height                              O(n)           O(1)
*
* */
