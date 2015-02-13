//leetcode 2nd 2015/1/31
//Mingxuan Wang
//Search in Rotated Sorted Array

public class Solution {
    public int search(int[] A, int target) {
        int start = 0;
		int end = A.length - 1;
		int mid;
		
		while (start + 1 < end){
			mid = start + (end - start) / 2;
			if (A[mid] == target){
				return mid;
			}
			if (A[start] < A[mid]){
				//bug: must be <= here
				if (A[start] <= target && target <= A[mid]){
					end = mid;
				}else{
					start = mid;
				}
			}else{
				if (A[mid] <= target && target <= A[end]){
					start = mid;
				}else{
					end = mid;
				}
			}
		}
		if (A[start] == target){
			return start;
		}
		if (A[end] == target){
			return end;
		}
		//bug: forget to return -1 at last
		return -1;
    }
}