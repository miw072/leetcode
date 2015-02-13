//leetcode 2nd 2015/2/7
//Mingxuan Wang
//getPermutation

public class Solution {
    public String getPermutation(int n, int k) {
        StringBuffer result = new StringBuffer();
		int factor = 1;
		int[] num = {1,2,3,4,5,6,7,8,9};
		for (int i = 1; i < n; i++){
			factor = factor * i;
		}
		k--;
		
		for (int i = 0; i < n; i++){
			int index = k / factor;
			result.append((char)('0' + num[index]));
			
			for(int j = index; j < n; j++){
				num[j]= num[j + 1];
			}
			
			k = k % factor;
			if (n - 1 - i > 0){
				factor = factor / (n - 1 - i);
			}
		}
		return result.toString();
    }
}