package mayi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        //前缀和，次数
//        HashMap<Integer,Integer> cnt = new HashMap<>();
//        //相同为0，相异为1
//        cnt.put(0,1);
//
//        int n = s.length();
//        //res存当前的位图的状态值
//        int res = 0;
//        int ans = 0;
//        for(int i = 0;i < n;i++){
//            //前缀和
//            res ^= 1<<(s.charAt(i)-'a');
//            System.out.println(i+"\t"+Integer.toString(res,2));
//            for(int j = 0;j < 26;j++){
//                //遍历26个字符的如果为1则可
//                int mask = res^(1<<j);
//                System.out.println("\t" + j+"\t"+Integer.toString(mask,2)+"\t"+cnt);
//                for(Integer k :cnt.keySet()){
//                    System.out.print("\t\t" +Integer.toString(k,2)+": "+cnt.get(k) + "||");
//                }
//                if(cnt.containsKey(mask)){
//                    ans += cnt.get(mask);
//                }
//                System.out.println("\t\t\t"+ans);
//            }
//            cnt.put(res,cnt.getOrDefault(res,0)+1);
//        }
//
//        System.out.println(ans);
//    }
//}

//public class Main{
//
//    public static int bitCount(int x){
//        int res = 0;
//        while(x>0){
//            x = x & (x - 1);
//            res++;
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        String s = "abc";
//        int len = s.length();
//        int[] presum = new int[len+1];
//        presum[0] = 0;
//        /*
//        1. 先把当前字符串的前缀和求出来
//        presum代表的前缀和，presum[0]不用
//        此处的前缀和表示
//        以abc为例
//        - a
//      a:    1
//          =>1
//
//        - ab
//      a:    1
//      b:   10
//         =>11 :3
//
//        - abc
//      ab:  11
//      c:  100
//        =>111 :7
//
//        所以：presum:[0, 1, 3, 7]
//         */
//        for(int i=0;i<len;i++){
//            presum[i+1] = presum[i] ^ (1<<(s.charAt(i) - 'a'));
//        }
//        System.out.println(Arrays.toString(presum));
//        /*
//        2. 在前缀和区间，找符合要求的区间[left,right]
//        idx:      0 1  2  3
//        presum:     a ab abc
//        如果想找bc，是不是符合要求，则相当于presum[1]^presum[3],然后看对应的二进制数是否只有一个1， bitCount就起这样的作用（判断有几个1）
//         */
//        int ans = 0;
//        for (int left=0;left < len;left++){
//            for (int right= left;right < len;right++){
//                System.out.println(left+" "+right);
//                System.out.println(Integer.toString(presum[right+1]^presum[left],2));
//                if(bitCount(presum[right+1]^presum[left])==1){
//                    ans++;
//                }
//            }
//        }
//        System.out.println(ans);
//    }
//}


public class Main{
    public static void main(String[] args) {
        String s = "abc";
        int len = s.length();
        int[] presum = new int[len+1];
        presum[0] = 0;
        /*
        1. 先把当前字符串的前缀和求出来
        presum代表的前缀和，presum[0]不用
        此处的前缀和表示
        以abc为例
        - a
      a:    1
          =>1

        - ab
      a:    1
      b:   10
         =>11 :3

        - abc
      ab:  11
      c:  100
        =>111 :7

        所以：presum:[0, 1, 3, 7]
         */
        for(int i=0;i<len;i++){
            presum[i+1] = presum[i] ^ (1<<(s.charAt(i) - 'a'));
        }
        System.out.println(Arrays.toString(presum));
        /*
        2. 在前缀和区间，找符合要求的区间[left,right]
        idx:      0 1  2  3
        presum:     a ab abc
        如果想找bc，是不是符合要求，则相当于presum[1]^presum[3],然后看对应的二进制数是否只有一个1， bitCount就起这样的作用
         */

        /*
        3. 优化掉bitCount中的循环
        本来是对于[left,right]之间，需要满足bitCount(presum[right+1]^presum[left])==1 只有某一位是1，但现在不知道是哪一位
        把式子移项，得到如下的关系式
        现在用hashmap去存left的情况，就是对于当前遍历到的presum[right+1]^1>>(i)，有多少个presum[left]满足

        也就是a^b = 1;
        现在 a = b^1;

         */
        int presums = 0;
        int newans = 0;
        //存储<k,v> = <状态，次数>
        HashMap<Integer,Integer> memo = new HashMap<>();

        memo.put(0,1);
        for(int i=0;i<len;i++){
            //left
            presums ^= 1 << (s.charAt(i)-'a');
            /*
            对应之前是 ans += memo.getOrdefualt(presum-k,0);
            已知left定的情况下，找符合要求的right
            =>
            因为不知道具体是哪个字母为1,所以需要遍历去做
            遍历:假设right的那个字母是a,那就异或一下left，看看结果是否在hashmap中有,有就是符合的加进去，没有就加0
             */
            //right
            for(int j=0;j < 26;j++){
                int k = 1 << j;
                newans += memo.getOrDefault(presums^k,0);
            }
            memo.put(presums,memo.getOrDefault(presums,0)+1);
        }
        System.out.println(newans);
    }
}
