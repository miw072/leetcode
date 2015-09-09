public boolean isNumber(String s){
	boolean res = false;
	if(s == null) return res;
	s = s.trim();
	if(s.equals("")) return res;
	
	//需要考虑：符号，点，指数e，数字
	boolean hasSign = false, hasDot = false;
	boolean hasExp = false, hasDigit = false;
	
	s = s.toLowerCase();
	int len = s.length();
	
	for(int i = 0; i < s.length(); i++){
		char c = s.charAt(i);
		if(!isValid(c)) return false;
		switch(c){
			case '+':
			case '-':
				//不在第一个或者e后面，不再最后一个字符
				if((i!=0 && s.charAt(i-1)!='e') || i == len-1){
					return false;
				}else{
					hasSign = true;
				}
				break;
			case '.':
				//只有一个字符，只有符号和点，在e和点之后
				if(len == 1 || (len == 2 && hasSign) || hasExp || hasDot){
					return false;
				}else{
					hasDot = true;
				}
				break;
			case 'e':
				//出现在第一个和最后一个，前面没有数字，前面有e了
				if(i == 0 || i == len-1 || !hasDot || hasExp){
					return false;
				}else{
					hasExp = true;
				}	
				break;
			default:
				hasDigit = true;
				break;		
		}
	}
	return true;
}

public boolean isValid(char c){
	if (c == '+' || c == '-' || c == '.' || c == 'e' || (c >= '0' && c <= '9')){
		return true;
	}else{
		return false;
	}
}