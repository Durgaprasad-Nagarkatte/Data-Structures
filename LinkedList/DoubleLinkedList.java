public class DoubleLinkedList<T>{

    public class Node{
        public T data;
        public Node prevNode;
        public Node nextNode;
    }
    
    private Node tailNode;
    private Node headNode;
    private int size;

    public DoubleLinkedList(){
        this.headNode = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        if (this.headNode == null){
            return true;
        }
        return false;
    }

    public void insertAtHead(T data){
        Node newNode = new Node();
        newNode.data = data;

        if(isEmpty()){
            this.tailNode = newNode;
        }

        newNode.nextNode = this.headNode;
        this.headNode = newNode;
        this.size++;
    }

    public void insertAtEnd(T data){
        Node newNode = new Node();
        newNode.data = data;

        if (isEmpty()){
            insertAtHead(data);
            return;
        }

        Node currentNode = this.headNode;
        while (currentNode.nextNode != null){
            currentNode = currentNode.nextNode;
        }

        this.tailNode = newNode;
        newNode.prevNode = currentNode;
        currentNode.nextNode = newNode;
        this.size++;
    }

    public void insertAfter(T data, T previous){
        Node newNode = new Node();
        newNode.data = data;

        if (isEmpty()){
            insertAtHead(data);
            return;
        }

        Node currentNode = this.headNode;
        while(currentNode != null){
            if (currentNode.data.equals(previous)){
                if (currentNode.nextNode == null){
                    this.tailNode = newNode;
                }
                newNode.nextNode = currentNode.nextNode;
                newNode.prevNode = currentNode;
                currentNode.nextNode = newNode;
                currentNode.nextNode.prevNode = newNode;
                this.size++;
                return;
            }
            currentNode = currentNode.nextNode;
        }
    }

    public void deleteAtHead(){
        if(isEmpty()){
            return;
        }
        this.headNode = this.headNode.nextNode;
        this.headNode.prevNode = null;
        this.size--;
        if(headNode == null){
            this.tailNode = null;
        }
    }

    public void delete(T data){
        if(isEmpty()){
            return;
        }

        Node currentNode = this.headNode;
        if (currentNode.nextNode == null){
            deleteAtHead();
        }

        while(currentNode != null){
            if (currentNode.data.equals(data)){
                if (currentNode.nextNode == null){
                    this.tailNode = currentNode.prevNode;
                }
                currentNode.prevNode.nextNode = currentNode.nextNode;
                currentNode.nextNode.prevNode = currentNode.prevNode;
                this.size--;
                return;
            }
            currentNode = currentNode.nextNode;
        }
    }

    public void printAll(){
        if (isEmpty()){
            System.out.println("List is Empty!!!");
            return;
        }
        Node currentNode = this.headNode;

        while(currentNode.nextNode != null){
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.nextNode;
        }
        System.out.println(currentNode.data + " -> null ");
    }

    public void printFromLast(){
        if (isEmpty()){
            System.out.println("List is Empty!!!");
            return;
        }
        Node currentNode = this.tailNode;

        while(currentNode.prevNode != null){
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.prevNode;
        }
        System.out.println(currentNode.data + " -> null ");
    }

    //Method to get the count of number of nodes in a double linked list.
    public int length(){
        int count = 0;
        if (isEmpty()){
            return count;
        }
        Node currentNode = headNode;
        while(currentNode != null){
            count++; 
            currentNode.nextNode = currentNode;
        }
        return count;
    }

    public static void main(String[] args){
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
        dll.printAll();
        for (int i = 0; i <= 10; i++){
            //dll.insertAtHead(i);
            dll.insertAtEnd(i);
        }
        dll.printAll();
        dll.printFromLast();
        dll.insertAfter(11, 5);
        dll.printAll();
        //dll.printFromLast();
        dll.deleteAtHead();
        dll.printAll();
        dll.delete(3);
        dll.delete(12);
        dll.printAll();
    }
}