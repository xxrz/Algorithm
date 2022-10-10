package wangyi;

import java.util.*;

/*
方法一：暴力dfs
首先遍历所有点，每个点used为true
从上下左右四个方向走
然后每个方向进行一次dfs，四个方向都为true则为制高点

注意：刚开始吧所有的都ran在一起了，所以导致了算法有诸多问题，比如要保证入口点的四个方向都为true(&&)，其他点的dfs有一个为true(||)
那么就分开，不要ran在一起
 */
//public class Main1 {
//    static ArrayList<Integer> res = new ArrayList<>();
//    static int[] dx = {-1,1,0,0};
//    static int[] dy = {0,0,-1,1};
//    static boolean[][] used;
//    static boolean resFlag = true;
//
//    public static void main(String[] args) {
//        int[][] nums = {{1,3,2,3,5},{3,4,5,6,3},{2,7,4,3,3},{5,2,2,3,1}};
//        for(int i = 0;i < nums.length;i++){
//            for(int j = 0;j < nums[0].length;j++){
////                System.out.println("i:"+i+"\tj:"+j);
//                resFlag = true;
//                for(int k = 0;k < 4;k++){
//                    used = new boolean[nums.length][nums[0].length];
//                    used[i][j] = true;
//                    int x = i+dx[k];
//                    int y = j+dy[k];
//                    boolean flag = dfs(nums,x,y,nums[i][j]);
////                    System.out.println("\tpre:"+nums[i][j]+"\tflag:"+flag);
//                    if(!flag) {
//                        resFlag = false;
//                        break;
//                    }
//                }
//                if(resFlag)
//                    res.add(nums[i][j]);
//            }
//        }
//        System.out.println(res);
//    }
//
//    public static boolean dfs(int[][] nums,int i,int j,int pre){
//
//        if(i >= nums.length || i < 0 || j >= nums[0].length || j < 0) {
//            return true;
//        }
//
//        if(used[i][j]) return false;
//
//        used[i][j] = true;
//
//        if(nums[i][j] >= pre) return false;
//
//        for(int k = 0;k < 4;k++){
//            int x = i + dx[k];
//            int y = j + dy[k];
//            boolean tmp = dfs(nums,x,y,nums[i][j]);
//            if(tmp) return true;
//        }
//
//        return false;
//    }
//}


/*
优化：bfs
既然从每个点走向边缘的搜索有些低效，那么不妨以边缘的所有点为起点向内部进行搜索，看下一个节点是否不小于自己的值（这和下山的规则相反）。
标记能够到达的点为True，继续搜索，直到不能走为止。
按照这样的思路，标记四个边界可以到达的点，都为True的点为制高点。（也就是四个集合的交集）
这就是典型的逆向思维，算法中经常要求这种逆向思维
 */
public class Main1 {
    static ArrayList<String> res = new ArrayList<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static HashSet<String>[] flag;

    public static void main(String[] args) {
        int[][] nums = {{1,3,2,3,5},{3,4,5,6,3},{2,7,4,3,3},{5,2,2,3,1}};
        flag = new HashSet[4];
        for(int i = 0;i < 4;i++){
            flag[i] = new HashSet<>();
        }

        for(int i = 0;i < nums[0].length;i++) {
            bfs(nums,0,i,0);
            bfs(nums,nums.length-1,i,1);
        }

        for(int i = 0;i < nums.length;i++) {
            bfs(nums,i,0,2);
            bfs(nums,i,nums[0].length-1,3);
        }

        for(String set:flag[0]){
            boolean f = true;
            for(int i = 1;i <= 3;i++){
                if(!flag[i].contains(set)){
                    f= false;
                    break;
                }
            }
            if(f) res.add(set);
        }
        System.out.println(res);

    }

    public static void bfs(int[][] nums,int i,int j,int idx){
        boolean[][] used = new boolean[nums.length][nums[0].length];

        LinkedList<int[]> q = new LinkedList<>();
        q.addLast(new int[]{i,j});

        while(!q.isEmpty()){
            int[] tmp = q.removeFirst();
            int x1 = tmp[0];
            int y1 = tmp[1];
            used[x1][y1] = true;
            flag[idx].add(x1+"#"+y1);

            for(int k = 0;k < 4;k++){
                int x = x1 + dx[k];
                int y = y1 + dy[k];
                if(x < nums.length && x >= 0 && y < nums[0].length && y >= 0 && !used[x][y] && nums[x1][x1] < nums[x][y]){
                    q.addLast(new int[]{x,y});
                }
            }
        }
    }
}