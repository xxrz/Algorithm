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
            System.out.println("右移前："+ res);
            res <<= 1;   //此时count[0]统计的是在最高位，为了从最低位开始判断，需要将res先左移一位
            System.out.println("右移后："+ res);
            res |= count[31-i] % m;
            System.out.println("i："+ i);
            System.out.println("count[31-i]："+ count[31-i]);
            System.out.println("或等后："+ res);
        }
        return res;
    }
}