//leetcode 2nd 2015/1/31
//Mingxuan Wang
//longestValidParentheses

public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null){
			return 0;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int sum = 0;
		int tmp = 0;
		
		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			
			if (c == '('){
				stack.push(i);
			}else{
				if (stack.isEmpty()){
					sum = 0;
					continue;
				}else{
					tmp = i - stack.pop() + 1;
					if (stack.isEmpty()){
						sum += tmp;
						max = Math.max(max, sum);
					}else{
						tmp = i - stack.peek();
						max = Math.max(max, tmp);
					}
				}
			}
		}
		return max;
    }
}