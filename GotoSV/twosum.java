//给定整型数组，是否能找出其中的两个数，使其和为指定的某个
boolean hasSum(int[] A, int target){
	boolean res = false;
	if (A == null || A.length < 2) return false;
	Arrays.sort(A);
	int i = 0, j = A.length - 1;
	while (i < j){
		if (A[i] + A[j] == target){
			res = true;
			break;
		}else if (A[i] + A[j] > target){
			j--;
		}else{
			i++;
		}
	}
	return res;	
}

