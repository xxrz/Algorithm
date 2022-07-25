package huawei;//package huawei;
//import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class Main {
//
////    //变化的全排列
////    public void dfs(int[][] data,int sum){
//////        System.out.println(path);
////        if(path.size() ==  data.length){
//////            System.out.println(path);
////            max = Math.max(ans,max);
////            return;
////        }
////
////        for(int i = 0;i < data.length;i++){
////            int idx = data[i][2] - 1;
////
////            if(used[i] || (idx!=-1 && !used[idx])) continue;
////            price += data[i][0];
////            ans += data[i][0]*data[i][1];
////            used[i] = true;
////            path.add(i);
////
//////            System.out.println(path);
////            if(price > sum){
////                ans -= data[i][0]*data[i][1];
////                price -= data[i][0];
////                used[i] = false;
////                path.removeLast();
////                max = Math.max(ans,max);
//////                System.out.println("path:"+ path + "\tmax:" + max);
////                continue;
//////                return;
////            }
////
////            dfs(data,sum);
////
////            ans -= data[i][0]*data[i][1];
////            price -= data[i][0];
////            used[i] = false;
////            path.removeLast();
////        }
////    }
////
////    //最大价值
////    static boolean[] used;
////    static int ans = 0;
////    static int max = 0;
////    static int price = 0;
////    static LinkedList<Integer> path = new LinkedList<>();
////    public static void main(String[] args) {
////        //测试输入
////        Scanner scanner = new Scanner(System.in);
////        int sum = scanner.nextInt();
////        int num = scanner.nextInt();
////        int[][] data = new int[num][3];
////        for(int i = 0;i < num;i++){
////            for(int j = 0;j < 3;j++){
////                data[i][j] = scanner.nextInt();
////            }
////        }
//////
//////        System.out.println(Arrays.deepToString(data));
////        Main main = new Main();
////        used = new boolean[num];
////        main.dfs(data,sum);
////        System.out.println(max);
////    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cnt = scanner.nextInt();
//
//        for(int i = 0;i < cnt;i++){
//            String line = scanner.nextLine();
//            String[] tmp = line.split(" ");
//            for(int j = 0;j < tmp.length;i++){
//                tmp.
//            }
//        }
//
//    }
//}

//import java.util.*;
//
//
//public class Main{
//    public static HashSet<String> record;
//
//    public static String find(String s,String target){
//        int idx_s = s.indexOf(target);
//        if(idx_s!=-1){
//            String t = s.substring(idx_s+target.length());
//            //  System.out.println("t"+t);
//            int t_id = t.indexOf("/");
//            if(t_id!=-1){
//
//                String ans = t.substring(0,t_id).split(":")[0];
//                // System.out.println("ans"+ans+" "+t_id);
//                ans = ans.toLowerCase();
//                if(ans.indexOf("com")!=-1){
//                    return ans;
//                }
//            }
//
//        }
//        return "";
//    }
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.nextLine();
//        record = new HashSet<>();
//        boolean f = false;
//        while(n>0){
//            n--;
//            String line = sc.nextLine();
//            String s1 = find(line,"http://");
//            String s2 = find(line,"https://");
//            if(!s1.equals("")&&!record.contains(s1)){
//                System.out.println(s1);
//                f = true;
//                record.add(s1);
//            }
//            if(!s2.equals("")&&!record.contains(s2)){
//                System.out.println(s2);
//                f = true;
//                record.add(s2);
//            }
//
//        }
//        if(!f) System.out.println("none");
//    }
//}


//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.LinkedList;
//import java.util.Scanner;
//
//class Data{
//    int[] fanwei = new int[2];
//    int value;
//
//    Data(int i,int j,int value){
//        this.fanwei[0] = i;
//        this.fanwei[1] = j;
//        this.value = value;
//    }
//}
//public class Main{
//
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        int cnt = scanner.nextInt();
//        int[] location = new int[cnt];
//        int[] fanwei = new int[cnt];
//        int[] value = new int[cnt];
//
//        used = new boolean[cnt];
//        for(int i = 0;i < cnt;i++){
//            location[i] = scanner.nextInt();
//        }
//        for(int i = 0;i < cnt;i++){
//            fanwei[i] = scanner.nextInt();
//        }
//        for(int i = 0;i < cnt;i++){
//            value[i] = scanner.nextInt();
//        }
//
//        Data[] data = new Data[cnt];
//        for(int i = 0;i < cnt;i++){
//            data[i] = new Data(location[i]-fanwei[i],location[i]+fanwei[i],value[i]);
//        }
//
//
//        Arrays.sort(data, new Comparator<Data>() {
//            @Override
//            public int compare(Data o1, Data o2) {
//                return o1.fanwei[0]-o2.fanwei[0];
//            }
//        });
//
//        dfs(data,0);
//        System.out.println(max);
//
//    }
//
//    static boolean[] used;
//    static int[] s = new int[2]; //当前范围
//    static int sum = 0;
//    static int max = 0;
//    static LinkedList<Integer> path = new LinkedList<>();
//    public static void dfs(Data[] data,int k){
//
//        if(k==data.length){
//            max = Math.max(max,sum);
////            System.out.println(path);
//            return;
//        }
//
//        for(int i = 0;i < data.length;i++){
////            System.out.println(Arrays.toString(s)+"\t" + Arrays.toString(data[i].fanwei));
//
//            boolean res1  = data[i].fanwei[0] < s[0] &&  data[i].fanwei[1] < s[1];
//            boolean res2 = data[i].fanwei[0] > s[0] && data[i].fanwei[0] < s[1] && data[i].fanwei[1] > s[1] ;
//            boolean res3 = data[i].fanwei[0] > s[0] &&  data[i].fanwei[1] < s[1];
//            if(used[i]||res1 ||res2 || res3) continue;
//
////            System.out.println(path);
//            used[i]  = true;
//            sum += data[i].value;
//            path.add(i);
//            int tmp1 = s[0];
//            int tmp2 = s[1];
//            s[0] = Math.min(s[0],data[i].fanwei[0]);
//            s[1] = Math.max(s[1],data[i].fanwei[1]);
//
//            dfs(data,i+1);
//
//            used[i] = false;
//            sum -= data[i].value;
//            path.removeLast();
//            s[0] = tmp1;
//            s[1] = tmp2;
//        }
//    }

//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Scanner;
//
//class Main{
//
//    static int res = 0;
//    static int cur = 0;
//    static LinkedList<Integer> path = new LinkedList<>();
//    public static void dfs(int[]nums, int sum,int idx){
//        for(int i = idx;i < nums.length;i++){
//
//            if(i > idx && nums[i]==nums[i-1]){
//                continue;
//            }
//
//            if(cur > sum){
//                continue;
//            }
//
//            if(cur == sum){
//                System.out.println(path);
//                res += 1;
//                continue;
//            }
//
//            path.add(i);
//            cur += nums[i];
//
//            dfs(nums,sum,i+1);
//
//            cur -= nums[i];
//            path.removeLast();
//        }
//    }
//
//
//    public static void main(String[]args){
//        Scanner scanner = new Scanner(System.in);
//        int cnt = scanner.nextInt();
//        int[] nums = new int[cnt];
//        for(int i = 0;i < cnt;i++){
//            nums[i] = scanner.nextInt();
//        }
//        int sum = scanner.nextInt();
//        Arrays.sort(nums);
//        dfs(nums,sum,0);
//        System.out.println(res);
//    }
//
//}



