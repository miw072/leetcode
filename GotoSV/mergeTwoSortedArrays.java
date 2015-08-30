//给定两个有序数组A和B，把B合并到A里，保持结果有序。假设A有足够的空间容纳B的元素。初始时，A和B的元素各有m和n个。
void mergeTwoSortedArrays(int[] A, int m, int[] B, int n){
	while (n > 0){
		if(m <= 0 || A[m-1] < B[n-1]){
			A[n+m-1] = B[--n];
		}else{
			A[n+m-1] = A[--m];
		}
	}
}