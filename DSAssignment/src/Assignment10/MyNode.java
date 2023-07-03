package Assignment10;

import java.util.ArrayList;

public class MyNode {
    private Object element;
    private MyNode parent;
    private ArrayList children;

    MyNode(){
        element =null;
        parent = null;
        children = null;
    }
    MyNode(Object e){
        element = e;
        parent = null;
        children = new ArrayList();
        this.children.add(null);
        this.children.add(null);
    }
    public Object element(){return this.element;}
    public MyNode parent(){return this.parent;}
    public ArrayList children(){return this.children;}
    public int degree(){
        return children.size();
    }
    public void setElement(Object e){element = e;}
    public void setParent(MyNode p){parent = p;}
    public void setChildren(ArrayList c){children = c;}

}
