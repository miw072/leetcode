//leetcode 2nd 2015/2/9
//Mingxuan Wang
//sortColors

public class Solution {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0){
			return;
		}
		
		int left = 0;
		int right = A.length - 1;
		int i = 0;
		
		while (i <= right){
			if (A[i] == 0){
				swap(A, left, i);
				left ++;
				i++;
			}else if (A[i] == 2){
				swap(A, right, i);
				right--;
			}else{
				i++;
			}
		}
    }
	
	private void swap(int[] A, int a, int b){
		int tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}
}