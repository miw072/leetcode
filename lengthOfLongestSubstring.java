//leetcode 2nd 2015/1/28
//Mingxuan Wang
//lengthOfLongestSubstring
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null ){
			return 0;
		}
		
		int max = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int leftbound = 0;
		
		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			//bug 1: the index of the repeated element must be after the leftbound, "abba"
			if (map.containsKey(c) && map.get(c) >= leftbound){
				leftbound = map.get(c) + 1;
			}
			
			map.put(c, i);
			
			max = Math.max(max, i - leftbound + 1);
		}
		return max;
    }
}