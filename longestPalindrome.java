//leetcode 2nd 2015/1/28
//Mingxuan Wang
//longestPalindrome

public class Solution {
    public String longestPalindrome(String s) {
        //deal with two pointers from mid to side
		if (s == null){
			return null;
		}
		
		String result = null;
		int max;
		
		for (int i = 0; i < s.length(); i++){
			String s1 = getLongest(s, i, i);
			String s2 = getLongest(s, i, i + 1);
			
			if (s1.length() > max){
				max = s1.length();
				result = s1;
			}
			
			if (s1.length() > max){
				max = s2.length();
				result = s2;
			}
		}
		return result;
    }
	
	private String getLongest(String s, int left, int right){
		while (left >= 0 && right < s.length()){
			if (s.charAt(left) != s.charAt(right)){
				break;
			}
			left --;
			right ++;
		}
		return s.substring(left + 1, right);
	}
}