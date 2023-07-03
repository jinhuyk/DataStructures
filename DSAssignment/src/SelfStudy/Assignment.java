package SelfStudy;


public class Assignment {
    public static void main(String[] args) {

        MyBinTree Tree = new MyBinTree();
        Tree.addRoot("+");
        MyBinNode node1 = Tree.insertLeft(Tree.root(),"*");
        MyBinNode node2 = Tree.insertRight(Tree.root(),"*");
        Tree.insertLeft(node1,2);
        MyBinNode node3 =Tree.insertRight(node1,"-");
        Tree.insertLeft(node3,3);
        Tree.insertRight(node3,1);
        Tree.insertLeft(node2,3);
        Tree.insertRight(node2,2);

        System.out.println("실습 3");
        System.out.println();
        printExpr(Tree.root());
        System.out.println();
        System.out.println("= "+ evalExpr(Tree.root()));

        printExprEuler e = new printExprEuler();
        e.eulerTour(Tree,Tree.root());

    }
    static class printExprEuler extends EulerTour{

        @Override
        protected void visitExternal(MyBinTree T, MyBinNode p) {
        }

        @Override
        protected void visitLeft(MyBinTree T, MyBinNode p) {
            System.out.print("(");
        }

        @Override
        protected void visitBelow(MyBinTree T, MyBinNode p) {
            System.out.print(p.element());
        }

        @Override
        protected void visitRight(MyBinTree T, MyBinNode p) {
            System.out.print(")");
        }
    }
    static int evalExpr(MyBinNode v){
        if(v == null) return 0;
        if(v.left()==null && v.right()==null){
            return (Integer) v.element();
        }
        int op1 = evalExpr(v.left());
        int op2 = evalExpr(v.right());
        switch ((String) v.element()){
            case "+": return op1 + op2;
            case "-": return op1 - op2;
            case "*": return op1 * op2;
            case "/": return op1 / op2;
        }

        return 0;
    }
    static void printExpr(MyBinNode v){
        if(v == null) return;
        if(v.left()!=null){
            System.out.print("(");
            printExpr(v.left());
        }

        System.out.print(v.element());
        if(v.right()!=null){
            printExpr(v.right());
            System.out.print(")");
        }

    }

}
