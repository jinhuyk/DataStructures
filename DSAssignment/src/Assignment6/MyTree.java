package Assignment6;

import java.util.ArrayList;
public class MyTree {
    private MyNode root;
    private int size;
    public MyTree(){
        this.root = null;
        this.size = 0;
    }
    public MyTree(Object e){
        root = new MyNode(e);
        this.size = 1;
    }
    public int size() {
        return this.size;
    }
    public MyNode root() {
        return root;
    }
    public ArrayList children(MyNode v){
        return v.children();
    }
    public boolean isExternal (MyNode v){
        return v.children().isEmpty();
    }
    public MyNode addRoot(Object e){
        MyNode old = this.root;
        this.root = new MyNode(e);
        size = 1;
        return old;
    }
    public MyNode addNode(Object e){
        MyNode newNode = new MyNode(e);
        newNode.setParent(this.root);
        root.children().add(newNode);
        size++;
        return newNode;


    }
    public MyNode addChild(MyNode v, Object e) {
        MyNode newNode = new MyNode(e);
        newNode.setParent(v);
        v.children().add(newNode);
        size++;
        return newNode;
    }
    public MyNode addChild(MyNode v, int i , Object e){
        MyNode newNode = new MyNode(e);
        newNode.setParent(v);
        v.children().add(i,newNode);

        size++;
        return newNode;
    }
    public MyNode setChild(MyNode v, int i, Object e){
        MyNode newNode = new MyNode(e);
        newNode.setParent(v);
        v.children().set(i,newNode);
        return v;
    }
    public MyNode removeChild(MyNode v, int i) {
        this.size--;
        return (MyNode) v.children().remove(i);
    }

    public boolean isRoot(MyNode v){
        if(this.root ==v ) return true;
        else return false;
    }
    public int depth(MyNode v){
        if(this.isRoot(v)) return 0;
        else return 1+ depth( v.parent());
    }
}
