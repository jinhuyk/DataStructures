package Assignment7;

import java.util.Comparator;

public class IntComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        MyEntry e1 = (MyEntry) o1;
        MyEntry e2 = (MyEntry) o2;
        if((Integer)e1.getKey() < (Integer) e2.getKey()) return -1;
        else return 1;
    }
    public static void main(String[] args) {
        IntComparator c = new IntComparator();
        MyPQ pq = new MyPQ(c);

        pq.insert(new Integer(30),null);
        pq.insert(new Integer(10),null);
        pq.insert(new Integer(20),null);

        System.out.println(pq.removeMin().getKey());
        System.out.println(pq.removeMin().getKey());
        System.out.println(pq.removeMin().getKey());
    }
}

