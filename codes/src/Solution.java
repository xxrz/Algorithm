//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//class Solution {
//
////    public int[] nextGreaterElements(int[] nums) {
////        //如果不是循环数组
////        Stack<Integer> s = new Stack<>();
////        int[] res = new int[nums.length];
////
////        for(int i = nums.length-1;i >=0;i-- ){
////            while(!s.isEmpty() && nums[i] >= s.peek()){
////                s.pop();
////            }
////            res[i] = s.isEmpty()? -1: s.peek();
////            s.push(nums[i]);
////        }
////
////        return res;
////    }
//
//    public int[] nextGreaterElements(int[] nums) {
//        //如果是循环数组,则将下标扩大两倍，然后用取余的方法进行遍历
//        Stack<Integer> s = new Stack<>();
//        int[] res = new int[nums.length];
//
//        for(int i = 2*nums.length-1;i >=0;i-- ){
//            while(!s.isEmpty() && nums[i%nums.length] >= s.peek()){
//                s.pop();
//            }
//            res[i%nums.length] = s.isEmpty()? -1: s.peek();
//            s.push(nums[i%nums.length]);
//        }
//
//        return res;
//    }
//
//    //归并排序
//    int cnt = 0;
//    public int InversePairs(int [] array) {
//        return mergeSort(array,0,array.length-1);
////         System.out.println(Arrays.toString(array));
////         return cnt;
//
//    }
//
//    //[]
//    public int mergeSort(int[] array,int low,int high){
//        if(low >= high) return 0;
//
//        int mid = low + (high-low)/2;
//
//        int left = mergeSort(array,low,mid);
////        System.out.println("array left:"+"low:"+low+"\thigh"+high+"\tarray:"+ Arrays.toString(array)+"res:"+left);
//        int right = mergeSort(array, mid + 1,high);
////        System.out.println("array right:"+"low:"+(int)(mid + 1)+"\thigh"+high+"\tarray:"+Arrays.toString(array)+"res:"+right);
//        int cnt = merge(array,low,mid,high);
////        System.out.println("array cnt:"+"low:"+ low +"\thigh"+high+"\tarray:"+Arrays.toString(array)+"res:"+cnt);
//        return left+right+cnt;
//    }
//
//    public int merge(int[] array,int low,int mid, int high){
//
//        int[] res = new int[high-low+1];
//        int idx1 = low, idx2 = mid + 1,idx = 0;
//        int cc = 0;
//        while(idx1 <= mid && idx2 <=high){
//            if(array[idx1] <= array[idx2]){
//                res[idx++] = array[idx1++];
//            }else{
//                res[idx++] = array[idx2++];
////                 cnt += mid-idx1+1;
//                cc += mid - idx1 + 1;
////                 cnt=(cnt+mid-idx1+1)%1000000007;
//            }
//        }
//
//        while(idx1<=mid){
//            res[idx++] = array[idx1++];
//        }
//
//        while(idx2<=high){
//            res[idx++] = array[idx2++];
//        }
//
//
//        for(int i = 0;i < res.length;i++){
//            array[low + i] = res[i];
//        }
//
////        System.out.println("low:"+low+"\thigh"+high+"\tmerge:"+cc);
//        return cc;
//    }
//
////    public static void main(String[] args) throws IOException {
//////        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//////        String line = "";
//////        int res = 0;
//////        while((line=bufferedReader.readLine())!=null) {
//////            int num = Integer.valueOf(line);
//////            line = bufferedReader.readLine();
//////            String[] nums = line.split(" ");
//////            int[] tmp = new int[nums.length];
//////            for (int i = 0; i < nums.length; i++) {
//////                tmp[i] = Integer.valueOf(nums[i]);
//////            }
//////            Solution solution = new Solution();
//////            res = solution.test(num, tmp);
//////            System.out.println(res);
//////        }
////        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
////        String line = "";
////        int res = 0;
////        while((line=bufferedReader.readLine())!=null) {
////            String[] num12 = line.split(" ");
////            line = bufferedReader.readLine();
////            String[] nums = line.split(" ");
////            int[] tmp = new int[nums.length];
////            for (int i = 0; i < nums.length; i++) {
////                tmp[i] = Integer.valueOf(nums[i]);
////            }
////            Main solution = new Main();
////            solution.test(Integer.valueOf(num12[0]),Integer.valueOf(num12[1]),tmp);
////            System.out.println(res);
////        }
////    }
//
////    public int test(int cnt, int sum, int[] nums){
////        int res = 0;
////        for(int i= 0;i<cnt;i++){
////            int can
////        }
////    }
//
//}

import java.util.LinkedList;
import java.util.List;

class Solution {
    List<String> res = new LinkedList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4 && s.length() > 16) return res;

        dfs(s,0);
        System.out.println(res);

        return res;
    }

    //s是字符串不变，i
    public void dfs(String s,int i){
//        System.out.println(s.length() +"\t"+ i);
        if(s.length()==i && path.size()==4){
//            System.out.println("????");
            StringBuilder tmp = new StringBuilder();
            for(int k = 0;k < 3;k++){
                tmp.append(path.get(k));
                tmp.append(".");
            }
            tmp.append(path.get(3));
            res.add(tmp.toString());
            return;
        }

        if(i < s.length() && path.size()>=4){
//            System.out.println("jainlema");
            return;
        }

        //增量p的长度
        for(int len = 1;len <= 3 && i + len-1 < s.length();len++){
            if(len!=1 && s.charAt(i)=='0') continue;
            String t = s.substring(i,i + len);
            int num = Integer.parseInt(t);
            if(num > 255) continue;
            path.add(num+"");
//            System.out.println(path);
            dfs(s,i + len);
            path.removeLast();
//            System.out.println();
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "25525511135";
        solution.restoreIpAddresses(s);
    }
}