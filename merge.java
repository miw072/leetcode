//leetcode 2nd 2015/2/7
//Mingxuan Wang
//merge

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
    public List<Interval> merge(List<Interval> intervals) {
       if (intervals == null || intervals.size() <= 1){
		   return intervals;
	   } 
	   
	   List<Interval> result = new ArrayList<Interval>();
	   Collections.sort(intervals, new IntervalComparator());
	   Interval last = intervals.get(0);
	   
	   for (int i = 1; i < intervals.size(); i++){
		   Interval current = intervals.get(i);
		   //bug here: must be <=
		   if (current.start <= last.end){
			   last.end = Math.max(current.end, last.end);
		   }else{
			   result.add(last);
			   last = current;
		   }
	   }
	   result.add(last);
	   return result;
    }
	
	public class IntervalComparator implements Comparator<Interval>{
		public int compare(Interval interval1, Interval interval2){
			if (interval1.start > interval2.start){
				return 1;
			}else if (interval1.start < interval2.start){
				return -1;
			}else{
				return 0;
			}
		}
	}
}