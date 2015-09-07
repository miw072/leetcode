//打印出所有n对合理的括号组合
void printPar(int n){
	char[] str = new char[2*n];
	printPar(n, n, str, 0);
}

void printPar(int l, int r, char[] str, int count){
	if (l < 0 || r < l) return;
	if (l == 0 && r == 0){
		System.our.println(str);
	}else{
		if (l > 0){
			str[count] = '(';
			printPar(l-1, r, str, count+1);
		}
		if (r > l){
			str[count] = ')';
			printPar(l, r-1, str, count+1);
		}
	}	
}