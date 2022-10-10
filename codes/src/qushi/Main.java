package qushi;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    /*
     * 方法1：
     * 这是真的非常暴力
     * 每次在原串中找到与数组中匹配的index中的最小值进行返回
     * 然后修改原串，再去找，直到找不到了
     *
     * 需要注意的是：一定一定一定要先想清楚，再写！！！不然思路太乱了我真的求求了
     * 不要用什么不熟悉的数据结构，没有好下场什么treeMap，你在题里见过？
     * 哪怕用最暴力最简单的方式自己去实现，都不要用不熟悉的数据结构，可能根本不是你想的那样
     * indexOf, replace,replaceFirst
     * 匹配%不用转义，真他么神奇
     *
     * */
    public static void main(String[] args) {
        String str = "%FILENAME%VIRUSNAME%BADHJSHF%VIRUSNAME%FILENAME%";
        String[] dic = {"FILENAME","VIRUSNAME"};
        String[] content = {"myfile","sb"};

        HashMap<String,String> map = new HashMap<>();
        for(int i = 0;i < dic.length;i++){
            String tmp = "%" + dic[i] + "%";
            map.put(tmp,content[i]);
        }

        while(true){
            String tmp = help(str,dic);
            if(tmp.isEmpty()) break;
            str = str.replaceFirst(tmp,map.get(tmp));
        }
        System.out.println(str);
    }

    public static String help(String str, String[] dic){
        int min = Integer.MAX_VALUE;
        String res="";
        for(int i = 0;i < dic.length;i++){
            String f = "%" + dic[i] + "%";
            int t = str.indexOf(f);
            if(t!=-1 && min > t){
                min = t;
                res = f;
            }
        }
        return res;
    }

//    /*
//    * 方法2：
//    * 关键点在于把%的下标存下来，然后依次比较%%内部的值，map中是否存在
//    * 不要改原串，如果map中存在就加入res，如果不存在就加入原来的串
//    *
//    * */
//    public static void main(String[] args) {
//        String str = "%FILENAME%VIRUSNAME%BADHJSHF%VIRUSNAME%FILENAME%";
//        String[] dic = {"FILENAME","VIRUSNAME"};
//        String[] content = {"myfile","sb"};
//
//        HashMap<String,String> map = new HashMap<>();
//        for(int i = 0;i < dic.length;i++){
//            String tmp = "%" + dic[i] + "%";
//            map.put(tmp,content[i]);
//        }
//
//        ArrayList<Integer> idxs = new ArrayList<>();
//        for(int i = 0;i < str.length();i++){
//            char c = str.charAt(i);
//            if(c=='%'){
//                idxs.add(i);
//            }
//        }
//
//        if(idxs.size()<2) return;
//        int left =  0;
//        int right = 0;
//        StringBuilder res = new StringBuilder();
//        for(int i = 0;i < idxs.size()-1;){
//            left =  idxs.get(i);
//            right = idxs.get(i+1);
//            String tmp = str.substring(left,right+1);
//            if(map.containsKey(tmp)){
//                res.append(map.get(tmp));
//                i= i+2;
//            }else{
//                res.append(str.substring(left,right+1));
//                i++;
//            }
//        }
//        res.append(str.substring(right+1));
//
//        System.out.println(res.toString());
//    }
}
