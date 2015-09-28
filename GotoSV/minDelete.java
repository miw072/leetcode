ArrayList<Integer> minDelete(int[] A){
	ArrayList<Integer> res = new ArrayList<Integer>();
	HashMap<Integer, Integer> bt = new HashMap<Integer, Integer>();
	int[] dp = new int[A.length];
	int maxCount = 0;
	int end = 0;
	
	for(int i = 0; i < A.length; i++){
		dp[i] = 1;
		for(int j = 0; j < i; j++){
			if(A[i] > A[j]){
				dp[i] = Math.max(dp[i], dp[j] + 1);
				if(maxCount < dp[i]){
					maxCount = dp[i];
					bt.put(i, j);
					end = i;
				}
			}
		}
	}
	
	int k = A.length-1;
	while(k >= 0){
		while(k > end){
			res.add(A[k]);
			k--;
		}
		k--;
		if(bt.containsKey(end)){
			end = bt.get(end);
		}else{
			end = -1;
		}
	}
	return res;
}