int partition(int[] data, int start, int end){
	if (start > end){
		return -1;
	}
	int index = start; //可以随机选择pivot
	
	//第一次swap
	int tmp = data[index];
	data[index] = data[end];
	data[end] = tmp;
	
	for (int i = start; i < end; i++){
		if (data[i] <= data[end]){
			if (i != index){
				//第二次swap
				tmp = data[index];
				data[index] = data[i];
				data[i] = tmp;
			}
			index++;
		}
	}
	//第三次swap
	tmp = data[end];
	data[end] = data[index];
	data[index] = tmp;
	return index;
}

void getTopK(int[] data, int k){
	int start = 0, end = data.length-1;
	int index = partition(data, start, end);
	while (index != k-1){
		if (index > k-1){
			end = index-1;
			index = partition(data, start, end);
		}else{
			start = index+1;
			index = partition(data, start, end);
		}
	}
	for (int i = 0; i < k; i++){
		System.out.println(data[i]+"\t");
	}
}