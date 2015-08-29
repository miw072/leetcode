int getMinOfRotation(int A[]){
	int left = 0, right = A.length-1, mid, min = A[left];
	while(left < right){
		mid = left + (right-left)/2;
		min = Math.min(A[left], min);
		if (A[mid] == A[left] && A[mid] == A[right]){
			left++;//如果有相同元素
		}else if(A[mid]>=A[left]){
			left = mid+1;
			min = Math.min(min, A[left]);
		}else{
			min = Math.min(min, A[mid]);
			right = mid - 1;
		}
	}
	return min;
}