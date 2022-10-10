package bytes;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> set = new ArrayList<>();
        int cnt = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0;i < cnt;i++){
            String str = scanner.nextLine();
            boolean flag1 = false;
            if(set.contains(str)) {
                System.out.println("yes");
                flag1 = true;
            }

            if(set.size()==10){
                set.remove(0);
            }
            set.add(str);

            if(flag1) continue;

            HashSet<Character> cs = new HashSet<>();
            cs.add('q');
            cs.add('w');
            cs.add('k');
            cs.add('h');
            cs.add('j');
            int left = -1,right = 0;
            boolean flag = false;
            while(right < str.length()){
                char c = str.charAt(right);
                if(!cs.contains(c)){
                    left = right;
                }
                int len = right-left;
                if(len >=5) {
                    System.out.println("yes");
                    flag=true;
                    break;
                }
                right++;
            }
            if(!flag)
                System.out.println("no");
        }
        System.out.println();
    }
}

//public class Main{
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        String[][] nums = new String[n][m];
//        for(int i = 0;i < n;i++){
//
//            nums[i] = scanner.nextLine();
//        }
//        System.out.println();
//
//
//    }
//}