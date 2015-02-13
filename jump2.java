//leetcode 2nd 2015/2/4
//Mingxuan Wang
//jump2

public class Solution {
    public int jump(int[] A) {
       if (A == null || A.length == 0){
		   return 0;
	   } 
	   
	   int step = 0;
	   int maxCover = 0;
	   int lastMaxCover = 0;
	   
	   for (int i = 0; i < A.length && i <= maxCover; i++){
		   if (i > lastMaxCover){
			   step++;
			   lastMaxCover = maxCover;
		   }
		   maxCover = Math.max(maxCover, A[i] + i);
	   }
	   
	   if (maxCover < A.length - 1){
		   return 0;
	   }
	   return step;
    }
}