//leetcode 2nd time, 2015/1/28
//by Mingxuan Wang
//Valid Palindrome

public class Solution{
	public boolean isPalindrome(String s){
		if (s == null || s.length() == 0){
			return true;
		}
		
		int left = 0;
		int right = s.length() - 1;
		
		while (left < right){
			//bug 1: left < s.length()
			while (left < s.length() && !isValid(s.charAt(left))){
				left++;
			}
			
			//bug 2: need to consider ",,.."
			if (left == s.length()){
			    return true;
			}
			
			while (right >= 0 && !isValid(s.charAt(right))){
				right--;
			}
			
			if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
				return false;
			}else{
				left++;
				right--;
			}
		}
		return true;
	}
	
	private boolean isValid(char c){
		return Character.isLetter(c) || Character.isDigit(c);
	}
}