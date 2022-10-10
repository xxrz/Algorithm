package xhs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//public class Main {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cnt = scanner.nextInt();
//        int k = scanner.nextInt();
//        int[] nums = new int[cnt];
//        for(int i = 0;i < nums.length;i++){
//            nums[i] = scanner.nextInt();
//        }
//
//        int res = solution(nums,k);
//        System.out.println(res);
//    }
//
//    /*
//    状态：dp[i]表示目前到i为止的最小的代价
//    状态转移方程：
//    dp[i] = if nums[x] < nums[i] :dp[x] + nums[x]-nums[i]
//    else dp[i] = dp[x]
//    求最小值
//    初始化：Arrays.fill(dp,Integer.MAX)
//    结果：
//    dp[n.length-1]
//     */
//    private static int solution(int[] nums,int k) {
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp,Integer.MAX_VALUE);
//
//        dp[0] = 0;
//        for(int i = 0;i < nums.length;i++){
//           for(int j = 1;j <= k;j++){
//               if(i-j>=0) {
//                   if (nums[i - j] < nums[i]) {
//                       dp[i] = Math.min(dp[i], dp[i - j] + nums[i] - nums[i - j]);
//                   } else {
//                       dp[i] = Math.min(dp[i - j], dp[i]);
//                   }
//               }
//           }
//        }
////        System.out.println(Arrays.toString(dp));
//
//        return dp[nums.length-1];
//
//    }
//
//}


/*
6 2
1 2 1 3 2 3
 */
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int k = scanner.nextInt();
//        int[] nums = new int[n];
//        for(int i = 0;i < nums.length;i++){
//            nums[i] = scanner.nextInt();
//        }
//
//        long res = 0;
//        int[] cnt = new int[n+1];
//        for(int i = 0;i < nums.length;i++){
//            for(int j = i;j < nums.length;j++){
//                int add = nums[j];
//                cnt[add]++;
//                boolean r = solution(cnt,k);
//                if(r) {
////                   System.out.println(Arrays.toString(Arrays.copyOfRange(nums,i,j+1)) +"\t" + Arrays.toString(cnt));
//                    res++;
//                }
//            }
//            Arrays.fill(cnt,0);
//        }
//
//        System.out.println(res);
//
//    }
//
//    public static boolean solution(int[] cnt,int k ){
//        Arrays.sort(cnt);
//        if(cnt[cnt.length-1] >= k ) return true;
//        else return false;
//    }
//
//
//}


public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int left = 0, right = 0;
        int cnt = 0;
        Map<Integer, Integer> window = new HashMap<>();
        while (right < n) {
            int num1 = arr[right];
            window.put(num1, window.getOrDefault(num1, 0) + 1);
            //在符合要求时收缩窗口
            while (window.get(num1) == k) {
                int num2 = arr[left];
                left++;
                window.put(num2, window.get(num2) - 1);
                //这个条件比较重要，当前满足，则后面的都满足（先忽略众数这个条件吧）
                cnt = cnt + (n - right);
            }
            right++;
        }
        System.out.println(cnt);
    }
}