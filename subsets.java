//leetcode 2nd 2015/2/9
//Mingxuan Wang
//subsets

public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (S == null || S.length == 0){
			return result;
		}
		
		List<Integer> path = new ArrayList<Integer>();
		Arrays.sort(S);
		dfs(S, result, path, 0);
		return result;
    }
	
	private void dfs(int[] S, List<List<Integer>> result, List<Integer> path, int start){
		result.add(new ArrayList<Integer>(path));
		for (int i = start; i < S.length; i++){
			path.add(S[i]);
			dfs(S, result, path, i + 1);
			path.remove(path.size() - 1);
		}
	}
}