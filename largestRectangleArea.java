//leetcode 2nd 2015/2/10
//Mingxuan Wang
//largestRectangleArea

public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0){
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		for (int i = 0; i <= height.length; i++){
			//bug here: must push -1 into stack to pop all elements before out
			int current = (i == height.length) ? -1 : height[i];
			while (!stack.isEmpty() && current <= height[stack.peek()]){
				int h = height[stack.pop()];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(max, h * w);
			}
			stack.push(i);
		}
		return max;
    }
}