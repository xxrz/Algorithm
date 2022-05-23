# DFS

回溯算法其实就是我们常说的 DFS 算法，本质上就是一种暴力穷举算法。

**解决一个回溯问题，实际上就是一个决策树的遍历过程**。



## 1. 框架

>站在回溯树的一个节点上，你只需要思考 3 个问题：
>
>1、路径：也就是已经做出的选择。
>
>2、选择列表：也就是你当前可以做的选择。
>
>3、结束条件：也就是到达决策树底层，无法再做选择的条件。



```java
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return
    
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
```

**其核心就是 for 循环里面的递归，在递归调用之前「做选择」，在递归调用之后「撤销选择」**



决策树，在一个节点上需要思考的问题：

决策树的值在边上

![image-20220420095018954](appendix\2总结——7DFS和回溯\image-20220420095018954.png)



>1、路径：也就是已经做出的选择。[2]
>
>2、选择列表：也就是你当前可以做的选择。[1,3]
>
>3、结束条件：也就是到达决策树底层，无法再做选择的条件。[叶子]，也就是选择列表为空

**前序遍历的代码在进入某一个节点之前的那个时间点执行，后序遍历代码在离开某个节点之后的那个时间点执行**。



我们定义的 `backtrack` 函数其实就像一个指针，在这棵树上游走，同时要正确维护每个节点的属性，每当走到树的底层，其「路径」就是一个全排列。

前序遍历的代码在**进入某一个节点之前**的那个时间点执行，后序遍历代码在**离开某个节点之后**的那个时间点执行。

![image-20220420095411651](appendix\2总结——7DFS和回溯\image-20220420095411651.png)



## 2. 题

#### [46. 全排列](https://leetcode-cn.com/problems/permutations/)

给定一个不含重复数字的数组 `nums` ，返回其 *所有可能的全排列* 。你可以 **按任意顺序** 返回答案。

```java
//无论变量是不是全局的，在内存空间里是一个，则就是全局共享的，就需要回溯
    //如果每一次的path和res都是新申请的空间，则不需要进行回溯
    //记录结果
    List<List<Integer>> res;
    //记录path
    LinkedList<Integer> path;
    //记录是否被used
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        //暴力回溯

        res = new LinkedList<>();
        path = new LinkedList<>();
        //记录已经做过的决定和当前可以做的选择
        used = new boolean[nums.length];

        backtrack(nums);

        return res;
    }

    void backtrack(int[] nums) {
        //触发的结束条件
        if(path.size()==nums.length){
            res.add(new LinkedList(path));
            return;
        }

        //排除不合法的选择
        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }

            //做选择
            path.add(nums[i]);
            used[i] = true;

            //进行下一层决策树
            backtrack(nums);

            //撤销选择
            path.removeLast();
            used[i] = false;
        }
    }
```

#### [51. N 皇后](https://leetcode-cn.com/problems/n-queens/)

```java
List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        //把N皇后的问题抽象成从每一行开始放。
        //只用记录每一行中列的位置
        res = new LinkedList<>();
        char[][] board = new char[n][n];
        for(char[] c:board){
            Arrays.fill(c,'.');
        }
        backtrack(board,0);
        return res;
    }
    
    //row表示当前在第几行
    public void backtrack(char[][] board,int row){
        //终止条件
        if(row==board.length){
            res.add(charToList(board));
            return;
        }

        //当前的行的每一列都可以做选择，再排除掉那些不可能的列
        for(int col=0;col < board.length;col++){
            if(!isValid(board,row,col)){
                continue;
            }

            //做出选择
            board[row][col] = 'Q';
            //继续进入下一层
            backtrack(board,row+1);
            //撤销选择
            board[row][col] = '.';
        }
    }

    //把当前的矩阵转换为列表
    public List<String> charToList(char[][] board){
        List<String> list = new ArrayList<>();
        for(char[] row:board){
            list.add(String.copyValueOf(row));
        }
        return list;
    }

    //查看是否有效位
    //只用看左上 上 右上是否符合规范
    public boolean isValid(char[][] board,int row,int col){
        int n = board.length;
        //检查列是否有冲突
        for(int  i=0;i<n;i++){
            if(board[i][col]=='Q') return false;
        }

        //检查右上是否有冲突
        for(int i = row-1,j = col+1;i>=0 && j<n;i--,j++){
            if(board[i][j]=='Q') return false;
        }

        //检查左上是否有冲突
        for(int i = row-1,j = col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }

        return true;
    }
```

回溯算法和动态规划是不是有点像呢？动态规划的三个需要明确的点就是「状态」「选择」和「base case」，就对应着走过的「路径」，当前的「选择列表」和「结束条件」

某种程度上说，动态规划的暴力求解阶段就是回溯算法。只是有的问题具有重叠子问题性质，可以用 dp table 或者备忘录优化，将递归树大幅剪枝，这就变成了动态规划。



## 3. 集合划分
 [698. 划分为k个相等的子集](https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/)

题目：

给你输入一个数组 `nums` 和一个正整数 `k`，请你判断 `nums` 是否能够被平分为元素和相同的 `k` 个子集。

抽象场景：

将 `n` 个标记了不同序号的球（标号为了体现顺序的差异），放入 `k` 个标记了不同序号的盒子中（其中 `n >= k`，每个盒子最终都装有恰好一个球），共有 `P(n, k)` 种不同的方法。现在你来，往盒子里放球，你怎么放？

- **首先，你可以站在盒子的视角**，每个盒子必然要选择一个球。

  第一个盒子可以选择 `n` 个球中的任意一个，然后你需要让剩下 `k - 1` 个盒子在 `n - 1` 个球中选择。

  p(n,k) = np(n-1,k-1)

- **另外，你也可以站在球的视角**

  因为并不是每个球都会被装进盒子，所以球的视角分两种情况：

  - 第一个球可以不装进任何一个盒子，这样的话你就需要将剩下 `n - 1` 个球放入 `k` 个盒子。

  - 第一个球可以装进 `k` 个盒子中的任意一个，这样的话你就需要将剩下 `n - 1` 个球放入 `k - 1` 个盒子。

    p(n,k) = p(n-1,k) + kp(n-1,k-1)



类比抽象场景思路：

- 遍历桶：**如果我们切换到这 `n` 个数字的视角，每个数字都要选择进入到 `k` 个桶中的某一个**。

  时间复杂度分析：每个数字有 `k` 个桶可供选择，所以组合出的结果个数为 `k^n`，时间复杂度也就是 `O(k^n)`。

  ![image-20220421144519682](appendix\2总结——7DFS和回溯\image-20220421144519682.png)



- 遍历数字：**如果我们切换到这 `k` 个桶的视角，对于每个桶，都要遍历 `nums` 中的 `n` 个数字，然后选择是否将当前遍历到的数字装进自己这个桶里**。（少量多次，这个复杂度更低）

  时间复杂度分析：每个桶要遍历 `n` 个数字，对每个数字有「装入」或「不装入」两种选择，所以组合的结果有 `2^n` 种；而我们有 `k` 个桶，所以总的时间复杂度为 `O(k*2^n)`。

  ![image-20220421144538243](appendix\2总结——7DFS和回溯\image-20220421144538243.png)

  - 解法一
  
    ```java
        //DFS暴力深搜
        //明确选择列表
        //站在桶的角度，选择装不装球，时间复杂度为：O(k*2^n)
        public boolean canPartitionKSubsets(int[] nums, int k) {
            //排除一些情况
            if(k > nums.length) return false;
            int sum = 0;
            for(int num:nums){
                sum += num;
            }
            if(sum%k!=0) return false;
    
            boolean[] used = new boolean[nums.length];
            int target = sum/k;
    
            return backtrack(nums,k,target,0,0,used);
    
        }
    
        //现在的k号桶正在思考是否应该把nums[i]装进来，目前k号桶已经装的数字之和是curSum
        //used表示某个数组是否已经被装到桶中
        //target是目标和
        boolean backtrack(int[] nums,int k,int target,int curSum,int idx,boolean[] used){
    
            //base case 所有桶都装满了
            if(k==0) return true;
    
            //当前桶装满了
            if(curSum==target){
                //让下一个桶开始选
                return backtrack(nums,k-1,target,0,0,used);
                // k--会出错,--k
                // return backtrack(nums,k--,target,0,0,used);
            }
    
            //做选择
            for(int j = idx;j < nums.length;j++){
                if(used[j]) continue;
                if(nums[j] + curSum > target) continue;
    
                used[j] = true;
                curSum += nums[j]; 
                if(backtrack(nums,k,target,curSum,j+1,used)){
                    return true;
                }
                //撤销
                used[j] = false;
                curSum -= nums[j];
            }
            //穷举完都装不完当前的桶
            return false;
        }
    ```
  
    
  
  - 优化一
  
    ```java
    //==============================================================================
        //DFS暴力深搜 + memo,优化
        //有些组合在此之前已经出现过了，只是装i桶和装j桶不一样 ，我们可以用memo进行备忘录，
        //在装满一个桶时记录当前 used 的状态，如果当前 used 的状态是曾经出现过的，那就不用再继续穷举，从而起到剪枝避免冗余计算的作用。
        //存储方式：把数组转为hashSet的键的方式进行存储
    
        HashMap<String, Boolean> memo = new HashMap<>();
        public boolean canPartitionKSubsets(int[] nums, int k) {
            //排除一些情况
            if(k > nums.length) return false;
            int sum = 0;
            for(int num:nums){
                sum += num;
            }
            if(sum%k!=0) return false;
    
            boolean[] used = new boolean[nums.length];
            int target = sum/k;
            
    
            return backtrack(nums,k,target,0,0,used);
    
        }
    
        //现在的k号桶正在思考是否应该把nums[i]装进来，目前k号桶已经装的数字之和是curSum
        //used表示某个数组是否已经被装到桶中
        //target是目标和
        boolean backtrack(int[] nums,int k,int target,int curSum,int idx,boolean[] used){
    
            //base case 所有桶都装满了
            if(k==0) return true;
    
            // 将 used 的状态转化成形如 [true, false, ...] 的字符串
            // 便于比较和存入 HashMap
            String state = Arrays.toString(used);
    
            //当前桶装满了
            if(curSum==target){
                //让下一个桶开始选
                // k--会出错,应该传--k
                // Boolean res =  backtrack(nums,k--,target,0,0,used);
                Boolean res =  backtrack(nums,k-1,target,0,0,used);
                //记录状态
                
                memo.put(state, res);
                //
                return res;
                
            }
    
            //如果当前状态曾今计算过，就直接返回，不要再递归穷举了
            if(memo.containsKey(state)){
                return memo.get(state);
            }
    
            //做选择
            for(int j = idx;j < nums.length;j++){
                if(used[j]) continue;
                if(nums[j] + curSum > target) continue;
    
                used[j] = true;
                curSum += nums[j]; 
                if(backtrack(nums,k,target,curSum,j+1,used)){
                    return true;
                }
                //撤销
                used[j] = false;
                curSum -= nums[j];
            }
            //穷举完都装不完当前的桶
            return false;
        }
    ```
  
  - 优化二：
  
    ```java
    //==============================================================================
        //DFS暴力深搜 + memo,优化
        //有些组合在此之前已经出现过了，只是装i桶和装j桶不一样 ，我们可以用memo进行备忘录，
        //在装满一个桶时记录当前 used 的状态，如果当前 used 的状态是曾经出现过的，那就不用再继续穷举，从而起到剪枝避免冗余计算的作用。
        //存储方式：把数组转为hashSet的键的方式进行存储
        //优化2：不用数组进行存储，用位
        //用整数 used 的第 i 位（(used >> i) & 1）的 1/0 来表示 used[i] 的 true/false
    
        HashMap<Integer, Boolean> memo = new HashMap<>();
        public boolean canPartitionKSubsets(int[] nums, int k) {
            //排除一些情况
            if(k > nums.length) return false;
            int sum = 0;
            for(int num:nums){
                sum += num;
            }
            if(sum%k!=0) return false;
    
            int used = 0;
            int target = sum/k;
            
    
            return backtrack(nums,k,target,0,0,used);
    
        }
    
        //现在的k号桶正在思考是否应该把nums[i]装进来，目前k号桶已经装的数字之和是curSum
        //used表示某个数组是否已经被装到桶中
        //target是目标和
        boolean backtrack(int[] nums,int k,int target,int curSum,int idx,int used){
    
            //base case 所有桶都装满了
            if(k==0) return true;
    
            //当前桶装满了
            if(curSum==target){
                //让下一个桶开始选
                // k--会出错,应该是因为改变了k的值所以后面都应该要回溯
                // 不是 ，
                // Boolean res =  backtrack(nums,k--,target,0,0,used);
                Boolean res =  backtrack(nums,k-1,target,0,0,used);
                //记录状态
                
                memo.put(used, res);
                //
                return res;
                
            }
    
            //如果当前状态曾今计算过，就直接返回，不要再递归穷举了
            if(memo.containsKey(used)){
                return memo.get(used);
            }
    
            //做选择
            for(int j = idx;j < nums.length;j++){
                //如果是第j位为1则代表用过了
                if(((used >> j) & 1) == 1) continue;
                if(nums[j] + curSum > target) continue;
    
                used |= 1 << j;
                curSum += nums[j]; 
                if(backtrack(nums,k,target,curSum,j+1,used)){
                    return true;
                }
                //撤销
                used ^= 1 << j;
                curSum -= nums[j];
            }
            //穷举完都装不完当前的桶
            return false;
        }
    ```
    
    

## 4. 组合/子集

组合子集树

![image-20220421164914070](appendix\2总结——7DFS和回溯\image-20220421164914070.png)

![image-20220421161827837](appendix\2总结——7DFS和回溯\image-20220421161827837.png)

- **通过保证元素之间的相对顺序不变来防止出现重复的子集**。

- **如果把根节点作为第 0 层，将每个节点和根节点之间树枝上的元素作为该节点的值，那么第 `n` 层的所有节点就是大小为 `n` 的所有子集**。

### 4.1 子集

#### 4.1.1 元素无重不可复选

##### [78. 子集](https://leetcode-cn.com/problems/subsets/)

给你一个整数数组 `nums` ，数组中的元素 **互不相同** 。返回该数组所有可能的子集（幂集）。

解集 **不能** 包含重复的子集。你可以按 **任意顺序** 返回解集。

```java
    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();

    // 主函数
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    // 回溯算法核心函数，遍历子集问题的回溯树
    void backtrack(int[] nums, int start) {
        //base case
    //     //nums.length==start时，将空集加入结果，不会进入循环，程序结束

        // 前序位置，每个节点的值都是一个子集
        res.add(new LinkedList<>(track));
    
        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }
```





#### 4.1.2 元素可重不可复选

![image-20220421171243269](appendix\2总结——7DFS和回溯\image-20220421171243269.png)

我们需要进行剪枝，如果一个节点有多条值相同的树枝相邻，则只遍历第一条，剩下的都剪掉，不要去遍历。

**体现在代码上，需要先进行排序，让相同的元素靠在一起，如果发现 `nums[i] == nums[i-1]`，则跳过**

##### [90. 子集 II](https://leetcode-cn.com/problems/subsets-ii/)

给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

```java
    // 主函数
    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();

    // 主函数
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //排序：让相邻的一样的节点去剪枝
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    // 回溯算法核心函数，遍历子集问题的回溯树
    void backtrack(int[] nums, int start) {
        //base case
    //     //nums.length==start时，将空集加入结果，不会进入循环，程序结束

        // 前序位置，每个节点的值都是一个子集
        res.add(new LinkedList<>(track));
    
        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            if(i > start && nums[i]==nums[i-1]){
                continue;
            }
            // 做选择
            track.addLast(nums[i]);
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }
```





### 4.2 组合

#### 4.2.1 元素无重不可复选

##### [77. 组合](https://leetcode-cn.com/problems/combinations/)

给定两个整数 `n` 和 `k`，返回范围 `[1, n]` 中所有可能的 `k` 个数的组合。

```java
    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();

    // 主函数
    public List<List<Integer>> combine(int n,int k) {
        backtrack(1,n,k);
        return res;
    }

    // 回溯算法核心函数，遍历子集问题的回溯树
    void backtrack(int start, int n,int k) {
        //base case
        // 遍历到了第 k 层，收集当前节点的值
        if(track.size()==k){
            res.add(new LinkedList<>(track));
            return;
        }
    
        // 回溯算法标准框架
        for (int i = start; i <= n; i++) {
            // 做选择
            track.addLast(i);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(i+1,n,k);
            // 撤销选择
            track.removeLast();
        }
    }
```



#### 4.2.2 元素可重不可复选

![image-20220421171243269](appendix\2总结——7DFS和回溯\image-20220421171243269.png)

我们需要进行剪枝，如果一个节点有多条值相同的树枝相邻，则只遍历第一条，剩下的都剪掉，不要去遍历。

**体现在代码上，需要先进行排序，让相同的元素靠在一起，如果发现 `nums[i] == nums[i-1]`，则跳过**

##### [40. 组合总和 II](https://leetcode-cn.com/problems/combination-sum-ii/)

给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用 一次 。

注意：解集不能包含重复的组合。 

```java
    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();
    int curSum = 0;

    // 主函数
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length==0) return res;
        //排序：让相邻的一样的节点去剪枝
        Arrays.sort(candidates);
        // System.out.println(Arrays.toString(candidates));
        backtrack(candidates,0,target);
        return res;
    }

    // 回溯算法核心函数，遍历子集问题的回溯树
    void backtrack(int[] candidates, int start,int target) {
        //base case
        // 
        if(curSum==target){
            res.add(new LinkedList<>(track));
            return;
        }

        //剪枝，不可
        if(curSum > target) return;

        // 回溯算法标准框架
        for (int i = start; i < candidates.length; i++) {

            if(i>start && candidates[i]==candidates[i-1]){
                continue;
            }

            // 做选择
            track.add(candidates[i]);
            curSum += candidates[i];

            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(candidates,i+1,target);

            // 撤销选择
            track.removeLast();
            curSum -= candidates[i];
            }
        }
```

#### 4.2.3 元素无重可复选

- **标准的子集/组合问题是如何保证不重复使用元素的**：

  `i` 从 `start` 开始，那么下一层回溯树就是从 `start + 1` 开始，从而保证 `nums[start]` 这个元素不会被重复使用

- 如果想让每个元素被重复使用，我要把 `i + 1` 改成 `i` 即可：

	```java
    for (int i = start; i < nums.length; i++) {
        // ...
        // 递归遍历下一层回溯树，注意参数
        backtrack(nums, i);
	```
	
	设置合适的 base case 以结束算法，即路径和大于 `target` 时就没必要再遍历下去了
	
	```java
	// base case，超过目标和，停止向下遍历
	    if (trackSum > target) {
	        return;
	    }
	```
	
	

##### [39. 组合总和](https://leetcode-cn.com/problems/combination-sum/)

给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。

candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 

对于给定的输入，保证和为 target 的不同组合数少于 150 个。

```java
    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();
    int curSum = 0;

    // 主函数
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length==0) return res;
        //排序：让相邻的一样的节点去剪枝
        Arrays.sort(candidates);
        // System.out.println(Arrays.toString(candidates));
        backtrack(candidates,0,target);
        return res;
    }

    // 回溯算法核心函数，遍历子集问题的回溯树
    void backtrack(int[] candidates, int start,int target) {
        //base case
        // 
        if(curSum==target){
            res.add(new LinkedList<>(track));
            return;
        }

        //base case
        if(curSum > target) return;

        // 回溯算法标准框架
        for (int i = start; i < candidates.length; i++) {

            if(i>start && candidates[i]==candidates[i-1]){
                continue;
            }

            // 做选择
            track.add(candidates[i]);
            curSum += candidates[i];

            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(candidates,i,target);

            // 撤销选择
            track.removeLast();
            curSum -= candidates[i];
            }
        }
```



## 5. 排列

排列树

![image-20220421164949990](appendix\2总结——7DFS和回溯\image-20220421164949990.png)

![image-20220421165326025](appendix\2总结——7DFS和回溯\image-20220421165326025.png)

### 5.1 元素无重不可复选

##### [46. 全排列](https://leetcode-cn.com/problems/permutations/)

给定一个不含重复数字的数组 `nums` ，返回其 *所有可能的全排列* 。你可以 **按任意顺序** 返回答案。

```java
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        recur(nums,0);
        return res;
    }

    public void recur(int[] nums,int s){

        //base case
        if(path.size()==nums.length){
            res.add(new LinkedList(path));
            return;
        }

        for(int i = 0; i<nums.length;i++){
            if(used[i]){
                continue;
            }

            //选择
            used[i] = true;
            path.addLast(nums[i]);

            //递归
            recur(nums,i+1);

            //撤销选择
            path.removeLast();
            used[i] = false;
        }
    }
```

如果题目不让你算全排列，而是让你算元素个数为 `k` 的排列，怎么算？

改下 `backtrack` 函数的 base case，仅收集第 `k` 层的节点值即可：

```java
if (track.size() == k) {
```





### 5.2 元素可重不可复选

- **保证相同元素在排列中的相对位置保持不变**

  反映到代码上，这个剪枝逻辑是：

  ```java
  // 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
  if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
      // 如果前面的相邻相等元素没有用过，则跳过
      continue;
  }
  // 选择 nums[i]
  
  ```

- !used[i-1]

  **used （下标有没有被用过）记录的是当前路径下，被遍历过的数，所以会回溯**

  **path记录的也是path（序列）**

  ![image-20220421184808156](appendix\2总结——7DFS和回溯\image-20220421184808156.png)

- used[i-1]

  ![ ](appendix\2总结——7DFS和回溯\image-20220421184825945.png)

##### [47. 全排列 II](https://leetcode-cn.com/problems/permutations-ii/)

给定一个可包含重复数字的序列 `nums` ，***按任意顺序*** 返回所有不重复的全排列。

```java
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        //排序：为剪枝做准备
        Arrays.sort(nums);
        recur(nums,0);
        return res;
    }

    public void recur(int[] nums,int s){

        //base case
        if(path.size()==nums.length){
            res.add(new LinkedList(path));
            return;
        }

        for(int i = 0; i<nums.length;i++){
            //1.used
            //2.保持相邻元素相等，且相对位置不变
            if(used[i] || i > 0 && nums[i]==nums[i-1] && !used[i-1]){
                continue;
            }

            //选择
            used[i] = true;
            path.addLast(nums[i]);

            //递归
            recur(nums,i+1);

            //撤销选择
            path.removeLast();
            used[i] = false;
        }
    }
```



### 5.3 元素无重可复选

**标准的全排列算法利用 `used` 数组进行剪枝，避免重复使用同一个元素。如果允许重复使用元素的话，直接放飞自我，去除所有 `used` 数组的剪枝逻辑就行了**。

```java
List<List<Integer>> res = new LinkedList<>();
LinkedList<Integer> track = new LinkedList<>();

public List<List<Integer>> permuteRepeat(int[] nums) {
    backtrack(nums);
    return res;
}

// 回溯算法核心函数
void backtrack(int[] nums) {
    // base case，到达叶子节点
    if (track.size() == nums.length) {
        // 收集叶子节点上的值
        res.add(new LinkedList(track));
        return;
    }

    // 回溯算法标准框架
    for (int i = 0; i < nums.length; i++) {
        // 做选择
        track.add(nums[i]);
        // 进入下一层回溯树
        backtrack(nums);
        // 取消选择
        track.removeLast();
    }
}
```



## 6. 组合排列子集问题总结

**形式一、元素无重不可复选，即 `nums` 中的元素都是唯一的，每个元素最多只能被使用一次**，`backtrack` 核心代码如下：

```java
/* 组合/子集问题回溯算法框架 */
void backtrack(int[] nums, int start) {
    // 回溯算法标准框架
    for (int i = start; i < nums.length; i++) {
        // 做选择
        track.addLast(nums[i]);
        // 注意参数
        backtrack(nums, i + 1);
        // 撤销选择
        track.removeLast();
    }
}

/* 排列问题回溯算法框架 */
void backtrack(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        // 剪枝逻辑
        if (used[i]) {
            continue;
        }
        // 做选择
        used[i] = true;
        track.addLast(nums[i]);

        backtrack(nums);
        // 撤销选择
        track.removeLast();
        used[i] = false;
    }
}

```

**形式二、元素可重不可复选，即 `nums` 中的元素可以存在重复，每个元素最多只能被使用一次**，其关键在于排序和剪枝，`backtrack` 核心代码如下：

```java
Arrays.sort(nums);
/* 组合/子集问题回溯算法框架 */
void backtrack(int[] nums, int start) {
    // 回溯算法标准框架
    for (int i = start; i < nums.length; i++) {
        // 剪枝逻辑，跳过值相同的相邻树枝
        if (i > start && nums[i] == nums[i - 1]) {
            continue;
        }
        // 做选择
        track.addLast(nums[i]);
        // 注意参数
        backtrack(nums, i + 1);
        // 撤销选择
        track.removeLast();
    }
}


Arrays.sort(nums);
/* 排列问题回溯算法框架 */
void backtrack(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        // 剪枝逻辑
        if (used[i]) {
            continue;
        }
        // 剪枝逻辑，固定相同的元素在排列中的相对位置
        if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
            continue;
        }
        // 做选择
        used[i] = true;
        track.addLast(nums[i]);

        backtrack(nums);
        // 撤销选择
        track.removeLast();
        used[i] = false;
    }
}

```

**形式三、元素无重可复选，即 `nums` 中的元素都是唯一的，每个元素可以被使用若干次**，只要删掉去重逻辑即可，`backtrack` 核心代码如下：

```java
/* 组合/子集问题回溯算法框架 */
void backtrack(int[] nums, int start) {
    // 回溯算法标准框架
    for (int i = start; i < nums.length; i++) {
        // 做选择
        track.addLast(nums[i]);
        // 注意参数
        backtrack(nums, i);
        // 撤销选择
        track.removeLast();
    }
}


/* 排列问题回溯算法框架 */
void backtrack(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        // 做选择
        track.addLast(nums[i]);
        backtrack(nums);
        // 撤销选择
        track.removeLast();
    }
}

```



## 7. 岛屿问题

### 7.1 DFS框架遍历二维数组

```java
// 二叉树遍历框架
void traverse(TreeNode root) {
    traverse(root.left);
    traverse(root.right);
}

// 二维矩阵遍历框架
// 方向数组，分别代表上、下、左、右
int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};

void dfs(int[][] grid, int i, int j, boolean[][] visited) {
    int m = grid.length, n = grid[0].length;
    if (i < 0 || j < 0 || i >= m || j >= n) {
        // 超出索引边界
        return;
    }
    if (visited[i][j]) {
        // 已遍历过 (i, j)
        return;
    }

    // 进入节点 (i, j)
    visited[i][j] = true;
    // 递归遍历上下左右的节点
    for (int[] d : dirs) {
        int next_i = i + d[0];
        int next_j = j + d[1];
        dfs(grid, next_i, next_j, visited);
    }
    // 离开节点 (i, j)
}
```

#### [200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)

[FloodFill 算法](https://mp.weixin.qq.com/s/Y7snQIraCC6PRhj9ZSnlzw)

题目：

给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

思路：

在主函数中找到一个以1开头的节点，将结果++，然后利用dfs遍历相邻的陆地，用水把其淹了

解法：

```java
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    //从节点(i,j)开始进行dfs遍历，把相邻节点的陆地用水淹了
    public void dfs(char[][] grid,int i,int j){

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        //base case
        if(i < 0 || i >= grid.length || j < 0 ||j >= grid[0].length){
            return;
        }

        if(grid[i][j]=='0'){
            return;
        }

        grid[i][j]='0';

        for(int k=0;k < 4;k++){
            int x = i + dx[k];
            int y = j + dy[k];
            dfs(grid,x,y);
        }

    }
```

#### *[1254. 统计封闭岛屿的数目](https://leetcode-cn.com/problems/number-of-closed-islands/)

>   先用水把边界淹了，因为矩阵边界里为陆地的，已经不是封闭岛屿了

题目：

二维矩阵 `grid` 由 `0` （土地）和 `1` （水）组成。岛是由最大的4个方向连通的 `0` 组成的群，封闭岛是一个 `完全` 由1包围（左、上、右、下）的岛。

思路：

封闭岛的周围是水，所以矩阵的边界都不是封闭岛，需要将边界的先用水淹掉，再按上题计算就可以了

解法：

```java
    public int closedIsland(int[][] grid) {
        //先淹边界的陆地

        for(int i = 0;i< grid[0].length;i++){
            //上
            dfs(grid,0,i);
            //下
            dfs(grid,grid.length-1,i);
        }

        for(int i = 0;i < grid.length;i++){
            //左
            dfs(grid,i,0);
            //右
            dfs(grid,i,grid[0].length-1);
        }

        int res = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    //从节点(i,j)开始进行dfs遍历，把相邻节点的陆地用水淹了
    public void dfs(int[][] grid,int i,int j){

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        //base case
        if(i < 0 || i >= grid.length || j < 0 ||j >= grid[0].length){
            return;
        }

        if(grid[i][j]==1){
            return;
        }

        grid[i][j]=1;

        for(int k=0;k < 4;k++){
            int x = i + dx[k];
            int y = j + dy[k];
            dfs(grid,x,y);
        }

    }
```

#### [1020. 飞地的数量](https://leetcode-cn.com/problems/number-of-enclaves/)

题目：

给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量

说人话就是，求封闭岛屿的面积，封闭岛屿是由0包裹的

思路：

和1254一样,就是排除完边界的以后，不用递归

解法：

```java
    public int numEnclaves(int[][] grid) {
        
        //先淹边界的陆地

        for(int i = 0;i< grid[0].length;i++){
            //上
            dfs(grid,0,i);
            //下
            dfs(grid,grid.length-1,i);
        }

        for(int i = 0;i < grid.length;i++){
            //左
            dfs(grid,i,0);
            //右
            dfs(grid,i,grid[0].length-1);
        }

        int res = 0;
        //数一下剩下的陆地不用递归
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    res+=1;
                    // dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    //从节点(i,j)开始进行dfs遍历，把相邻节点的陆地用水淹了
    public void dfs(int[][] grid,int i,int j){

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        //base case
        if(i < 0 || i >= grid.length || j < 0 ||j >= grid[0].length){
            return;
        }

        if(grid[i][j]==0){
            return;
        }

        grid[i][j]=0;

        for(int k=0;k < 4;k++){
            int x = i + dx[k];
            int y = j + dy[k];
            dfs(grid,x,y);
        }

    }
```

#### [695. 岛屿的最大面积](https://leetcode-cn.com/problems/max-area-of-island/)

题目：

给你一个大小为 m x n 的二进制矩阵 grid 。

岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。

岛屿的面积是岛上值为 1 的单元格的数目。

计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。

思路：

**大体思路和之前完全一样，只不过 `dfs` 函数淹没岛屿的同时，还应该想办法记录这个岛屿的面积**。给 `dfs` 函数设置返回值，记录每次淹没的陆地的个数

解法：

注意避坑

```java
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j=0;j < grid[0].length;j++){
                if(grid[i][j]==1){
                    int res = dfs(grid,i,j);
                    max = Math.max(res,max);
                }
            }
        }
        return max;
    }

    //从节点(i,j)开始进行dfs遍历，把相邻节点的陆地用水淹了
    
    public int dfs(int[][] grid,int i,int j){

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        //base case
        if(i < 0 || i >= grid.length || j < 0 ||j >= grid[0].length){
            return 0;
        }

        if(grid[i][j]==0){
            return 0;
        }

        //当前节点
        grid[i][j]=0;
        int res = 1; //别忘加上当前的格子

        for(int k=0;k < 4;k++){
            int x = i + dx[k];
            int y = j + dy[k];
            res += dfs(grid,x,y);
        }

        return res;
    }
```

#### *[1905. 统计子岛屿](https://leetcode-cn.com/problems/count-sub-islands/)

>  //需要先把不符合要求的子岛屿淹了，不能只是这样简单的判断，不然会有情况没排除，比如第一个示例的最后一个1，就会多算

题目：

给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，它们只包含 0 （表示水域）和 1 （表示陆地）。一个 岛屿 是由 四个方向 （水平或者竖直）上相邻的 1 组成的区域。任何矩阵以外的区域都视为水域。

如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，那么我们称 grid2 中的这个岛屿为 子岛屿 。

请你返回 grid2 中 子岛屿 的 数目 。

思路：

当岛屿 `B` 中所有陆地在岛屿 `A` 中也是陆地的时候，岛屿 `B` 是岛屿 `A` 的子岛。

**反过来说，如果岛屿 `B` 中存在一片陆地，在岛屿 `A` 的对应位置是海水，那么岛屿 `B` 就不是岛屿 `A` 的子岛**。

那么，我们只要遍历 `grid2` 中的所有岛屿，把那些不可能是子岛的岛屿排除掉，剩下的就是子岛。

解法：

```java
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        //先淹掉不符合要求的岛屿：也就是grid2中岛屿位置（1）在grid1中的是海水（0）
        for(int i = 0;i < grid2.length;i++){
            for(int j = 0;j < grid2[0].length;j++){
                if(grid1[i][j]==0 && grid2[i][j]==1){
                    dfs(grid2,i,j);
                }
            }
        }

        //再统计符合要求的子岛屿
        int res = 0;
        for(int i = 0;i < grid2.length;i++){
            for(int j = 0;j < grid2[0].length;j++){
                if(grid2[i][j]==1){
                    res++;
                    dfs(grid2,i,j);
                }
            }
        }

        return res;
    }

    public void dfs(int[][] grid,int i ,int j){
        //base case
        if(i<0 || i>=grid.length ||j<0||j>=grid[0].length){
            return;
        }

        if(grid[i][j]==0){
            return;
        }

        grid[i][j] = 0;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        for(int k=0;k<4;k++){
            int x = i + dx[k];
            int y = j + dy[k];
            dfs(grid,x,y);
        }
    }
```

#### *694.不同岛屿的数量

>   这题是把图的遍历顺序进行序列化，是把四个方向(上下左右)抽象成1,2,3,4，选择为+（先序），撤销为负（后序）

题目：

题目还是输入一个二维矩阵，`0` 表示海水，`1` 表示陆地，这次让你计算 **不同的 (distinct)** 岛屿数量

思路:


很显然我们得想办法把二维矩阵中的「岛屿」进行转化，变成比如字符串这样的类型，然后利用 HashSet 这样的数据结构去重，最终得到不同的岛屿的个数。**首先，对于形状相同的岛屿，如果从同一起点出发，`dfs` 函数遍历的顺序肯定是一样的**。因为遍历顺序是写死在你的递归函数里面的

![image-20220423133724888](appendix\2总结——7DFS和回溯\image-20220423133724888.png)

如果我用分别用 `1, 2, 3, 4` 代表上下左右，用 `-1, -2, -3, -4` 代表上下左右的撤销，那么可以这样表示它们的遍历顺序：

2, 4, 1, -1, -4, -2

注意：

至于为什么初始调用 `dfs` 函数时的 `dir` 参数可以随意写，这里涉及 DFS 和回溯算法的一个细微差别，前文  [图算法基础](https://labuladong.gitee.io/algo/2/20/48/) 有写，这里就不展开了

因为回溯关注的是边，而不是节点，看回溯树

解法：

```java
int numDistinctIslands(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    // 记录所有岛屿的序列化结果
    HashSet<String> islands = new HashSet<>();
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) {
                // 淹掉这个岛屿，同时存储岛屿的序列化结果
                StringBuilder sb = new StringBuilder();
                // 初始的方向可以随便写，不影响正确性
                dfs(grid, i, j, sb, 666);
                islands.add(sb.toString());
            }
        }
    }
    // 不相同的岛屿数量
    return islands.size();
}

void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir) {
    int m = grid.length, n = grid[0].length;
    if (i < 0 || j < 0 || i >= m || j >= n 
        || grid[i][j] == 0) {
        return;
    }
    // 前序遍历位置：进入 (i, j)
    grid[i][j] = 0;
    sb.append(dir).append(',');
    
    dfs(grid, i - 1, j, sb, 1); // 上
    dfs(grid, i + 1, j, sb, 2); // 下
    dfs(grid, i, j - 1, sb, 3); // 左
    dfs(grid, i, j + 1, sb, 4); // 右
    
    // 后序遍历位置：离开 (i, j)
    sb.append(-dir).append(',');
}

```



注意和图里的onPath的区别

这个 `onPath` 数组的操作很像  [回溯算法核心套路](https://labuladong.gitee.io/algo/4/29/105/) 中做「做选择」和「撤销选择」，区别在于位置：回溯算法的「做选择」和「撤销选择」在 for 循环里面，而对 `onPath` 数组的操作在 for 循环外面。

在 for 循环里面和外面唯一的区别就是对根节点的处理。

比如下面两种多叉树的遍历：

```java

onpath
void traverse(TreeNode root) {
    if (root == null) return;
    System.out.println("enter: " + root.val);
    for (TreeNode child : root.children) {
        traverse(child);
    }
    System.out.println("leave: " + root.val);
}

回溯
void traverse(TreeNode root) {
    if (root == null) return;
    for (TreeNode child : root.children) {
        System.out.println("enter: " + child.val);
        traverse(child);
        System.out.println("leave: " + child.val);
    }
}

```

前者会正确打印所有节点的进入和离开信息，而后者唯独会少打印整棵树根节点的进入和离开信息。

**为什么回溯算法框架会用后者？因为回溯算法关注的不是节点，而是树枝**。

