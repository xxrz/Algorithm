import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();

        for(int i = temperatures.length-1;i>=0;i--){
            while(!s.empty() && temperatures[s.peek()] <= temperatures[i]){
                s.pop();
            }
            res[i] = s.empty()? 0: s.peek()-i;
            s.add(i);
        }

        return res;
    }
}