//leetcode 2nd 2015/2/5
//Mingxuan Wang
//totalNQueens

public class Solution {
    public int totalNQueens(int n) {
        if (n == 0){
            return 0;
        }
        
        return dfs(n, 0, new ArrayList<Integer>());
    }
    
    private int dfs(int n, int row, ArrayList<Integer> path){
        if (row == n){
            return 1;
        }
        
        int num = 0;
        
        for (int i = 0; i < n; i++){
            if (isValid(path, i)){
                path.add(i);
                num += dfs(n, row + 1, path);
                path.remove(path.size() - 1);
            }
        }
        return num;
    }
    
    private boolean isValid(ArrayList<Integer> path, int col){
        int size = path.size();
        for (int i = 0; i < size; i++){
            if (col == path.get(i)){
                return false;
            }
            if (size - i == Math.abs(col - path.get(i))){
                return false;
            }
        }
        return true;
    }
}