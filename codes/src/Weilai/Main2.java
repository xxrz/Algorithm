package Weilai;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

//public class Main2 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cnt = scanner.nextInt();
//        int[] nums = new int[cnt];
//        for(int i = 0;i < cnt;i++){
//            nums[i] = scanner.nextInt();
//        }
//        int n = scanner.nextInt();
//        for(int i = 0;i < n;i++){
//            int sum = 0;
//            int num = scanner.nextInt();
//            for(int j = 0;j < cnt;j++){
//                nums[j] = nums[j] + num;
//                sum += Math.abs(nums[j]);
//            }
//            System.out.println(sum);
//        }
//    }
//}

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = scanner.nextInt();
        LinkedList<Integer> nums = new LinkedList<>();
        for(int i = 1;i <= people;i++){
            nums.add(i);
        }
        int cnt = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0;i < cnt;i++){
            String door = scanner.nextLine();
            if(door.equals("A")){
                A(nums);
            }else{
                B(nums);
            }
        }
    }

    public static void A(LinkedList<Integer> nums){
        int n = nums.removeFirst();
        nums.addLast(n);
        System.out.println(nums);
    }
    public static void B(LinkedList<Integer> nums){
        Collections.reverse(nums);
        System.out.println(nums);
    }
}
