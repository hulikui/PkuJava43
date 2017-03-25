/** @important
 *  四数之和


 给一个包含n个数的整数数组S，在S中找到所有使得和为给定整数target的四元组(a, b, c, d)。

 注意事项

 四元组(a, b, c, d)中，需要满足a <= b <= c <= d

 答案中不可以包含重复的四元组。

 样例
 例如，对于给定的整数数组S=[1, 0, -1, 0, -2, 2] 和 target=0. 满足要求的四元组集合为：

 (-1, 0, 0, 1)

 (-2, -1, 1, 2)

 (-2, 0, 0, 2)
 */
/
public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     *  三数之和用的是穷举的方法 结合最接近三数和的题，可以适当降低一点时间复杂度
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(numbers);
        int length = numbers.length;
        for(int i=0; i<length-3; i++){
            for(int j=i+1; j<length-2;j++){
                int left = j+1;
                int right = length - 1;
                while(left < right){
                    int sum = numbers[i] + numbers[j] + numbers[left] + numbers[right];
                    if(sum == target){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[left]);
                        list.add(numbers[right]);
                        if(!res.contains(list)){
                            res.add(list);
                            left++;
                            right--;
                        }
                    }else if(sum < target){
                        left ++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}