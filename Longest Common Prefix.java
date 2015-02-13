//leetcode 2nd 2015/1/29
//Mingxuan Wang
//Longest Common Prefix


public class Solution {
    public String longestCommonPrefix(String[] str) {
        if (str == null){
			return null;
		}
		if (str.length == 0 || str[0].length() == 0){
			return "";
		}
		int i = 0;
		//bug 1: array--length; string--length()
		for (; i < str[0].length(); i++){
			char c = str[0].charAt(i);
			int j = 1;
			for (; j < str.length; j++){
				if (str[j].length() <= i || str[j].charAt(i) != c){
					break;
				}
			}
			
			if (j < str.length){
				break;
			}
		}
		return str[0].substring(0, i);
    }
}