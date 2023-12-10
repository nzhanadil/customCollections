package collections.stack;

public class StackWithArray {

    int[] arr;
    int lastIndex;

    public StackWithArray(int size){
        this.arr = new int[size];
        lastIndex = -1;
    }

    public boolean isEmpty(){
        return lastIndex == -1;
    }

    public boolean isFull(){
        return lastIndex == arr.length-1;
    }

    public void push(int e){
        if(!isFull()){
            arr[++lastIndex] = e;
        }
    }

    public int pop(){
        if(!isEmpty()){
            return arr[lastIndex--];
        }
        return -1;
    }

    public int peek(){
        if(!isEmpty()){
            return arr[lastIndex];
        }
        return -1;
    }

    public void delete(){
        arr = null;
    }
}
