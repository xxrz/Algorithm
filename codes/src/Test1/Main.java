package Test1;


import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/*
 * 利用全排列解决猜算式问题
 * 全排列：利用递归实现全排列，每次用当前交脚标值进行和其他值的交换
 */
public class Main {


    public static void main(String[] args) throws IOException {
        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream("F:\\xrz\\桌面\\Algorithm\\codes\\src\\Test1\\test");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String str = null;
        HashMap<Integer,Integer> map = new HashMap<>();
        while((str = bufferedReader.readLine()) != null)
        {
            String[] cs = str.split(",");
            for(String c:cs){
                int num = Integer.parseInt(c);
                map.put(num,map.getOrDefault(num,0)+1);
            }

//            System.out.println(str);
        }
        System.out.println(map);

        //close
        inputStream.close();
        bufferedReader.close();
    }
}
