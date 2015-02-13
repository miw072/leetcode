//leetcode 2nd 2015/2/1
//Mingxuan Wang
//searchRange

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int start = 0;
		int end = A.length - 1;
		int mid;
		int[] result = new int[2];
		while (start + 1 < end){
		    mid = start + (end - start) / 2;
			if (A[mid] == target){
				end = mid;
			}else if (A[mid] < target){
				start = mid;
			}else{
				end = mid;
			}
		}
		if (A[start] == target){
			result[0] = start;
		}else if (A[end] == target){
			result[0] = end;
		}else{
			result[0] = result[1] = -1;
			//bug: must reture here
			return result;
		}
		
		//bug: forget to reinitialize here
		start = 0;
		end = A.length - 1;
		while (start + 1 < end){
			mid = start + (end - start) / 2;
			if (A[mid] == target){
				start = mid;
			}else if (A[mid] < target){
				start = mid;
			}else{
				end = mid;
			}
		}
		if (A[end] == target){
			result[1] = end;
		}else if (A[start] == target){
			result[1] = start;
		}else{
			result[0] = result[1] = -1;
			return result;
		}
		return result;
    }
}