package DSA.CODE;

class BINARY_TREE_A{
    String [] arr;
    int last;
    public BINARY_TREE_A(int size){
        arr = new String[size+1];
        last = 0;
    }
    public boolean isFull(){
        if (last == arr.length-1){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){
        if (last == 0){
            return true;
        }
        return false;
    }

    /*-----------------INSERT_METHOD-----------------*/
    public void insert(String data){
        if(isFull()){
            System.out.println("Tree is full");
            return;
        }
        last++;
        arr[last] = data;
    }

    /*-----------------LEVEL_ORDER_TRAVERSAL-----------------*/
    public void levelOrder(){
        for (int i = 1; i <= last; i++) {
            System.out.print(arr[i]+"-->");
        }
    }
    /*-----------------PRE_ORDER_TRAVERSAL-----------------*/
      /*   ROOT
         LEFT SUBTREE
         RIGHT SUBTREE
    */
    public void preorder(int i){
        if (i > last){
            return;
        }
        System.out.print(arr[i]+"-->"); // root node
        preorder(2*i); // left childs
        preorder((2*i)+1); // right childs
    }

    /*-----------------IN_ORDER_TRAVERSAL-----------------*/
     /*   LEFT SUBTREE
         ROOT
         RIGHT SUBTREE
    */
    public void inorder(int i){
        if(i>last){
            return;
        }
        inorder(2*i);// left childs
        System.out.print(arr[i]+"-->"); // root node
        inorder((2*i)+1); // right childs
    }

    //------------------------@@ POST_ORDER @@------------------------//
    /*   LEFT SUBTREE
         RIGHT SUBTREE
         ROOT
    */
    public void postorder(int i){
        if(i>last){
            return;
        }
        postorder(2*i);// left childs
        postorder((2*i)+1); // right childs
        System.out.print(arr[i]+"-->"); // root node
    }

    /*-----------------SEARCH_METHOD-----------------*/
    public int search(String data){
        if(isEmpty()){
            System.out.println("Tree is empty");
            return -1;
        }
        int i = 1;
        while(i<=last){
            if(arr[i].equals(data)){
                break;
            }
            i++;
        }
        if(i>last){
            System.out.println("Node not found");
            return -1;
        }
        System.out.println("Node found at index "+i);
        return i;
    }

    /*-----------------DELETE_METHOD-----------------*/
    public void delete(String data){
        if(isEmpty()){
            System.out.println("Tree is empty");
            return;
        }
        int i = 1;
        while(i<=last){
            if(arr[i].equals(data)){
                break;
            }
            i++;
        }
        if(i>last){
            System.out.println("Node not found");
            return;
        }
        arr[i] = arr[last]; // swap with last node
        last--;             // delete last node
    }

    /*-----------------DELETE_BT-----------------*/
    public void deleteBT(){
        try {
            arr = null;
            last = 0;
            System.out.println("Tree deleted");
        }
        catch (Exception e){
            System.out.println("Tree is empty");
        }
    }


}
public class sec06B_BINARY_TREE_USING_ARRAY {
    public static void main(String [] args){
            // in array implementation we don't need to create a node class
            // we don't use index 0 for simplicity
            // left child = 2*i  --> i = index of parent
            // right child = 2*i + 1 --> i = index of parent
        // parent = i/2 --> i = index of child
        // root index = 1

        BINARY_TREE_A tree = new BINARY_TREE_A(10);
        tree.insert("N1");
        tree.insert("N2");
        tree.insert("N3");
        tree.insert("N4");
        tree.insert("N5");
        tree.insert("N6");
        tree.insert("N7");
        tree.insert("N8");
        tree.insert("N9");
/*
          BINARY_TREE

                  N1
            N2         N3
         N4    N5     N6   N7
       N8  N9

*/

        System.out.println("Level order traversal");
        tree.levelOrder();
        System.out.println("\nPre order traversal");
        tree.preorder(1);
        System.out.println("\nIn order traversal");
        tree.inorder(1);
        System.out.println("\nPost order traversal");
        tree.postorder(1);

        System.out.println("\nSearching");
        tree.search("N5");

        tree.delete("N5");
        tree.levelOrder();

        System.out.println("\nDeleting tree");
        tree.deleteBT();

    }
}

/*                         space           time
*      Create -->          O(n)            O(1)
*      Insert -->          O(1)            O(1)
*      Delete -->          O(1)            O(1)
*      Search -->          O(n)            O(1)
*      Traversal -->       O(n)            O(1)
*      Delete Tree -->     O(1)            O(1)
*

* */