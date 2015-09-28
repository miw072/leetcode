int maxAreaII(int A[]){
	int n = A.length, result = 0;
	int highest = 0;
	for(int i = 0; i < n; i++){
		if(A[i] > highest){
			highest = A[i];
		}
	}
	int second = 0;
	for(int i = 0; i < highest; i++){
		if(second > A[i]){
			result += second - A[i];
		}else{
			second = A[i];
		}
	}
	second = 0;
	for(int i = n-1; i > highest; i--){
		if(second > A[i]){
			return += second - A[i];
		}else{
			second = A[i];
		}
	}
	return result;
}