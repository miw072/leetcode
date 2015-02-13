//leetcode 2nd 2015/2/5
//Mingxuan Wang
//pow

public class Solution {
    public double pow(double x, int n) {
		if (n == 0){
			return 1;
		}
		if (n == 1){
			return x;
		}
		
		boolean isNeg = false;
		if (n < 0){
			n = -n;
			isNeg = true;
		}
		
		int half = n / 2;
		int left = n - half * 2;
		double firstPart = pow(x, half);
		double secondPart = pow(x, left);
		
		if (isNeg){
			return 1 / (firstPart * firstPart * secondPart);
		}else{
			return firstPart * firstPart * secondPart;
		}
    }
}