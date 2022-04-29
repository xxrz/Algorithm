import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    //转成完全背包问题
    //状态：所选的数，价值
    //dp[i][j]：可以选择0-i-1的数的平方，现在和为j的最小的个数
    //状态转移：当前的数的平方选还是不选
    //  dp[i][j] = Math.min(dp[i-1][j],dp[i][j-i^2] + 1)
    //初始值：
    //  dp[0][0]=0,其他都是最大值
    //结果：
    //  dp[m][n]
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        int t=1;
        while(t*t<=n){
            list.add(t*t);
            t++;
        }

        int m = list.size();
        int[][] dp = new int[m+1][n+1];

        for(int i = 0;i <= m;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE/2);
        }

        for(int i=1;i<=m;i++){
            dp[i][0] = 0;
        }

//        for(int i =0;i<=m;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }

        // dp[0][0] = 0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(j-list.get(i-1) < 0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],(int)(dp[i][j-list.get(i-1)])+1);

//                    System.out.println("dp[i-1][j]: "+(i-1)+","+ j +"  :" + dp[i-1][j]);
//                    System.out.println("dp[i][j-list.get(i-1)]: "+i+", "+(j-list.get(i-1))+ "  :"+ (int)(dp[i][j-list.get(i-1)])+1);
//                    System.out.println("dp[i][j]: "+(i)+","+ j +"  :" + dp[i][j]);
//                    System.out.println();
                }
            }
        }

//        System.out.println();
//        for(int i =0;i<=m;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }

        return dp[m][n];
    }
}