package collections;

import java.util.Arrays;

public class ArrayList {

    private int[] array;
    private int size;

    public ArrayList() {
        this.array = new int[10];
        this.size = 0;
    }

    public void add(int e, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }

        if (size + 1 == array.length) {
            array = Arrays.copyOf(array, (int) (array.length * 1.5));
        }

        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = e;
        size++;
    }

    public void add(int e) {
        if (size == array.length) {
            array = Arrays.copyOf(array, (int) (array.length * 1.5));
        }
        array[size] = e;
        size++;
    }

    public int get(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        return array[index];
    }

    public int remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }

        int el = array[index];

        for (int i = index; i < size; i++) {
            if (i != size - 1) {
                array[i] = array[i + 1];
            }
        }
        array[size - 1] = 0;

        size--;
        return el;
    }

    public boolean contains(int object) {
        for (int i = 0; i < size; i++) {
            if (array[i] == object) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    public int size() {
        return size;
    }
}
