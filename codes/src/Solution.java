class Solution {
    public int superPow(int a, int[] b) {
        if(a==1) return 1;
        int len = b.length;
        return superRecur(a,b,len-1);
    }

    //拆分
    public int superRecur(int a,int[] b,int idx){
        if(idx == -1) return 1;
        int x1 = myPow(a,b[idx]);

        int x2 = myPow(superRecur(a,b,idx-1),10);

        return (x1*x2)%1337;
    }

    //快速幂,b是幂
    public int myPow(int a,int b){
        int res = 1;
        a = a%1337;
        while(b != 0){
            if((b&1)==1){
                res*= a%1337;
            }
            //base每次向左移，幂逐位取
            a = a*a%1337;
            b = b>>1;
        }

        return res%1337;
    }

}