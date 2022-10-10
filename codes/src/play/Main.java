package play;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {



//    public static void main(String[] args) {
//        int x = -1;
//        if (x>>>31==0){
//            System.out.println("正");
//        }else if (x>>>31==1){
//            System.out.println("负");
//        }
//    }

    /*
    其实修改的是Boolean 中的类变量的值
    public final class Boolean implements java.io.Serializable,
                                      Comparable<Boolean>
{
    public static final Boolean TRUE = new Boolean(true);
     */
//    static {
//        try {
////            首先通过反射拿到Boolean类中定义的TRUE这个变量
//            Field trueField = Boolean.class.getDeclaredField("TRUE");
//            trueField.setAccessible(true);
//
////            接着使用反射，去掉它的final修饰符
//            Field modifiersField = Field.class.getDeclaredField("modifiers");
//            modifiersField.setAccessible(true);
//            modifiersField.setInt(trueField, trueField.getModifiers() & ~Modifier.FINAL);
//
////            最后再将它的值设为false
//            trueField.set(null, false);
//        } catch(IllegalAccessException | NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//    }
//
//
    public static void main(String[] args) {
//        Boolean reality = true;
//        if(reality) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }
        int foo = foo(12, 20);
        System.out.println(foo);
    }

    public static int foo(int x, int y){
        if(x<=0 ||  y<=0)
            return 1;
        return 3*foo(x-6,y/2);
    }
//
//    public static void main(String[] args) {
//        //  System.out.println("coder Hydra");
    //\u000d
//    }
}
