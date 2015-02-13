//leetcode 2nd 2015/2/11
//Mingxuan Wang
//merge

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
       int index = m + n;
	   while (m > 0 && n > 0){
		   if (A[m - 1] > B[n - 1]){
			   A[--index] = A[--m];
		   }else{
			   A[--index] = B[--n];
		   }
	   }
	   
	   while (n > 0){
		   A[--index] = B[--n];
	   }
	   while (m > 0){
		   A[--index] = A[--m];
	   }
    }
}