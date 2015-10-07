package leetcode;

public class Q191 {
	// you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
        	count++;
        	n=n&(n-1);
        }
        return count;
    }
    
    public static void main(String[] args) {
		int n = 11;
		int w = hammingWeight(n);
		System.out.println(w);
	}
}
