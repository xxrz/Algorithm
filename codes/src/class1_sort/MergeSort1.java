package class1_sort;

import java.util.Arrays;

//归并排序就像二叉树的后序遍历
public class MergeSort1 {

    public void mergeSort(int[] numbers){
        if(numbers==null || numbers.length < 2 ) return;

        mergeSort(numbers,0,numbers.length-1);

        System.out.println(Arrays.toString(numbers));

    }

    //先排左边，再排右边，再合并
    public void mergeSort(int[] numbers,int low,int high){
        //base case
        if(low==high) return;

        System.out.println(low+"  ----   "+high);

        int mid = low + (high-low)/2;
        //[low,mid]
        mergeSort(numbers,low,mid);
        //[mid+1,high]
        mergeSort(numbers,mid+1,high);
        merge(numbers,low,mid,high);
    }
    // 将 nums[lo..mid] 和 nums[mid+1..hi] 这两个有序数组合并成一个有序数组
    public void merge(int[] numbers,int low, int mid,int high){
        int[] help = new int[high-low+1];
        int p1 = low;
        int p2 = mid + 1;
        int idx = 0;
        while(p1<=mid && p2<=high){
            if(numbers[p1] < numbers[p2]){
                help[idx] = numbers[p1++];
            }
            else if(numbers[p1] >= numbers[p2]){
                help[idx] = numbers[p2++];
            }
            idx++;
        }

        while(p1<=mid){
            help[idx++] = numbers[p1++];
        }

        while(p2<=high){
            help[idx++] = numbers[p2++];
        }

        //复制回去
        for(int i = low;i <= high;i++){
            numbers[i] = help[i-low];
        }
    }

    public static void main(String[] args) {
        MergeSort1 test = new MergeSort1();
        int[] data  = {73,74,75,71,69,72,76,73};
        test.mergeSort(data);
    }

}
