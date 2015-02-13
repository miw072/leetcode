//leetcode 2nd 2015/2/9
//Mingxuan Wang
//exist

public class Solution {
    public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0){
			return false;
		}
		if (word.length() == 0){
			return true;
		}
		
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[0].length; j++){
				boolean result = dfs(board, word, i, j, 0);
				if (result == true){
					return true;
				}
			}
		}
		return false;
    }
	
	private boolean dfs(char[][] board, String word, int i, int j, int start){
		if (start == word.length()){
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)){
			return false;
		}
		
		board[i][j] = '#';
		boolean answer = dfs(board, word, i + 1, j, start + 1) || dfs(board, word, i - 1, j, start + 1) ||
						 dfs(board, word, i, j + 1, start + 1) || dfs(board, word, i, j - 1, start + 1);
		board[i][j] = word.charAt(start);
		return answer;
	}
}