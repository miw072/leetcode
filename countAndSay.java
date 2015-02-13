//leetcode 2nd 2015/2/4
//Mingxuan Wang
//countAndSay

public class Solution {
    public String countAndSay(int n) {
		String lastString = "1";
		for (int i = 1; i < n; i++){
			char[] lastCharArray = lastString.toCharArray();
			StringBuffer result = new StringBuffer();
			
			for (int j = 0; j < lastCharArray.length; j++){
				int count == 0;
				while ((j + 1) < lastCharArray.length && lastCharArray[j] == lastCharArray[j + 1]){
					count ++;
					j++;
				}
				result.append(String.valueOf(count) + String.valueOf(lastCharArray[j]));
			}
			lastString = result.toString();
		}
		return lastString;
    }
}