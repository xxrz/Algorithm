package class1_sort;

import java.util.Arrays;

public class HeapSort1 {

    public int[] heapSort(int[] arr){
        if(arr==null || arr.length<2) return arr;

        //建堆
        int heapSize = arr.length;
        buildHeap(arr);
        //删除最大元素
        swap(arr,--heapSize,0);
        //调整堆
        while(heapSize > 0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
        return arr;
    }

    //下沉
    public void heapify(int[] nums, int index, int heapSize){
        int left = index*2 + 1,right = left + 1;
        int largest = index;
        while(left < heapSize){ //该条件是否有孩子
            if(nums[left] > nums[largest]){
                largest = left;
            }
            if(right < heapSize && nums[right] > nums[largest]){
                largest = right;
            }
            //注意终止条件
            if(largest==index)
                break;
            swap(nums,index,largest);
            //继续向下调整
            index = largest;
            left = 2*index + 1;
            right = left + 1;
        }
    }

    public void buildHeap(int[] arr){
        //
        for(int i = arr.length-1; i>=0 ;i--){
            heapify(arr,i,arr.length);
        }
    }

    public void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] data  = {73,74,75,71,69,72,76,73};
        HeapSort1 test = new HeapSort1();
        test.heapSort(data);
        System.out.println(Arrays.toString(data));
    }

}
