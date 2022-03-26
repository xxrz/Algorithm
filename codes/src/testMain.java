import java.util.Arrays;

public class testMain {
    public static void main(String[] args) {
        int[] arr = {3,5,3,3};
        Solution test = new Solution();
        int res = test.singleNumber(arr);
        System.out.println(res);
//        System.out.println(Arrays.toString(res));
    }
}
