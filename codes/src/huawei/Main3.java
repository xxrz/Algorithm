package huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/*
5
3
1 2 30
1 5 20
3 5 10
 */
//public class Main3 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int[] nums = new int[n+1];
//        Arrays.fill(nums,Integer.MAX_VALUE);
//        for(int idx = 0;idx < m;idx++){
//            int start = scanner.nextInt();
//            int end = scanner.nextInt();
//            int value = scanner.nextInt();
//            for(int i = start;i <= end;i++){
//                if(nums[i] > value){
//                    nums[i]=value;
//                }
//            }
//        }
//        int res = 0;
//        for(int i = 1;i <= n;i++){
//            res += nums[i];
//        }
//        System.out.println(res);
//    }
//}


//public class Main3{
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cnt = Integer.parseInt(scanner.nextLine());
//        for(int i = 0;i < cnt;i++){
//            String str = scanner.nextLine();
//            int idx1 = str.indexOf("*");
//            int idx2 = str.indexOf("=");
//            String num1 = str.substring(0,idx1);
//            String num2 = str.substring(idx1+1,idx2);
//            String num3 = str.substring(idx2+1);
//            if(Integer.parseInt(num1)*Integer.parseInt(num2)==Integer.parseInt(num3)){
//                System.out.println(0);
//                continue;
//            }
//            int res = bfs(str,idx1,idx2);
//            System.out.println(res);
//        }
//    }
//
//    public static int bfs(String num,int idx1,int idx2){
//        LinkedList<String> q = new LinkedList<>();
//        HashSet<String> set = new HashSet<>();
//        q.add(num);
//        set.add(num);
//
//        int step = 0;
//        while(!q.isEmpty()){
//            int len = q.size();
//            for(int i = 0;i < len;i++){
//                //草这块不能再错了啊啊啊啊啊
//                String str = q.removeFirst();
//                for(int k = 0;k < str.length();k++){
//                    for(char j = '0';j <= '9';j++){
//                        //刚开始忘记考虑分割位置了
//                        if(k==idx1 || k==idx2) continue;
//                        StringBuilder sb = new StringBuilder(str);
//                        sb.setCharAt(k,j);
//                        String tmp = sb.toString();
//
//                        String num1 = tmp.substring(0,idx1);
//                        String num2 = tmp.substring(idx1+1,idx2);
//                        String num3 = tmp.substring(idx2+1);
//
//                        if(num1.length()>1 && num1.charAt(0)=='0' || num2.length()>1 && num2.charAt(0)=='0'
//                                ||num3.length()>1 && num3.charAt(0)=='0') continue;
//
//
//                        System.out.println(tmp);
//                        if(Integer.parseInt(num1)*Integer.parseInt(num2)==Integer.parseInt(num3)){
//                            System.out.println(num1+"\t"+num2+"\t"+num3);
//                            return step + 1;
//                        }
//
//                        if(!set.contains(sb.toString())){
//                            set.add(tmp);
//                            q.add(tmp);
//                        }
//                    }
//                }
//            }
//            step++;
//        }
//        return -1;
//    }
//}

/*
2
100 100 100
10000 8000
60 60 60
60 60 60

3
200 200 200
10000 8000 7000
150 150 150
80 80 80
90 90 90

3
200 200 200
10000 8000 7000
300 100 100
100 300 100
100 100 300

* */
public class Main3{
    static class Node{
        int need1;
        int need2;
        int need3;
        int value;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        sum = new int[3];
        used = new boolean[cnt];
        state = new int[3];
        max = 0;
        Node[] projects = new Node[cnt];
        for(int i = 0;i < 3;i++){
            sum[i] = scanner.nextInt();
        }
        for(int i = 0;i < cnt;i++ ){
            projects[i] = new Node();
            projects[i].value = scanner.nextInt();
        }
        for(int i = 0;i < cnt;i++ ){
            projects[i].need1 = scanner.nextInt();
            projects[i].need2 = scanner.nextInt();
            projects[i].need3 = scanner.nextInt();
        }
        dfs(projects,0);
        System.out.println(max);
    }

    static boolean[] used;
    static int[] sum;
    static int[] state;
    static int value;
    static int max;
    public static void dfs(Node[] projects,int start){

        for(int i = start;i < projects.length;i++){
            if(used[i]) continue;

            value += projects[i].value;
            state[0] += projects[i].need1;
            state[1] += projects[i].need2;
            state[2] += projects[i].need3;
            used[i] = true;

            if(state[0] <= sum[0] && state[1] <=sum[1] && state[2]<=sum[2]){
                max = Math.max(max,value);
            }else{
                return;
            }

            dfs(projects,i+1);

            value -= projects[i].value;
            state[0] -= projects[i].need1;
            state[1] -= projects[i].need2;
            state[2] -= projects[i].need3;
            used[i] = false;
        }
    }
}