//leetcode 2nd 2015/1/28
//Mingxuan Wang
//String to Integer (atoi)

public class Solution {
    public int atoi(String str) {
		if (str == null || str.length() == 0){
			return 0;
		}
		str = str.trim();
		if (str.length() == 0){
			return 0;
		}
		
		int sign = 1;
		int index = 0;
		
		if (str.charAt(0) == '+'){
			index ++;
			sign = 1;
		}
		if (str.charAt(0) == '-'){
			index ++;
			sign = -1;
		}
		
		//Be careful, here must be long, to store the whole num when overflow
		long result = 0;
		for(; index < str.length(); index++){
			if (str.charAt(index) < '0' || str.charAt(index) > '9'){
				break;
			}
			result = result * 10 + (str.charAt(index) - '0');
			if ((result > Integer.MAX_VALUE && sign == 1) || (-result < Integer.MIN_VALUE && sign == -1)){
				break;
			}
		}
		if (Math.abs(result) * sign > Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}
		if (Math.abs(result) * sign < Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}
		//bug 1: forget (int)
		return (int)result * sign;
    }
}