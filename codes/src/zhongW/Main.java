package zhongW;

import java.util.*;

//public class Main {
////    O(1)删除链表
////    只给一个要删除的节点
////    提示：可以改变内部的值
//    static class ListNode{
//        int val;
//        ListNode next;
//
//        ListNode(int val){
//            this.val = val;
//        }
//    }
//    ListNode tar;
//    public ListNode create(){
//        ListNode head = new ListNode(0);
//        ListNode cur = head;
//        for(int i = 1;i < 5;i++){
//            cur.next = new ListNode(i);
//            if(i==3) tar = cur;
//            cur = cur.next;
//
//        }
//        return head;
//    }
//
//    //因为这个tar是我心new的，如何返回head中的3呢
//    public ListNode delete(ListNode head){
//        System.out.println("tar"+tar.val);
//        if(tar!=null){
//            if(tar.next!=null) {
//                tar.val = tar.next.val;
//                tar.next = tar.next.next;
//            }else{
//                tar = null;
//            }
//        }
//        return head;
//    }
//
//
//    public static void main(String[] args) {
//        Main main = new Main();
//        ListNode head = main.create();
//        ListNode h = main.delete(head);
//        ListNode cur = h;
//        while(cur!=null){
//            System.out.println(cur.val);
//            cur = cur.next;
//        }
//    }
//}

//public class Main{
//
//    //判断快乐数
//    //19=》 1*1+9*9 = 82; 8*8+2*2 = 68;6*6+8*8 = 100,1*1+0+0 = 1 是快乐数
//    //111=》 1*1 +1*1+1*1 = 3; 3*3 =9; 9*9 = 81,8*8+1*1 = 65,
//    //如何收敛呢
//    //输入：19 true
//    //111 false
//    public static boolean isHappy(int n) {
//        // System.out.println(getNext(38));
//        //隐含链表
//        int slow = n;
//        int fast = getNext(n);
//        while(slow!=fast){
//            slow = getNext(slow);
//            fast = getNext(getNext(fast));
//        }
//
//        return slow==1? true:false;
//    }
//
//    public static int getNext(int n){
//        int sum = 0;
//        while(n!=0){
//            int digit = n % 10;
//            n = n/10;
//            sum += digit * digit;
//        }
//        return sum;
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        System.out.println(isHappy(n));
//    }
//}

//public class Main{
//    //给一个序列判断三角形
//    //输入：[2 3 4 4]
//    //输出：4
//}


public class Main{
    PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    });
}
