import java.util.Arrays;

public class testMain {
    public static void main(String[] args) {
        int[] arr = {3,2,1};
        int k = 2;
        int[] res = Solution.getLeastNumbers(arr,k);
        System.out.println(Arrays.toString(res));
    }
}
