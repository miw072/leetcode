//leetcode 2nd 2015/1/29
//Mingxuan Wang
//Letter Combinations of a Phone Number

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
		if (digits == null){
			return result;
		}
		char[][] map = {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
		dfs(digits, result, new String(), map);
		return result;
    }
	private void dfs(String digits, List<String> result, String path, char[][] map){
		if (digits.length() == 0){
			result.add(new String(path));
			return;
		}
		
		int now = digits.charAt(0) - '0';
		for (int i = 0; i < map[now - 2].length; i++){
			path += map[now - 2][i];
			dfs(digits.substring(1), result, path, map);
			path = path.substring(0, path.length() - 1);
		}
	}
	
}