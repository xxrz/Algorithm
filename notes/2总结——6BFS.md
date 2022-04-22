# BFS

BFS 的核心思想：把一些问题抽象成图，从一个点开始，向四周开始扩散。一般来说，我们写 BFS 算法都是用「队列」这种数据结构，每次将一个节点周围的所有节点加入队列。

BFS 相对 DFS 的最主要的区别是：**BFS 找到的路径一定是最短的，但代价就是空间复杂度可能比 DFS 大很多**

常见场景：**在一幅「图」中找到从起点 `start` 到终点 `target` 的最短距离**

## 1. 框架

```java
// 计算从起点 start 到终点 target 的最近距离
int BFS(Node start, Node target) {
    Queue<Node> q; // 核心数据结构
    Set<Node> visited; // 避免走回头路
    
    q.offer(start); // 将起点加入队列
    visited.add(start);
    int step = 0; // 记录扩散的步数

    while (q not empty) {
        int sz = q.size();
        /* 将当前队列中的所有节点向四周扩散 */
        for (int i = 0; i < sz; i++) {
            Node cur = q.poll();
            /* 划重点：这里判断是否到达终点 */
            if (cur is target)
                return step;
            /* 将 cur 的相邻节点加入队列，有多少个相邻节点 */
            for (Node x : cur.adj()) {
                if (x not in visited) { //在加入队列之前判断孩子的有效性，而不是判断当前节点
                    q.offer(x);
                    visited.add(x);
                }
            }
        }
        /* 划重点：更新步数在这里,对应二叉树的高度 */
        step++;
    }
}
//visited 的主要作用是防止走回头路，大部分时候都是必须的，但是像一般的二叉树结构，没有子节点到父节点的指针，不会走回头路就不需要 visited
```



## 2. 题目

#### [111. 二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)

题目：给定一个二叉树，找出其最小深度。最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

解答：

```java
    public int minDepth(TreeNode root) {		
        //这个条件不能忘
        if (root == null) return 0;
        
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        int depth = 1;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++){
                TreeNode cur = q.poll();
                //判断是否到达终点，而不是判断当前节点的有效性
                if(cur.left==null && cur.right==null){
                    return depth;
                }
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
            depth++;
        }

        return depth;
        
    }
```

问题：

- **为什么 BFS 可以找到最短距离，DFS 不行吗**

  BFS 的逻辑，`depth` 每增加一次，**队列中的所有节点都向前迈一步**，这保证了第一次到达终点的时候，走的步数是最少的。DFS 不能找最短路径吗？其实也是可以的，但是时间复杂度相对高很多。要找到最短路径，肯定得把二叉树中所有树杈都探索完才能对比出最短的路径有多长对不对？而 BFS 借助队列做到一次一步「齐头并进」，是可以在不遍历完整棵树的条件下找到最短距离的。形象点说，DFS 是线，BFS 是面；DFS 是单打独斗，BFS 是集体行动。

- **BFS 那么好，为啥 DFS 还要存在**

  BFS 可以找到最短距离，但是空间复杂度高，而 DFS 的空间复杂度较低。假设给你的这个二叉树是满二叉树，节点数为 `N`，对于 DFS 算法来说，空间复杂度无非就是递归堆栈，最坏情况下顶多就是树的高度，也就是 `O(logN)`。BFS 算法，队列中每次都会储存着二叉树一层的节点，这样的话最坏情况下空间复杂度应该是树的最底层节点的数量，也就是 `N/2`，用 Big O 表示的话也就是 `O(N)`。一般来说在找最短路径的时候使用 BFS，其他时候还是 DFS 使用得多一些。

#### [752. 打开转盘锁](https://leetcode-cn.com/problems/open-the-lock/)

```java
   //把问题的求解抽象成图，每个节点的相邻节点是8个（上+下），
    //求解从起点到终点的最短路径
    //其中不能包含死亡序列
    //需要注意不能走回头路
    //确定终止条件，最小旋转次数其实就是depth

    //向上滑动一步返回的字符串
    String plusOne(String s,int j){
        char[] ch = s.toCharArray();
        if(ch[j]=='9'){
            ch[j]='0';
        }else{
            ch[j]+=1;
        }
        return new String(ch);
    }

    //向下滑动一步返回的字符串
    String minusOne(String s,int j){
        char[] ch = s.toCharArray();
        if(ch[j]=='0'){
            ch[j]='9';
        }else{
            ch[j]-=1;
        }
        return new String(ch);
    }

    public int openLock(String[] deadends, String target) {
        //初始化
        Queue<String> q = new LinkedList<>();
        HashSet<String> dead = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        for(String str:deadends){
            dead.add(str);
        }
        int depth=0;
        q.offer("0000");
        visited.add("0000");

        //开始遍历
        while(!q.isEmpty()){
            
            int len = q.size();
            //判断
            for(int i=0;i<len;i++){
                //判断和加入
                String cur = q.poll();
                //不用在这里进行判断
                // if(visited.contains(cur)){
                //     continue;
                // }
                //判断是否到达终点
                if(dead.contains(cur)){
                    continue;
                }
                if(cur.equals(target)){
                    return depth;
                }

                //加入相邻节点
                /* 将一个节点的未遍历相邻节点加入队列 */
                for(int j = 0;j<4;j++){
                    String up = plusOne(cur, j);
                    //一般都是判断孩子 的有效性
                    if(!visited.contains(up)){
                        q.offer(up);
                        visited.add(up);
                    }
                }

                for(int j = 0;j<4;j++){
                    String down = minusOne(cur, j);
                    if(!visited.contains(down)){
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            depth++;
            
        }
        return -1;
    }
```

双向BFS: **传统的 BFS 框架就是从起点开始向四周扩散，遇到终点时停止；而双向 BFS 则是从起点和终点同时开始扩散，当两边有交集的时候停止**。



#### [934. 最短的桥](https://leetcode-cn.com/problems/shortest-bridge/)

题目：在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）

现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。

返回必须翻转的 0 的最小数目。（可以保证答案至少是 1 。）

思路：

先找到其中一个岛屿中的一个点，然后进行DFS，把遍历到的所有点都变成2，并且加入队列;

然后使用该队列进行BFS，同时把遍历到的点0变成2，并且记录遍历的步数，然后当有一个碰到1时，返回步数（桥长度）

所以使用该队列进行BFS，同时把遍历到的点0变成2（相当于visited数组），并且记录遍历的步数，然后当有一个碰到1时，返回步数（桥长度）【BFS必是最短】。

```java
    //先找到其中一个岛屿中的一个点，然后进行DFS，把遍历到的所有点都变成2，并且加入队列
    //再利用BFS达到另一座岛，遍历过程中，已经遍历过得节点赋值2
    //然后当有一个碰到1时，返回步数（桥长度）

    //图的四个方向的变换，相当于多叉树的分支
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    //存放第一座岛屿
    Queue<int[]> q;
    public int shortestBridge(int[][] grid) {
        q = new LinkedList<>();

        //dfs找到第一座岛屿，将其置为2
        for(int i =0;i < grid.length;i++){
            boolean b = false;
            for(int j=0;j < grid[0].length;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j);
                    b = true;
                    break;  //如果只有这一个break，则只跳出了当前循环，外面还有一层
                }
            }
            if(b) break;
        }

        //bfs达到另一座岛中的任意一点，遍历过程中，已经遍历过得节点赋值2
        //多源
        return bfs(grid);

    }

    public int bfs(int[][] grid){
        int res = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i =0;i<len;i++){
                int[] cur = q.poll();
                for(int k=0;k<4;k++){
                    int x = cur[0] + dx[k];
                    int y = cur[1] + dy[k];
                    if(y>=0 && y < grid.length && x>=0 && x<grid.length && grid[x][y]!=2){
                        if(grid[x][y]==0){
                            q.add(new int[]{x,y});
                            grid[x][y] =2;
                        }else if(grid[x][y]==1){
                            return res;
                        }
                    }
                }
            }
            res++;
        }
        return res-1;
    }

    public void dfs(int[][] grid,int i,int j){
        q.add(new int[]{i,j});
        grid[i][j] = 2;

        for(int k = 0;k<4;k++){
            int x = i + dx[k];
            int y = j + dy[k];

            //让没有遍历过的节点去进行遍历
            if(y>=0 && y < grid.length && x>=0 && x<grid.length && grid[x][y]==1){
                dfs(grid,x,y);
            }
        }
    }
```

