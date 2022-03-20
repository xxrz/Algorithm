package class2_eor;

public class EvenTimesOddTimes {
    //0^n = n;
    //n^n = 0;
    //arr中，只有一种数，出现奇数次
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for(int i = 0;i< arr.length;i++){
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    // arr中，有两种不相等的数，出现奇数次
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        //得到a^b，且一定不为0,则最后一位一个为1，一个必为0
        for(int i = 0;i< arr.length;i++){
            eor ^= arr[i];
        }
        // eor :  00110010110111000
        // ~eor : 11001101001000111
        // rightOne :00000000000001000
        int rightOne = eor & (~eor + 1); // 提取出最右的1
        int eor1 = 0;
        for(int i = 0;i < arr.length;i++){
            if ((arr[i]&rightOne)==1){
                eor1 ^= arr[i]; //得到a or b
            }
        }
        System.out.println(eor1+" "+ (eor1^eor));
    }


    public static void main(String[] args) {
        int a = 5;
        int b = 7;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);

        int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
        printOddTimesNum1(arr1);

        int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
        printOddTimesNum2(arr2);

    }
}
