//leetcode 2nd 2015/2/9
//Mingxuan Wang
//simplifyPath

public class Solution {
    public String simplifyPath(String path) {
        String result = "/";
		String[] element = path.split("/+");
		ArrayList<String> paths = new ArrayList<String>();
		
		for (String s:element){
			if (s.equals("..")){
				if (paths.size() >= 1){
					paths.remove(paths.size() - 1);
				}
			}
			else if (!s.equals(".") && !s.equals("")){
				paths.add(s);
			}
		}
		
		for (String s:paths){
			result += s + "/";
		}
		if (result.length() > 1){
			result = result.substring(0, result.length() - 1);
		}
		return result;
    }
}