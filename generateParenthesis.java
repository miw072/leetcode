//leetcode 2nd 2015/1/29
//Mingxuan Wang
//generateParenthesis

public class Solution {
    public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		if (n <= 0){
			return result;
		}
		getPair(result, "", n, n);
		return result;
    }
	
	private void getPair(List<String> result, String s, int left, int right){
		//bug 1: left must be greater than right, ow return
		if (left > right || left < 0 || right < 0){
			return;
		}
		if (left == 0 && right == 0){
			result.add(s);
			return;
		}
		
		getPair(result, s + "(", left - 1, right);
		getPair(result, s + ")", left, right - 1);
	}
}