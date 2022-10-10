package mayi;

import java.util.*;

//public class Main1 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        used = new boolean[n+1];
//        memo = new int[2*n+1];
//        //-1表示还没有,0表示是质数，1表示不是质数
//        Arrays.fill(memo,-1);
//        dfs(n);
//        if(flag) {
//            for (Integer re : res) {
//                System.out.print(re + " ");
//            }
//        }
//        else System.out.println(-1);
//        System.out.println(Arrays.toString(memo));
//
//    }
//    static boolean[] used;
//    static LinkedList<Integer> path = new LinkedList<>();
//    static boolean flag = false;
//    static LinkedList<Integer> res ;
//    static int[] memo;
//
//    public static void dfs(int n){
//        if(flag) return;
//
//        boolean tmp = judge();
//        if(!tmp) return;
//
//        if(path.size()==n){
//           flag = true;
//           res = new LinkedList<>(path);
//           return;
//        }
//
//        for(int i = 1;i <=n ;i++){
//            if(used[i]) continue;
//
//            path.add(i);
//            used[i] = true;
//
//            dfs(n);
//
//            path.removeLast();
//            used[i] = false;
//        }
//    }
//
//    public static boolean judge(){
//        for(int i = 0;i < path.size();i++){
//            int tmp = isPrime(path.get(i)+i+1);
//            if(tmp==0) return false;
//        }
//        return true;
//    }
//
//    public static int isPrime(int n) {
////        System.out.println(n);
//        if(memo[n]!=-1) return memo[n];
//        if (n <= 3) {
//            return n > 1?0:1;
//        }
//        //只需判断一个数能否被小于sqrt(n)的奇数整除
//        int sqrt = (int)Math.sqrt(n);
//        for (int i = 3; i <= sqrt; i += 2) {
//            if(n % 2 == 0 || n % i == 0) {
//                memo[n] = 1;
//                return memo[n];
//            }
//        }
//        memo[n] = 0;
//        return 0;
//    }
//}

public class Main1{
    public static void main(String[] args) {
        int a = 127;
        Integer integer = Integer.valueOf(a);
        int i = integer.intValue();

    }
}


//public class Main1 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int k = scanner.nextInt();
//        int[] nums = new int[n];
//        HashSet<Integer> set = new HashSet<>();
//        for(int i=0;i < n;i++){
//            nums[i] = scanner.nextInt();
//        }
//
//        Arrays.sort(nums);
//
//        int res = 0;
//        for(int i = 0;i < n;i++){
//            if(!set.contains(nums[i])){
//                set.add(nums[i]);
//            }else{
//                int num = nums[i] + k;
//                res++;
//                while(set.contains(num)){
//                    num += k;
//                    res++;
//                }
//                set.add(num);
//            }
//        }
//
//        System.out.println(res);
//    }
//
//}

///*
//3 3
//1 2 1
//0 2 0
//1 2 1
//2
//1 2 2 2
//3 2 3 1
// */
//public class Main1 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int[][] nums = new int[n][m];
//        for(int i=0;i < n;i++){
//            for(int j = 0;j < m;j++){
//                nums[i][j] = scanner.nextInt();
//            }
//        }
//        int cnt = scanner.nextInt();
//        int[][] ops = new int[cnt][4];
//        for(int i = 0;i < cnt;i++){
//            for(int j= 0;j < 4;j++){
//                ops[i][j] = scanner.nextInt();
//            }
//        }
//
//        Arrays.sort(ops, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        });
//
//        int min = ops[0][0];
//        int max = ops[cnt-1][0];
//        int time = 1;
//        int idx= 0;
//        int res = 0;
//        int[] dx = {0,1,2,-1,-2,0,0,0,0};
//        int[] dy = {0,0,0,0,0,1,2,-1,-2};
//        while(time <= max && idx < cnt ){
//            int t = ops[idx][0];
//            if(time < t){
//                addGross(nums,t-time+1);
//                time = t;
//            }
//            int x = ops[idx][1]-1;
//            int y = ops[idx][2]-1;
//            int h = ops[idx][3];
////            System.out.println(x+"\t"+y+"\t"+h);
//
//            for(int k =0;k < 9;k++){
//                int x1 = x + dx[k];
//                int y1 = y + dy[k];
//
//                if(x1 >= nums.length || y1>=nums[0].length || x1<0 || y1<0) continue;
////                System.out.println("\t"+x1+"\t"+y1+"\t"+h+"\t"+res);
//                if(nums[x1][y1]-h<=0){
//                    res +=nums[x1][y1];
//                    nums[x1][y1] = 0;
//                }else{
//                    nums[x1][y1] -= h;
//                    res += h;
//                }
//            }
////            System.out.println(res);
////            System.out.println(Arrays.deepToString(nums));
//            idx++;
//        }
//        System.out.println(res);
//    }
//
//    public static void addGross(int[][] nums,int t){
//        for(int i = 0;i < nums.length;i++){
//            for(int j = 0;j < nums[0].length;j++){
//                nums[i][j] = nums[i][j] + t;
//            }
//        }
//    }
//
//}