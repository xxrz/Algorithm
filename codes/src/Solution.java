import java.util.*;

class Solution {
    // //快速选择
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private static int[] quickSearch(int[] nums, int L, int R, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int res = partition(nums, L, R);
        if (res == k) {
            return Arrays.copyOf(nums, res + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return res > k? quickSearch(nums, L, res - 1, k): quickSearch(nums, res + 1, R, k);
    }
    public static int partition(int[] arr,int L,int R){
        int less = L-1;
        int pivot = arr[R];
        int index = L;

        while(index < R){
            if(arr[index] < pivot){
                swap(arr,++less,index);
            }
            index++;
        }
        swap(arr,++less,R);
        return less;
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}