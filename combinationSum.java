//leetcode 2nd 2015/2/4
//Mingxuan Wang
//combinationSum

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Interger>> result = new ArrayList<List<Intger>>();
		if (candidates == null){
			return result;
		}
		Array.sort(candidates);
		List<Integer> path = new ArrayList<Integer>();
		dfs(result, path, 0, target, candidates);
		return result;
    }
	
	private void dfs(List<List<Integer>> result, ArrayList<Integer> path, int index, int target, int[] candidates){
		if (target == 0){
			result.add(new ArrayList<Integer>(path));
			return;
		}
		
		for (int i = index; i < candidates.length; i++){
			if (candidates[i] > target){
				break;
			}
			dfs(result, path, i, target - candidates[i], candidates);
			path.remove(path.size() - 1);
		}
		return;
	}
}