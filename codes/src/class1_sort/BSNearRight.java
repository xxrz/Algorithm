package class1_sort;

import java.util.Arrays;

public class BSNearRight {
    //在一个有序数组中，找小于等于某个数最右侧的位置 <=
    public static int nearestIndex(int[] sortedArr, int value) {
        int L = 0;
        int R = sortedArr.length-1;
        //index的初始化的值是 不存在数组中的
        int index = -1;
        //注意等值，至少一个数
        while(L <= R){
            int mid = L + ((R-L) >> 1);
            //发现左侧有小于目标值的，抛弃左边，左边下标L=mid+1
            if(sortedArr[mid] <= value){
                index = mid;
                L = mid + 1;
            }
            else{
                R = mid -1;
            }
        }
        return index;
    }
    // for test
    public static int test(int[] arr, int value) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= value) {
                return i;
            }
        }
        return -1;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
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

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != nearestIndex(arr, value)) {
                printArray(arr);
                System.out.println(value);
                System.out.println(test(arr, value));
                System.out.println(nearestIndex(arr, value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
