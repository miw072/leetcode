//输入字符串，判断该字符串是否不含有重复字符
boolean isUniqueChars(String str){
	boolean[] char_set = new boolean[256];
	for(int i = 0; i < str.length(); i++){
		int val = str.charAt(i);
		if(char_set[val]) return false;
		char_set[val] = true;
	}
	return true;
}


//如果只有a-z
boolean isUniqueChars2(String str){
	int checker = 0;
	str = str.toLowerCase();
	for (int i = 0; i < str.length(); i++){
		int val = str.charAt(i)-'a';
		if((checker & (1<<val)) > 0) return false;
		checker |= (1<<val);
	}
	return true;
}