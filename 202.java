public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> repeatedNums = new HashSet<Integer>();  //容器中只能存储不重复的对象
        while(!repeatedNums.contains(n)){//防止出现重复计算相同的结果后出现死循环  
        repeatedNums.add(n);  
        int sum = 0;  
        while(n != 0){  
            int digit = n % 10;  //低位不断求平方和
            n /= 10;  
            sum += Math.pow(digit,2);  
        }  
        n = sum;  
        if(sum == 1) return true;  
    }  
    return false;  
    }  
}  