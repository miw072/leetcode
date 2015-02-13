//leetcode 2nd 2015/2/5
//Mingxuan Wang
//maxSubArray

public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0){
			return 0;
		}
		int[] dp = new int[A.length];
		int max = Integer.MIN_VALUE;
		dp[0] = A[0];
		max = Math.max(max, dp[0]);
		
		for (int i = 1; i < A.length; i++){
			dp[i] = Math.max(A[i], dp[i - 1] + A[i]);
			max = Math.max(max, dp[i]);
		}
		return max;
    }
}