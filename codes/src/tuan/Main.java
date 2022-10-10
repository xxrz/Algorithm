package tuan;

import java.util.*;


///*
//6 5
//5 6 7 8 9 10
// */
//class Main{
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int t = scanner.nextInt();
//        int[] deadline = new int[n];
//        for(int i = 0;i < deadline.length;i++){
//            deadline[i] = scanner.nextInt();
//        }
//
//        Arrays.sort(deadline);
//        if(deadline[0] >= n*t){
//            System.out.println(0);
//            return;
//        }
//
//        int cnt = 0; //魔法
//        int num = 1; //不用魔法
//        for(int i = 0;i < deadline.length;i++){
//            if(num*t > deadline[i] || deadline[i] < t){
//                cnt++;
//            }else{
//                num++;
//            }
//        }
//        System.out.println(cnt);
//
//    }
//}

//public class Main {
////     有点鸡肋
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int k = scanner.nextInt();
//        Scanner scanner1 = new Scanner(System.in);
//        String str = scanner1.nextLine();
//        char[] cs = str.toCharArray();
//        HashMap<Character,int[]> map = new HashMap<>();
//
//        map.put('S',new int[]{0,1});
//        map.put('W',new int[]{0,-1});
//        map.put('A',new int[]{-1,0});
//        map.put('D',new int[]{1,0});
//
//        boolean[][] used = new boolean[n][m];
//        used[0][0] = true;
//        int x = 0;
//        int y = 0;
//        for(int i = 0;i < k;i++){
//            char c = cs[i];
//            int[] tmp = map.get(c);
//            int x1 = x + tmp[0];
//            int y1 = y + tmp[1];
//            used[x1][y1] = true;
//            x = x1;
//            y = y1;
//            if(check(used)){
//                System.out.println("Yes");
//                System.out.println(i+1);
//                return;
//            }
//        }
//
//        int cnt = 0;
//        for(int i = 0;i <used.length;i++){
//            for(int j = 0;j<used[0].length;j++){
//                if(used[i][j]==false){
//                    cnt++;
//                }
//            }
//        }
//
//        System.out.println("No");
//        System.out.println(cnt);
//
//    }
//
//    public static boolean check(boolean[][] used){
//        for(int i = 0;i <used.length;i++){
//            for(int j = 0;j<used[0].length;j++){
//                if(!used[i][j]){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//}

///*
//2 2 5
//SDWAS
//*/
//public class Main{
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int k = scanner.nextInt();
//        scanner.nextLine();
//        String str = scanner.nextLine();
//
//        boolean[][] used = new boolean[n][m];
//        used[0][0] = true;
//        int x = 0;
//        int y = 0;
//        int cnt = 1;
//        for(int i = 0;i < str.length();i++){
//            char c = str.charAt(i);
//            if(c=='W') y--;
//            else if(c=='S') y++;
//            else if(c=='A') x--;
//            else if(c=='D') x++;
//            if(!used[x][y]){
//                cnt++;
//                used[x][y] = true;
//                if(cnt==n*m){
//                    System.out.println("Yes");
//                    System.out.println(i+1);
//                    return;
//                }
//            }
//        }
//        System.out.println("No");
//        System.out.println(n*m-cnt);
//    }
//}



//public class Main{
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cnt = scanner.nextInt();
//        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
//        int[] nums = new int[cnt];
//        for(int i = 0;i < cnt;i++){
//            nums[i] = scanner.nextInt();
//            if(!map.containsKey(nums[i])){
//                map.put(nums[i],new ArrayList<>());
//                map.get(nums[i]).add(i);
//            }
//            map.get(nums[i]).add(i);
//        }
//
//        int res = 0;
//        for(int i = 0;i < nums.length;i++){
//            res += help(nums,map,i);
//        }
//        System.out.println(res);
//    }
//
//    public static int help(int[]nums,HashMap<Integer, ArrayList<Integer>> map,int i){
//        int sum = 3*nums[i];
//        int cnt = 0;
//        for(int idx = 0;idx < i;idx++){
//            int num1 = nums[idx];
//            if(map.containsKey(sum-num1)){
//                ArrayList<Integer> tmp = map.get(sum-num1);
//                int j = 0;
//                while(j < tmp.size() && tmp.get(j) <= i){
//                    j++;
//                }
//                cnt += tmp.size()-j;
//            }
//        }
//        return cnt;
//    }
//
//}

///*
//4
//1 2 3 4
// */
//public class Main{
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cnt = scanner.nextInt();
//        int[] nums = new int[cnt];
//        for(int i = 0;i < nums.length;i++){
//            nums[i] = scanner.nextInt();
//        }
//
//        long t = System.currentTimeMillis();
//        LinkedList<Integer> q = new LinkedList<>();
//        for(int i = nums.length-1;i >= 0;i--){
//            q.addFirst(nums[i]);
//            if(q.size()==1) continue;
//            q.addFirst(q.removeLast());
//            q.addFirst(q.removeLast());
//        }
//        System.out.println(q);
//        System.out.println(System.currentTimeMillis()-t);
//    }
//}

//public class Main{
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        int cnt = scanner.nextInt();
//        int[] nums = new int[cnt];
//        for(int i = 0;i < nums.length;i++){
//            nums[i] = scanner.nextInt();
//        }
//
//        long l = System.currentTimeMillis();
//        Deque<Integer> dq = new ArrayDeque<>();
//        for(int i = nums.length-1;i >= 0;i--){
//            dq.addFirst(nums[i]);
//            if(dq.size()==1) continue;
//            dq.addFirst(dq.removeLast());
//            dq.addFirst(dq.removeLast());
//        }
//        System.out.println(dq);
//        System.out.println(System.currentTimeMillis()-l);
//    }
//}

//public class Main{
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        int cnt = scanner.nextInt();
//        ArrayList<Integer> idx = new ArrayList<>();
//        int[] nums = new int[cnt];
//        for(int i = 0;i < cnt;i++){
//            nums[i]= scanner.nextInt();
//            idx.add(i);
//        }
//
//        int[] res = new int[cnt];
//        int start = 0;
//        for(int i = 0;i < cnt;i++){
//            start = (start + 2) % idx.size();
//            int num = idx.get(start);
//            res[num] = nums[i];
//            idx.remove(start);
//        }
//
//        System.out.println(Arrays.toString(res));
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cnt = scanner.nextInt();
//        int[] nums = new int[cnt+1];
//        for(int i = 1;i <=cnt;i++){
//            nums[i] = scanner.nextInt();
//        }
//
//        dfs(nums,1);
//        System.out.println(max);
//
//    }
//    static int sum = 0;
//    static int max = Integer.MIN_VALUE;
//    public static void dfs(int[] nums, int i){
//        if(i >= nums.length) return;
//
//        int left = 2*i;
//        int right = 2*i + 1;
//        sum += nums[i];
//
//        if(left > nums.length && right > nums.length){
//            max = Math.max(max,sum);
//            sum-= nums[i];
//            return;
//        }
//
//        dfs(nums,left);
//        dfs(nums,right);
//        sum-= nums[i];
//    }
//}

public class Main{
    public static void main(String[] args) {
        String[] strs=  {"03:56","02:57","04:56","01:22"};
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        //[01:22, 02:57, 03:56, 04:56]
        System.out.println(Arrays.toString(strs));
    }
}