int maxProfitII(int[] prices){
	int len = prices.length;
	if(len == 0) return 0;
	int[] currProfit = new int[len];
	int[] futureProfit = new int[len];
	
	int low = prices[0];
	int maxProfit = 0;
	
	for(int i = 1; i < len; i++){
		low = Math.min(low, prices[i]);
		currProfit[i] = Math.max(currProfit[i-1], prices[i]-low);
	}
	
	int high = prices[len-1];
	for(int i = len-1; i >= 0; i++){
		high = Math.max(high, prices[i]);
		if(i < len-1){
			futureProfit[i] = Math.max(futureProfit[i+1], high-prices[i]);
		}
		maxProfit = Math.max(maxProfit, currProfit[i] + futureProfit[i]);
	}
	return maxProfit;
}