package Assignment10;

public class MyBinTree extends MyTree{
    MyBinTree(){
        super();
    }
    MyBinTree(Object e){super(e);}

    public Boolean isEmpty(){
        return size()==0;
    }
    public boolean isRoot(MyBinNode v){
        return v.parent()==null;
    }
    public boolean isExternal(MyBinNode v) {
        if(!this.hasLeft(v) && !this.hasRight(v))
            return true;
        else
            return false;
    }
    public boolean isInternal(MyBinNode v){
        return !this.isExternal(v);
    }
    public MyBinNode root() {
        return (MyBinNode)super.root();
    }
    public MyBinNode parent(MyBinNode v){
        return (MyBinNode) v.parent();
    }
    public MyBinNode left (MyBinNode v) {
        return (MyBinNode)v.children().get(0);
    }

    public MyBinNode right (MyBinNode v) {
        return (MyBinNode)v.children().get(1);
    }
    public boolean hasLeft (MyBinNode v) {
        return v.children().get(0) != null;
    }

    public boolean hasRight (MyBinNode v) {
        return v.children().get(1) != null;
    }
    public MyBinNode addRoot(Object e){
        return (MyBinNode) super.addRoot(e);
    }
    public MyBinNode addNode(Object e){
        return (MyBinNode) super.addNode(e);
    }
    public MyBinNode insertLeft(MyBinNode v, Object e){
        MyBinNode node = new MyBinNode(e);
        node.setParent(v);
        this.addChild(v,0,e);
        return node;
    }
    public MyBinNode insertRight(MyBinNode v, Object e){
        MyBinNode node = new MyBinNode(e);
        node.setParent(v);
        this.addChild(v,1,e);
        return node;
    }
    public Object replace(MyBinNode v, Object e){
        Object old = v.element();
        v.setElement(e);
        return old;
    }
    public MyBinNode remove (MyBinNode v) throws TwoChildrenException{
        if(v.degree()==2) throw new TwoChildrenException("TwoChildren Exception");
        if(v.degree()==0) {
            if(this.left((MyBinNode) v.parent()) == v)this.removeChild(v.parent(),0);
            else if(this.right((MyBinNode) v.parent()) == v) this.removeChild(v.parent(),1);
        }
        if(v.degree()==1){
            if(this.left((MyBinNode) v.parent()) == v){
                this.removeChild(v.parent(),0);
                this.insertLeft((MyBinNode) v.parent(), this.hasLeft(v) ? v.left():v.right() );
            }
            else if(this.right((MyBinNode) v.parent()) == v){
                this.removeChild(v.parent(),1);
                this.insertRight((MyBinNode) v.parent(), this.hasLeft(v) ? v.left():v.right() );
            }
        }
        v.setParent(null);
        return v;
    }

    public void attach(MyBinNode v, MyBinNode t1, MyBinNode t2) throws NotExternalException{
        if(!this.isExternal(v)) throw new NotExternalException("no");
        else{
            this.insertLeft(v,t1.element());
            this.insertRight(v,t2.element());
        }
    }
    public void inOrder(MyBinNode v) {

        if(this.hasLeft(v)) {
            inOrder(this.left(v));
        }

        System.out.print(v.element()+"-");

        if(this.hasRight(v)) {
            inOrder(this.right(v));
        }
    }
    static class TwoChildrenException extends Exception {

        TwoChildrenException(String msg){
            super(msg);
        }

    }

    class NotExternalException extends Exception {

        NotExternalException(String msg){
            super(msg);
        }
    }
}
