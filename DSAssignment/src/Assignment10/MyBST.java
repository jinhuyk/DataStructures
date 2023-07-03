package Assignment10;

import java.util.ArrayList;

public class MyBST extends MyBinTree{

    MyBST() {super();}
    MyBST(Object e){
        super(e);
    }

    private MyBinNode nextNode(MyBinNode v){
        MyBinNode node =null;
        if(this.hasRight(v)){
            node = this.right(v);
            while(true){
                if(!this.hasLeft(node)){
                    break;
                }
                node = this.left(node);
            }
        }
        return node;
    }

    public Object find(Object k) {

        MyBinNode temp = this.root();
        Object result = null;
        while(true) {

            if(temp == null) break;

            if((int)temp.element() == (int)k) {
                result = temp;
                break;
            }
            else if((int)temp.element() < (int)k) {
                temp = temp.right();
            }
            else {
                temp = temp.left();
            }

        }
        return result;
    }

    public ArrayList findAll(Object k){
        ArrayList arrList = new ArrayList();
        inOrderf(arrList, this.root(),k);
        return arrList;
    }
    public void inOrderf(ArrayList l ,MyBinNode v, Object k){
        if(this.hasLeft(v)) {
            inOrderf(l, this.left(v), k);
        }

        if((int)v.element() == (int)k)
            l.add(k);

        if(this.hasRight(v)) {
            inOrderf(l, this.right(v), k);
        }
    }
    public Object insert(Object k){
        MyBinNode w= this.root();
        while(true){
            if((int)w.element() == (int)k){
                if(this.hasLeft(w)) w = w.left();
                else if (this.hasLeft(w)) w = w.right();
                else break;
            }
            else if((int)w.element() < (int) k){
                if(!this.hasRight(w)){
                    this.insertRight(w,k);
                    break;
                }
                else{
                    w = w.right();
                }
            }
            else{
                if(!this.hasLeft(w)){
                    this.insertLeft(w,k);
                    break;
                }
                else{
                    w = w.left();
                }
            }
        }
        return w;
    }

    public Object remove(Object k) throws TwoChildrenException {
        MyBinNode r= this.root();
        Object rst = null;
        while(true){
            if(r == null) break;
            if((int)r.element() == (int)k){
                if(this.hasLeft(r) && this.hasRight(r)){
                    MyBinNode node = this.nextNode(r);
                    r.setElement(node.element());
                    MyBinNode parent = (MyBinNode) node.parent();
                    rst = super.remove(node);
                }
                else{
                    rst = super.remove(r);
                }
                break;
            }
            else if ((int)r.element() <(int) k){
                r = r.right();
            }
            else r = r.left();

        }
        return rst;
    }


    public static void main(String args[]) {
        MyBST bst = new MyBST(new Integer(6));
        bst.insert(new Integer(2));
        bst.insert(new Integer(9));
        bst.insert(new Integer(1));
        bst.insert(new Integer(4));
        bst.insert(new Integer(8));
        bst.insert(new Integer(9));

        System.out.println(bst.find(new Integer(8)));
        System.out.println(bst.find(new Integer(3)));
        bst.insert(new Integer(3));
        bst.insert(new Integer(7));
        bst.insert(new Integer(9));
        try {
            bst.remove(new Integer(1));
        } catch (TwoChildrenException e) {
            new TwoChildrenException("TwoChildrenException");
        }
        try {
            bst.remove(new Integer(4));
        } catch (TwoChildrenException e) {
            new TwoChildrenException("TwoChildrenException");
        }
        try {
            bst.remove(new Integer(6));
        } catch (TwoChildrenException e) {
            new TwoChildrenException("TwoChildrenException");
        }
        
        System.out.println(bst.find(new Integer(3)));
        System.out.println(bst.find(new Integer(6)));
        System.out.println(bst.findAll(new Integer(9)));
        bst.inOrder(bst.root());
    }
}
