//leetcode 2nd 2015/1/31
//Mingxuan Wang
//strStr

public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null){
			return -1;
		}
		
		int len1 = haystack.length();
		int len2 = needle.length();
		
		for (int i = 0; i < len1 - len2 + 1; i++){
		    int j;
			for (j = 0; j < len2; j++){
				if (haystack.charAt(j + i) != needle.charAt(j)){
					break;
				}
			}
			//bug 1: return i here
			if (j == len2){
				return i;
			}
		}
		return -1;
    }
}