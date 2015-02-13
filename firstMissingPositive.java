//leetcode 2nd 2015/2/4
//Mingxuan Wang
//firstMissingPositive

public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A == null){
			return 1;
		}
		
		for (int i = 0; i < A.length; i++){
			if (A[i] <= A.length; A[i] > 0; A[i] != A[A[i] - 1]){
				int tmp = A[A[i] - 1];
				A[A[i] - 1] = A[i];
				A[i] = tmp;
			}
		}
		
		for (int i = 0; i < A.length; i++){
			if (A[i] != i + 1){
				return i + 1;
			}
		}
		return A.length + 1;
    }
}