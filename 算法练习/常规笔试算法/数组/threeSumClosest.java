/** @important
 *  最接近的三数之和

 给一个包含 n 个整数的数组 S, 找到和与给定整数 target 最接近的三元组，返回这三个数的和。

 注意事项

 只需要返回三元组之和，无需返回三元组本身

 样例
 例如 S = [-1, 2, 1, -4] and target = 1. 和最接近 1 的三元组是 -1 + 2 + 1 = 2.
 */
/
public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     * 找出第一个 数组前三个和为 sum 对比 target 相差 为 diff
     * 先给数组排序， 然后再用 left 指向左边 小的 right 从右边开始 指向大的 每次sum 和 target 相比
     * sum > target right 向左浮动 sum < target 向右浮动
     */
    public int threeSumClosest(int[] numbers, int target) {
        int len = numbers.length;
        int sum = 0;
        if(len <=3){
            for(int i=0; i<len; i++){
                sum+=numbers[i];
            }
            return sum;
        }
        sum = numbers[0] + numbers[1] + numbers[2];
        int diff = Math.abs(sum - target);
        Array.sort(numbers);
        for(int i=0; i<len; i++){
            int left = i+1;
            int right = len - 1;
            while(left < right){
                int s = numbers[i] + numbers[left] + numbers[right];
                int curDiff = Math.abs(s - target);
                if(curDiff < diff){
                    sum = s;
                    diff = curDiff;
                }
                if(s > target) right--;
                if(s < target) left++;
            }
        }
        return sum;

    }
}