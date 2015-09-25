int[] sortColors(int A[]){
	int p0 = 0, p2 = A.length;
	for(int i = 0; i < p2; ++i){
		if(A[i] == 0){
			int tmp = A[p0];
			A[p0] = A[i];
			A[i] = tmp;
			p0++
		}
		else if(A[i] == 2){
			p2--;
			int tmp = A[p2];
			A[p2] = A[i];
			A[i] = tmp;
			i--;
		}
	}
	return A;
}