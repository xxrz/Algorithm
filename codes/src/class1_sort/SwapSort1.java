package class1_sort;

import java.util.Arrays;

public class SwapSort1 {
    public int[] SelectSort(int[] arr) {
        if(arr==null || arr.length<2) return arr;
        //每次选择最小
        for(int i = 0;i < arr.length;i++){
            int smallIndex = i;
            for(int j = i;j < arr.length;j++){
                if(arr[i] > arr[j]){
                    smallIndex = j;
                }
            }
            swap(arr,smallIndex,i);
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
        SwapSort1 test = new SwapSort1();
        test.SelectSort(data);
        System.out.println(Arrays.toString(data));
    }
}
