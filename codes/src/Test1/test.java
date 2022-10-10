package Test1;

import java.util.Scanner;

public class test {
    class treeNode{
        int val;
        treeNode left;
        treeNode right;

        treeNode(int val){
            this.val = val;
        }
    }

    static treeNode root;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int[] nums = new int[cnt];
        for(int i = 0;i < cnt;i++){
            nums[i] = scanner.nextInt();
        }

        test test = new test();
        root = test.buildTree(nums);
        test.preTravel(root);
    }

    static int i = 0;
    private treeNode buildTree(int[] nums) {
//        if(nums.length == 0) return root;

        if(i >= nums.length){
            return root;
        }

        if(nums[i]==-1) {
            i++;
            return null;
        }

        treeNode treeNode = new treeNode(nums[i]);
        i++;
        treeNode.left = buildTree(nums);
        treeNode.right = buildTree(nums);

        return treeNode;
    }

    public void preTravel(treeNode root){
        if(root==null) return;

        System.out.println(root.val);
        preTravel(root.left);
        preTravel(root.right);
    }

}
