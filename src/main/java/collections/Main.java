package collections;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.createSLL(4);
        System.out.println(sll.tail.value);
    }
}
