package Star;

import java.io.*;
import java.util.*;

////第一题：暴力
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cnt = scanner.nextInt();
//        for(int k = 0;k < cnt;k++){
//            int len = scanner.nextInt();
//            int[] nums = new int[len];
//            for(int i = 0;i < len;i++){
//                nums[i] = scanner.nextInt();
//            }
//
//            int res = help(nums);
//            System.out.println(res);
//        }
//    }
//
//    private static int help(int[] nums) {
//        int cnt = 0;
//        for(int j = 1;j < nums.length;j++){
//            for(int i = j-1;i>=0;i--){
//                if(nums[j] > nums[i] && nums[j]-nums[i]==j-i){
//                    cnt++;
//                }
//            }
//        }
//        return cnt;
//    }
//}

////第一题：利用HashMap进行优化
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cnt = scanner.nextInt();
//        for(int k = 0;k < cnt;k++){
//            int len = scanner.nextInt();
//            int[] nums = new int[len];
//            for(int i = 0;i < len;i++){
//                nums[i] = scanner.nextInt();
//            }
//
//            int res = help(nums);
//            System.out.println(res);
//        }
//    }
//
//    //优化的关键思想是：转换公式
//    //找nums[i] - i == nums[j] - j;
//    //HashMap<nums[i]-i,次数>
//    //并且边遍历，边保存，可以保证在i < j的情况下，统计nums[i] - i == nums[j] - j相等的次数
//    //然后利用公式进行求和计算
//    private static int help(int[] nums) {
//        long cnt = 0;
//
//        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
//        for(int i = 0;i < nums.length;i++){
//            int diff = nums[i]-i;
//            if(map.containsKey(diff))
//                map.put(diff,map.get(diff)+1);
//            else{
//                map.put(diff,1);
//            }
//        }
//
////        System.out.println(map);
//
//        for(Integer i : map.values()){
//            if(i > 1){
//                //这样得到的结果是 map:{1=5, 5=1}
//                //则求的过程是，4+3+2+1,所以不用循环，直接利用公式求出结果为
//                //((i-1) + 1)*(i-1)/2 [首项+末项]/2
//                cnt += (i-1)*i/2;
//            }
//        }
//
//        return cnt;
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
//        while(t > 0){
//            t--;
//            int n = scanner.nextInt();
//            int[] arr = new int[n];
//            List<Integer> record = new ArrayList<>();
//            long ct = 0;
//            for(int i = 0;i < n;i++){
//                arr[i] = scanner.nextInt();
//                if(arr[i]!=(i+1))
//                    record.add(i);
//                else ct++;
//            }
//
//            long res = ct * (ct-1)/2;
////            long res = 0;
//            while(record.size()>0){
//                int base = arr[record.get(0)];
//                int base_id = record.get(0);
//                long count = 1;
//                List<Integer> tp = new ArrayList<>();
//
//                for(int i = 1;i < record.size();i++){
//                    if(arr[record.get(i)]-base==record.get(i) - base_id){
//                        count++;
//                    }else{
//                        tp.add(record.get(i));
//                    }
//                }
//
//                if(count > 1){
//                    //此处会越界
//                    res += count*(count-1)/2;
//                }
//                record = tp;
//            }
//            System.out.println(res);
//        }
//
//    }
//}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(System.out));
//        int t = Integer.parseInt(rd.readLine());
//        while(t > 0){
//            t--;
//            int n = Integer.parseInt(rd.readLine());
//            String[] in = rd.readLine().split(" ");
//
//            int[] arr = new int[n];
//            List<Integer> record = new ArrayList<>();
//            long ct = 0;
//            for(int i = 0;i < n;i++){
//                arr[i] = Integer.parseInt(in[i]);
//                if(arr[i]!=(i+1))
//                    record.add(i);
//                else ct++;
//            }
//
//            long res = ct * (ct-1)/2;
////            long res = 0;
//            while(record.size()>0){
//                int base = arr[record.get(0)];
//                int base_id = record.get(0);
//                long count = 1;
//                List<Integer> tp = new ArrayList<>();
//
//                for(int i = 1;i < record.size();i++){
//                    if(arr[record.get(i)]-base==record.get(i) - base_id){
//                        count++;
//                    }else{
//                        tp.add(record.get(i));
//                    }
//                }
//
//                if(count > 1){
//                    //此处会越界
//                    res += count*(count-1)/2;
//                }
//                record = tp;
//            }
////            System.out.println(res);
//            wt.write(Long.toString(res));
//            wt.newLine();
//        }
//        wt.flush();
//
//    }
//}

////第二题：dfs
////先序
//public class Main{
//
//    static int min = Integer.MAX_VALUE;
//    //最短路的结果，最短路的次数
//    static HashMap<Integer,Integer> res = new HashMap();
//    static int[] dx = {-1,1,0,0};
//    static int[] dy = {0,0,-1,1};
//    static boolean[][] used;
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int len = scanner.nextInt();
//        int[][] nums = new int[len][len];
//        for(int i = 0;i < len;i++){
//            for(int j = 0;j < len;j++){
//                nums[i][j] = scanner.nextInt();
//            }
//        }
//
//        used = new boolean[len][len];
//        long l = System.currentTimeMillis();
//
//        dfs(nums,0,0,0);
//
//        if(min==Integer.MAX_VALUE){
//            System.out.println(0);
//            System.out.println(0);
//        }else{
//            System.out.println(min);
//            System.out.println(res.get(min));
//        }
//
//        long l1 = System.currentTimeMillis();
//        System.out.println(l1-l);
//
//    }
//
//    public static int dfs(int[][] nums,int i,int j,int step){
//        if(i >= nums.length || i < 0 || j >= nums.length || j < 0 || nums[i][j]==0 || used[i][j]){
//            return Integer.MAX_VALUE;
//        }
//
//        if(i==nums.length-1 && j==nums.length-1){
//            if(step <= min){
//                if(res.containsKey(step)){
//                    res.put(step,res.get(step) + 1);
//                }else{
//                    res.put(step,1);
//                }
//                min = step;
//            }
////            System.out.println(step);
////            used[i][j] = false;
////            return step;
//        }
//
//
//        step++;
//        used[i][j] = true;
//
//        for(int k = 0;k < 4;k++){
//            int x = dx[k] + i;
//            int y = dy[k] + j;
//
//            dfs(nums,x,y,step);
//        }
//
//        used[i][j] = false;
//
//        return step;
//    }
//}

//第二题：dfs + memo
//后序 + memo
//先序没有办法加memo，因为传递的信息不足
// 这道题好像没有办法后序，可以记录最小值，但没有办法记录最小值的次数
public class Main{

    static int min = Integer.MAX_VALUE;
    //最短路的结果，最短路的次数
    static HashMap<Integer,Integer> res = new HashMap();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] used;
    static int[][] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[][] nums = new int[len][len];
        for(int i = 0;i < len;i++){
            for(int j = 0;j < len;j++){
                nums[i][j] = scanner.nextInt();
            }
        }

        used = new boolean[len][len];
        memo = new int[len][len];
        for(int i = 0;i < len;i++){
            Arrays.fill(memo[i],-1);
        }

        System.out.println(dfs(nums,0,0)-1);

//        if(min==Integer.MAX_VALUE/2+1){
//            System.out.println(0);
//            System.out.println(0);
//        }else{
//            System.out.println(min);
//            System.out.println(res.get(min));
//        }

    }

    public static int dfs(int[][] nums,int i,int j){
        if(i >= nums.length || i < 0 || j >= nums.length || j < 0 || nums[i][j]==0 || used[i][j]){
            return Integer.MAX_VALUE/2;
        }

        if(i==nums.length-1 && j==nums.length-1){
            return 1;
        }

//        if(memo[i][j]!=-1) {
//            res.put(memo[i][j],res.get(memo[i][j]) + 1);
//
//            return memo[i][j];
//        }

        int step = Integer.MAX_VALUE/2;
        used[i][j] = true;

        for(int k = 0;k < 4;k++){
            int x = dx[k] + i;
            int y = dy[k] + j;
            step = Math.min(step,dfs(nums,x,y));
//            System.out.println(step);
        }

        used[i][j] = false;

        int r = step + 1;
        //这块变成2以后再也不会变了
        //因为不会再小了，min是全局的，只记录了一步
//        if(r <= min){
//            if(res.containsKey(r)){
//                res.put(r,res.get(r) + 1);
//            }else{
//                res.put(r,1);
//            }
//            min = r;
//        }

//        memo[i][j] = r;
        return r;
    }
}

////bfs 更简单一些
////不用回溯是吧
//public class Main{
//
//    static int[] dx = {-1,1,0,0};
//    static int[] dy = {0,0,-1,1};
//    static boolean[][] used;
//    static int cnt = 0;
//    static int min = 0;
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int len = scanner.nextInt();
//        int[][] nums = new int[len][len];
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < len; j++) {
//                nums[i][j] = scanner.nextInt();
//            }
//        }
//
//        used = new boolean[len][len];
//        long l = System.currentTimeMillis();
//
//        bfs(nums);
//        if(cnt==0){
//            System.out.println(0);
//        }else{
//            System.out.println(min);
//        }
//        System.out.println(cnt);
//        System.out.println(System.currentTimeMillis()-l);
//    }
//
//    public static void bfs(int[][] nums){
//        LinkedList<int[]> q = new LinkedList<>();
//        q.addLast(new int[]{0,0});
//
//        while(!q.isEmpty()){
//            int len = q.size();
//            for(int i = 0;i < len;i++){
//                int[] cur = q.removeFirst();
//                used[cur[0]][cur[1]] = true;
//                if(cur[0]==nums.length-1 && cur[1]==nums.length-1){
//                    cnt++;
//                }
//                for(int k = 0;k < 4;k++){
//                    int x = cur[0] + dx[k];
//                    int y = cur[1] + dy[k];
//                    if(x >= nums.length || x < 0 || y >= nums.length || y < 0 || nums[x][y]==0 || used[x][y]){
//                        continue;
//                    }
//                    q.addLast(new int[]{x,y});
//                }
//            }
//            if(cnt!=0) break;
//            min++;
//        }
//    }
//}

//第三题：思路
//public class Main{
//    public static void main(String[] args) {
//        //思路：
//        //先利用HashMap<String,Object>存储所有的变量，其中变量名要符合规范
//        //然后用一个ArrayList存储这一行的结果
//        //用一个栈保留表达式的结果
//
//        //对用户的输入进行解析，先将表达式切成原子的：
//        //  先检查有无括号，有则将()的表达式切成一串，然后放到ArrayList中
//        //  检查有无and , or，切成不同的原子表达式，放入ArrayList中，并记录是and还是or
//
//        //遍历ArrayList对每个原子表示进行解析：
//        //  如果是符号：+,-,*,/ ：先考虑所有的*/法，将这些运算后的结果放回原表达式的相应位置，然后计算整个表达式的值，也就是整数的+-
//        //      如果是+：将数字入栈
//        //      如果是-：入数字的相反数
//        //      如果是*: 则直接取栈顶进行*
//        //      如果是/: 则直接去栈顶进行/
//        //  如果是 < , >: 则将栈内的元素相加作为第一操作数，和右边的数字相比，将结果替换ArrayList中的相对应的位置
//        //  如果是 = ：则将栈内的元素相加作为第一操作数，和右边的数字相比，看是否相等，将结果替换ArrayList中的相对应的位置
//        //  如果是is：判断是is not null 还是is null,然后将栈内的元素相加作为第一操作数，进行判断，将结果替换ArrayList中的相对应的位置
//        //  如果是合理的变量名，则在HashMap中查找他的值，进行替换为数字
//        //  如果是数字：找到连续的数字，作为整个数字，然后存在临时变量中，等待遇到+ - * /再考虑
//        //直到ArrayList只剩下单个，则即为所求
//
//        //然后将所有ArrayList中的结果合并输出
//        //  如果是布尔值，则按规则转为数字
//
//        //当不合法的时候要进行异常处理，输出Error
//        //  包括：变量的命名，true和false的大小写，包含多个相连的and 或者 or
//    }
//}