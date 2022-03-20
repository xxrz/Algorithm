package class4_tree;

import java.util.*;

public class travelTree {
    //结构
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }


    public static void preOrderRecur(PrintTree.Node head){
        if(head==null){
//            System.out.print("null");
            return;
        }

        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(PrintTree.Node head){
        if(head==null){
//            System.out.print("null");
            return;
        }

        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    public static void posOrderRecur(PrintTree.Node head){
        if(head==null){
//            System.out.print("null");
            return;
        }

        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    public static void preOrderUnRecur(PrintTree.Node head) {
        if(head==null) return;
        Stack<PrintTree.Node> stack = new Stack<>();
        stack.add(head);
        while(!stack.isEmpty()){
            PrintTree.Node cur = stack.pop();
            System.out.print(cur.value + " ");

            if(cur.right!=null){
                stack.add(cur.right);
            }

            if(cur.left!=null){
                stack.add(cur.left);
            }
        }
    }

    public static void posOrderUnRecur(PrintTree.Node head) {
        if(head == null) return;

        Stack<PrintTree.Node> s1 = new Stack<>();
        Stack<PrintTree.Node> s2 = new Stack<>();

        s1.add(head);
        while(!s1.isEmpty()) {
            PrintTree.Node cur = s1.pop();
            s2.add(cur);

            if (cur.left != null) {
                s1.add(cur.left);
            }

            if (cur.right != null) {
                s1.add(cur.right);
            }
        }

        while(!s2.isEmpty()){
            System.out.print(s2.pop().value + " ");
        }
    }

    public static void inOrderUnRecur1(PrintTree.Node head) {
        if(head==null) return;
        Stack<PrintTree.Node> stack = new Stack<>();
        stack.add(head);

        //左边界入栈
        while(head.left!=null){
            stack.add(head.left);
            head = head.left;
        }

        //
        while(!stack.isEmpty()){
            PrintTree.Node cur = stack.pop();
            System.out.print(cur.value + " ");

            //对右子树做相同操作
            PrintTree.Node right = cur.right;

            while(right!=null){
                stack.add(right);
                right = right.left;
            }
        }

    }

    public static void inOrderUnRecur2(PrintTree.Node head) {
        if(head!=null){
            Stack<PrintTree.Node> stack = new Stack<>();

            while(!stack.isEmpty() || head!=null){
                if(head!=null) {
                    stack.add(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
    }

    public static void BFS(PrintTree.Node head){
        if(head==null) return;

        Queue<PrintTree.Node> queue = new LinkedList<>();
        queue.add(head);

        while(!queue.isEmpty()){
            PrintTree.Node cur = queue.poll();
            System.out.print(cur.value + " ");

            if(cur.left!=null){
                queue.add(cur.left);
            }

            if(cur.right!=null){
                queue.add(cur.right);
            }
        }
    }


    //随机建树
    public static PrintTree.Node generate(int level,int maxlevel,int maxvalue){
        //节点一半概率为空，一半不为空
        if(level > maxlevel || Math.random()< 0.1){
            return null;
        }

        PrintTree.Node node = new PrintTree.Node((int)(Math.random()*maxvalue));
        node.left = generate(level+1,maxlevel,maxvalue);
        node.right = generate(level+1,maxlevel,maxvalue);

        return node;
    }

    public static void main(String[] args) {
        int maxLevel = 3;
        int maxValue = 30;
        PrintTree.Node head = generate(1,maxLevel,maxValue);
//        preOrderRecur(head);
//        System.out.println();
//        inOrderRecur(head);
//        System.out.println();
//        posOrderRecur(head);

        //非递归
//        preOrderUnRecur(head);
//        System.out.println();

//        posOrderUnRecur(head);
//        System.out.println();

//        inOrderUnRecur1(head);
//        System.out.println();
//        inOrderUnRecur2(head);
//        System.out.println();

        //宽度优先遍历
        BFS(head);
        System.out.println();

        PrintTree tree = new PrintTree();
        tree.printTree(head);
    }
}
