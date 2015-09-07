//根据字典，从一个没有空格的字符串里提取出全部单词组合，拼接成句子
ArraList<String> tokenizeString(String input, HashSet<String> d, HashMap<String, ArraList<String>> memorized){
	ArraList<String> res = new ArraList<String>();
	if (input == null || input.length() == 0) return res;
	if(memorized.containsKey(input)) return memorized.get(input);
	if (d.contains(input)) res.add(input);
	int len = input.length();
	for (int i = 0; i < len; i++){
		String prefix = input.substring(0, i);
		if(d.contains(prefix)){
			for(String segSuffix:tokenizeString(input.substring(i,len), d, memorized)){
				if(segSuffix != null){
					res.add(prefix + " " + segSuffix);
				}
			}
		}
	}
	memorized.put(input, res);
	return res;
}