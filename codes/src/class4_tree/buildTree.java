package class4_tree;

import java.util.LinkedList;

public class buildTree {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    static TreeNode head;
    public static void main(String[] args) {
        int[] nums = {1,2,4,-1,-1,5,-1,-1,3,-1,-1};
        LinkedList<TreeNode> q = new LinkedList<>();
        for(int num:nums){
            q.addLast(new TreeNode(num));
        }
        head = buildTree(q);
        preOrder(head);
    }


    public static TreeNode buildTree(LinkedList<TreeNode> q){
        if(q.isEmpty()) return head;

        TreeNode cur = q.removeFirst();

        if(cur.val==-1) return null;

        cur.left  = buildTree(q);
        cur.right = buildTree(q);

        return cur;
    }

    public static void preOrder(TreeNode head){
        if(head==null) return;

        System.out.println(head.val);
        preOrder(head.left);
        preOrder(head.right);
    }

}
