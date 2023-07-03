package Assignment4;

import java.util.EmptyStackException;

public class MyStack {
    private MyArrayList stack;

    public static void main(String[] args){
        MyStack stack = new MyStack();
        for(int i = 1;i<=10;i++){
            stack.push(i);
        }
        for(int i = 1;i<=10;i++){
            System.out.println(stack.pop());
        }
    }
    public MyStack(){
        stack = new MyArrayList();
    }
    public void push(Object e){
        stack.add(stack.size(),e);
    }
    public Object pop(){
        if(stack.isEmpty()) throw new EmptyStackException();
        return stack.remove(stack.size()-1);
    }
    public Object top(){
        if(stack.isEmpty()) throw new EmptyStackException();
        return stack.get(stack.size()-1);
    }
    public int size(){
        return stack.size();
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
