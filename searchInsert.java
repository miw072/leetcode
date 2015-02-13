//leetcode 2nd 2015/2/1
//Mingxuan Wang
//searchInsert

public class Solution {
    public int searchInsert(int[] A, int target) {
        int start = 0;
		int end = A.length - 1;
		int mid;
		
		if (target < A[0]){
			return 0;
		}
		if (target > A[end]){
			return end + 1;
		}
		
		while (start + 1 < end){
			mid = start + (end - start) / 2;
			if (A[mid] == target){
				return mid;
			}else if (A[mid] < target){
				start = mid;
			}else{
				end = mid;
			}
		}
		
		if (A[start] == target){
			return start;
		}
		if (A[end] == target){
			return end;
		}
		
		return start + 1;
    }
}