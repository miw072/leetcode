//leetcode 2nd 2015/2/5
//Mingxuan Wang
//anagrams

public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
		if (strs == null || strs.length == 0){
			return result;
		}
		
		HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		for (int i = 0; i < strs.length; i++){
			String s = strs[i];
			char[] tmp = s.toCharArray();
			Arrays.sort(tmp);
			String key = new String(tmp);
			if (map.containsKey(key)){
				List<Integer> value = map.get(key);
				value.add(i);
				map.put(key, value);
			}else{
				List<Integer> value = new ArrayList<Integer>();
				value.add(i);
				map.put(key, value);
			}
		}
		
		for (Map.Entry<String, List<Integer>> entry: map.entrySet()){
			List<Integer> temp = entry.getValue();
			if (temp.size() > 1){
				for (int i = 0; i < temp.size(); i++){
					result.add(strs[temp.get(i)]);
				}
			}
		}
		return result;
    }
}