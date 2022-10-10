package Test1;

public class test3 {
    public static void main(String[] args) {
        int n = 23132;
        int[] nums = {2,3,9};

        dfs(nums,String.valueOf(n));
        System.out.println(max);

    }
    static int max =  0;
    static StringBuilder res = new StringBuilder();
    public static void dfs(int[] nums, String n){
        if(res.length() > n.length()) {
            return;
        }
        if(res.length()!=0 && Integer.parseInt(res.toString()) < Integer.parseInt(n)){
            max = Math.max(max,Integer.parseInt(res.toString()));
        }

        for(int i = 0;i < nums.length;i++){
            res.append(nums[i]);
            dfs(nums,n);
            res.deleteCharAt(res.length()-1);
        }
    }
}
