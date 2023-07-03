package Assignment14;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class MyMergeSort {
    private ArrayList L1;
    private ArrayList L2;
    private Comparator comp;

    MyMergeSort(Comparator c){
        this.comp = c;
    }

    public void sort(ArrayList l){
        int now = 0, n = l.size();
        L1 = new ArrayList(l);
        L2 = new ArrayList(l);

        for(int i = 1;i<n;i*=2){
            for(int j = 0;j<n;j+=2*i) merge((now==0)?L1:L2,(now==0)?L2:L1,j,i);
            now = (now == 0)?1:0;
        }
        l.clear();
        for(int i =0;i<n;i++) l.add(i, (now==1)?L2.get(i):L1.get(i));

    }
    private void merge(ArrayList in, ArrayList o,int s, int c){
        int end1 = Math.min(s+c,in.size()),end2 = Math.min(s+2*c,in.size());
        int x = s, y = s+c,z = s;
        int i = 0;

        while(x < end1 && y < end2) o.set(z++, in.get((comp.compare(in.get(x), in.get(y))<0)?x++:y++));
        if(x<end1) while(i < end1 - x) o.set(z++,in.get((i++)+x));
        else if(y<end2) while(i < end2 - y) o.set(z++,in.get((i++)+y));
    }
    public Comparator setComparator(Comparator c){
        Comparator old = this.comp;
        this.comp = c;
        return old;
    }

    public static void main(String args[]){
        MyMergeSort IntegerSort = new MyMergeSort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if((int) o1 < (int) o2 ) return -1;
                else return 1;
            }
        });
        MyMergeSort StringSort = new MyMergeSort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String s1 = (String) o1;
                return s1.compareTo((String)o2);
            }
        });
        ArrayList list1 = new ArrayList();
        for(int i = 0;i<20;i++){
            list1.add((int)(Math.random() * 99)+1);
        }
        System.out.println(list1);
        IntegerSort.sort(list1);
        System.out.println(list1);

        ArrayList list2 = new ArrayList();
        String str= "In computer science, a data structure is a data organization, management, and storage format that enables efficient access and modification. More precisely, a data structure is a collection of data values, the relationships among them, and the functions or operations that can be applied to the data.";
        String[] strArr = str.split(" ");
        for(String s : strArr){
            String repair = s.replaceAll(",|\\.","");
            list2.add(repair);
        }
        System.out.println(list2);
        StringSort.sort(list2);
        System.out.println(list2);




    }
}
