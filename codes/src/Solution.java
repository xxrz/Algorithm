import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        //统计好每一位为1的数量
        for(int num:nums){
            for(int i=0;i<32;i++){
                count[i] += num&1;
                //num右移
                num >>>=1; //此时在最低位,为了判断下一个高位，需要右移
            }
        }

        int res = 0,m=3;
        for(int i= 0;i<32;i++){
            res <<= 1;
            res |= count[31-i] % m;
        }
        return res;
    }
}