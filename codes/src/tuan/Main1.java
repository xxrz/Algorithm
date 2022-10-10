package tuan;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  =scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums1 = new int[n];
        int[] nums2 = new int[m];
        for(int i= 0;i < nums1.length;i++){
            nums1[i]= scanner.nextInt();
        }
        for(int i= 0;i < nums2.length;i++){
            nums2[i]= scanner.nextInt();
        }
        int res = minDistance(nums1,nums2);
        System.out.println(res);

    }

    //备忘录优化
    static int[][] memo;
    public static int minDistance(int[] word1, int[] word2) {
        int m = word1.length, n = word2.length;
        memo = new int[m][n];
        for(int i = 0;i < m;i++){
            Arrays.fill(memo[i],-1);
        }
        // i，j 初始化指向最后一个索引
        return dfs(word1, m - 1, word2, n - 1);
    }

    // 定义：返回 s1[0..i] 和 s2[0..j] 的最小操作数
    public static int dfs(int[] word1,int i,int[] word2,int j){
        //base case
        //当两个序列走完了
        if(i==-1) {
            int sum = 0;
            for(int k = j;k >= 0;k--){
                sum += Math.abs(word2[k]);
            }
            return sum;
        }

        if(j==-1) {
            int sum = 0;
            for(int k = i;k >= 0;k--){
                sum += Math.abs(word1[k]);
            }
            return sum;
        }

        //剪枝
        if(memo[i][j]!=-1){
            return memo[i][j];
        }

        //返回
        if(word1[i]==word2[j]){
            return dfs(word1,i-1,word2,j-1);
        }

        //增，删，改
        int insert = dfs(word1,i,word2,j-1) + Math.abs(word2[j]);
        int delete = dfs(word1,i-1,word2,j) + Math.abs(word1[i]);
        int update = dfs(word1,i-1,word2,j-1) + Math.abs(word1[i]-word2[j]);
        memo[i][j] = Math.min(insert,Math.min(delete,update));
        return memo[i][j];
    }
}
