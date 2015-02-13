//leetcode 2nd 2015/2/4
//Mingxuan Wang
//multiply

public class Solution {
    public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null){
			return null;
		}
		
		int len1 = num1.length();
		int len2 = num2.length();
		int len3 = len1 + len2;
		int[] number = new int[len3];
		
		for (int i = len1 - 1; i >= 0; i--){
			for (int j = len2 - 1; j >= 0; j--){
				//bug here : must be +=
				number[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
			}
		}
		
		int carry = 0;
		for (int i = len3 - 1; i >= 0; i--){
			number[i] += carry;
			carry = number[i] / 10;
			number[i] %= 10;
		}
		
		StringBuffer result = new StringBuffer();
		int i = 0;
		while (i < len3 - 1 && number[i] == 0){
			i++;
		}
		
		while (i < len3){
			result.append(number[i]);
			i++;
		}
		
		return result.toString();
    }
}