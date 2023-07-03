package Assignment8;

import java.util.ArrayList;

public class MyHashTable {
    private ArrayList bucketArray;
    private int bucketCapacity;
    private  float loadFactor;
    private int n;
    MyHashTable(int initialCapacity){
        this(initialCapacity,(float)0.9);
    }
    MyHashTable(int initialCapacity, float loadFactor){
        bucketCapacity = initialCapacity;
        this.loadFactor = loadFactor;
        bucketArray = new ArrayList(bucketCapacity);
        for(int i =0;i<bucketCapacity;i++){
            bucketArray.add(new ArrayList());
        }
        n=0;
    }

    private void rehash(int capacity){
        bucketCapacity = capacity*2;
        ArrayList bigger =new ArrayList(bucketCapacity);
        for(int i =0;i<bucketCapacity;i++){
            bigger.add(new ArrayList());
        }
        for(Object list : bucketArray){
            if(list != null) {
                ArrayList l = (ArrayList) list;
                for (Object o : l) {
                    if (o != null) {

                        StudentInfo s = (StudentInfo) o;
                        String k = s.getStudentID();
                        String v = s.getStudentName();
                        ArrayList M = (ArrayList) bigger.get(hashFunc(k));
                        M.add(s);
                    }
                }
            }
        }
        bucketArray = bigger;
    }
    private int mod(int h){
        if(h % bucketCapacity>=0) return h % bucketCapacity;
        else return (h%bucketCapacity) + bucketCapacity;
    }
    public float getLoadFactor(){
        return loadFactor;
    }
    private int hashFunc(String k){
        int h = 0;
        for(int i =0;i<k.length();i++){
            h = (h << 5) | (h >>>27);
            h += (int) k.charAt(i);
        }
        return mod(h);
    }
    public int size(){
        return n;
    }
    public String get(String k){
        ArrayList M = (ArrayList) bucketArray.get(hashFunc(k));
        for(Object o : M){
            if(o!=null){
                StudentInfo s = (StudentInfo) o;
                if(s.getStudentID() == k) return s.getStudentName();
            }
        }
        return null;
    }
    public  String put(String k, String v){

        StudentInfo S = new StudentInfo();
        S.setStudentID(k);
        S.setStudentName(v);

        if((float)n/bucketCapacity >= loadFactor) rehash(bucketCapacity);

        ArrayList M = (ArrayList) bucketArray.get(hashFunc(k));
        for(Object o : M){
            if(o!=null){
                StudentInfo s = (StudentInfo) o;
                if(s.getStudentID() == k){
                    String t = s.getStudentName();
                    s.setStudentName(v);
                    return t;
                }
            }
        }
        n += 1;
        M.add(S);
        return null;
    }
    public String remove(String k){
        ArrayList M = (ArrayList) bucketArray.get(hashFunc(k));
        for(Object o : M){
            if(o!=null){
                StudentInfo s = (StudentInfo) o;
                if(s.getStudentID() == k){
                    String t = s.getStudentName();
                    M.remove(o);
                    n -=1;
                    return t;
                }
            }
        }
        return null;
    }
    public static void main(String[] args){
        MyHashTable H = new MyHashTable(13,(float) 0.9);
        H.put("202210748","mun");
        H.put("202210123","kim");
        H.put("202210234","lee");
        H.put("202210333","park");
        H.put("202210111","choi");
        H.put("202110758","shin");
        H.put("202010718","oh");
        H.put("202210128","go");
        H.put("202211128","jane");
        H.put("202212458","ho");
        H.put("202218881","choi1");
        H.put("202167676","shin1");
        H.put("202456765","oh1");
        H.put("202298653","go1");
        H.put("202243256","jane1");
    }
}
