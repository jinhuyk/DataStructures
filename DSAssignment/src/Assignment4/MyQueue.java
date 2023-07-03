package Assignment4;

public class MyQueue {
    private MyArrayList queue;

    public static void main(String[] args){
        MyQueue queue = new MyQueue();
        for(int i = 1;i<=10;i++){
            queue.enqueue(i);
        }
        for(int i = 1;i<=10;i++){
            System.out.println(queue.dequeue());
        }
    }
    public MyQueue(){
        queue = new MyArrayList();
    }
    public void enqueue(Object e){
        queue.add(queue.size(),e);
    }
    public Object dequeue(){
        if(queue.isEmpty())throw new EmptyQueueException();
        return queue.remove(0);
    }
    public Object front(){
        if(queue.isEmpty())throw new EmptyQueueException();
        return queue.get(0);
    }
    public int size(){
        return queue.size();
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
