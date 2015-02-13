//leetcode 2nd 2015/2/9
//Mingxuan Wang
//plusOne

public class Solution {
    public int[] plusOne(int[] digits) {
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--){
			int sum = digits[i] + carry;
			carry = sum / 10;
			digits[i] = sum % 10;
		}
		
		if (carry == 0){
			return digits;
		}
		
		int[] newDigits = new int[digits.length + 1];
		for (int i = 1; i < digits.length; i++){
			newDigits[i] = digits[i];
		}
		newDigits[0] = 1;
		return newDigits;
    }
}