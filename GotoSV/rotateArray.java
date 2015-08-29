//返回将一维数组向右旋转k个位置。space:常数级。
//思路：三次反转数组
int[] rotateK(int[] A, int k){
	if (A == null || k >= A.length - 1){
		return A;
	}
	reverse(A, 0, A.length - 1);
	reverse(A, 0, k-1);
	reverse(A, k, A.length - 1);
	return A;
}

void reverse(int[] A, int start, int end){
	while (start < end){
		int tmp = A[start];
		A[start] = A[end];
		A[end] = tmp;
		start++;
		end--;
	}
}