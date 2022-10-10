package baidu;

/*
懒汉式；
1. 创建一个votaile的全局的类变量
2. 私有化构造函数
3. 创建对象的方法
    双重校验锁

 */
class LazySingle {
    //为什么是volatile：如果存在多线程，则指令重拍可能会导致出错
    private static volatile LazySingle lazySingle;

    private LazySingle(){}

    public static LazySingle getLazySingle(){
        if(lazySingle!=null) return lazySingle;

        //如果没有对象，则创建
        //为什么要加锁：保证只有一个线程在获取ExerciseLazySingle类的资源
        synchronized (LazySingle.class){
            if(lazySingle==null){
                //为什么要加判断：如果存在线程竞争，时间片轮转，则会导致可能exerciseLazySingle不为空
                lazySingle = new LazySingle();
            }
        }

        return lazySingle;
    }

}
