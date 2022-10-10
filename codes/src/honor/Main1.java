package honor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        HashMap<String, List<String>> map = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        String name = "";
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            if(str.contains("{")){
                name =  str.trim().split(" ")[1];
                if(!map.containsKey(name)){
                    map.put(name,new LinkedList<String>());
                }
            }else if(str.contains(";") && !str.contains("}")){
                List<String> tmp = map.get(name);
                String type = "";
                if(str.contains("struct")){
                    type = str.trim().split(" ")[1];
                }else{
                    type = str.trim().split(" ")[0];
                }
                tmp.add(type);
                map.put(name,tmp);
            }else if(str.contains("sizeof")){
                String s = str.trim().substring(7,str.length()-1);
                int len = help(map,s);
                System.out.println(len);
            }else if(str.contains("};")){
                name = "";
            }
        }
    }

    public static int help(HashMap<String, List<String>> map, String key){
        int len = 0;
        boolean flag = false;
        System.out.println(key);
        if(map.containsKey(key)){
            List<String> list = map.get(key);
            for(int i = 0;i < list.size();i++){
                String s = list.get(i);
                if(s.equals("char")){
                    len += 1;
                }else if(s.equals("short")){
                    len += 2;
                }else if(s.equals("long")) {
                    len += 4;
                }else{
                    len += help(map,s);
                    if(flag){
                        len = 0;
                        return len;
                    }
                }
            }
            return len;
        }else{
            flag = true;
            return 0;
        }

    }
}
