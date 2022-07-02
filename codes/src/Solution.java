import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

//    public int[] nextGreaterElements(int[] nums) {
//        //如果不是循环数组
//        Stack<Integer> s = new Stack<>();
//        int[] res = new int[nums.length];
//
//        for(int i = nums.length-1;i >=0;i-- ){
//            while(!s.isEmpty() && nums[i] >= s.peek()){
//                s.pop();
//            }
//            res[i] = s.isEmpty()? -1: s.peek();
//            s.push(nums[i]);
//        }
//
//        return res;
//    }

    public int[] nextGreaterElements(int[] nums) {
        //如果是循环数组,则将下标扩大两倍，然后用取余的方法进行遍历
        Stack<Integer> s = new Stack<>();
        int[] res = new int[nums.length];

        for(int i = 2*nums.length-1;i >=0;i-- ){
            while(!s.isEmpty() && nums[i%nums.length] >= s.peek()){
                s.pop();
            }
            res[i%nums.length] = s.isEmpty()? -1: s.peek();
            s.push(nums[i%nums.length]);
        }

        return res;
    }

    //归并排序
    int cnt = 0;
    public int InversePairs(int [] array) {
        return mergeSort(array,0,array.length-1);
//         System.out.println(Arrays.toString(array));
//         return cnt;

    }

    //[]
    public int mergeSort(int[] array,int low,int high){
        if(low >= high) return 0;

        int mid = low + (high-low)/2;

        int left = mergeSort(array,low,mid);
//        System.out.println("array left:"+"low:"+low+"\thigh"+high+"\tarray:"+ Arrays.toString(array)+"res:"+left);
        int right = mergeSort(array, mid + 1,high);
//        System.out.println("array right:"+"low:"+(int)(mid + 1)+"\thigh"+high+"\tarray:"+Arrays.toString(array)+"res:"+right);
        int cnt = merge(array,low,mid,high);
//        System.out.println("array cnt:"+"low:"+ low +"\thigh"+high+"\tarray:"+Arrays.toString(array)+"res:"+cnt);
        return left+right+cnt;
    }

    public int merge(int[] array,int low,int mid, int high){

        int[] res = new int[high-low+1];
        int idx1 = low, idx2 = mid + 1,idx = 0;
        int cc = 0;
        while(idx1 <= mid && idx2 <=high){
            if(array[idx1] <= array[idx2]){
                res[idx++] = array[idx1++];
            }else{
                res[idx++] = array[idx2++];
//                 cnt += mid-idx1+1;
                cc += mid - idx1 + 1;
//                 cnt=(cnt+mid-idx1+1)%1000000007;
            }
        }

        while(idx1<=mid){
            res[idx++] = array[idx1++];
        }

        while(idx2<=high){
            res[idx++] = array[idx2++];
        }


        for(int i = 0;i < res.length;i++){
            array[low + i] = res[i];
        }

//        System.out.println("low:"+low+"\thigh"+high+"\tmerge:"+cc);
        return cc;
    }

//    public static void main(String[] args) throws IOException {
////        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
////        String line = "";
////        int res = 0;
////        while((line=bufferedReader.readLine())!=null) {
////            int num = Integer.valueOf(line);
////            line = bufferedReader.readLine();
////            String[] nums = line.split(" ");
////            int[] tmp = new int[nums.length];
////            for (int i = 0; i < nums.length; i++) {
////                tmp[i] = Integer.valueOf(nums[i]);
////            }
////            Solution solution = new Solution();
////            res = solution.test(num, tmp);
////            System.out.println(res);
////        }
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String line = "";
//        int res = 0;
//        while((line=bufferedReader.readLine())!=null) {
//            String[] num12 = line.split(" ");
//            line = bufferedReader.readLine();
//            String[] nums = line.split(" ");
//            int[] tmp = new int[nums.length];
//            for (int i = 0; i < nums.length; i++) {
//                tmp[i] = Integer.valueOf(nums[i]);
//            }
//            Main solution = new Main();
//            solution.test(Integer.valueOf(num12[0]),Integer.valueOf(num12[1]),tmp);
//            System.out.println(res);
//        }
//    }

//    public int test(int cnt, int sum, int[] nums){
//        int res = 0;
//        for(int i= 0;i<cnt;i++){
//            int can
//        }
//    }

    public static void main(String[] args) {
        Main main = new Main();
        boolean res = main.isValid("<s></d>");
        System.out.println(res);
    }

    private boolean isValid(String s) {
        Stack st = new Stack();
        if(s.length()==0) return true;
        if(s.charAt(0)!='<' || s.charAt(s.length()-1)!='>') return false;

        int right = getLeftTag(s,0);
        if(right==-1) return false;
        st.push(s.substring(0,right+1));
        int index = right+1;
        if(index < s.length()) return false;
        while(index<s.length()){
            if(s.charAt(index)<=122 &&s.charAt(index)>=97)
                index++;
            else if(!st.isEmpty() &&s.charAt(index)=='<' &&s.charAt(index+1)=='/'){
                index = getRightTag(s,index,(String)st.peek());
                if(index == -1) return false;
                st.pop();
            }
            else if(st.isEmpty() || s.charAt(index ) =='<'){
                int temp = index;
                index = getLeftTag(s,index)+1;
                if(index==-1) return false;
                st.push(s.substring(temp,index));
            }
            else return false;
        }
        return true;
    }

    private int getRightTag(String s, int index, String peek) {
        int right = -1;
        String l = "</" + left.s
    }

    private int getLeftTag(String s, int index) {
        int right = -1;
        for(;index < s.length();index++){
            if(s.charAt(index)=='<' || (s.charAt(index)<=122 && s.charAt(index)>=97)){
                continue;
            }
            else if(s.charAt(index)=='>'){
                right = index;
                break;
            }

        }
        return right;
    }

}