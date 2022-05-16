import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

class Solution {

//    public int[] nextGreaterElements(int[] nums) {
//        //如果不是循环数组
//        Stack<Integer> s = new Stack<>();
//        int[] res = new int[nums.length];
//
//        for(int i = nums.length-1;i >=0;i-- ){
//            while(!s.isEmpty() && nums[i] >= s.peek()){
//                s.pop();
//            }
//            res[i] = s.isEmpty()? -1: s.peek();
//            s.push(nums[i]);
//        }
//
//        return res;
//    }

    public int[] nextGreaterElements(int[] nums) {
        //如果是循环数组,则将下标扩大两倍，然后用取余的方法进行遍历
        Stack<Integer> s = new Stack<>();
        int[] res = new int[nums.length];

        for(int i = 2*nums.length-1;i >=0;i-- ){
            while(!s.isEmpty() && nums[i%nums.length] >= s.peek()){
                s.pop();
            }
            res[i%nums.length] = s.isEmpty()? -1: s.peek();
            s.push(nums[i%nums.length]);
        }

        return res;
    }
}