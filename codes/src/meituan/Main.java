package meituan;

import java.util.*;

public class Main{
    static class Node{
        int seq;
        int val;

        Node(int seq,int val){
            this.seq = seq;
            this.val = val;
        }
    }

    static int[] dis;
    static int path = 0;
    static int max = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dis = new int[n+1];
        ArrayList<Node>[] nums = new ArrayList[n+1];
        for(int i = 0;i < nums.length;i++){
            nums[i] = new ArrayList<Node>();
        }
        for(int i = 1;i <= n-1;i++){
            int from  = sc.nextInt();
            int to = sc.nextInt();
            int val = sc.nextInt();
            Node node = new Node(to,val);
            nums[from].add(node);
        }

        dfs(nums,1);
        System.out.println(Arrays.toString(dis));

        int sum = 0;
        for(int i = 0;i < dis.length;i++){
            sum += dis[i];
        }
        System.out.println(sum*2 - max);
        System.out.println(max);
    }

    public static void dfs(ArrayList<Node>[] nums,int i){
        ArrayList<Node> tmp = nums[i];

        if(tmp.size()==0){
            max = Math.max(path,max);
        }

        for(int k = 0;k < tmp.size();k++){
            path += tmp.get(k).val;
            dis[tmp.get(k).seq] = path;
            dfs(nums,tmp.get(k).seq);
            path -= tmp.get(k).val;
        }
    }
}