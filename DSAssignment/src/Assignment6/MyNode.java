package Assignment6;

import java.util.ArrayList;

public class MyNode {
    private Object element;
    private MyNode parent;
    private ArrayList children;

    MyNode(){
        element = null;
        parent = null;
        children = null;
    }
    MyNode(Object e){
        element = e;
        parent = null;
        children = new ArrayList();
    }

    public Object element() {
        return this.element;
    }
    public MyNode parent(){
        return this.parent;
    }
    public ArrayList children(){
        return this.children;
    }
    public int degree() {
        return this.children.size();
    }
    public void setElement(Object e){
        this.element = e;
    }
    public void setParent(MyNode p){
        this.parent = p;
    }
    public void setChildren(ArrayList e){
        this.children = e;
    }
}
