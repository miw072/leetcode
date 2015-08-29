//给定两个数组表示的整数，如x=1234=[1,2,3,4]...返回第一个整数的重组后的值最接近第二个整数且大于第二个整数
int[] getClosestBigger(int[] x, int[] y){
	int len = x.length;
	int[] res = new int[len];
	
	//对x排序
	Arrays.sort(x);
	int i = 0, k = 0;
	boolean used[] = new boolean[len];
	for (int j = 0; j < len; j++){
		i = 0;
		while (i < len && (used[i] || x[i] < y[j])){
			i++;
		}
		//找到一个大于等于的数字
		res[k++] = x[i];
		used[i] = true;
		if(i == len-1) {
			break;
		}
		if (x[i] > y[j]){
			//复制未使用序列
			for (i = 0; i < len; i++){
				if (!used[i]){
					res[k++] = x[i];
				}
			}
			break;
		}
	}
	return res;
}