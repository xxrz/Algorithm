package zuiyou;

public class Main {

    /**
     * 思路：动态规划
     * 状态：
     * dp[i][0]表示在第i天选择了a，所得到的最大价值
     * dp[i][1]表示在第i天选择了b，所得到的最大价值
     * 选择：
     * dp[i][0] = Math.max(dp[i-1][0] + a[i],dp[i-2][1] + a[i])
     * dp[i][1] = Math.max(dp[i-1][1] + b[i],dp[i-2][0] + b[i])
     * 初始值：
     * dp[0][0] = a[0],dp[0][1] = b[0]
     * dp[1][0] = a[0] + a[1],dp[1][1] = b[0] + b[1]
     * 结果：
     * Math.max(dp[len-1][0],dp[len-1][1])
     */

    public static void main(String[] args) {
//        int[] a = {11,2,2,9};
//        int[] b = {4,1,21,23};

        int[] a = {1,3,1};
        int[] b = {7,7,7};

        int len = a.length;
        int[][] dp = new int[len][len];

        dp[0][0] = a[0];
        dp[0][1] = b[0];
        dp[1][0] = a[0] + a[1];
        dp[1][1] = b[0] + b[1];

        for(int i = 2;i < len;i++){
            dp[i][0] = Math.max(dp[i-1][0] + a[i],dp[i-2][1] + a[i]);
            dp[i][1] = Math.max(dp[i-1][1] + b[i],dp[i-2][0] + b[i]);
        }

        int res = Math.max(dp[len-1][0],dp[len-1][1]);
        System.out.println(res);
    }
}
