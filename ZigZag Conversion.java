//leetcode 2nd 2015/1/28
//Mingxuan Wang
//ZigZag Conversion

public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || s.length() == 0){
			return s;
		}
		if (s.length() <= nRows || nRows == 1){
			return s;
		}
		
		StringBuffer[] sb = new StringBuffer[nRows];
		for (int i = 0; i < nRows; i++){
			sb[i] = new StringBuffer();
		}
		
		int current = 0;
		boolean isAdd = true;
		for (int i = 0; i < s.length(); i++){
			sb[current].append(s.charAt(i));
			if (current == 0){
				isAdd = true;
			}
			if (current == nRows - 1){
				isAdd = false;
			}
			if (isAdd){
				current++;
			}
			if (!isAdd){
				current--;
			}
		}
		
		String result = new String();
		for (String tmp:sb){
			result = result + tmp.toString();
		}
		return result;
    }
}