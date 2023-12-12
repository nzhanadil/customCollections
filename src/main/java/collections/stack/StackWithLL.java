package collections.stack;

import collections.linkedList.SinglyLinkedList;

public class StackWithLL {

    SinglyLinkedList ll;

    public StackWithLL() {
        ll = new SinglyLinkedList();
    }

    public boolean isEmpty() {
        return ll.head == null;
    }

    public void push(int e) {
        ll.add(e, 0);
    }

    public int pop() {
        return ll.remove(0);
    }

    public int peek() {
        return ll.get(0);
    }

    public void delete() {
        ll.delete();
    }
}