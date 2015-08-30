//给定一个旋转的有序数组和一个目标值，返回目标值在该数组的下标。如果不存在，那么返回-1。假设没有重复。
int searchRotatedArray(int[] A, int target){
	int left = 0;
	int right = A.length - 1;
	while (left < right){
		int mid = left + (right-left)/2;
		if (A[mid] == target) {
			return mid;
		}
		if(A[left] <= A[mid]){
			if (A[left] <= target && target < A[mid]){
				right = mid-1;
			}else{
				left = mid+1；
			}
		}else{
			if(A[mid]<target && target<=A[right]){
				left = mid+1
			}else{
				right = mid-1;
			}
		}
	}
	return -1;
}