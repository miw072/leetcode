//leetcode 2nd 2015/1/31
//Mingxuan Wang
//nextPermutation

public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null){
			return;
		}
		
		int len = num.length;
		int index = -1;
		for (int i = len - 1; i >= 0; i--){
			if (i != len - 1 && num[i] < num[i + 1]){
				index = i;
				break;
			}
		}
		
		if (index != -1){
			for (int i = len - 1; i >= index; i--){
				if (num[i] > num[index]){
					int tmp = num[index];
					num[index] = num[i];
					num[i] = tmp;
					break;
				}
			}
		}
		
		int left = index + 1;
		int right = len - 1;
		while (left < right){
			int tmp = num[left];
			num[left] = num [right];
			num[right] = tmp;
			left ++;
			right --;
		}
    }
}