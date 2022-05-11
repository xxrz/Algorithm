import java.util.ArrayList;
import java.util.HashMap;

class Solution {

    public int[][] findContinuousSequence(int target) {
        //滑动窗口
        int low = 1,high = 1;
        int sum = 1;
        ArrayList<int[]> res = new ArrayList<>();

        while(high <= (target/2 + 1) ){
            if(sum < target){
                high++;
                sum = sum + high;
            }else if(sum > target){
                sum = sum -low;
                low++;
            }else{
                int[] tmp = new int[high-low+1];
                for(int i = low;i<=high;i++) {
                    tmp[i - low] = i;
                }
                res.add(tmp);
                high++;
                sum = sum + high;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}