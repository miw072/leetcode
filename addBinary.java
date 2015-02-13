//leetcode 2nd 2015/2/7
//Mingxuan Wang
//addBinary

public class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()){
			String tmp = a;
			a = b;
			b = tmp;
		}
		
		int lenA = a.length();
		int lenB = b.length();
		String result = "";
		int carry = 0;
		
		while (lenB > 0){
			int sum = (a.charAt(lenA - 1) - '0') + (b.charAt(lenB - 1) - '0') + carry;
			//bug here: must be result = ... + result;
			result = String.valueOf(sum % 2) + result;
			carry = sum / 2;
			lenA--;
			lenB--;
		}
		while (lenA > 0){
			int sum = (a.charAt(lenA - 1) - '0') + carry;
			result = String.valueOf(sum % 2) + result;
			carry = sum / 2;
			lenA--;
		}
		if (carry == 1){
			result = "1" + result;
		}
		return result;
    }
}
