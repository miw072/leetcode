//leetcode 2nd 2015/1/28
//Mingxuan Wang
//findMedianSortedArrays
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
		int len = A.length + B.length;
		if (len % 2 == 0){
			return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
		}else{
			return (double)findKth(A, 0, B, 0, len / 2 + 1);
		}
    }
	
	private int findKth(int A[], int A_start, int B[], int B_start, int k){
		//base case of recursion
		if (A_start >= A.length){
			return B[B_start + k - 1];
		}
		if (B_start >= B.length){
			return A[A_start + k - 1];
		}
		if (k == 1){
			if (A[A_start] < B[B_start]){
				return A[A_start];
			}else{
				return B[B_start];
			}
		}
		
		//bug 1: if A_start + k/2 - 1 < A.length?
		int keyA = A_start + k/2 - 1 < A.length ? A[A_start + k/2 - 1]: Integer.MAX_VALUE;
		int keyB = B_start + k/2 - 1 < B.length ? B[B_start + k/2 - 1]: Integer.MAX_VALUE;
		
		//bug 2: next level recursion--from A_start & B_start not 0!
		if (keyA <= keyB){
			return findKth(A, A_start + k/2, B, B_start, k - k/2);
		}else{
			return findKth(A, A_start, B, B_start + k/2, k - k/2);
		}
	}
}