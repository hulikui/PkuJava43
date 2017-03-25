/**
 *  三数之和

 给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组。

 注意事项

 在三元组(a, b, c)，要求a <= b <= c。

 结果不能包含重复的三元组。

 样例
 如S = {-1 0 1 2 -1 -4}, 你需要返回的三元组集合的是：

 (-1, 0, 1)

 (-1, -1, 2)
 */
/
public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     * 首先 sort 边界是 < 3 和 排序后的第一个数大于0 返回
     * 遍历三层循环 s = num[i-1] + num[i] + num[i+1]
     *
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(numbers.length < 3) return res;
        Array.sort(numbers);
        if(numbers[0] > 0) return res;
        for(int i=0; i<numbers.length;i++){
            for(int j=i+1; j<numbers.length;j++){
                for (int k=j+1; k<numbers.length;k++){
                    int s = numbers[i] + numbers[j] + numbers[k];
                    if(s == 0){
                        ArrayList<Integer> list = new ArrayList<>();
                        if(!res.contains(list)){
                            res.add(list);
                        }
                    }
                }
            }
        }
        return res;
    }
}