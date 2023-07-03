package Assignment4;

public class MyArrayList {

    Object[] list;
    private int size;

    public MyArrayList(){
        list = new Object[4];
        size=0;
    }
    public Object get(Integer i){
        if(i < 0 || i > size-1){
            throw new IndexOutOfBoundsException();
        }
        return list[i];
    }
    public Object set(Integer i , Object e){
        if(i < 0 || i > size-1){
            throw new IndexOutOfBoundsException();
        }
        Object old = get(i);
        list[i] = e;
        return old;
    }
    public void add(Integer i,Object e){

        if( size >= list.length){
            Object[] bigger = new Object[list.length*2];
            System.arraycopy(list,0,bigger,0,list.length);
            list = bigger;
        }
        for(int j = size;j>i;j--){
            list[j] = list[j-1];
        }
        list[i] = e;
        size++;
    }
    public Object remove(Integer i){
        if(i < 0 || i > size-1){
            throw new IndexOutOfBoundsException();
        }
        Object old = get(i);
        for(int j = i;j<size();j++){
            list[j] = list [j+1];
        }
        size--;
        return old;
    }
    public Integer size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
}
