//leetcode 2nd 2015/2/4
//Mingxuan Wang
//permuteUnique

public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0){
			return result;
		}
		List<Integer> path = new ArrayList<Integer>();
		int[] visited = new int[num.length];
		
		Arrays.sort(num);
		dfs(result, path, num, visited);
		return result;
    }
	
	private void dfs(List<List<Integer>> result, List<Integer> path, int[] num, int[] visited){
		if (path.size() == num.length){
			result.add(new ArrayList<Integer>(path));
			return;
		}
		
		for (int i = 0; i < num.length; i++){
			if (visited[i] == 1 || (i != 0 && num[i] == num[i - 1] && visited[i - 1] == 0)){
				continue;
			}
			
			visited[i] = 1;
			path.add(num[i]);
			dfs(result, path, num, visited);
			path.remove(path.size() - 1);
			//bug here: forget to set visited back to 0
			visited[i] = 0;
		}
	}
}