public double findMedianSortedArrays(int A[], int B[]){
	if ((A == null || A.length == 0) && (B == null || B.length == 0)){
		return 0.0;
	}
	int m = A.length, n = B.length;
	int k = (n+m-1)/2+1;
	return findKthSortedArrays(A, B, k);
}

double findKthSortedArrays(int[] A, int[] B, int k){
	int m = A.length, n = B.length;
	if (m > n){
		return findKthSortedArrays(B, A, k);
	}
	
	while(left < right){
		int mid = left + (right-left)/2, j = k - 1 - mid;
		if (j >= n || A[mid] < B[j]){
			left = mid + 1;
		}else{
			right = mid;
		}
	}
	int Aminus1 = left - 1 >= 0?A[left-1]:Integer.MIN_VALUE;
	int Bj = k-1-left >= 0?B[k-1-left]:Integer.MIN_VALUE;
	int valK = Math.max(Aminus1, Bj);
	if ((n+m)%2 == 1){
		return valK;
	}
	int Bjplus1 = k - left >= n?Integer.MAX_VALUE:B[k-left];
	int Ai = left >= m?Integer.MAX_VALUE:A[left];
	return ((double)(valK+Math.min(Bjplus1, Ai)))/2.0
}