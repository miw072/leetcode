public int[][] generateMatrix(int n) {
        if (n < 0){
            return null;
        }
        
        int[][] result = new int[n][n];
        
        int cols = 0;
        int rows = 0;
        int num = 1;
        
        while (n > 0){
            if (n == 1){
                result[rows][cols] = num ++;
            }
            
            for (int i = 0; i < n - 1; i++){
                result[rows][cols + i] = num++;
            }
            
            for (int i = 0; i < n - 1; i++){
                result[rows + i][cols + n - 1] = num++;
            }
            
            for (int i = 0; i < n - 1; i++){
                result[rows + n -1][cols  + n - i - 1] = num ++;
            }
            
            for (int i = 0; i < n -1 ; i++){
                result[rows + n - i - 1][cols] = num ++;
            }
            
            rows++;
            cols++;
            n -= 2;
        }
        return result;
    }