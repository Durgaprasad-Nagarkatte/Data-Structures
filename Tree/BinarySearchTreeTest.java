package Tree;

public class BinarySearchTreeTest {

    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        /*
        bst.add(6);
        bst.add(4);
        bst.add(9);
        bst.add(5);
        bst.add(2);
        bst.add(8);
        bst.add(12);
        bst.add(10);
        bst.add(14);
         */
        Node root;
        root = bst.addRecursive(6, bst.getRoot());
        if(bst.getRoot() == null){
            bst.setRoot(root);
        }
        bst.addRecursive(4, bst.getRoot());
        bst.addRecursive(9, bst.getRoot());
        bst.addRecursive(5, bst.getRoot());
        bst.addRecursive(2, bst.getRoot());
        bst.addRecursive(8, bst.getRoot());
        bst.addRecursive(12, bst.getRoot());
        bst.addRecursive(10, bst.getRoot());
        bst.addRecursive(14, bst.getRoot());

        bst.printTree();
        //System.out.println(bst.hasValue(9));
        //System.out.println(bst.hasValue(19));
        bst.deleteNode(9);
        bst.printTree();

        //.preOrderTraversal(bst.getRoot());
        //System.out.println();
        //bst.inOrderTraversal(bst.getRoot());
        //System.out.println();
        //bst.postOrderTraversal(bst.getRoot());
        //System.out.println();
        //System.out.println(bst.minimumValue(bst.getRoot()));
        System.out.println(bst.findAncestors(12));
    }
}
