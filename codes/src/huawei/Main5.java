package huawei;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[][] nums = new int[len][len];

        for(int i = 0;i < len;i++){
            for(int j = 0;j < len;j++){
                nums[i][j] = scanner.nextInt();
            }
        }
        Main5 main5 = new Main5();
        main5.dfs1(nums,0,0);
        System.out.println(res);
    }
    static int res = 0;
    int sum1 = 0; //遍历每一条第一个路径，然后用求df2的最大值
    int sum2 = 0; //第二条路径的和
    int max2 = 0; //第二条路径的最大值

    public void dfs1(int[][] nums,int i,int j){
        if(i < 0 || i>=nums.length || j<0 || j>=nums.length ) return;


        boolean flag = false;
        if(nums[i][j]!=0) {
            flag=true;
            nums[i][j] -= 1;
            sum1 += 1;
        }

        if(i==nums.length-1 && j==nums.length-1){
            max2 = 0;
            dfs2(nums,nums.length-1,nums.length-1);
            int cur = sum1 + max2;
            res = Math.max(cur,res);
        }

        dfs1(nums,i+1,j);
        dfs1(nums,i,j+1);


        if(flag) {
            sum1 -= 1;
            nums[i][j] += 1;
        }
    }

    public void dfs2(int[][] nums,int i,int j){
        if(i < 0 || i>=nums.length || j<0 || j>=nums.length) return;
        if(nums[i][j]!=0)
            sum2 += 1;

        if(i==0 && j==0){
            max2 = Math.max(max2,sum2);
        }

        dfs2(nums,i-1,j);
        dfs2(nums,i,j-1);

        if(nums[i][j]!=0)
            sum2 -= 1;
    }
}
