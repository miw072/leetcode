//leetcode 2nd 2015/1/29
//Mingxuan Wang
//isValid

public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0){
			return true;
		}
		
		Stack<Character> stack = new Stack<Character>();
		String paren = "([{";
		
		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if (paren.contains(String.valueOf(c))){
				stack.push(c);
			}else{
				if (stack.isEmpty()){
					return false;
				}
				char tmp = stack.pop();
				if (!isEqual(tmp, c)){
					return false;
				}
			}
		}
		return stack.isEmpty();
    }
	
	private boolean isEqual(char c1, char c2){
		return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']' || (c1 == '{' && c2 == '}'));
	}
}