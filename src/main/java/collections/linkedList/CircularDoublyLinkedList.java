package collections.linkedList;

import nodes.DoublyNode;

public class CircularDoublyLinkedList {

    private DoublyNode head;
    private DoublyNode tail;
    private int size;

    public CircularDoublyLinkedList() {
        size = 0;
    }

    public void add(int e, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }

        DoublyNode newNode = new DoublyNode();
        newNode.value = e;

        if (head == null) {
            newNode.next = newNode.prev = newNode;
            head = tail = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            tail.next = newNode;
            newNode.prev = tail;
            head = newNode;
        } else if (index == size - 1) {
            head.prev = newNode;
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            tail = newNode;
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < index - 1; i++) {
                tempNode = tempNode.next;
            }
            newNode.next = tempNode.next;
            newNode.next.prev = newNode;
            tempNode.next = newNode;
            newNode.prev = tempNode;
        }
        size++;
    }

    public void add(int e) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = e;

        if (head == null) {
            newNode.next = newNode.prev = newNode;
            head = tail = newNode;
        } else {
            head.prev = newNode;
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            tail = newNode;
        }
        size++;
    }

    public int get(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        DoublyNode tempNode = head;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode.value;
    }

    public int indexOf(int e) {
        DoublyNode tempNode = head;
        for (int i = 0; i < size; i++) {
            if (tempNode.value == e) {
                return i;
            }
            tempNode = tempNode.next;
        }
        return -1;
    }

    public int remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }

        int value = 0;

        if (size == 1) {
            value = head.value;
            head.next = head.prev = null;
            head = tail = null;
        } else if (index == 0) {
            value = head.value;
            head = head.next;
            tail.next = head;
            head.prev = tail;
        } else if (index == size - 1) {
            value = tail.value;
            tail = tail.prev;
            head.prev = tail;
            tail.next = head;
        } else {
            DoublyNode tempNode = head;
            value = tempNode.next.value;
            for (int i = 0; i < index - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
        }
        size--;
        return value;
    }

    public boolean contains(int e) {
        DoublyNode tempNode = head;
        for (int i = 0; i < size; i++) {
            if (tempNode.value == e) {
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }

    public void print() {
        if (head != null) {
            DoublyNode tempNode = head;
            System.out.print("[");
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(", ");
                }
                tempNode = tempNode.next;
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public void reversedPrint() {
        if (head != null) {
            DoublyNode tempNode = tail;
            System.out.print("[");
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(", ");
                }
                tempNode = tempNode.prev;
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public void delete() {
        if (head != null) {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++) {
                tempNode.prev = null;
                tempNode = tempNode.next;
            }

            head = tail = null;
            size = 0;
        }
    }

    public int size() {
        return size;
    }
}
