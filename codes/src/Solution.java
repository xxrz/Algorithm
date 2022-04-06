import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //思路：
        //1，左闭右开，hashmap中放的是索引值而不是单纯的次数
        //2，扩大right,并更新windows中字符的索引值
        //3，left缩小窗口的时候，要注意不是单纯的left++，要判断当前left的位置和这个字符上一次出现的索引+1的大小
        //4，结果在缩小窗口之后

        //定义变量
        HashMap<Character,Integer> windows = new HashMap<>(); //记录的是上个字符的索引值
        int left = 0, right = 0; //滑动窗口，左闭右开
        int maxlen = Integer.MIN_VALUE;

        //滑动窗口
        while(right < s.length()){
            //当前移入窗口的字符
            char c = s.charAt(right);
            System.out.println("left:"+left+"\tright:"+right + "\t:" + s.substring(left,right));

            //右移窗口
            right++;

            //判断窗口是否要收缩
            if(windows.containsKey(c)){
                //左移窗口
                System.out.println("\tleft:"+left+"\twindows:"+(int)(windows.get(c)+1));
                left = windows.get(c)+1;   //这块一定要取更大的那个，而不是单纯的left++
//                left = Math.max(left,windows.get(c)+1);   //这块一定要取更大的那个，而不是单纯的left++
            }
            //更新结果
            System.out.println("\t\tleft:"+left + "\tright:"+right);
            maxlen = Math.max(right-left, maxlen);
            windows.put(c, right-1);

        }
        return maxlen==Integer.MIN_VALUE?0:maxlen;
    }
}