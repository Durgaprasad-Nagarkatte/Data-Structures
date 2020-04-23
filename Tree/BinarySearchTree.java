package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public Node getRoot(){
        return this.root;
    }

    public void setRoot(Node root){
        this.root = root;
    }

    public boolean isEmpty(){
        return (this.root == null);
    }

    public void printTree(){
        if(isEmpty()) {
            System.out.println("Tree is Empty");
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node temp = q.poll();
            System.out.print(temp.getData() + " ");

            Node leftNode = temp.getLeftNode();
            Node rightNode = temp.getRightNode();

            if(leftNode != null){
                q.add(leftNode);
            }

            if(rightNode != null){
                q.add(rightNode);
            }
        }
        System.out.println();
    }

    public void add(int value){
        Node node = new Node(value);

        if(isEmpty()){
            root = node;
            return;
        }

        Node currentNode = this.root;
        while(currentNode != null){
            Node leftChild = currentNode.getLeftNode();
            Node rightChild = currentNode.getRightNode();

            if(currentNode.getData() >= value){
                if(leftChild == null){
                    currentNode.setLeftNode(node);
                    return;
                }
                currentNode = leftChild;
            }else{
                if(rightChild == null){
                    currentNode.setRightNode(node);
                    return;
                }
                currentNode = rightChild;
            }
        }
    }

    public Node addRecursive(int value, Node currNode){
        if(currNode == null){
            return new Node(value);
        }
        if(currNode.getData() > value){
            currNode.setLeftNode(addRecursive(value, currNode.getLeftNode()));
        }
        else if(currNode.getData() < value){
            currNode.setRightNode(addRecursive(value, currNode.getRightNode()));
        }
        return currNode;
    }

    public Node searchTree(int value){
        if(isEmpty()){
            System.out.println("Value not found. Tree is Empty ");
            return null;
        }
        Node currNode = this.root;

        while(currNode != null){
            if(currNode.getData() == value){
                return currNode;
            }
            else if(currNode.getData() > value){
                currNode = currNode.getLeftNode();
            }
            else{
                currNode = currNode.getRightNode();
            }
        }
        return currNode;
    }

    public Node searchTreeRecursive(int value, Node node){
        if(isEmpty()){
            return null;
        }
        if(node == null){
            return null;
        }
        Node left = null, right = null;

        if(node.getData() == value){
            return node;
        }else if(node.getData() > value){
            left = searchTreeRecursive(value, node.getLeftNode());
        }else{
            right = searchTreeRecursive(value, node.getRightNode());
        }
        if(left != null){
            return left;
        }else{
            return right;
        }
    }

    public boolean hasValue(int value){
        Node node = searchTree(value);
        node = searchTreeRecursive(value, this.root);
        if(node != null){
            return true;
        }
        return false;
    }

    public void preOrderTraversal(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.getData() + " ");
        preOrderTraversal(node.getLeftNode());
        preOrderTraversal(node.getRightNode());
    }

    public void inOrderTraversal(Node node){
        if(node == null){
            return;
        }
        inOrderTraversal(node.getLeftNode());
        System.out.print(node.getData() + " ");
        inOrderTraversal(node.getRightNode());
    }

    public void postOrderTraversal(Node node){
        if(node == null){
            return;
        }
        postOrderTraversal(node.getLeftNode());
        postOrderTraversal(node.getRightNode());
        System.out.print(node.getData() + " ");

    }

    public boolean deleteNode(int value){
        Node parentNode = null;
        Node currNode  = this.root;

        if(isEmpty()){
            System.out.println("Tree is empty. Node cannot be deleted");
            return false;
        }

        while((currNode != null) && (currNode.getData() != value)){
            if(currNode.getData() > value){
                currNode = currNode.getLeftNode();
            }else{
                currNode = currNode.getRightNode();
            }
        }

        if(currNode == null){
            return false;
        }

        if((currNode.getLeftNode() == null) && (currNode.getRightNode() == null)){
            if(currNode == this.root){
                setRoot(null);
                return true;
            }
            else if(currNode.getData() <= parentNode.getData()){
                parentNode.setLeftNode(null);
            }
            else{
                parentNode.setRightNode(null);
            }
            return true;
        }

        if((currNode.getLeftNode() == null) || (currNode.getRightNode() == null)){
            if(currNode.getLeftNode() != null){
                if(currNode == this.root){
                    this.setRoot(currNode.getLeftNode());
                    return true;
                }
                if(currNode.getData() <= parentNode.getData()){
                    parentNode.setLeftNode(currNode.getLeftNode());
                }else{
                    parentNode.setRightNode(currNode.getLeftNode());
                }
            }else{
                if(currNode == this.root){
                    this.setRoot(currNode.getRightNode());
                    return true;
                }
                if(currNode.getData() <= parentNode.getData()){
                    parentNode.setLeftNode(currNode.getRightNode());
                }else{
                    parentNode.setRightNode(currNode.getRightNode());
                }
            }
            return true;
        }

        Node temp = currNode.getRightNode();
        Node tempParent = currNode;
        while((temp.getLeftNode() != null) && (temp.getRightNode() != null)){
            tempParent = temp;
            temp = temp.getLeftNode();

        }
        if(currNode == this.root){
            currNode.setData(currNode.getRightNode().getData());
            return true;
        }else{
            currNode.setData(temp.getData());
            tempParent.setLeftNode(null);
            return true;
        }
    }
}
