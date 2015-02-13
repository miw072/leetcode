//leetcode 2nd 2015/1/29
//Mingxuan Wang
//threeSum

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num == null || num.length < 3){
			return result;
		}
		Arrays.sort(num);
		
		for (int i = 0; i < num.length - 2; i++){
			if (i != 0 && num[i] == num[i - 1]){
				continue;
			}
			int left = i + 1;
			int right = num.length - 1;
			while (left < right){
				int sum = num[i] + num[left] + num[right];
				if (sum == 0){
					List<Integer> tmp = new ArrayList<Integer>();
					tmp.add(num[i]);
					tmp.add(num[left]);
					tmp.add(num[right]);
					result.add(tmp);
					left ++;
					right --;
					while (left < right && num[left - 1] == num[left]){
						left ++;
					}
					while (left < right && num[right + 1] == num[right]){
						right --;
					}
				}else if (sum < 0){
					left ++;
				}else{
					right --;
				}
			}
		}
		return result;
    }
}