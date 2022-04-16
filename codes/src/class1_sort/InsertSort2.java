package class1_sort;

import java.util.Arrays;

public class InsertSort2 {

    public int[] InsertSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return arr;

        for(int i = 1;i < arr.length;i++){
            for(int j = i-1;j >= 0;j--){
                if(arr[j] < arr[j + 1]){
                    swap(arr,i,j);
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
        InsertSort2 test = new InsertSort2();
        test.InsertSort(data);
        System.out.println(Arrays.toString(data));
    }
}
