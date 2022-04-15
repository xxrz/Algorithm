package class1_sort;

import java.util.Arrays;

public class QuickSort1 {
    //快速排序(类似于二叉树的先序遍历)
    //1.选择基准值：在待排序列中，按照某种方式挑出一个元素，作为基准值。
    //2.分割操作：以该基准值在序列中的实际位置，把序列分成两个子序列，一边是比它大的值，另外一边是比它小的值。
    //3.递归：对两个子序列进行快排，直到序列为空或者只有一个元素。

    public void quickSort(int[] arr) {
        if(arr==null || arr.length<2) return;
        quickSort(arr,0,arr.length-1);
    }

    public void quickSort(int[] arr,int s,int e){
        //base case
        if(s>=e) return;

        //随机交换最后一个
        swap(arr, s + (int) (Math.random() * (e - s + 1)), e);
        int m = partition(arr,s,e);

        quickSort(arr,s,m-1);
        quickSort(arr,m+1,e);
    }

    // arr[L..R]上，以arr[R]位置的数做划分值
    // <= X > X
    // <= X X

    public int partition(int[] arr,int s, int e){
        if(s > e) return -1;
        if(s == e) return s;

        int index = s;
        int lessEqual = s-1;
        while(index < e){
            if(arr[index] < arr[e]){
                swap(arr,++lessEqual,index++);
            }else {
                index++;
            }
        }
        swap(arr,++lessEqual,e);
        return lessEqual;
    }

    public void swap(int[]arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] data  = {73,74,75,71,69,72,76,73};
        QuickSort1 test = new QuickSort1();
        test.quickSort(data);
        System.out.println(Arrays.toString(data));
    }


}
