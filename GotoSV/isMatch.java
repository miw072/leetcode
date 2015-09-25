boolean isMatch(String s, String p){
	if(s == null) return p == null;
	if(p == null) return false;
	return isMatch(s, p, 0, 0);
}

boolean isMatch(String s, String p, int i, int j){
	//p到头了，看s是否也到头
	if(j == p.length()) return i == s.length();
	//如果后一个字符不是*
	if(j == p.length()-1 || p.charAt(j+1) != '*'){
		if(i == s.length()) return false;
		return (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) && isMatch(s, p, ++i, ++j);
	}
	
	while(i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))){
		//跳过*字符，如果匹配，返回true，否则继续比较
		if(isMatch(s, p, i, j+2)) return true;
		i++;
	}
	return isMatch(s, p, i, j+2);
}