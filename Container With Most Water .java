//leetcode 2nd 2015/1/29
//Mingxuan Wang
//Container With Most Water 

public class Solution {
    public int maxArea(int[] height) {
        if (height == null){
			return 0;
		}
		
		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;
		
		while (left < right){
		    int h = Math.min(height[left], height[right]);
			maxArea = Math.max(maxArea, h * (right - left));
			if (height[left] < height[right]){
				left ++;
			}else{
				right --;
			}
		}
		return maxArea;
    }
}