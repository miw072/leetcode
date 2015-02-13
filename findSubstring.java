//leetcode 2nd 2015/1/31
//Mingxuan Wang
//findSubstring

public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        //use two hashmap
		List<Integer> result = new ArrayList<Integer>();
		if (S == null || L == null){
			return result;
		}
		
		HashMap<String, Integer> toFind = new HashMap<String, Integer>();
		HashMap<String, Integer> found = new HashMap<String, Integer>();
		int arrayLen = L.length;
		int wordLen = L[0].length();
		
		for (int i = 0; i < arrayLen; i++){
			if (!toFind.containsKey(L[i])){
				toFind.put(L[i], 1);
			}else{
				toFind.put(L[i], toFind.get(L[i]) + 1);
			}
		}
		
		//bug here: the end of loop is S.length() - arrayLen * wordLen + 1
		for (int i = 0; i < S.length() - arrayLen * wordLen + 1; i++){
			found.clear();
			int j;
			for (j = 0; j < arrayLen; j ++){
				int k = i + j * wordLen;
				String word = S.substring(k, k + wordLen);
				if (!toFind.containsKey(word)){
					break;
				}
				if (!found.containsKey(word)){
					found.put(word, 1);
				}else{
					found.put(word, found.get(word) + 1);
				}
				if (found.get(word) > toFind.get(word)){
					break;
				}
			}
			if (j == arrayLen){
				result.add(i);
			}
		}
		return result;
    }
}