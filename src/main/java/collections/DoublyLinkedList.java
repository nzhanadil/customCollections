package collections;

import nodes.DoublyNode;

public class DoublyLinkedList {

    private DoublyNode head;
    private DoublyNode tail;
    private int size;

    public DoublyLinkedList() {
        size = 0;
    }

    public void add(int e, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        DoublyNode newNode = new DoublyNode();
        newNode.value = e;

        if (head == null) {
            head = tail = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (index == size - 1) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < index - 1; i++) {
                tempNode = tempNode.next;
            }

            newNode.next = tempNode.next;
            newNode.next.prev = newNode;
            newNode.prev = tempNode;
            tempNode.next = newNode;
        }
        size++;
    }

    public void add(int e) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = e;

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
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
            head = tail = null;
        } else if (index == 0) {
            value = head.value;
            head.next.prev = null;
            head = head.next;
        } else if (index == size - 1) {
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            DoublyNode tempNode = head;
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
