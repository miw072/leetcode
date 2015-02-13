//leetcode 2nd 2015/1/29
//Mingxuan Wang
//intToRoman

public class Solution {
    public String intToRoman(int num) {
        if (num <= 0){
			return "";
		}
		
		int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] roma = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		StringBuffer result = new StringBuffer();
		int digit = 0;
		while (num > 0){
			int times = num / nums[digit];
			num = num - times * nums[digit];
			while (times > 0){
				result.append(roma[digit]);
				times--;
			}
			digit++;
		}
		return result.toString();
    }
}