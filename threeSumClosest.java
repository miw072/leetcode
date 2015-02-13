//leetcode 2nd 2015/1/29
//Mingxuan Wang
//threeSumClosest

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3){
			return 0;
		}
		Arrays.sort(num);
		//bug 1: must be Integer.MAX_VALUE / 2 here. Ow closet - target mey be overflow
		int closet = Integer.MAX_VALUE / 2;
		for (int i = 0; i < num.length - 2; i++){
			if (i != 0 && num[i] == num[i - 1]){
				continue;
			}
			int left = i + 1;
			int right = num.length - 1;
			while (left < right){
				int sum = num[i] + num[left] + num[right];
				if (sum == target){
					return sum;
				}else if (sum < target){
					left ++;
				}else{
					right --;
				}
				if (Math.abs(closet - target) > Math.abs(sum - target)){
					closet = sum;
				}
			}
		}
		return closet;
    }
}