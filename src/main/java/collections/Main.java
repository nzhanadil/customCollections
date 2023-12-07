package collections;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        sll.add(2, 4);
        sll.add(3, 1);
        sll.add(6, 0);
        sll.add(11);
        sll.add(15);
        sll.remove(5);
        sll.print();
    }
}
