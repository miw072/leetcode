//两个有序数组A和B，长度分别问m和n，求其合并后第k个值
int findKthSortedArrays(int[] A, int[] B, int k){
	int m = A.length, n =B.length;
	if (m > n){
		return findKthSortedArrays(B, A, k);
	}
	int left = 0, right = m;
	while(left < right){
		//二分查找
		int mid = left + (right-left)/2, j = k-1-mid;
		if (j >= n || A[mid] < B[j]){
			left = mid + 1;
		}else{
			right = mid;
		}
	}
	int Aiminus1 = left - 1 >= 0?A[left-1]:Integer.MIN_VALUE;
	int Bj = k - 1 - left >= 0?B[k-1-left]:Integer.MIN_VALUE; 	
	return Math.max(Aiminus1, Bj);
}