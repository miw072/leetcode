ArrayList<String> restoreIpAddress(String s){
	ArrayList<String> res = new ArrayList<String>();
	String ip = "";
	restoreIpAddress(s, 0, 0, ip, res);
	return res;
}

void restoreIpAddress(String s, int start, int part, String ip, ArrayList<String> res){
	//如果字数过多，忽略
	if(s.length()-start > (4-part)*3) return;
	//如果字数过少，忽略
	if(s.length()-start < (4-part)) return;
	
	//找到一个合法的ip
	if(start == s.length() && part == 4){
		res.add(ip.substring(0, ip.length()-1));
		return;
	}	
	int num = 0;
	for(int i = start; i < Math.min(start+3, s.length()); i++){
		num = num*10 + (s.charAt(i)-'0');
		if (num <= 255){
			ip += s[i];
			restoreIpAddress(s, i+1, part+1, ip+'.', res);
		}
		if (num==0) break;
	}
}