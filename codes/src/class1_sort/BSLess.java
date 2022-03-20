package class1_sort;

public class BSLess {
    //在数组上获取，局部最小值
    //分index去讨论
//    1）长度为1，arr[0]就是局部最小；
//    2）数组的开头，如果arr[0] < arr[1] ，arr[0]被定义为局部最小。
//    3）数组的结尾，如果arr[N-1] < arr[N-2] ，arr[N-1]被定义为局部最小。
//    4）任何一个中间位置i, 即数组下标1~N-2之间, 必须满足arr[i-1] > arr[i] <arr[i+1] ,叫找到一个局部最小。

    public static int getLessIndex(int[] arr) {
        //处理错误
        if (arr==null || arr.length==0){
            return -1;
        }
        //处理开头
        if (arr.length==1){
            return arr[0];
        }
        if (arr[0] < arr[1]){
            return arr[0];
        }
        //处理结尾
        if (arr[arr.length-1]<arr[arr.length-2]){
            return arr[arr.length-1];
        }
        //处理中间
        int L = 1;
        int R = arr.length-2;
        while(L<R){
            int mid = L + ((R-L)>>1);
            if(arr[mid] > arr[mid+1]){
                L = mid + 1;
            }
            else if(arr[mid] > arr[mid-1]){
                R = mid - 1;
            }
            else
                return mid;
        }
        return L;
    }

    public static void main(String[] args){
        System.out.println(5/2);
    }

}
