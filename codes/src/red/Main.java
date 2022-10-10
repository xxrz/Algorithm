package red;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
5 6 3
1 1 2 3 3 4
2 5 3 4 5 5
1 3 1 2 1 1
 */

public class Main {
    static int min = Integer.MAX_VALUE;
    static int cur_max = Integer.MIN_VALUE;
    static int step = 0;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[] starts = new int[m];
        int[] end = new int[m];
        int[] values = new int[m];
        used = new boolean[n];

        for(int i = 0;i < m;i++){
            starts[i] = scanner.nextInt()-1;
        }

        for(int i = 0;i < m;i++){
            end[i] = scanner.nextInt()-1;
        }

        for(int i = 0;i < m;i++){
            values[i] = scanner.nextInt();
        }

        List<Integer>[] graph = build(n,starts,end,values);
        dfs(n,graph,values,k,0);
        System.out.println(min);
    }


    static LinkedList<Integer> path = new LinkedList<>();


    public static void dfs(int n,List<Integer>[] graph,int[] values,int k,int i){
//        if(used[i]) return;
        if(used[i] || step > k){
            return;
        }

        if(values[i] > min){
            return;
        }

        used[i] = true;
        step++;
        boolean flag = false;
        int tmp = cur_max;
        if(cur_max < values[i]){
            cur_max = values[i];
            flag = true;
        }
        path.addLast(i);

        if(i==n-1){
            if(min > cur_max){
                min = cur_max;
            }
            System.out.println(path);
        }


        List<Integer> list = graph[i];
        for(Integer v:list){
            dfs(n,graph,values,k,v);
        }

        used[i] = false;
        if(flag){
            cur_max = tmp;
        }
        step--;
        path.removeLast();
    }

    private static List<Integer>[] build(int n, int[] starts, int[] end, int[] values) {
        List<Integer>[] graph = new List[n];

        for(int i = 0;i < n;i++){
            graph[i]= new ArrayList<>();
        }

        for(int i = 0;i < starts.length;i++){
            int from = starts[i];
            int to = end[i];
            graph[from].add(to);
            graph[to].add(from);
        }

        return graph;
    }
}
