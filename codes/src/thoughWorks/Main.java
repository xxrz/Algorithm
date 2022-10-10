package thoughWorks;

import java.util.LinkedList;
import java.util.Scanner;

//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int m = scanner.nextInt();
//        int n = scanner.nextInt();
//        int i = scanner.nextInt();
//        int start = m;
//        while(start <= n){
//            if(start%i==0) break;
//            start++;
//        }
//        int cnt = (n-start)/i;
//        int end = start + i*cnt;
//        int res = (start+end)*(cnt+1)/2;
//        System.out.println(res);
//    }
//}

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> nums = new LinkedList<>();
        int[] tmp = {1,2,5,8,10,6};
        for(int num:tmp){
            nums.add(num);
        }

        LinkedList<Integer> res = help(nums);
        int len = res.size();
        while(len > 2){
            res = help(res);
            len = res.size();
        }
        System.out.println(res.toString());

    }

    public static LinkedList<Integer> help(LinkedList<Integer> nums){
        LinkedList<Integer> list = new LinkedList<>();
        int left = 0;
        int right = nums.size()-1;
        while(left < right){
            list.addLast(nums.get(left)+nums.get(right));
            left++;
            right--;
        }
        if(nums.size()%2!=0) list.addLast(nums.get(left));
        return list;
    }
}
