//leetcode 2nd 2015/2/9
//Mingxuan Wang
//combine

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		
		dfs(result, path, n, k, 1);
		return result;
    }
	
	private void dfs(List<List<Integer>> result, List<Integer> path, int n, int k, int start){
		if (path.size() == k){
			result.add(new ArrayList<Integer>(path));
			return;
		}
		
		for (int i = start; i <= n; i++){
			path.add(i);
			dfs(result, path, n, k, i + 1);
			path.remove(path.size() - 1);
		}
	}
}