//leetcode 2nd 2015/1/29
//Mingxuan Wang
//isPalindrome

public class Solution {
    public boolean isPalindrome(int x) {
		if (x < 0){
			return false;
		}
		return x == reverse(x);
    }
	
	private int reverse(int x){
		int result = 0;
		while (x != 0){
			result = result * 10 + x % 10;
			x = x / 10;
		}
		return result;
	}
}