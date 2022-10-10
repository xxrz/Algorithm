package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//public class test3 {
//    public static void main(String[] args) {
//
//    }
//
//    static int INF = 0;
//    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        double[] res = new double[queries.size()];
//        double[][] relations = new double[26][26];
//        for(int i = 0;i < 26;i++){
//            Arrays.fill(relations[i],INF);
//        }
//
//        for(int i = 0;i < 26;i++){
//            relations[i][i] = 1.0;
//        }
//
//        for(int i = 0;i < values.length;i++){
//            List<String> tmp = equations.get(i);
//            int x1 = tmp.get(0).charAt(0)-'a';
//            int x2 = tmp.get(1).charAt(0)-'a';
//            relations[x1][x2] = values[i];
//            relations[x2][x1] = 1.0/values[i];
//            update(relations,x1,x2);
//            update(relations,x2,x1);
//        }
//
//        for(int i = 0;i < 26;i++){
//            System.out.println(Arrays.toString(relations[i]));
//        }
//
//        for(int i = 0;i < queries.size();i++ ){
//            List<String> tmp = queries.get(i);
//            int x1 = tmp.get(0).charAt(0)-'a';
//            int x2 = tmp.get(1).charAt(0)-'a';
//            if(relations[x1][x2]!=INF){
//                res[i] = relations[x1][x2];
//            }else{
//                res[i] = -1;
//            }
//        }
//
//        return res;
//    }
//
//
//    public void update(double[][] relations,int x1,int x2){
//        for(int i = 0;i < 26;i++){
//            if(relations[x2][i]!=INF && x1!=x2){
//                relations[x1][i] = relations[x2][i]*relations[x1][x2];
//            }
//        }
//    }
//}

public class test3 {
    /*
    利用hashmap给每个节点进行相应的编号，为了方便并查集使用数组表示，因为有weight要进行对应
     */

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();
        UF uf = new UF(2 * equationsSize);
        //1.预处理，将变量的值和id进行映射，使得并查集的底层使用数组实现，方便对应
        Map<String, Integer> map = new HashMap<>(2 * equationsSize);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!map.containsKey(var1)) {
                map.put(var1, id);
                id++;
            }

            if (!map.containsKey(var2)) {
                map.put(var2, id);
                id++;
            }

            uf.merge(map.get(var1), map.get(var2), values[i]);

        }

        //2. 做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer idx1 = map.get(var1);
            Integer idx2 = map.get(var2);

            if (idx1 == null || idx2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = uf.isConnected(idx1,idx2);
            }
        }

        return res;
    }


    //并查集
    class UF{
        //1. 定义数据结构并初始化
        //这块没有用hashMap因为还有权值，不好映射
        int[] parent;
        double[] weight;

        UF(int n){
            this.parent = new int[n];
            this.weight = new double[n];
            //初始化
            for(int i = 0;i < n;i++){
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        //2. 合并两个节点 merge（动态更新，合并两个节点,以及父节点之间的权重）
        public void merge(int x,int y,double value){
            int root1 = find(x);
            int root2 = find(y);

            if(root1!=root2){
                parent[root1] = root2;
                weight[root1] = weight[y]*value/weight[x];
            }
        }

        //3. 找到某个节点的parent,并压缩路径，递归写法
        public int find(int x){
            if(x!=parent[x]){
                int origin = parent[x];
                parent[x] = find(origin);
                weight[x]*=weight[origin];
            }
            return parent[x];
        }

        //4. 判断两个几点是否为一个集合(已经更新完毕，看两个点是否是一个集合)
        public double isConnected(int x,int y){
            int root1 = find(x);
            int root2 = find(y);
            if(root1==root2){
                return weight[x]/weight[y];
            }else{
                return -1.0d;
            }
        }
    }


}
