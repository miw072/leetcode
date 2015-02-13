//leetcode 2nd 2015/2/4
//Mingxuan Wang
//trap

public class Solution {
    public int trap(int[] A) {
        if (A == null){
			return 0;
		}
		
		int max = 0;
		int len = A.length;
		int [] left = new int[len];
		int [] right = new int[len];
		
		for (int i = 0; i < len; i++){
			left[i] = i == 0 ? A[i] : Math.max(left[i - 1], A[i]);
		}
		
		for (int i = len - 1; i >= 0; i--){
			right[i] = i == len - 1 ? A[i] : Math.max(right[i + 1], A[i]);
		}
		
		for(int i = 0; i < len; i ++){
			height = Math.min(left[i], right[i]);
			if (height > A[i]){
				max = max + height - A[i];
			}
		}
		return max;
    }
}