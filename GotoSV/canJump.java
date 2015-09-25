boolean canJump(int A[]){
	if(A.length <= 1) return true;
	int i, currMax = 0;
	for(int i = 0; i < A.length-1; i++){
		if(A[i] == 0 && currMax < i+1) return false;
		if(A[i] + i > currMax && A[i] > 0){
			currMax = A[i] + i;
			if(currMax >= A.length-1) return true;
		}
	}
	return false;
}

int jump(int A[]){
	int result = 0;
	int last = 0, curr = 0;
	for(int i = 0; i < A.length; i++){
		if(i > last){
			last = curr;
			result++;
		}
		curr = Math.max(curr, i+A[i]);
	}
	return result;
}