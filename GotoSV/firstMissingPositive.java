//给定一个无序整形数组，找出第一个不在数组里的正整数。要求时间：O(n),空间：O(1)
int firstMissingPositive(int[] A){
	int n = A.length;
	for(int i = 0; i < n; i++){
		if(A[i] > 0 && A[i] <=n){
			if(A[i]-1 != i && A[A[i]-1] != A[i]){
				int tmp = A[A[i]-1];
				A[A[i]-1] = A[i];
				A[i] = tmp;
				//交换之后，还要对A[i]重新判断
				i--;
			}
		}
	}
	for (int i = 0; i < n; i++){
		//输出第一个不匹配数字
		if(A[i]-1 != i){
			return i+1
		}
	}
	return n+1;
}