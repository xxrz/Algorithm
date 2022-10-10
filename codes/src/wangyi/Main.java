package wangyi;

import sun.awt.image.ImageWatched;

import java.util.*;

//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int num1  =scanner.nextInt();
//        int num2 = scanner.nextInt();
//
//        int res = bfs(num1,num2);
//        System.out.println(res);
//    }
//
//    private static int bfs(int num1, int num2) {
//        if (valid(num1, num2)) return 0;
//
//        LinkedList<int[]> q = new LinkedList<>();
//        HashSet<String> set = new HashSet<>();
//        int step = 0;
//        q.add(new int[]{num1, num2});
//
//        while (!q.isEmpty()) {
//            int len = q.size();
//            for (int i = 0; i < len; i++) {
//                int[] tmp = q.removeFirst();
//                num1 = tmp[0];
//                num2 = tmp[1];
//                String tmp1 = String.valueOf(num1);
//                String tmp2 = String.valueOf(num2);
//                if (valid(num1, num2)) return step;
//
//                for (int k = 0; k < tmp1.length() && tmp1.length() > 1; k++) {
//                    int newnum1 = Integer.parseInt(new StringBuilder(tmp1).deleteCharAt(k).toString());
//                    int[] t = new int[]{newnum1, num2};
//                    if(valid(newnum1, num2)) return step+1;
//                    String key = newnum1 + "#" + num2;
//                    if(!set.contains(key)){
//                        q.add(t);
//                        set.add(key);
//                    }
//                }
//
//                for (int k = 0; k < tmp2.length() && tmp2.length() > 1; k++) {
//                    int newnum2 = Integer.parseInt(new StringBuilder(tmp2).deleteCharAt(k).toString());
//                    int[] t = new int[]{num1, newnum2};
//                    if(valid(num1, newnum2)) return step+1;
//                    String key = num1 + "#" + newnum2;
//                    if (!set.contains(key)) {
//                        q.add(t);
//                        set.add(key);
//                    }
//                }
//            }
//            step++;
//        }
//        //无论如何都不能成为倍数，我不知道有没有这个
//        return -1;
//    }
//
//
//    public static boolean valid(int num1,int num2){
//        if(num1 < num2){
//            if(num2 % num1==0) return true;
//        }else{
//            if(num1 % num2==0) return true;
//        }
//        return false;
//    }
//}


//public class Main{
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
////        while(scanner.hasNext()) {
//            String str = scanner.next();
//            dfs(str, 0);
//            System.out.println(minSum);
////        }
//    }
//
//    static int sum = 0;  //表示修改的次数
//    static int maxCnt = Integer.MIN_VALUE;
//    static int minSum = Integer.MAX_VALUE;
//
//    public static void dfs(String str,int i){
//
//
//      //  System.out.println(str);
//        int cnt = len(str);  //当前的e的数量
//        if(cnt > maxCnt){
//            maxCnt = cnt;
//            minSum = sum;
////            System.out.println("******"+str+"\tminsum: " + minSum + "\tmaxCnt:"+ maxCnt);
//        }else if(cnt==maxCnt){
//            minSum = Math.min(sum,minSum);
////            System.out.println("******"+str+"\tminsum: " + minSum + "\tmaxCnt:"+ maxCnt);
//        }
//
//        if(i==str.length()){
//            return;
//        }
//
//        char c = str.charAt(i);
//        if(c=='r'){
//            sum += 1;
//            String tmp1 = str.substring(0,i) + 'e' + str.substring(i+1);
//            dfs(tmp1,i+1);
//            String tmp2 = str.substring(0,i) + 'd' + str.substring(i+1);
//            dfs(tmp2,i+1);
//            sum -= 1;
//            dfs(str,i+1);
//
//        }else if(c=='e'){
//            sum += 1;
//            String tmp1 = str.substring(0,i) + 'r' + str.substring(i+1);
//            dfs(tmp1,i+1);
//            String tmp2 = str.substring(0,i) + 'd' + str.substring(i+1);
//            dfs(tmp2,i+1);
//            sum -=1;
//            dfs(str,i+1);
//        }else if(c=='d'){
//            sum += 1;
//            String tmp1 = str.substring(0,i) + 'r' + str.substring(i+1);
//            dfs(tmp1,i+1);
//            String tmp2 = str.substring(0,i) + 'e' + str.substring(i+1);
//            dfs(tmp2,i+1);
//            sum -= 1;
//            dfs(str,i+1);
//        }
//
//    }
//    public static int len(String str){
//        int res = 0;
//        res += getCount(str,"red");
//        res += getCount(str,"der");
//        return res;
//    }
//
//    public static int getCount(String mainStr, String substr) {
//        int mainLength = mainStr.length();
//        int subLength = substr.length();
//        int count = 0;
//        int index = 0;
//        if (mainLength >= subLength) {
//            while ((index = mainStr.indexOf(substr, index)) != -1) {
//                count++;
//                index += subLength;
//            }
//            return count;
//        } else {
//            return 0;
//        }
//    }
//}

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int[] nums = new int[cnt];
        int max1 = Integer.MIN_VALUE; //奇数
        int max2 = Integer.MIN_VALUE; //偶数
        for(int i = 0;i < cnt;i++){
            nums[i] = scanner.nextInt();
            if(i%2!=0){
                max1 = Math.max(max1,nums[i]);
            }else{
                max2 = Math.max(max2,nums[i]);
            }
        }

        if(max1==max2) max1++;

        int res = 0;
        for(int i=0;i < cnt;i++){
            if(i%2!=0){
                res += max1-nums[i];
            }else{
                res += max2-nums[i];
            }
        }
        System.out.println(res);

    }
}