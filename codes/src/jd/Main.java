package jd;

import java.util.*;

//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cnt = scanner.nextInt();
//        HashMap<Integer,Integer> map = new HashMap<>();
//        int max = Integer.MIN_VALUE;
//        for(int i = 0;i < cnt;i++){
//            int num = scanner.nextInt();
//            map.put(num,map.getOrDefault(num,0)+1);
//            if(num > max){
//                max = num;
//            }
//        }
//        System.out.println(cnt-map.get(max));
//    }
//}


//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cnt = scanner.nextInt();
//        ArrayList<Integer> nums = new ArrayList<>();
//        for(int i = 0;i < cnt;i++){
//            nums.add(scanner.nextInt());
//        }
//
//        int res = bfs(nums);
//        System.out.println(res);
//    }
//
//    public static int bfs(ArrayList<Integer> nums){
//        LinkedList<ArrayList<Integer>> q = new LinkedList<>();
//        HashSet<String> set = new HashSet<>();
//        Collections.sort(nums);
//        q.add(nums);
//        set.add(nums.toString());
//
//        int cnt = 0;
//        while(!q.isEmpty()){
//            int len = q.size();
//            for(int i = 0;i < len;i++){
//                ArrayList<Integer> base = q.removeFirst();
////                System.out.println(base);
//                if(check(base)) return cnt;
//
//                for(int j = 0;j < base.size();j++){
//                    ArrayList<Integer> copy = new ArrayList<>();
//                    copy = (ArrayList<Integer>) base.clone();
//                    int num = base.get(j);
//                    if(num!=1){
//                        copy.remove(j);
//                        copy.add(1);
//                        copy.add(num-1);
//                        Collections.sort(copy);
//                        if(!set.contains(copy.toString())){
//                            q.addLast(copy);
//                            set.add(copy.toString());
//                            if(check(copy)) return cnt+1;
//                        }
//                    }
//                }
//
//
//                for(int j = 0;j < base.size();j++){
//                    ArrayList<Integer> copy1 = new ArrayList<>();
//                    copy1 = (ArrayList<Integer>) base.clone();
//                    int num = base.get(j);
//                    if(num!=1 && num%2==0){
//                        copy1.remove(j);
//                        int a = (int)Math.sqrt(num);
//                        while(num%a!=0){
//                            a--;
//                        }
//                        int b = num/a;
//                        copy1.add(a);
//                        copy1.add(b);
//                        Collections.sort(copy1);
//                        if(!set.contains(copy1.toString())){
//                            q.addLast(copy1);
//                            set.add(copy1.toString());
//                            if(check(copy1)) return cnt+1;
//                        }
//                    }
//                }
//            }
//            cnt++;
//
//        }
//
//        return cnt;
//    }
//
//    public static boolean check(ArrayList<Integer> nums){
//        for(int i = 0;i < nums.size();i++){
//            if(nums.get(i)!=1) return false;
//        }
//        return true;
//    }
//
//}

/*
测试用例：
2
2 6
 */

/*
优化思路：
核心：凑2，这一定是最优解
所以，偶数直接/2，不用bfs，计算次数
奇数-1，变成偶数

如果是2，则cnt++；
不是2，按上述的步骤进行
 */
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cnt = scanner.nextInt();
//        int[] nums = new int[cnt];
//        for(int i = 0;i < cnt;i++){
//            nums[i] = scanner.nextInt();
//        }
//
//        int res = solution(nums);
//        System.out.println(res);
//    }
//
//    public static int solution(int[] nums){
//        int cnt = 0;
//        for(int i = 0;i < nums.length;i++){
//            int num = nums[i];
//            if(num==1){
//                continue;
//            }else if(num==2){
//                cnt++;
//            }else{
//                while(num!=2){
//                    if(num%2==1){
//                        num = num-1;
//                        cnt++;
//                    }else{
//                        num/=2;
//                        cnt+=2;
//                    }
//                }
//                cnt++;
//            }
//        }
//        return cnt;
//    }
//}

public class Main{
    public static void main(String[] args) {
        double x = 1.732;

        System.out.println((int)(x*100)/100.0);
    }
}