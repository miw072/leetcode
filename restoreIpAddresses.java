//leetcode 2nd 2015/2/11
//Mingxuan Wang
//restoreIpAddresses

public class Solution {
    public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		if (s == null || s.length() < 4 || s.length() > 12){
			return result;
		}
		
		dfs(s, new ArrayList<String>(), result, 0);
		return result;
    }
	
	private void dfs(String s, List<String> path, List<String> result, int start){
		int len = s.length();
		if (path.size() == 4){
			//bug here: check start == len
		    if (start == len) {
			    StringBuffer sb = new StringBuffer();
			    for (String str:path){
				    sb.append(str);
				    sb.append(".");
			    }
			    sb.deleteCharAt(sb.length() - 1);
			
			    result.add(sb.toString());
		    }
			return;
		}
		
		for (int i = start; i < start + 3 && i < s.length(); i++){
			String sub = s.substring(start, i + 1);
			//bug here: check this
			if (s.charAt(start) == '0' && i != start){
				break;
			}
			if (!isValid(sub)){
				continue;
			}
			
			path.add(sub);
			dfs(s, path, result, i + 1);
			path.remove(path.size() - 1);
		}
	}	
	private boolean isValid(String sub){
		int num = Integer.parseInt(sub);
		return num >= 0 && num <= 255;
	}
}