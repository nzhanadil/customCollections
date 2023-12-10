package collections.linkedList;

import nodes.Node;

public class CircularSinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public CircularSinglyLinkedList() {
        this.size = 0;
    }

    public void add(int e, int index) {
        Node newNode = new Node();
        newNode.value = e;

        if (head == null) {
            newNode.next = newNode;
            head = newNode;
            tail = newNode;
        } else if (index == 0) {
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        } else if (index >= size) {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        } else {
            Node tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }
            newNode.next = tempNode.next;
            tempNode.next = newNode;
        }
        size++;
    }

    public void add(int e) {
        Node newNode = new Node();
        newNode.value = e;

        if (head == null) {
            newNode.next = newNode;
            head = newNode;
        } else {
            newNode.next = head;
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public int get(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        Node tempNode = head;

        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }

        return tempNode.value;
    }

    public int indexOf(int e) {
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            if(tempNode.value == e){
                return i;
            }
            tempNode = tempNode.next;
        }
        return -1;
    }

    public int remove(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        int value = 0;
        if (size == 1) {
            value = head.value;
            head.next = head = tail = null;
        } else if (index == 0) {
            value = head.value;
            head = head.next;
            tail.next = head;
        } else if (index == size - 1) {
            Node tempNode = head;
            for (int i = 0; i < index - 1; i++) {
                tempNode = tempNode.next;
            }
            value = tempNode.next.value;
            tempNode.next = head;
            tail = tempNode;
        } else {
            Node tempNode = head;
            for (int i = 0; i < index - 1; i++) {
                tempNode = tempNode.next;
            }
            value = tempNode.next.value;
            tempNode.next = tempNode.next.next;
        }
        size--;
        return value;
    }

    public boolean contains(int object) {
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            if (tempNode.value == object) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        if (head != null) {
            System.out.print("[");
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                tempNode = tempNode.next;
                if (i != size - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public void delete() {
        if (head != null) {
            head = tail = tail.next = null;
            size = 0;
        }
    }

    public int size() {
        return size;
    }
}
