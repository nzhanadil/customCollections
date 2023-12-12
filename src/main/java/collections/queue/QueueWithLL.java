package collections.queue;

import collections.linkedList.SinglyLinkedList;

public class QueueWithLL {

    SinglyLinkedList sll;

    public QueueWithLL() {
        this.sll = new SinglyLinkedList();
    }

    public boolean isEmpty() {
        return sll.head == null;
    }

    public void enqueue(int e) {
        sll.add(e, 0);
    }

    public int dequeue() {
        return sll.remove(0);
    }

    public int peek() {
        return sll.get(0);
    }

    public void delete() {
        sll.delete();
    }
}
