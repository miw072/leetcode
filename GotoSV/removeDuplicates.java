int removeDuplicates(int A[]){
	int i = 0;
	int j;
	int n = A.length;
	if(n<=1) return n;
	for(j = 1; j < n; j++){
		if(A[j] != A[i]){
			A[++i] = A[j];
		}
	}
	return i+1;
}