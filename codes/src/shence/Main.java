package shence;

public class Main {
    public static void main(String[] args) {
        /*
        dp定义规则：把i,j之间的状态，将j固定，dp[0,j-1]间的状态就是i的状态的变化！！！！
        状态：dp[j]表示, nums[0,j-1]的最大值（下标为i）+ j-i 之间的最大值
        状态转移：
        dp[i] = Math.max(dp[i-1],nums[i-1])-1;
        结果：
        res = Math.max(dp[i]+ nums[i],res) ;
         */
        int[] nums = {998,570,876,200,877};
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = 0;
        for(int i = 1;i < nums.length;i++){
            dp[i] = Math.max(dp[i-1],nums[i-1])-1;
            res = Math.max(dp[i]+ nums[i],res) ;
        }
        System.out.println(res);
    }
}
