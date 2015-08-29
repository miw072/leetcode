//给定一维整型数组和一个整数k，找出和不小于k的数目最少的子数组
//修改partition,降序
void getTopKII(int[] data, int k){
	int start = 0, end = data.length - 1;
	int last = -1;  //记录上次的子数组和不小于k的尾部元素下标
	
	ArrayList<Integer> currSum = new ArrayList<Integer>();
	int index = partition(data, start, end, currSum);
	while (index > 0){
		if (currSum.get(0) >= k){
			//记录当前下标，我们找的了0到index子数组，满足和不小于k的条件
			last = index;
			//从index前面找
			end = index-1;
			index = partition(data, start, end, currSum);
		}else{
			//从index后面找
			start = index + 1;
			k = k - currSum.get(0);
			index = partition(data, start, end, currSum);
		}
	}
	for (int i = 0;i <= last; i++){
		System.out.println(data[i]+"\t");
	}
}