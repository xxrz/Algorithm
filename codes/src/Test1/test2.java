package Test1;

import java.util.Arrays;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int[] nums = new int[cnt];
        for(int i = 0;i <nums.length;i++){
            nums[i] = scanner.nextInt();
        }

        mergeSort(nums);

        System.out.println(Arrays.toString(nums));

    }

    public static void mergeSort(int[] nums){
        mergeSort(nums,0,nums.length-1);
    }

    //[]
    public static void mergeSort(int[] nums,int left,int right){
        if(left==right) return;

        int mid = left + (right-left)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid + 1,right);
        merge(nums,left,mid,right);
    }

    public static void merge(int[] nums,int left,int mid,int right){
        int[] tmp = new int[right-left+1];
        int idx = 0;
        int p1 = left;
        int p2 = mid+1;
        while(p1 <= mid && p2 <= right){
            if(nums[p1] < nums[p2]){
                tmp[idx] = nums[p1];
                p1++;
            }else{
                tmp[idx] = nums[p2];
                p2++;
            }
            idx++;
        }

        while(p1 <= mid){
            tmp[idx++] = nums[p1++];
        }

        while(p2 <= right){
            tmp[idx++] = nums[p2++];
        }

        for(int i = 0;i < tmp.length;i++){
            nums[left + i] = tmp[i];
        }
    }
}
