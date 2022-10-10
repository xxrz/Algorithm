package oppo;

import java.util.*;

//public class Main {
//    public static void main(String[] args) {
//        String str1 = "Hello world Hello world";
//        String str2 = "l**";
//
//        int left =  str1.length()-1,right =  str1.length()-1;
//        int idx = 0;
//        int res = 0;
//        boolean flag = false;
//        while(left >=0 && right >= 0){
//            char c = str1.charAt(right);
//            if(idx < str2.length() && (c==str2.charAt(idx) || str2.charAt(idx)=='*')){
//                if(left-right+1==str2.length()){
//                    flag = true;
//                    res = left;
//                    idx = 0;
//                    left--;
//                    right = left;
//                    continue;
//                }
//                right--;
//                idx++;
//            }else{
//                left--;
//                right = left;
//                idx = 0;
//            }
//        }
//        if(!flag) System.out.println(-1);
//        else System.out.println(res);
//    }
//}

public class Main{
    public static void main(String[] args) {
        ArrayList<List<Integer>> wakeLock = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(1234,1240);
        List<Integer> list2 = Arrays.asList(1236,1238,1245,1250);

        wakeLock.add(list1);
        wakeLock.add(list2);

        int n = wakeLock.size();
        double[] res = new double[n];
        //key:
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            List<Integer> list = wakeLock.get(i);
            int nn = list.size();
            for(int j = 0;j < nn;j+=2){
                res[i] += list.get(j+1)-list.get(j);
                for(int k = list.get(j);k < list.get(j+1);k++){
                    map.put(k,map.getOrDefault(k,0)+1);
                }
            }
        }

        for(int i = 0;i < n;i++){
            List<Integer> list = wakeLock.get(i);
            int nn = list.size();
            for(int j = 0;j < nn;j+=2){
                for(int k = list.get(j);k < list.get(j+1);k++){
                    if(map.get(k)>1){
                        res[i] -= 1.0/map.get(k);
                    }
                }
            }
        }

        for(int i = 0;i < n;i++){
            res[i] = (int)res[i];
        }

        System.out.println(Arrays.toString(res));

    }
}