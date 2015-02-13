//leetcode 2nd 2015/2/7
//Mingxuan Wang
//insert

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null){
			return intervals;
		}
		List<Interval> result = new ArrayList<Interval>();
		if (intervals == null){
			result.add(newInterval);
			return result;
		}
		
		int position = 0;
		for (Interval interval:intervals){
			if (interval.end < newInterval.start){
				result.add(interval);
				position++;
			}else if (interval.start > newInterval.end){
				result.add(interval);
			}else{
				newInterval.start = Math.min(interval.start, newInterval.start);
				newInterval.end = Math.max(interval.end, newInterval.end);
			}
		}
		result.add(position, newInterval);
		return result;
    }
}