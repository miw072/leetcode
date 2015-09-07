//根据字典，从一个没有空格的字符串里提取所有单词组合，求出组合里最大单词的个数
int segString(String s, HashSet<String> d){
	if (s == null || s.length() == 0){
		return 0;
	}
	
	int dp[] = new int[s.length()];
	
	for (int i = 0; i < s.length(); i++){
		String sub = s.substring(0, i+1);
		if(d.contains(sub)){
			dp[i] = 1;
		}
	}
	
	for (int i = 0; i < s.length()-1; i++){
		for (int j = 0; j < s.length(); j++){
			if(dp[i] > 0){
				String sub = s.substring(i+1, j+1);
				if(d.contains(sub)){
					dp[j] = Math.max(dp[j], dp[i]+1);
				}
			}
		}
	}
	return dp[s.length()-1];
}