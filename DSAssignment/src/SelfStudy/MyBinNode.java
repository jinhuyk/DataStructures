package SelfStudy;

import java.util.ArrayList;

public class MyBinNode extends MyNode {

    MyBinNode(){super();
        ArrayList n = new ArrayList();
        n.add(null);
        n.add(null);
    setChildren(n);

    }
    MyBinNode(Object e){super(e);
        ArrayList n = new ArrayList();
        n.add(null);
        n.add(null);
        setChildren(n);}
    public MyBinNode left() {
        return (MyBinNode) children().get(0);
    }
    public MyBinNode right() {
        return (MyBinNode) children().get(1);
    }
    public void setLeft( MyBinNode v){
        children().set(0,v);
    }
    public void setRight(MyBinNode v){
        children().set(1,v);
    }
}
