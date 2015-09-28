int maxArea(int A[]){
	int i = 0, j = A.length - 1;
	int result = 0;
	while(i < j){
		int area = Math.min(A[i], A[j]) * (j-i);
		result = Math.max(result, area);
		if(A[i] <= A[j]){
			i++;
		}else{
			j--;
		}
	}
	return result;
}