/**
 * 数字组合

 给出一组候选数字(C)和目标数字(T),找到C中所有的组合，使找出的数字和为T。C中的数字可以无限制重复被选取。

 例如,给出候选数组[2,3,6,7]和目标数字7，所求的解为：

 [7]，

 [2,2,3]

 注意事项

 所有的数字(包括目标数字)均为正整数。
 元素组合(a1, a2, … , ak)必须是非降序(ie, a1 ≤ a2 ≤ … ≤ ak)。
 解集不能包含重复的组合。
 样例
 给出候选数组[2,3,6,7]和目标数字7

 返回 [[7],[2,2,3]
 */
/
public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     * 主要熟悉DFS的模式
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = candidates.length;
        if(len == 0) return res;
        List<Integer> list = new ArrayList<>();
        DFS(res, list, candidates, target, 0);
        return res;
    }
    public void DFS(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start){
        if(target == 0){
            List<Integer> s = new ArrayList<Integer>(list);
            if(!res.contains(s)){
                res.add(s);
                return;
            }
        }
        for (int i=start; i < candidates.length; i++){
            if(candidates[i] > target) return;
            target-=candidates[i];
            list.add(candidates[i]);
            DFS(res, list, candidates, target, i+1);
            target+=candidates;
            list.remove(list.size() - 1);
        }
    }
}