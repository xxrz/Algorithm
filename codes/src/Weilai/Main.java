package Weilai;

import java.util.*;
import java.util.stream.Collectors;

////第一题：四角和
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int[][] nums = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                nums[i][j] = scanner.nextInt();
//            }
//        }
//
//        int max = Math.min(m, n);
//
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                for (int k = 1; k < max; k++) {
//                    if (i + k >= n || j + k >= m) continue;
//                    int num1 = nums[i][j];
//                    int num2 = nums[i][j + k];
//                    int num3 = nums[i + k][j];
//                    int num4 = nums[i + k][j + k];
//                    int sum = num1 + num2 + num3 + num4;
//                    res = Math.max(res, sum);
//                }
//            }
//        }
//
//        System.out.println(res);
//    }
//
//}

////第二题：dp没通过
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int x = scanner.nextInt();
//        int y = scanner.nextInt();
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//
//        if (b % a != 0) {
//            System.out.println(1);
//            return;
//        }
//
//        int[] dp = new int[b + 1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[a] = 0;
//        for (int i = a; i <= b; i++) {
//            if (i % x == 0 && i / x >= a) {
//                dp[i] = dp[i / x] + 1;
//            }
//            if (i % y == 0 && i / y >= b) {
//                dp[i] = Math.min(dp[i], dp[i / y] + 1);
//            }
//        }
//        System.out.println(dp[b]);
//    }
//}

////第二题：dfs
////测试用例：2 3 2 20
//public class Main {
//    static boolean f = false;
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int x = scanner.nextInt();
//        int y = scanner.nextInt();
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//
//        if (b % a != 0) {
//            System.out.println(-1);
//            return;
//        }
//        f = false;
//
//        int res = dfs(x, y, a, b);
//        if (f) System.out.println(res);
//        else System.out.println(-1);
////        这里不能这么判断
////        因为res不一定等于Integer.MAX_VALUE-1000
////        会一直往上加
////        if(res==Integer.MAX_VALUE-1000)
////            System.out.println(-1);
////        else
////            System.out.println(res);
//    }
//
//    private static int dfs(int x, int y, int num, int end) {
//        if (num > end) return Integer.MAX_VALUE - 1000;
//
//        if (num == end) {
//            f = true;
//            return 0;
//        }
//
//        int a1 = dfs(x, y, num * x, end);
//        int a2 = dfs(x, y, num * y, end);
//        return Math.min(a1, a2) + 1;
//    }
//}


////第三题：组合问题
//class node{
//    int cost;
//    int happy;
//
//    node(int cost,int happy){
//        this.cost = cost;
//        this.happy = happy;
//    }
//}
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int k = scanner.nextInt();
//        node[] nums = new node[n];
//        for(int i = 0;i < n;i++){
//            nums[i]  = new node(0,0);
//            nums[i].cost = scanner.nextInt();
//            nums[i].happy = scanner.nextInt();
//        }
//
//        Arrays.sort(nums, new Comparator<node>() {
//            @Override
//            public int compare(node o1, node o2) {
//                return o1.cost-o2.cost;
//            }
//        });
//
//        for (node num : nums) {
//            System.out.println("cost:" + num.cost +"\thappy:"+ num.happy);
//        }
//
//        dfs(nums,0,k);
//        System.out.println(res);
//    }
//
//    static int res = 0;
//    static int max = 0; //happy sum
//    static LinkedList<Integer> path = new LinkedList<>();
//
//    public static void dfs(node[] nums,int i,int k){
//
//        for(int idx = i;idx < nums.length;idx++){
//
//            max += nums[idx].happy;
//            path.addLast(nums[idx].cost);
//
//            if(!check(k)) {
//                max -= nums[idx].happy;
//                path.removeLast();
//                continue;
//            }
//
//            //检查了没有问题以后再更新
//            res = Math.max(res,max);
//            System.out.println("path" + path + "\tcheck:" + check(k) + "\tmax:" + max + "\tres:"+res);
//
//            dfs(nums,idx+1,k);
//
//            max -= nums[idx].happy;
//            path.removeLast();
//        }
//    }
//
//    public static boolean check(int k){
//        if(path.size()-1 > 0){
//            if(path.get(path.size()-1)-path.get(0) >= k)
//                return false;
//            else
//                return true;
//        } else
//            return true;
//    }
//
//
//}


////第3题：滑动窗口
//class node{
//    int cost;
//    int happy;
//
//    node(int cost,int happy){
//        this.cost = cost;
//        this.happy = happy;
//    }
//}
//
//class Main{
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int k = scanner.nextInt();
//        node[] nums = new node[n];
//        for(int i = 0;i < n;i++){
//            nums[i]  = new node(0,0);
//            nums[i].cost = scanner.nextInt();
//            nums[i].happy = scanner.nextInt();
//        }
//
//        Arrays.sort(nums, new Comparator<node>() {
//            @Override
//            public int compare(node o1, node o2) {
//                return o1.cost-o2.cost;
//            }
//        });
//
//        //滑动窗口
//        int left = 0,right = 0;
//        int max = 0;
//        int sum = 0;
//        while(right < nums.length){
//            int cur = nums[right].cost;
//            sum += nums[right].happy;
//            while(left < right && cur-nums[left].cost >= k){
//                sum -= nums[left].happy;
//                left++;
//            }
//            max = Math.max(sum,max);
//            right++;
//        }
//        System.out.println(max);
//    }
//}


public class Main{
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cnt = scanner.nextInt();
//        ArrayList<Integer> nums = new ArrayList<>();
//        for(int i=0;i < cnt;i++){
//            nums.add(scanner.nextInt());
//        }
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(5);
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(6);

        System.out.println(bfs(nums));
    }

    //对每位同时执行3个操作
    //利用bfs，dfs要考虑顺序不好做，比如451236，只能是先移了3到最前面，才能移1 2
    //bfs统一针对每一位做操作
    //队列中存nums的结果
    private static int bfs(ArrayList<Integer> nums) {
        //结果
        ArrayList<Integer> res = new ArrayList<>(nums);
        Collections.sort(res);
//        System.out.println("res:"+res);

        LinkedList<ArrayList<Integer>> q = new LinkedList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        q.add(nums);
        set.add(nums);

        int cnt = 0;
        boolean flag = false;
        while(!q.isEmpty()){
            int len = q.size();
//            System.out.println("cnt:"+cnt);
            for(int i = 0;i < len;i++){
                ArrayList<Integer> tmp = q.removeFirst();
//                set.remove(tmp);
//                System.out.println(tmp);
                if(tmp.equals(res)) {
                    flag = true;
                    break;
                }
//                System.out.println(q);
                for(int j = 0;j < tmp.size();j++){
                    int num = tmp.get(j);
                    if(j!=0){
                        ArrayList<Integer> op1 = new ArrayList<>(tmp);
                        op1.remove(j);
                        op1.add(0,num);
//                        System.out.println("op1:\t"+op1);
//                        if(op1.equals(res)) break;

                        if(!set.contains(op1)){
                            q.addLast(op1);
                            set.add(op1);
                        }

                    }
//                    ArrayList<Integer> op2 = new ArrayList<>(tmp);
//                    q.add(op2);
                    if(j!=tmp.size()-1){
                        ArrayList<Integer> op3 = new ArrayList<>(tmp);
                        op3.remove(j);
                        op3.add(tmp.size()-1,num);
//                        System.out.println("op3:\t"+op3);
//                        if(op3.equals(res)) break;

                        if(!set.contains(op3)){
                            q.addLast(op3);
                            set.add(op3);
                        }

                    }
                }
//                set.remove(tmp);
//                System.out.println(q);
//                System.out.println("qlen:" + q.size() + "\tsetlen:" + set.size());
            }
            if(flag) break;
            cnt++;
//            break;
        }
        return cnt;

    }
}