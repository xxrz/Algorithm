package meituan;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cnt = scanner.nextLine();
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        int left = 0,right = 0;
        int idx = 0;
        int res = 0;
        while(left < str1.length() && right < str1.length()){
            char c = str1.charAt(right);
            if(c==str2.charAt(idx) || str2.charAt(idx)=='*'){
                if(right-left+1==str2.length()){
                    res++;
                    idx = 0;
                    left++;
                    right = left;
                    continue;
                }
                right++;
                idx++;

            }else{
                left++;
                right = left;
                idx = 0;
            }
        }
        System.out.println(res);
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.forEach(System.out::println);
    }
}

//public class Main1{
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int sumPower = Integer.parseInt(scanner.nextLine().split(" ")[1]);
//        String[] powers1 = scanner.nextLine().split(" ");
//        String[] times1 = scanner.nextLine().split(" ");
//
//        int[] powers = new int[powers1.length];
//        int[] times = new int[times1.length];
//        for(int i = 0;i < powers.length;i++){
//            powers[i] = Integer.parseInt(powers1[i]);
//            times[i] = Integer.parseInt(times1[i]);
//        }
//
//        if(powers[0] > sumPower) {
//            System.out.println("-1");
//            return;
//        }
//        //先把0加入，必须从0开始
//        path.add(0);
//        power += powers[0];
//
//        //然后从1 开始dfs
//        dfs(powers,times,sumPower,1);
//        System.out.println(minTime);
//
//    }
//
//    static int minTime = Integer.MAX_VALUE;
//    static int power = 0;
//
//    static LinkedList<Integer> path = new LinkedList<>();
//    public static void dfs(int[] powers, int[] times, int sumPower, int idx){
//
//        if(power > sumPower) return;
//
//        int tmp = cal(times);
//        System.out.println(path);
//        System.out.println("time:"+tmp);
//        minTime = Math.min(minTime,tmp);
//
//        for(int i = idx;i < powers.length;i++){
//            //选择加入
//            power += powers[i];
//            path.addLast(i);
//            dfs(powers,times,sumPower,i+1);
//            path.removeLast();
//            power -= powers[i];
//        }
//    }
//
//    public static int cal(int[] times){
//        int time = 0;
//        for(int i = 0;i < path.size();i++){
//            if(i==path.size()-1){
//                if(path.get(i)==times.length-1){
//                    time = Math.max(path.get(i),time);
//                }else{
//                    time = Math.max(times[i]*(times.length - path.get(i)),time);
//                }
//            }
//            if(i+1 < path.size()){
//                int l1 = path.get(i);
//                int l2 = path.get(i+1);
//                time = Math.max(times[l1]*(l2-l1),time);
//            }
//
//        }
//
//        return time;
//    }
//}
