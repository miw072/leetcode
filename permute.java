//leetcode 2nd 2015/2/4
//Mingxuan Wang
//permute

public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0){
			return result;
		}
		List<Integer> path = new ArrayList<Integer> ();
		dfs(result, path, num);
		return result;
    }
	
	private void result(List<List<Integer>> result, List<Integer> path, int[] num){
		if (path.size() == num.length){
			result.add(new ArrayList<Integer>(path));
			return;
		}
		
		for (int i = 0; i < num.length; i++){
			if (path.contains(num[i])){
				continue;
			}
			path.add(num[i]);
			dfs(result, path, num);
			path.remove(path.size() - 1);
		}
	}
}