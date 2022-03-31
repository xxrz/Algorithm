import java.util.*;

class Solution {
     //省空间的做法，更改当前已访问过的元素，在结束此次搜索后还原
     public boolean exist(char[][] board, String word) {

         for(int i = 0;i < board.length;i++){
             for(int j=0;j < board[0].length;j++){
                 boolean res = dfs(board,i,j,word,0);
                 if(res){
                     return true;
                 }
             }
         }
         return false;
     }

     //二维数组，以当前（i,j）节点为头开始递归，word所求词，idx为遍历到word的第几个词,
     public boolean dfs(char[][]board, int i, int j, String word,int idx){
         //如果当前字符也不相等，则直接返回（剪枝）+ 边界
         //边界条件没有想清楚
         if(i < 0 || j < 0 || i == board.length || j==board[0].length || board[i][j]!=word.charAt(idx)){
             return false;
         }

         //排除遍历过的节点
         if(board[i][j]=='\0') return false;

         if(idx == word.length()-1 ) return true;

         //将当前节点标记为已访问
         char tmp = board[i][j];
         board[i][j]='\0';

         //定义上下左右四个方向
         int[] di ={0,0,-1,1};
         int[] dj = {1,-1,0,0};

         //开使递归
         //只是针对此次搜索的res
         boolean res = false;
         for(int k = 0; k<4 ;k++){
             res |= dfs(board,i+di[k],j+dj[k],word,idx+1);
         }

         //回溯
         // 因为只代表此次搜索过程中，该元素已访问过，当初始i j变化时，又开始了另一次搜索过程
         board[i][j] = tmp;
         return res;

     }
}