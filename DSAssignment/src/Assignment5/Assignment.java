package Assignment5;


import java.util.ArrayList;

public class Assignment {
    public static void main(String[] args){

        MyTree Tree1 = new MyTree();

        Tree1.addRoot("Computers'R Us");
        MyNode node1 = Tree1.addChild(Tree1.root(),"Sales");
        MyNode node2 = Tree1.addChild(Tree1.root(),"Manufacturing");
        Tree1.addChild(Tree1.root(),"R&D");
        Tree1.addChild(node1,"US");
        MyNode node5 = Tree1.addChild(node1,"International");
        Tree1.addChild(node2,"Desktops");
        Tree1.addChild(node2,"Laptops");
        Tree1.addChild(node5,"Europe");
        Tree1.addChild(node5,"Asia");
        Tree1.addChild(node5,"Canada");

        System.out.println("실습3");
        PrintTree(Tree1);
        System.out.println('\n');
        System.out.println("실습4-1");
        MyTree Tree2 = new MyTree();
        Tree2.addRoot("Make Money Fast!");
        MyNode n1 = Tree2.addChild(Tree2.root(), "1. Motivations");
        MyNode n2 = Tree2.addChild(Tree2.root(), "2. Methods");
        Tree2.addChild(n1, "1.1 Greed");
        Tree2.addChild(n1, "1.2 Avidity");
        Tree2.addChild(n2, "2.1 Stock Fraud");
        Tree2.addChild(n2, "2.2 Ponzi Scheme");
        Tree2.addChild(n2, "2.3 Bank Robbery");
        Preorder(Tree2, Tree2.root());

        System.out.println('\n');
        System.out.println("실습4-2");
        MyTree Tree3 = new MyTree();
        Tree3.addRoot(new Object[]{"cs16/",null});
        MyNode nn1 = Tree3.addChild(Tree3.root(),new Object[]{"homeworks/",null});
        MyNode nn2 = Tree3.addChild(Tree3.root(),new Object[]{"programs/",null});
        Tree3.addChild(Tree3.root(),new Object[]{"todo.txt",1});
        Tree3.addChild(nn1,new Object[]{"h1c.doc",3});
        Tree3.addChild(nn1,new Object[]{"h1nc.doc",2});
        Tree3.addChild(nn2,new Object[]{"DDR.java",10});
        Tree3.addChild(nn2,new Object[]{"Stocks.java",25});
        Tree3.addChild(nn2,new Object[]{"Robot.java",20});
        Postorder(Tree3.root());
    }
    static void PrintTree(MyTree Tree){
        ArrayList<MyNode> queue = new ArrayList();
        ArrayList<Integer> sd = new ArrayList(Tree.size());
        queue.add(Tree.root());
        int count = -1;
        while(!queue.isEmpty()){
            if(count-Tree.depth(queue.get(0))!=0){
                count++;
                System.out.println("\n");
                System.out.println("[Level "+count+"]");
            }else{
                System.out.print(", ");
            }
            for(Object e : queue.get(0).children())
                queue.add((MyNode)e);
            System.out.print(queue.get(0).element());

            queue.remove(0);
        }
        System.out.println("\n");
        System.out.println("* Tree size = Total "+Tree.size()+" Nodes");
    }

    static void Preorder(MyTree T,MyNode v){
        for (int i = 0; i<T.depth(v);i++){
            System.out.print(" ");
        }
        System.out.println(v.element());
        for(Object i : v.children()){
            Preorder(T,(MyNode) i);
        }
    }

    static void Postorder(MyNode v){
        for (Object i : v.children()){
            Postorder((MyNode) i);
        }
        if(!v.children().isEmpty()){
            Object[] vv = (Object[]) v.element();
            int kb = 0;
            for(Object i : v.children()){
                MyNode e = (MyNode) i;
                Object[] element = (Object[]) e.element();
                kb += (Integer)element[1];
            }
            vv[1] = kb;
            System.out.println(vv[0]+"="+vv[1]+"KB");
        }
    }
}

