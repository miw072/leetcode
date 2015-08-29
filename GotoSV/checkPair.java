//给定N个整数，N为偶数，是否能找到N/2对，使得每对的和能被k整除。
boolean checkPairable(int[] nums, int k){
	if(k <= 0){
		return false;
	}
	int[] counts = new int[k];
	for (int num : nums){
		//初始化余数数组
		counts[num%k]++;  
	}
	//整除k的个数必须是偶数
	if (counts[0]%2 != 0){
		return false;
	}
	//k是偶数时，查看余数k/2的个数是否为偶数
	if (k%2 == 0){
		if(counts[k/2]%2 != 0){
			return false;
		}
	}
	
	for (int i = 0; i <= k/2; i++){
		if (counts[i] != counts[k-i]){
			return false
		}
	}
	return true;
}