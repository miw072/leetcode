//给定一个有序数组和一个目标值，找出目标值的起止下标，如果不含有，返回[-1, -1]
int[] searchRange(int[] A, int target){
	int[] range = [-1, -1];
	int lower = 0, upper = A.length, mid;
	if (A[upper-1] < target){
		return range;
	}
	//搜索起点
	while(lower < upper){
		mid = (lower+upper)/2;
		if (A[mid] < target){
			lower = mid+1;
		}else{
			upper = mid;//不用mid-1，是因为要保留可能存在目标值得元素
		}
	}
	if(A[lower] != target){
		return range;
	}
	range[0] = lower;
	
	//搜索止点
	upper = A.length;
	while(lower < upper){
		mid = (lower+upper)/2;
		if(A[mid] > target){
			upper = mid;
		}else{
			lower = mid+1;
		}
	}
	range[1] = upper-1;
	return range
}