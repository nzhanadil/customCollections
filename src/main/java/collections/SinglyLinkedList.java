package collections;

import nodes.Node;

public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        size = 0;
    }

    public void add(int e, int index) {
        if (head == null) {
            Node newNode = new Node();
            newNode.value = e;
            head = newNode;
            tail = newNode;
            size = 1;
        }
        Node newNode = new Node();
        newNode.value = e;

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else if (index >= size) {
            tail.next = newNode;
            tail = newNode;
        } else {
            Node tempNode = head;
            for (int i = 0; i < index - 1; i++) {
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
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public int get(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }

        Node tempNode = head;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                return tempNode.value;
            }
            tempNode = tempNode.next;
        }
        return -1;
    }

    public int remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        int value = -1;

        if (size == 1) {
            tail = head = null;
        } else if (index == 0) {
            value = head.value;
            head = head.next;
        } else if (index == size - 1) {
            Node tempNode = head;
            for (int i = 0; i < index - 1; i++) {
                tempNode = tempNode.next;
            }
            value = tempNode.next.value;
            tempNode.next = null;
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
            tempNode = tempNode.next;
        }
        return false;
    }

    public void print() {
        if (head != null) {
            System.out.print("[");
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(", ");
                }
                tempNode = tempNode.next;
            }
            System.out.println("]");
        }
    }

    public int size() {
        return size;
    }
}
