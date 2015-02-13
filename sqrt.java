//leetcode 2nd 2015/2/9
//Mingxuan Wang
//sqrt

public class Solution {
    public int sqrt(int x) {
		long high = x;
		long low = 0;
		long mid = 0;
		
		while (low <= high){
			mid = low + (high - low) / 2;
			if (x < mid * mid){
				high = mid - 1;
			}else if (x > mid * mid){
				low = mid + 1;
			}else{
				return (int)mid;
			}
		}
		//bug here: must return high
		return (int) high;
    }
}