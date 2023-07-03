package Assignment7;

import java.util.ArrayList;
import java.util.Comparator;

public class MyPQ {
    Comparator comp;
    int initialCapacity;
    ArrayList PQ;
    MyPQ(Comparator comp){
        this.initialCapacity = 10;
        this.PQ = new ArrayList(this.initialCapacity);
        this.comp = comp;
    }
    MyPQ(int initialCapacity, Comparator comp){
        this.initialCapacity = initialCapacity;
        this.PQ = new ArrayList(this.initialCapacity);
        this.comp = comp;
    }
    public int size() {
        return this.PQ.size();
    }
    public boolean isEmpty(){
        return this.PQ.isEmpty();
    }
    public MyEntry insert(Object k, Object v){
        MyEntry e = new MyEntry();
        e.setKey(k);
        e.setValue(v);
        this.PQ.add(e);
        this.PQ.sort(this.comp);
        return e;
    }
    public MyEntry removeMin() {
        if(this.PQ.isEmpty()) throw new PQEmptyException();
        else{
            MyEntry e = (MyEntry) this.PQ.get(0);
            this.PQ.remove(0);
            return e;
        }

    }
    public MyEntry min() {
        if(this.PQ.isEmpty()) throw new PQEmptyException();
        else return  (MyEntry) this.PQ.get(0);
    }
}
