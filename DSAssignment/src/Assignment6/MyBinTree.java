package Assignment6;


public class MyBinTree extends MyTree {

    private MyBinNode root;
    private int size;
    MyBinTree() {
        super();
    }

    MyBinTree(Object e) {
        super(e);
    }
    private void Preorder(MyBinNode v ){
        size++;
        for(Object i : v.children()){
            Preorder((MyBinNode) i);
        }
    }


    public Boolean isEmpty(){
        Preorder(root);
        return size==0;

    }
    public boolean isRoot(MyBinNode v){
        if(this.root ==v ) return true;
        else return false;
    }
    public boolean isInternal(MyBinNode v){
        return !this.isExternal(v);
    }
    public boolean isExternel(MyBinNode v){
        return v.children().isEmpty();
    }
    public MyBinNode root(){
        return this.root;
    }
    public MyBinNode parent(MyBinNode v){
        return (MyBinNode) v.parent();
    }
    public MyBinNode left(MyBinNode v){
        return (MyBinNode) v.left();
    }
    public MyBinNode right(MyBinNode v){
        return (MyBinNode) v.right();
    }
    public boolean hasLeft(MyBinNode v){
        return v.left()!=null;
    }
    public boolean hasRight(MyBinNode v){
        return v.right()!=null;
    }
    public MyBinNode addRoot(Object e){
        MyBinNode old = this.root;
        this.root = new MyBinNode(e);
        return old;
    }
    public MyBinNode addNode(Object e){
        MyBinNode newNode = new MyBinNode(e);
        newNode.setParent(this.root);
        root.children().add(newNode);
        return newNode;
    }
    public MyBinNode insertLeft(MyBinNode v, Object e){
        MyBinNode newNode = new MyBinNode(e);
        newNode.setParent(v);
        v.setLeft(newNode);
        return newNode;
    }
    public MyBinNode insertRight(MyBinNode v, Object e){
        MyBinNode newNode = new MyBinNode(e);
        newNode.setParent(v);
        v.setRight(newNode);
        return newNode;
    }
    public Object replace(MyBinNode v, Object e){
        Object old = v.element();
        v.setElement(e);
        return old;
    }
    public MyBinNode remove(MyBinNode v) {
        MyBinNode old = v;
        if (this.hasLeft(v) && this.hasRight(v))
            throw new TwoChildrenException();

        if (this.hasLeft(v)){
            MyBinNode parent = (MyBinNode) v.parent();
            MyBinNode child = v.left();
            if(parent.left() == v) parent.setLeft(child);
            else if(parent.right() == v) parent.setRight(child);
            v.setParent(null);
        }
        else if (this.hasRight(v)){
            MyBinNode parent = (MyBinNode) v.parent();
            MyBinNode child = v.right();
            if(parent.left() == v) parent.setLeft(child);
            else if(parent.right() == v) parent.setRight(child);
            v.setParent(null);
        }
        else{
            MyBinNode parent = (MyBinNode) v.parent();
            if(parent.left() == v) parent.setLeft(null);
            else if(parent.right() == v) parent.setRight(null);
            v.setParent(null);
        }
        return v;
    }

    public void attach(MyBinNode v, MyBinNode t1, MyBinNode t2) {
        if(!isExternel(v)) throw new NotExternalException();
        v.setLeft(t1);
        v.setRight(t2);
    }
}

