//leetcode 2nd 2015/1/28
//Mingxuan Wang
//two sum

public class Solution{
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length < 2){
			return null;
		}
		
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap();
		for (int i = 0; i < numbers.length; i++){
			map.put(numbers[i], i + 1);
		}
		
		for (int i = 0; i < numbers.length; i++){
			if (map.containsKey(target - numbers[i])){
				int index1 = i + 1;
				int index2 = map.get(target - numbers[i]);
				if (index1 == index2){
					continue;
				}
				result[0] = index1;
				result[1] = index2;
				return result;
			}
		}
	}
}