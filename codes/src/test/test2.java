package test;

import java.util.LinkedList;
import java.util.Scanner;

public class test2 {
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
        LinkedList<Integer> nums  = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        for(int i = 0;i < cnt;i++){
            nums.addLast(scanner.nextInt());
        }
        head = buildTree(nums);
        preTravel(head);
        int res = height(head);
        System.out.println(res);
    }

    private static TreeNode buildTree(LinkedList<Integer> nums) {
        if(nums.size()==0) return head;
        int num = nums.removeFirst();
        if(num==-1) return null;

        TreeNode treeNode = new TreeNode(num);
        treeNode.left = buildTree(nums);
        treeNode.right = buildTree(nums);
        return treeNode;
    }


    public static void preTravel(TreeNode head){
        if(head==null) return;

        System.out.println(head.val);
        preTravel(head.left);
        preTravel(head.right);
    }

    public static int height(TreeNode head){
        if(head==null)  return 0;

        int left = height(head.left);
        int right = height(head.right);
        return Math.max(left,right) + 1;
    }


}
