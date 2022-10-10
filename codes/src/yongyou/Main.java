package yongyou;

import java.util.Arrays;
import java.util.HashMap;

//1.
//public class Main {
//    public static void main(String[] args) {
//        Main main = new Main();
//        String str = "abcdtyz@!.";
//        int[][] res = main.solution(str);
//        System.out.println(Arrays.deepToString(res));
//    }
//
////    public int[][] solution(String str){
////        HashMap<Character,Integer> map = new HashMap<>();
////        int[] tmp = new int[10];
////        for(int i = 0;i < str.length();i++){
////            char c = str.charAt(i);
////            map.put(c,map.getOrDefault(c,0) + 1);
////        }
////        System.out.println(map);
////
////        //不可以这样，因为b是2
////        for(char c : map.keySet()){
////            if(c=='@' || c=='!' || c=='.' || c=='/'){
////                tmp[1] += map.get(c);
////            }else if( c>='a' && c <='c'){
////                tmp[2]+= map.get(c);
////            }else if( c>='d' &&c <='f'){
////                tmp[3]+= map.get(c);
////            }
////            else if( c>='g' &&c <='i'){
////                tmp[4]+= map.get(c);
////            }
////            else if( c>='j' &&c <='l'){
////                tmp[5]+= map.get(c);
////            }
////            else if( c>='m' &&c <='o'){
////                tmp[6]+= map.get(c);
////            }
////            else if( c>='p' &&c <='s'){
////                tmp[7]+= map.get(c);
////            }
////            else if( c>='t' &&c <='v'){
////                tmp[8]+= map.get(c);
////            }else{
////                tmp[9]+= map.get(c);
////            }
////        }
////
////        System.out.println(Arrays.toString(tmp));
////
////        int cnt = 0;
////        for(int i = 0;i < tmp.length;i++){
////            if(tmp[i]!=0){
////                cnt++;
////            }
////        }
////        int[][] res = new int[cnt][2];
////        int idx = 0;
////        for(int i= 0 ;i < tmp.length;i++){
////            if(tmp[i]!=0){
////                res[idx][0] = i;
////                res[idx][1] = tmp[i];
////                idx++;
////            }
////        }
////        return res;
////    }
//
//    //还是应该用map直接坐
//    //map存键值的关系
//    //b,[2,3]
//    //HashMap<Character,int[]>
//    //然后遍历
//}


//2.分成都变0或者都变1两种情况
//然后利用滑动窗口
public class Main{
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int n = 2;
        Main main = new Main();
        int ans1 = main.solution(nums,n,0);
        int ans2 = main.solution(nums,n,1);
        int res = Math.max(ans1,ans2);
        System.out.println(res);
    }

    //连续的0有多长
    public int solution(int[] nums,int n,int k){
        int left = 0,right = 0;
        int max = 0;
        int cnt = 0;

        while(left < nums.length && right < nums.length){
            int c = nums[right];
            if(c != k){
                if(cnt < n) {
                    cnt++;
                }
                else {
                    while(left < nums.length && nums[left] == k){
                        left++;
                    }
                    //此时的nums[left]!=k
                    //到它的下一个去
                    left++;
                }
            }
            max = Math.max(max,right-left + 1);
//            System.out.println(Arrays.toString(nums)+"\tleft:"+left+"\tright:"+right+ "\tcnt:"+cnt+"\tmax:"+max);
            right++;
        }
        return max;
    }
}