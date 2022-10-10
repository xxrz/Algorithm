package test;

import class4_tree.buildTree;

import java.util.*;

public class test {

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
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        LinkedList<Integer> nums = new LinkedList<>();
        for(int i = 0;i < cnt;i++){
            nums.addLast(scanner.nextInt());
        }

        System.out.println(nums);
        head = buildTree(nums);
        preOrder(head);
    }

    public static void preOrder(TreeNode head){
        if(head==null) return;

        System.out.println(head.val);
        preOrder(head.left);
        preOrder(head.right);
    }

    private static TreeNode buildTree(LinkedList<Integer> nums) {
        if(nums.size()==0) return head;

        int val = nums.removeFirst();

        if(val==-1) return null;

        TreeNode root = new TreeNode(val);
        root.getClass().getMethods();
        root.left = buildTree(nums);
        root.right = buildTree(nums);

        return root;
    }
}
