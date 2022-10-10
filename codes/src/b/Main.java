package b;

import java.util.Arrays;
import java.util.Scanner;

/*
4 4
1 2 2 1
1 2 2 1
2 1 1 2
1 2 1 2
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[][] nums = new long[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                nums[i][j] = scanner.nextLong();
            }
        }
        long res =  0;
        //对应的四个角都要相同
        long[] tmp = new long[5];
        for(int i = 0;i  < n;i++){
            for(int j = 0;j < m;j++){
                tmp[1] = nums[i][j];
                System.out.println(i+"\t"+j);
                System.out.println(n-i-1+"\t"+j);
                System.out.println(i+"\t"+ (m-j-1));
                System.out.println(n-i-1+"\t"+(m-j-1));
                tmp[2]= nums[n-i-1][j];
                tmp[3] = nums[i][m-j-1];
                tmp[4] = nums[n-i-1][m-j-1];
                //排序找到中位数：为tmp[2]
                Arrays.sort(tmp,1,4);

                for(int k = 1;k<=4;k++){
                    //不是中位数则++
                    if(tmp[k]!=tmp[2]) res+=1;
                }
            }
            System.out.println();
        }
        //四个角，每次都要判断一次，所以除以4就可
        System.out.println(res/4);
    }
}
