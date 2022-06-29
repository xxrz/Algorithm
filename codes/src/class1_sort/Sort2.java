package class1_sort;

import java.util.Arrays;

public class Sort2 {
    //记得分析时间复杂度
    public static void main(String[] args) {
        int[] nums = {5,6,8,9,3,2,6,4,2};
        Sort2 sort2 = new Sort2();
//        System.out.println(Arrays.toString(sort2.Bubble(nums)));
//        System.out.println(Arrays.toString(sort2.Select(nums)));
//        System.out.println(Arrays.toString(sort2.Insert(nums)));
        System.out.println(Arrays.toString(sort2.MergeSort(nums)));
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     *冒泡排序：相邻两两比较进行交换
     *
     *时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *稳定性：可以是稳定的
     * @param nums
     * @return
     */
    public int[] Bubble(int[] nums){
        int len = nums.length;

        for(int i = 0;i < len;i++){
            for(int j = 0;j < len-i-1;j++){
                //相邻的进行比较
                if(nums[j] > nums[j + 1]){
                    swap(nums,j,j+1);
                }
            }
        }

        return nums;
    }

    /**
     *选择排序：选择一个最小的再进行一次交换
     *时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *稳定性：不稳定
     * 6、7、6、2、8
     * @param nums
     * @return
     */
    public int[] Select(int[] nums){
        for(int i = 0;i < nums.length;i++){
            int min = i;
            for(int j = i;j < nums.length;j++){
                if(nums[min] > nums[j]){
                    min = j;
                }
            }
            swap(nums,i,min);
        }
        return nums;
    }

    /**
     *插入排序：分成两个区间，前一个区间有序，后一个区间的数，从后往前查找第一个区间中小于当前数的值，进行交换
     *时间复杂度：O(n^2)
     *空间复杂度：O(1)
     *稳定性：稳定
     *
     * @param nums
     * @return
     */
    public int[] Insert(int[] nums){

        for(int i = 1;i < nums.length;i++){
            for(int j = i;j > 0;j--) {
                if (nums[j] < nums[j-1]) {
                    swap(nums, j, j-1);
                }
            }
        }

        return nums;
    }

    //归并排序
    /**
     *归并排序：分治
     *时间复杂度：O(nlogn)
     *空间复杂度：O(n)
     *稳定性：稳定
     * @param nums
     * @return
     */
    public int[] MergeSort(int[] nums){
        return MergeSort(nums,0,nums.length-1);
    }

    //[low,high]
    //左闭有开好像处理不了单个的情况，因为不包含右边嘛
    public int[] MergeSort(int[] nums, int low, int high){

        if(high <= low) return nums;

        int mid = low + (high-low)/2;

        MergeSort(nums,low,mid);
//        System.out.println("left:"+Arrays.toString(nums));
        MergeSort(nums,mid+1,high);
//        System.out.println("right:"+Arrays.toString(nums));
        Merge(nums,low,mid,high);
//        System.out.println("merge:"+Arrays.toString(nums));

        return nums;
    }

    private void Merge(int[] nums, int low, int mid, int high) {
        //区间1和区间2均为有序的
        int idx1 = low,idx2 = mid+1, idx = 0;
        int[] res = new int[high-low+1];

        while(idx1 <= mid && idx2 <= high){
            if(nums[idx1] < nums[idx2]){
                res[idx] = nums[idx1];
                idx1++;
            }else{
                res[idx] = nums[idx2];
                idx2++;
            }
            idx++;
        }

        while(idx1 <= mid){
            res[idx++] = nums[idx1++];
        }

        while(idx2 <= high){
            res[idx++] = nums[idx2++];
        }

        for(int i = low;i <= high;i++){
            nums[i] = res[i-low];
        }
    }


    //快排

    //堆排序

    //桶排
}
