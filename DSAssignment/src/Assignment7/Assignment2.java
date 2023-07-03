package Assignment7;

import java.awt.*;
import java.util.Comparator;

public class Assignment2 {
    public static class PointComparator implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {
            MyEntry e1 = (MyEntry) o1;
            MyEntry e2 = (MyEntry) o2;
            Point p1 = (Point) e1.getValue();
            Point p2 = (Point) e2.getValue();
            double dist_p1 = Math.sqrt(p1.x * p1.x + p1.y * p1.y);
            double dist_p2 = Math.sqrt(p2.x * p2.x + p2.y * p2.y);
            if(dist_p1 < dist_p2) return -1;
            else return 1;
        }
    }
    public static class PointComparator2 implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {
            MyEntry e1 = (MyEntry) o1;
            MyEntry e2 = (MyEntry) o2;
            Point p1 = (Point) e1.getValue();
            Point p2 = (Point) e2.getValue();
            double dist_p1 = Math.sqrt(p1.x * p1.x + p1.y * p1.y);
            double dist_p2 = Math.sqrt(p2.x * p2.x + p2.y * p2.y);
            if(dist_p1 > dist_p2) return -1;
            else return 1;
        }
    }
    public static void main(String[] args){
        MyPQ pq1 = new MyPQ(new PointComparator());
        pq1.insert("a",new Point(5,4));
        pq1.insert("b",new Point(2,7));
        pq1.insert("c",new Point(9,5));
        pq1.insert("d",new Point(3,1));
        pq1.insert("e",new Point(7,2));
        pq1.insert("f",new Point(9,7));
        pq1.insert("g",new Point(1,4));
        pq1.insert("h",new Point(4,3));
        pq1.insert("i",new Point(8,2));
        pq1.insert("j",new Point(4,8));
        System.out.println("[가까운 순서]");
        while(!pq1.isEmpty()) {
            MyEntry e = pq1.removeMin();
            Point p = (Point) e.getValue();
            System.out.println(e.getKey() + " (" +(int) p.getX()+","+(int)p.getY()+")" );
        }

        MyPQ pq2 = new MyPQ(new PointComparator2());
        pq2.insert("a",new Point(5,4));
        pq2.insert("b",new Point(2,7));
        pq2.insert("c",new Point(9,5));
        pq2.insert("d",new Point(3,1));
        pq2.insert("e",new Point(7,2));
        pq2.insert("f",new Point(9,7));
        pq2.insert("g",new Point(1,4));
        pq2.insert("h",new Point(4,3));
        pq2.insert("i",new Point(8,2));
        pq2.insert("j",new Point(4,8));
        System.out.println("[멀리 있는 순서]");
        while(!pq2.isEmpty()) {
            MyEntry e = pq2.removeMin();
            Point p = (Point) e.getValue();
            System.out.println(e.getKey() + " (" +(int) p.getX()+","+(int)p.getY()+")" );
        }
    }
}
