package honor;

import java.util.LinkedList;

class test {

    LinkedList<Integer> s1;
    LinkedList<Integer> s2;

    public test() {
        s1 = new LinkedList<>();//正常
        s2 = new LinkedList<>();//最小栈
    }

    public void push(int val) {
        s1.addLast(val);
        if(!s2.isEmpty() && s2.getLast() > val){
            s2.addLast(val);
        }
    }

    public void pop() {
        int v = s1.removeLast();
        if(v==s2.getLast()){
            s2.removeLast();
        }

    }

    public int top() {
        return s1.getLast();
    }

    public int getMin() {
        return s2.getLast();
    }
}