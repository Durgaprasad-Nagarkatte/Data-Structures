class SinglyLinkedList<T> {
    //Node inner class for SLL
    public class Node {
        public T data;
        public Node nextNode;

    }

    public Node headNode; //head node of the linked list
    public int size;      //size of the linked list

    //Constructor - initializes headNode and size
    public SinglyLinkedList() {
        headNode = null;
        size = 0;
    }

    //Helper Function that checks if List is empty or not 
    public boolean isEmpty() {
        if (headNode == null) return true;
        return false;
    }

    //Inserts new data at the start of the linked list
    public void insertAtHead(T data) {
        //Creating a new node and assigning it the new data value
        Node newNode = new Node();
        newNode.data = data;
        //Linking head to the newNode's nextNode
        newNode.nextNode = headNode;
        headNode = newNode;
        size++;
    }

    public void insertAtEnd(T data){
        
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null;

        if (isEmpty()){
            insertAtHead(data);
            return;
        }
        Node lastNode = headNode;
        while (lastNode.nextNode != null){
            lastNode = lastNode.nextNode;
        }
        lastNode.nextNode = newNode;
        size++;
    }

    public void insertAfter(T data, T previous){
        Node newNode = new Node();
        newNode.data = data;

        if (isEmpty()){
            insertAtHead(data);
            return;
        }

        Node previousNode = headNode;
        while(previousNode != null && previousNode.data != previous){
            previousNode = previousNode.nextNode;
        }

        if(previousNode != null){
            newNode.nextNode = previousNode.nextNode;
            previousNode.nextNode = newNode;
            size++;
        }
    }

    // Helper Function to printList
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : ");
        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }
        System.out.println(temp.data.toString() + " -> null");
    }
}

public class ListDemo {
    public static void main( String args[] ) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.printList();
        for (int i = 1; i <= 10; i++) {
            //sll.insertAtHead(i);
            sll.insertAtEnd(i);
			sll.printList();
        }
        System.out.println(sll.size);
        sll.insertAfter(6, 6);
        sll.printList();
        System.out.println(sll.size);
        sll.insertAfter(7, 11);
        sll.printList();
        System.out.println(sll.size);
    }
}