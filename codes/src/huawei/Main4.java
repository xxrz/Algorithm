package huawei;

import java.util.Scanner;

public class Main4 {
    static int min = Integer.MAX_VALUE;
    static boolean[][] used;
    static int t;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        t = scanner.nextInt();

        used = new boolean[m][n];

        int[][] nums = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                nums[i][j] = scanner.nextInt();
            }
        }
        dfs(nums,0,0,0,0,0,0);
        System.out.println(min);

    }

    private static void dfs(int[][] nums, int i,int j,int cnt,int level,int lastx,int lasty) {
        if(i >= nums.length || j>=nums[0].length ||i<0 || j<0 || used[i][j] || cnt >= 3){
            return;
        }

        if(nums[lastx][lasty]-nums[i][j] > t){
            cnt++;
        }

        used[i][j] = true;

        if(i==nums.length-1 && j==nums[0].length-1){
            if(cnt <= t){
                min = Math.min(min,level);
            }
            used[i][j]=false;
            return;
        }

        for(int k = 0;k < 4;k++){
            int x = dx[k]+i;
            int y = dy[k]+j;
            dfs(nums,x,y,cnt,level+1,i,j);
        }

        used[i][j]=false;
    }
}
