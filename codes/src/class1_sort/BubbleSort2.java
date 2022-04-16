package class1_sort;

import java.util.Arrays;

public class BubbleSort2 {

    public int[] bubbleSort(int[] arr) {
        if(arr==null || arr.length<2) return arr;

        for(int i =0;i < arr.length;i++){
            for(int j=1;j < arr.length-i;j++){
                if(arr[j-1] > arr[j]){
                    swap(arr,j-1,j);
                }
            }
        }

        return arr;

    }


    public void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] data  = {73,74,75,71,69,72,76,73};
        BubbleSort2 test = new BubbleSort2();
        test.bubbleSort(data);
        System.out.println(Arrays.toString(data));
    }
}
