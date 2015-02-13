//leetcode 2nd 2015/2/9
//Mingxuan Wang
//removeDuplicates

public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0){
			return 0;
		}
		
		int size = 1;
		int count = 0;
		
		//bug here: must be i = 1
		for (int i = 1; i < A.length; i++){
			if (A[i] != A[size - 1]){
				A[size++] = A[i];
				count = 0;
			}else if (count < 1){
				count ++;
				A[size++] = A[i];
			}
		}
		return size;
    }
}