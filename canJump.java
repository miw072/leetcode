//leetcode 2nd 2015/2/5
//Mingxuan Wang
//canJump

public class Solution {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0){
			return false;
		}
		
		int maxCover = 0;
		for (int = 0; i <= maxCover && i < A.length; i++){
			maxCover = Math.max(maxCover, A[i] + i);
		}
		
		if (maxCover >= A.length - 1){
			return true;
		}
		
		return false;
    }
}