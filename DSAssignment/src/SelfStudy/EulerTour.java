package SelfStudy;

public abstract class EulerTour {
    protected MyBinTree tree;
    protected abstract void visitExternal(MyBinTree T, MyBinNode p);
    protected abstract void visitLeft(MyBinTree T, MyBinNode p);
    protected abstract void visitBelow(MyBinTree T, MyBinNode p);
    protected abstract void visitRight(MyBinTree T, MyBinNode p);

    protected void eulerTour(MyBinTree T, MyBinNode p){
        if (T.isExternel(p)) visitExternal(T,p);
        visitLeft(T,p);
        if(T.hasLeft(p)) eulerTour(T,p.left());
        visitBelow(T,p);
        if (T.hasRight(p)) eulerTour(T,p.right());
        visitRight(T,p);
    }
}
