public class Solution {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();//用于存储数组结果集
    
    public List<List<Integer>> threeSum(int[] num) {
        if (num == null || num.length < 3) return ret;
        
        Arrays.sort(num);
        
        int len = num.length;
        for (int i = 0; i < len-2; i++) {
            if (i > 0 && num[i] == num[i-1]) continue;//遇到已经遍历的相同数字直接跳过当前i继续i++
            find(num, i+1, len-1, num[i]); //寻找两个数与num[i]的和为0
        }
        
        return ret;//返回结果集
    }
    
    public void find(int[] num, int begin, int end, int target) {
        int l = begin, r = end;
        while (l < r) {
            if (num[l] + num[r] + target == 0) {
                List<Integer> ans = new ArrayList<Integer>();
                ans.add(target);
                ans.add(num[l]);
                ans.add(num[r]);
                ret.add(ans); //放入结果集中
                while (l < r && num[l] == num[l+1]) l++;////避免结果重复，其后面和它相等的直接被跳过。
                while (l < r && num[r] == num[r-1]) r--;
                l++;
                r--;
            } else if (num[l] + num[r] + target < 0) {
                l++;//结果小于0往后找
            } else {//结果大于0往前找
                r--;
            }
        }
    }
}