//leetcode 2nd 2015/1/28
//Mingxuan Wang
//Reverse Integer

public class Solution {
    public int reverse(int x) {
        boolean isNeg = false;
        if (x < 0){
		    isNeg = true;
			x = Math.abs(x);
		}
		
		int result = 0;
		while (x != 0){
			if (result > (Integer.MAX_VALUE - x % 10) / 10){
				return 0;
			}
			result = result * 10 + x % 10;
			x = x / 10;
		}
		if (isNeg){
			return -result;
		}else{
			return result;
		}
    }
}