int minProduct(int A[], int B[]){
	int m = A.length, n = B.length;
	int[][] dp = new int[m][n];
	
	for(int i = 0; i < m; i++){
		for(int j = i; j < i + (n-m) + 1; j++){
			if(j > i){
				if(i > 0) dp[i][j]  = Math.min(A[i]*B[j] + dp[i-1][j-1], dp[i][j-1]);
				else dp[i][j] = Math.min(A[i]*B[j], dp[i][j-1]);
			}else{
				if(i==0){
					dp[i][j] = A[i] * B[j];
				}else{
					dp[i][j] = A[i] * B[j] + dp[i-1][j-1];
				}
			}
		}
	}
	return dp[m-1][n-1];
}