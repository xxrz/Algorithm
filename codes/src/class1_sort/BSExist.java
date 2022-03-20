package class1_sort;

import java.util.Arrays;

public class BSExist {
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length-1;
        int mid = 0;
        //至少两个数
        while(L < R){
            mid = L + ((R-L) >> 1);
            //mid = L + (R-L)/2;
            if (sortedArr[mid] == num)
                return true;
            else if(sortedArr[mid] > num){
                R = mid - 1;
            }
            else{
                L = mid + 1;
            }
        }
        //注意返回条件：不是简单的return false，最终L和R相等时
        //不用soredArr[L]是因为，当mid为0时，R会变成-1，导致越界
        return sortedArr[L]==num;
    }

    // for test
    public static boolean test(int[] sortedArr, int num) {
        for(int cur : sortedArr) {
            if(cur == num) {
                return true;
            }
        }
        return false;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != exist(arr, value)) {
                succeed = false;
                printArray(arr);
                System.out.println(value);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
