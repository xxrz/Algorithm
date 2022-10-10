package keda;

import java.util.*;

//public class Main {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int size = scanner.nextInt();
//        double[] nums = new double[size];
//        for(int i = 0;i < size;i++){
//            nums[i] = scanner.nextDouble();
//        }
//
//
//        for(int i = 0;i < size;i++){
//            nums[i] = (int)Math.round(nums[i]*(0.5*(1-Math.cos((2*Math.PI*(double)((double)i/(double)size))))));
//        }
//
//        System.out.println(Arrays.toString(nums));
//    }
//
//}


//public class Main{
//    //判断直角三角形
//    public static void main(String[] args) {
//        int cnt = 8;
//        int[][] data= new int[cnt][2];
//        Main main = new Main();
//        int res = main.solution(data);
//        System.out.println(res);
//    }
//
//    //任意选三个点进行判断
//    public int solution(int[][] data){
//        int cnt = 0;
//        for(int i = 0;i < data.length;i++){
//            for(int j = i + 1;j < data.length;j++){
//                for(int k = j + 1;k < data.length;k++){
//                    int[] p1 = data[i];
//                    int[] p2 = data[j];
//                    int[] p3 = data[k];
//                    if(judge(p1,p2,p3))
//                        cnt++;
//                }
//            }
//        }
//        return cnt;
//    }
//
//    //判断是否为直角三角形
//    public boolean judge(int[] p1,int[] p2,int[] p3){
//        int dis1 = dis(p1,p2);
//        int dis2 = dis(p2,p3);
//        int dis3 = dis(p1,p3);
//
//        if(dis1==dis2 + dis3 ||
//                dis2==dis1 + dis3 ||
//                    dis3==dis2 + dis1)
//            return true;
//        return false;
//    }
//
//    //边的平方
//    public int dis(int[] p1, int[] p2){
//        int x1 = p1[0],y1 = p1[1];
//        int x2 = p2[0],y2 = p2[1];
//        return Math.abs(x1-x2)*Math.abs(x1-x2) + Math.abs(y1-y2)*Math.abs(y1-y2);
//    }
//}

public class Main{
    public static void main(String[] args) {

    }
}