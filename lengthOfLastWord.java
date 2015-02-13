//leetcode 2nd 2015/2/7
//Mingxuan Wang
//lengthOfLastWord

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0){
			return 0;
		}
		
		int result = 0;
		for (int i = s.length() - 1; i >= 0; i--){
			if (result == 0){
				if (s.charAt(i) == ' '){
					continue;
				}else{
					result++;
				}
			}else{
				if (s.charAt(i) == ' '){
					break;
				}else{
					result++;
				}
			}
		}
		return result;
    }
}