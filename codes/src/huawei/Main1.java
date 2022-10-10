package huawei;

//public class Main1 {
//    public static void main(String[] args) {
////        String str = "a=b+c+d*e";
////        String str = "b*(b-d)";
//        String str = "a=b";
//        int res = 0;
//        int standard = 0;
//        int cnt = 0;
//        for(int i = 0;i < str.length();i++){
//            char c = str.charAt(i);
//            if(c=='+' || c=='-'){
//                standard = 1;
//                cnt++;
//            }else if(c=='*'){
//                standard = 2;
//                cnt++;
//            }else if(c=='/'){
//                standard = 4;
//                cnt++;
//            }else{
//                continue;
//            }
//            res += standard;
//        }
//        if(cnt <= 10)
//            System.out.println(res);
//        else
//            System.out.println(-1);
//    }
//}


import java.math.BigInteger;
import java.util.*;

public class Main1{
    static LinkedList<int[]> res = new LinkedList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static boolean[] used;
    public static void main(String[] args) {
        int[] nums = {75,36,10,4,30,225,90,25,12};
        used = new boolean[9];
        dfs(nums);
        sort();
        print();

    }

    public static void dfs(int[] nums){

        if(path.size()==9){
            if(vaild()) res.add(trans());
            return;
        }

        for(int i = 0;i < 9;i++){
            if(used[i]) continue;
            used[i] = true;
            path.addLast(nums[i]);

            dfs(nums);

            used[i] = false;
            path.removeLast();
        }
    }



    public static boolean vaild(){
        int[] nums = trans();

        BigInteger c1 = new BigInteger(String.valueOf(nums[0]*nums[1]*nums[2]));
        BigInteger c2 = new BigInteger(String.valueOf(nums[3]*nums[4]*nums[5]));
        BigInteger c3 = new BigInteger(String.valueOf(nums[6]*nums[7]*nums[8]));
        BigInteger c4 = new BigInteger(String.valueOf(nums[1]*nums[4]*nums[7]));
        BigInteger c5 = new BigInteger(String.valueOf(nums[2]*nums[5]*nums[8]));
        BigInteger c6 = new BigInteger(String.valueOf(nums[0]*nums[4]*nums[8]));
        BigInteger c7 = new BigInteger(String.valueOf(nums[2]*nums[4]*nums[6]));
        BigInteger c8 = new BigInteger(String.valueOf(nums[0]*nums[3]*nums[6]));
        if(c1.equals(c2) && c2.equals(c3) && c3.equals(c4) && c4.equals(c5) && c5.equals(c6)
                && c6.equals(c7) && c7.equals(c8))
            return true;
        else
            return false;
    }

    public static int[] trans(){
        int[] nums = new int[9];
        for(int i = 0;i < 9;i++){
            nums[i] = path.get(i);
        }
        return nums;
    }

    public static void sort(){
        Collections.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int idx = 0;
                while(idx < o1.length && o1[idx]==o2[idx]){
                    idx++;
                }
                return o1[idx]-o2[idx];
            }
        });

    }

    public static void print(){
        Iterator<int[]> iterator = res.iterator();
        while(iterator.hasNext()){
            int[] tmp = iterator.next();
            for (int i : tmp) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

}