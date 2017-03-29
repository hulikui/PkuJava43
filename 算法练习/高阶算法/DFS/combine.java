/**
 * 组合

 组给出两个整数n和k，返回从1......n中选出的k个数的组合。

 样例
 例如 n = 4 且 k = 2

 返回的解为：

 [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
 */
/
public class Solution {
/**
 * @param n: Given the range of numbers
 * @param k: Given the numbers of combinations
 * @return: All the combinations of k numbers out of 1..n
 */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        list<Integer> list = new ArrayList<>();
        DFS(res, list, n , k, 1);
        return res;
    }
    public void DFS(List<List<Integer>> res, list<Integer> list, int n, int k, int start){
        if(k == 0){
            list<Integer> s = new ArrayList<>(list);
            if(!res.contains(s)){
                res.add(s);
            }
            return;
        }
        for(int i = start; i <= n; i++){
            k-=1;
            list.add(i);
            DFS(res, list, n, k, i+1);
            k+=1;
            list.remove(list.size() - 1);
        }
    }
}