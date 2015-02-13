//leetcode 2nd 2015/2/7
//Mingxuan Wang
//uniquePathsWithObstacles

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        
        int hei = obstacleGrid.length;
        int len = obstacleGrid[0].length;
        int[][] pathGrid = new int[hei][len];
        
        for (int i = 0; i < hei; i++){
            if (obstacleGrid[i][0] != 1){
                pathGrid[i][0] = 1;
            }else{
                break;
            }
        }
        
        for (int i = 0; i < len; i++){
            if (obstacleGrid[0][i] != 1){
                pathGrid[0][i] = 1;
            }else{
                break;
            }
        }
        
        for (int i = 1; i< hei; i++){
            for (int j = 1; j < len; j++){
                if (obstacleGrid[i][j] != 1){
                    pathGrid[i][j] = pathGrid[i-1][j] + pathGrid[i][j-1];
                }else{
                    pathGrid[i][j] = 0;
                }
            }
        }
        
        return pathGrid[hei - 1][len - 1];
    }
}