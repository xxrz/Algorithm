package class1_sort;

import java.util.*;

public class Sort {

    public static void swap(int[]nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //冒泡排序，每次冒最大的值
    //稳定
    public static int[] BubbleSort(int[] nums){
        if (nums == null || nums.length < 2)
            return nums;

        for(int i = 0; i < nums.length; i++){
            for(int j = 1;j < nums.length-i;j++){
                if(nums[j-1] > nums[j]){
                    swap(nums,j-1,j);
                }
            }
        }
        return nums;
    }

    //选择排序,每次选最小的值
    //不稳定
    public static int[] SelectSort(int[] nums){
        if (nums == null || nums.length < 2)
            return nums;

        int smallIndex;
        for(int i = 0 ; i<nums.length; i++){
            smallIndex = i;
            for(int j = i; j < nums.length;j++){
                if(nums[j] < nums[smallIndex]){
                    smallIndex = j;
                }
            }
            swap(nums,smallIndex,i);
        }
        return nums;
    }

    //插入排序，i之前默认有序，从未有序中选一个数插入
    //稳定
    public static int[] InsertSort(int[] nums){
        if (nums == null || nums.length < 2)
            return nums;
        //1号元素默认有序
        for(int i = 1; i< nums.length ;i++){
            for(int j = i-1;j >=0 ;j--){
                if(nums[j] > nums[j+1]){  //在有序数组中从右向左遍历位置
                    swap(nums,j,j+1);
                }
            }
        }
        return nums;
    }

    //归并排序
    public static int[] mergeSort(int[] nums){
        if(nums==null || nums.length < 2){
            return nums;
        }
        return mergeSort(nums,0,nums.length-1);
    }

    public static int[] mergeSort(int[] nums,int L,int R){
        //递归返回条件
        if(L >= R)
            return nums;

        int mid  = L + ((R-L)>>1);
        mergeSort(nums,0,mid);
        mergeSort(nums,mid+1,R);
        return merge(nums,L,mid,R);
    }

    public static int[] merge(int[]nums, int L,int mid,int R){
        int p1 = L,p2 = mid+1;
        int[] help = new int[R-L+1];
        int index = 0;
        while(p1<=mid &&p2<=R){
            if(nums[p1] < nums[p2]) {
                help[index++] = nums[p1++];
            }else{
                help[index++] = nums[p2++];
            }
        }
        while(p1<=mid){
            help[index++] = nums[p1++];
        }

        while(p2<=R){
            help[index++] = nums[p2++];
        }

        //注意
        for(int i = 0;i < help.length; i++){
            nums[L+i] = help[i];
        }
        return nums;
    }

    //快速排序
    public static void QuickSort(int[] nums){
        if(nums==null || nums.length<2){
            return;
        }
        QuickSort(nums,0,nums.length-1);
    }

    public static void QuickSort(int[] nums,int L,int R){
        if(L>=R) {
            System.out.println(Arrays.toString(nums));
            return;
        }
        swap(nums,R,(int)(Math.random()*(R-L+1)+L));
        int less = partition(nums,L,R);
        QuickSort(nums,L,less);
        QuickSort(nums,less+1,R);
    }

    public static int partition(int[]nums, int L, int R){
        int pivot = nums[R];
        int index = L;
        int less = L-1;
        while(index < R){
            if(nums[index] < pivot){
                swap(nums,++less,index++);
            }else{
                index++;
            }
        }
        swap(nums,++less,R);
        return less;
    }


    //堆排
//    public static void HeapSort(int[] nums){
//        if(nums==null || nums.length < 2){
//            return;
//        }
//        int heapsize = nums.length;
//
//        while(heapsize > 0){
//            buildHeap(nums,heapsize);
//            swap(nums,--heapsize,0);
//        }
//    }
//
//    public static void heapify(int[] nums, int index,int heapSize){
//        int left = index*2 + 1,right = left + 1;
//        int largest = index;
//        while(left < heapSize){ //该条件是否有孩子
//            if(left < heapSize && nums[left] > nums[largest]){
//                largest = left;
//            }
//            if(right < heapSize && nums[right] > nums[largest]){
//                largest = right;
//            }
//            //注意终止条件
//            if(largest==index)
//                break;
//            swap(nums,index,largest);
//            index = largest;
//            left = 2*index + 1;
//        }
//    }
//
//    public static void buildHeap(int[] nums,int heapSize){
//        for(int i = heapSize-1; i >= 0; i--){
//            heapify(nums,i,heapSize);
//        }
//    }



//    public static void HeapSort(int[] arr) {
//        if (arr == null || arr.length < 2) {
//            return;
//        }
//        // O(N*logN)
////		for (int i = 0; i < arr.length; i++) { // O(N)
////			heapInsert(arr, i); // O(logN)
////		}
//        // O(N)
//        for (int i = arr.length - 1; i >= 0; i--) {
//            heapify(arr, i, arr.length);
//        }
//        int heapSize = arr.length;
//        swap(arr, 0, --heapSize);
//        // O(N*logN)
//        while (heapSize > 0) { // O(N)
//            heapify(arr, 0, heapSize); // O(logN)
//            swap(arr, 0, --heapSize); // O(1)
//        }
//    }
//
//    // arr[index]刚来的数，往上
//    public static void heapInsert(int[] arr, int index) {
//        while (arr[index] > arr[(index - 1) / 2]) {
//            swap(arr, index, (index - 1) / 2);
//            index = (index - 1) / 2;
//        }
//    }
//
//    // arr[index]位置的数，能否往下移动,移除的那个数
//    public static void heapify(int[] arr, int index, int heapSize) {
//        int left = index * 2 + 1; // 左孩子的下标
//        while (left < heapSize) { // 下方还有孩子的时候
//            // 两个孩子中，谁的值大，把下标给largest
//            // 1）只有左孩子，left -> largest
//            // 2) 同时有左孩子和右孩子，右孩子的值<= 左孩子的值，left -> largest
//            // 3) 同时有左孩子和右孩子并且右孩子的值> 左孩子的值， right -> largest
//            //有问题这样写
//            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
//            // 父和较大的孩子之间，谁的值大，把下标给largest
//            largest = arr[largest] > arr[index] ? largest : index;
//            if (largest == index) {
//                break;
//            }
//            swap(arr, largest, index);
//            index = largest;
//            left = index * 2 + 1;
//        }
//    }

    public static void HeapSort(int[] arr, int k) {
        //维护K值的大根堆
        if(arr==null||arr.length < 2){
            return;
        }
        int heapsize = arr.length;
        buildHeap(arr,heapsize);
        //调整堆
        swap(arr,--heapsize,0);
        while(heapsize > 0){
            heapify(arr,0,heapsize);
            swap(arr,--heapsize,0);
        }
    }

    public static void buildHeap(int[] arr,int heapsize){
        for(int i= arr.length-1; i >=0 ; i--){
            heapify(arr,i,arr.length);
        }
    }

    public static void heapify(int[] arr,int i,int heapsize){
        int left = 2*i + 1,right = left + 1;
        int largest = i;

        while(left < heapsize){
            if(left < heapsize && arr[left] > arr[largest]){
                largest = left;
            }
            if(right < heapsize && arr[right] > arr[largest]){
                largest = right;
            }
            if(largest==i){
                break;
            }
            swap(arr,largest,i);
            i = largest;
            left = 2*i + 1;
            right = left + 1;
        }
    }

    //桶排
    public static void bucketSort(int[] nums,int max){
        if(nums==null ||nums.length <2 ){
            return;
        }

        //建桶,因为数组从0开始，所以要+1
        int[] buckets = new int[max+1];

        //进桶
        for(int i = 0;i < nums.length;i++){
            buckets[nums[i]]++;
        }

        //排序
        for(int i = 0,j = 0;i < buckets.length;i++){
            while(buckets[i]>0){
                nums[j] = i;
                j++;
                buckets[i]--;
            }
        }
        buckets = null;
    }



    public static void main(String[] args) {
        Sort s = new Sort();
        int[] nums = {0,0,1,2,4,2,2,3,1,4};
//        BubbleSort(nums);
//        SelectSort(nums);
//        InsertSort(nums);
//        mergeSort(nums);
//        QuickSort(nums);
        s.HeapSort(nums,8);
//        bucketSort(nums,9);
        System.out.println(Arrays.toString(nums));
    }
}
