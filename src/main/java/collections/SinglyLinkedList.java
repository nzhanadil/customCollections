package collections;

import nodes.Node;

public class SinglyLinkedList {

    Node head;
    Node tail;
    int size;

    public void createSLL(int nodeValue){
        head = new Node();
        Node newNode = new Node();
        newNode.value = nodeValue;
        head = newNode;
        tail = newNode;
        size = 1;
    }

}
