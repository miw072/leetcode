//leetcode 2nd 2015/2/11
//Mingxuan Wang
//numDecodings

public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0){
			return 0;
		}
		
		int len = s.length();
		int[] dp = new int[len + 1];
		
		dp[0] = 1;
		for (int i = 1; i < len + 1; i++){
			dp[i] = 0;
			
			if (isValidSingle(s.charAt(i - 1))){
				dp[i] += dp[i - 1];
			}
			
			if (i > 1 && isValidDouble(s.substring(i - 2, i))){
				dp[i] += dp[i - 2];
			}
		}
		return dp[len];
    }
	
	private boolean isValidSingle(char ch){
		if (c >= '1' && c <= '9'){
			return true;
		}
		return false;
	}
	
	private boolean isValidDouble(String s){
		int num = Integer.parseInt(s);
		if (num >= 10 && num <= 26){
			return true;
		}
		return false;
	}
}