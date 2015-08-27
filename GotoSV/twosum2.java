//给定一个整型数组，找到两数之和为目标数，返回这两个数的下标，假设元素各不相同。时间：O(n)
int[] twoSum(int[] A, int target){
	int[] res = [-1. -1];
	if (A == null || A.length < 2){
		return res;
	}
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	for (int i = 0; i < A.length; i++){
		//扫描一遍，存储值和下标
		hm.put(A[i], i);
	}
	for (int i = 0; i < A.length; i++){
		if (hm.containsKey(A[i]-target) && target != 2*A[i]){
			res[0] = i;
			res[1] = hm.get(target-A[i]);
			break;
		}
	}	
	return res;
}