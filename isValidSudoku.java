//leetcode 2nd 2015/2/1
//Mingxuan Wang
//isValidSudoku

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9){
			return false;
		}
		HashSet<Character> set = new HashSet<Character>();
		
		for (int i = 0; i < 9; i++){
			set.clear();
			for(int j = 0; j < 9; j++){
				if (!isValid(board[i][j], set)){
					return false;
				}
			}
		}
		
		for (int i = 0; i < 9; i ++){
			set.clear();
			for (int j = 0; j < 9; j++){
				if (!isValid(board[j][i], set)){
					return false;
				}
			}
		}
		
		for (int i = 0; i< 9; i += 3){
			for (int j = 0; j < 9; j += 3){
				set.clear();
				for (int k = 0; k < 9; k ++){
					if (!isValid(board[i + k / 3][j + k % 3], set)){
						return false;
					}
				}
			}
		}
		return true;
    }
	private boolean isValid(char c, HashSet<Character> set){
		if (c == '.'){
			return true;
		}
		if (c > '9' || c < '0'){
			return false;
		}
		
		if (set.contains(c)){
			return false;
		}
		
		set.add(c);
		return true;
	}
}