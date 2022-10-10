////package test;
////
////import java.util.Arrays;
////import java.util.Comparator;
////import java.util.PriorityQueue;
////import java.util.Scanner;
////
////class Main{
////    static int max = Integer.MIN_VALUE;
////    static StringBuilder num = new StringBuilder();
////    public static void main(String[] args) {
////        int n = 11111;
////        int[] nums = {1, 4, 5};
////        String n1 = String.valueOf(n);
////        dfs(nums, n1, 0);
////        System.out.println(max);
////    }
////
////    //全排列 + 剪枝
////    public static void dfs(int[] nums,String n1,int depth){
////        if(depth > n1.length()) return;
////
////        if(num.length()!=0 && Integer.valueOf(num.toString()) >= Integer.valueOf(n1)){
////            return;
////        }
////
////        if(num.length()!=0 && Integer.valueOf(num.toString()) > max){
////            max = Integer.valueOf(num.toString());
////        }
////
////
////        for(int i = 0;i < nums.length;i++){
////            num.append(nums[i]);
////
////            dfs(nums,n1,depth+1);
////
////            num.deleteCharAt(num.length()-1);
////        }
////    }
////
////    public void test(){
////        PriorityQueue<Integer> nums = new PriorityQueue<>(new Comparator<Integer>(){
////            @Override
////            public int compare(Integer a,Integer b){
////                return  a-b;
////            }
////        });
////
////
////    }
////}
//
//
//package test;
//
//import java.util.LinkedList;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        LinkedList<Character> s = new LinkedList<>();
//
//        for(int i = 0;i < str.length();i++){
//            char c = str.charAt(i);
//            s.addLast(c);
//        }
//
//        char pre = ' ';
//        int cnt = 1;
//        StringBuilder res = new StringBuilder();
//        while(!s.isEmpty()){
//            char c = s.removeFirst();
////            System.out.println(c+"\t"+pre+"\t"+cnt);
//            if(c!=pre){
//                if(cnt!=1)
//                    res.append(cnt);
//                if(pre!=' ')
//                    res.append(pre);
//                cnt = 1;
//                pre = c;
//            }else{
//                cnt++;
//            }
//
//            if(s.isEmpty()){
//                if(cnt!=1)
//                    res.append(cnt);
//                res.append(c);
//
//            }
//        }
//        System.out.println(res);
//    }
//
//
//}
