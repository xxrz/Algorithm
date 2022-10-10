package baidu;

/*
饿汉式：
1.定义一个私有的构造方法
2.定义一个类变量并实例化
3.定义一个可以获取单例的方法
 */
public class Single {

    private static Single single = new Single();

    private Single(){}

    private Single getSingle(){
        return single;
    }

}
