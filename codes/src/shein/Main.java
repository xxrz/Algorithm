package shein;

import java.util.ArrayList;

//静态类
class Main{


//    //sdfdsf2[asjdfhd]
//    //s = asjdfhd
//    public static String decodeString(String s) {
//        if(onlyString(s)){
//            return s;
//        }
//
//        int index = 0;
//        int len = s.length();
//
//        StringBuilder res = new StringBuilder();
//        while(index < len){
//            char ch = s.charAt(index);
//            if('a' <= ch && ch <= 'z'){
//                res.append(ch);
//                index++;
//            }else{
//                int num = 0;
//                int left = index;
//                int right = index;
//                while(right < len && s.charAt(right) >= '0' && s.charAt(right) <= '9')
//                    right++;
//                num = Integer.parseInt(s.substring(left, right));
//                left = right;
//                right++;
//                int leftP = 1;
//                while(leftP != 0){
//                    char temp = s.charAt(right);
//                    if(temp == '['){
//                        leftP++;
//                    }else if(temp == ']'){
//                        leftP--;
//                    }
//
//                    if(leftP == 0)
//                        break;
//                    right++;
//                }
//
//                String smallFrac = decodeString(s.substring(left + 1, right));
//                for(int i = 0; i < num; i++)
//                    res.append(smallFrac);
//
//                index = right + 1;
//            }
//        }
//
//        return res.toString();
//    }
//

//    public static void main(String[] args) {
//        String s = "ajhdjs3[acd]";
//        String res = decodeString(s);
//        System.out.println(res);
//    }

    public static boolean onlyString(String s){
        int index = 0;
        while(index != s.length()){
            char ch = s.charAt(index);

            if(ch == '[' || ch == ']')
                return false;
            index++;
        }

        return true;
    }


    public static String decodeString(String s) {
        //sjdfk
        if (onlyString(s)) return s;

        StringBuilder res = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            //sdf5[]
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                res.append(s.charAt(i));
                i++;
                //3[..]
            } else {
                int num = 0;
                int left = i, right = i;
                while (s.charAt(right) <= '9' && s.charAt(right) >= '0') {
                    right++;
                }
                //[]
                num = Integer.parseInt(s.substring(left, right));
                left = right;
                right++;
                int leftP = 1;
                while (leftP != 0) {
                    if (s.charAt(right) == ']') leftP--;
                    else if (s.charAt(right) == '[') leftP++;
                    if (leftP == 0) break;
                    right++;
                }

                String tmp = decodeString(s.substring(left + 1, right));
                System.out.println(tmp);
                for (int idx = 0; idx < num; idx++) {
                    res.append(tmp);
                }

                //跳过]
                i = right + 1;
//                System.out.println(s.charAt(i-1));
            }
        }
        return res.toString();
    }

    private static int x =100;

    public static void main(String[] args) {
//        Main main = new Main();
//        main.x++;
//        System.out.println(main.x);
//        Main main1 = new Main();
//        main1.x++;
//        System.out.println(main1.x);
//        Main main2 = new Main();
//        main2.x++;
//        System.out.println(main2.x);
//        Main.x--;
//        System.out.println(Main.x);

        Integer num1 = new Integer(1);
        Integer num2  = num1;
        System.out.println(num2);
        test(num2);
        System.out.println(num1==num2);
        num2  = new Integer(3);
        System.out.println(num1==num2);
    }

    private static void test(Integer num2) {
        num2 = new Integer(2);
        ArrayList<Object> objects = new ArrayList();
    }

}
