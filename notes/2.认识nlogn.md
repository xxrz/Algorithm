# 认识nlogn

1. 递归(栈)

   - 求数组中的最大值

     ```java
     //求中点
     mid = L+R/2, L+R可能会溢出
     mid = L + (R-L)/2
     mid = L + ((R-L) >> 1) //右移就是/2
     ```

   - 逻辑过程

     ![逻辑栈 ](\appendix\递归.png)

   - master公式：确定递归的时间复杂度，子问题规模得相同

     T(N) = a * T(N/b) + O(N^d)(其中的a、b、d都是常数)  

     ​      N：母问题的规模

     ​      a：子调用的数目

     ​      N/b：子问题规模（等量）

     如果 log(b,a) < d，复杂度为O(N^d)  
     如果 log(b,a) > d，复杂度为O(N^log(b,a))  
     如果 log(b,a) == d，复杂度为O(N^d  * logN)  

     用来分析递归函数的时间复杂度

2. 归并排序

   ![归并](appendix\归并.png)

   1）整体是递归，左边排好序+右边排好序+merge让整体有序 
   2）让其整体有序的过程里用了排外序方法  
   3）利用master公式来求解时间复杂度  

   ​	一共执行次数  log_2N, merge 一次的复杂度 O(N)  
   总的复杂度: O(N*logN)

   4）当然可以用非递归实现  

   ```java
   // 递归方法实现
   public static void mergeSort1(int[] arr) {
       if (arr == null || arr.length < 2) {
           return;
       }
       process(arr, 0, arr.length - 1);
   }
   
   // arr[L...R]范围上，变成有序的
   // L...R    N    T(N) = 2*T(N/2) + O(N)  ->
   public static void process(int[] arr, int L, int R) {
       if (L == R) { // base case
           return;
       }
       int mid = L + ((R - L) >> 1);
       process(arr, L, mid);
       process(arr, mid + 1, R);
       merge(arr, L, mid, R);
   }
   
   public static void merge(int[] arr, int L, int M, int R) {
       int[] help = new int[R - L + 1];
       int i = 0;
       int p1 = L;
       int p2 = M + 1;
       while (p1 <= M && p2 <= R) {
           help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
       }
       // 要么p1越界了，要么p2越界了
       while (p1 <= M) {
           help[i++] = arr[p1++];
       }
       while (p2 <= R) {
           help[i++] = arr[p2++];
       }
       for (i = 0; i < help.length; i++) {
           arr[L + i] = help[i];
       }
   }
   ```

   

3. 归并排序的扩展

   ![题](appendix\归并扩展.png)

   - 小和问题：

     求一个数组的小和，可以转化为求每个元素在小和累加过程出现的次数，然后将当前元素与出现次数相乘，累加得到小和

     **假设当前元素为a，a右边比a大的元素个数则为a在小和累加过程出现的次数**

     在merge时，要注意，如果左右相等，需要先拷右边的，才能直接获得右边有多少个数比左组数大

     ```java
     public static int merge(int[] arr, int L, int m, int r) {
        int[] help = new int[r - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
           res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
           help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
           help[i++] = arr[p1++];
        }
        while (p2 <= r) {
           help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
           arr[L + i] = help[i];
        }
        return res;
     ```

- 逆序对：

  差不多

  

4. 荷兰国旗问题

   ![题](appendix\荷兰国旗.png)

   - 题一：没说有序

     在arr[L..R]范围上，进行快速排序的过程：

     1）用arr[R]对该范围做partition，<= arr[R]的数在左部分并且保证arr[R]最后来到左部分
     的最后一个位置，记为M； <= arr[R]的数在右部分（arr[M+1..R]）

     2）对arr[L..M-1]进行快速排序(递归)

     3）对arr[M+1..R]进行快速排序(递归)

     因为每一次partition都会搞定一个数的位置且不会再变动，所以排序能完成

   - 题二：

     ![荷兰](appendix\荷兰国旗2.png)

5. 快速排序

   - 快排1.0（递归）

     在arr[L..R]范围上，进行快速排序的过程：

     1）用arr[R]对该范围做partition，<= arr[R]的数在左部分并且保证**arr[R]最后来到左部分
     的最后一个位置**，记为M； <= arr[R]的数在右部分（arr[M+1..R]）

     2）对arr[L..M-1]进行快速排序(递归)

     3）对arr[M+1..R]进行快速排序(递归)

     因为每一次partition都会搞定一个数的位置且不会再变动，所以排序能完成

     **时间复杂度：o(N^2)**

     

   - 快排2.0（荷兰国旗）

     在arr[L..R]范围上，进行快速排序的过程：

     1）用arr[R]对该范围做partition，< arr[R]的数在左部分，== arr[R]的数中间，
         >arr[R]的数在右部分。假设== arr[R]的数所在范围是[a,b]

     2）对arr[L..a-1]进行快速排序(递归)

     3）对arr[b+1..R]进行快速排序(递归)

     因为每一次partition都会搞定一批数的位置且不会再变动，所以排序能完成

     **时间复杂度：o(N^2)**

     

   - 快排3.0（优化：划分值，随机选一个值做划分）

     在arr[L..R]范围上，进行快速排序的过程：

     1）在这个范围上，**随机选一个数记为num**

     ```java
     swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
     ```
     
     
     
     2）用num对该范围做partition，< num的数在左部分，== num的数中间，>num的数在右部分。
        假设== num的数所在范围是[a,b]

     3）对arr[L..a-1]进行快速排序(递归)

     4）对arr[b+1..R]进行快速排序(递归)

     因为每一次partition都会搞定一批数的位置且不会再变动，所以排序能完成

     时间复杂度：
     
     通过分析知道，划分值越靠近中间，性能越好；越靠近两边，性能越差；随机选一个数进行划分的目的就是让好情况和差情况都变成概率事件；把每一种情况都列出来，会有每种情况下的时间复杂度，但概率都是1/N；那么所有情况都考虑，时间复杂度就是这种概率模型下的长期期望！
     
     时间复杂度O(N* logN)，
     
     空间复杂度O(logN)：左边用完释放给右边，所以是树
     
     