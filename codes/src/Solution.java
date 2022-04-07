import java.util.*;

class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int left = 1,right = 1;
        int sum = 0;

        while(left <= target/2){
            int c = right;
            right++;

            sum+=c;

            while(sum >= target){
                if(sum==target){
                    int[] ans = new int[c-left+1];
                    for(int k = left;k <= c;k++){
                        ans[k-left] = k;
                    }
                    res.add(ans);
                }
                int d = left;
                left++;
                sum = sum-d;
            }
        }

        return res.toArray(new int[0][]);
    }
}