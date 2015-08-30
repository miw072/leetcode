//给定一个正整数n，产生Pascal三角形的前n行
ArrayList<ArrayList<Integer>> pascalTriangle(int n){
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	if (n < 1){
		return res;
	}	
	//初始化第一行
	ArrayList<Integer> row1 = new ArrayList<Integer>();
	res.add(row1);
	if(n == 1){
		return res;
	}
	for (int i = 0; i < n; i++){
		ArrayList<Integer> row = new ArrayList<Integer>();
		row.add(1);
		for (int j = 1; j < i; j++){
			row.add(j, res.get(i-1).get(j-1)+res.get(i-1).get(j));
		}
		row.add(1);
		res.add(row);	
	}
	return res;
}