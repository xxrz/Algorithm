package huawei;


//public class Main2 {
//    public static void main(String[] args) {
//        String str = "1010010";
//        System.out.println(solution(str));
//    }
//
//    public static String preDeal(String str){
//        int i = 0;
//        while(i < str.length() && str.charAt(i)=='0'){
//            i++;
//        }
//        return str.substring(i,str.length());
//    }
//
//    public static boolean isEqual(String str1, String str2, String str3){
//        String str11 = preDeal(str1);
//        String str22 = preDeal(str2);
//        String str33 = preDeal(str3);
//        if(!str11.equals(str22)) return false;
//        if(!str22.equals(str33)) return false;
//        if(str1.isEmpty()) return false;
//        else return true;
//    }
//
//    public static boolean solution(String str){
//
//        for(int idx1 = 0;idx1 < str.length()-2;idx1++){
//            String str1 = str.substring(0,idx1);
//            for(int idx2 = idx1;idx2 < str.length()-1;idx2++){
//                String str2 = str.substring(idx1,idx2);
//                String str3 = str.substring(idx2,str.length());
//                boolean res = isEqual(str1,str2,str3);
//                if(res) return true;
//            }
//
//        }
//        return false;
//    }
//
//}


import java.util.Arrays;

//public class Main2{
//    static int res = 0;
//    public static void main(String[] args) {
//        int[] nums = {1,3,2,3,1};
//        mergeSort(nums);
//        System.out.println(res);
//    }
//
//    public static void mergeSort(int[] numbers){
//        if(numbers==null || numbers.length < 2 ) return;
//        mergeSort(numbers,0,numbers.length-1);
//    }
//
//    public static void mergeSort(int[] numbers,int low,int high){
//        if(low==high) return;
//        int mid = low + (high-low)/2;
//        mergeSort(numbers,low,mid);
//        mergeSort(numbers,mid+1,high);
//        merge(numbers,low,mid,high);
//    }
//    public static void merge(int[] numbers,int low, int mid,int high){
//        int[] help = new int[high-low+1];
//        int p1 = low;
//        int p2 = mid + 1;
//        int idx = 0;
//        while(p1<=mid && p2<=high){
//            if(numbers[p1] < numbers[p2]){
//                help[idx] = numbers[p1++];
//            }
//            else if(numbers[p1] >= numbers[p2]){
//                if(numbers[p1] >= numbers[p2]*2){
//                    res += p2-mid+1;
//                }
//                help[idx] = numbers[p2++];
//            }
//            idx++;
//        }
//        while(p1<=mid){
//            help[idx++] = numbers[p1++];
//        }
//        while(p2<=high){
//            help[idx++] = numbers[p2++];
//        }
//        for(int i = low;i <= high;i++){
//            numbers[i] = help[i-low];
//        }
//    }
//}
