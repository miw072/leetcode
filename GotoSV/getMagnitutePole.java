int getMagnitutePole(int[] A){
	if(A == null || A.length == 0) return -1;
	boolean[] isCurrMax = new boolean[A.length];
	int first = A[0];//max
	for(int i = 0; i < A.length; i++){
		if(A[i] >= first){
			first = A[i];
			isCurrMax[i] = true;
		}
	}
	int second = A[A.length-1];//min
	for(int i = A.length-1; i >= 0; i--){
		if(A[i] <= second){
			second = A[i];
			if(isCurrMax[i]) return i;
		}
	}
	return -1;
}