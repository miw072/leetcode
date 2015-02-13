//leetcode 2nd 2015/2/5
//Mingxuan Wang
//solveNQueens

public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
		if (n <= 0){
			return result;
		}
		
		List<Integer> cols = new ArrayList<Integer>();
		dfs(n, 0, result, cols);
		return result;
    }
	
	private void dfs(int n, int level, List<String[]> result, List<Integer> cols){
		if (level == n){
			String[] s = draw(n, cols);
			result.add(s);
			return;
		}
		
		for(int i = 0; i < n; i++){
			if(isValid(i, cols)){
				cols.add(i);
				dfs(n, level + 1, result, cols);
				cols.remove(cols.size() - 1);
			}
		}
	}
	
	private boolean isValid(int col, List<Integer> cols){
		int row = cols.size();
		for (int i = 0; i < row; i++){
			if (cols.get(i) == col){
				return false;
			}
			if (cols.get(i) - i == col - row){
				return false;
			}
			if (cols.get(i) + i == col + row){
				return false;
			}
		}
		return true;
	}
	
	private String[] draw(int n, List<Integer> cols){
		String[] tmp = new String[n];
		for(int i = 0; i < n; i++){
			StringBuffer tmp2 = new StringBuffer();
			for (int j = 0; j < n; j ++){
				tmp2.append(j == cols.get(i) ? "Q" : ".");
			}
			tmp[i] = tmp2.toString();
		}
		return tmp;
	}
}