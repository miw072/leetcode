//给定一个没有重叠的区间序列，现插入一个新的区间到该序列，要求维持没有重叠的情况。假设该序列是有序的。
ArrayList<Interval> insert(Interval[] intervals, Interval newInt){
	ArrayList<Interval> res = new ArrayList<Interval>();
	if (intervals == null){
		res.add(newInt);
		return res;
	}
	int i = 0, n = intervals.length;
	while (i < n && newInt.start > intervals[i].end){
		res.add(intervals[i++]);
	}
	while (i < n && newInt.end >= intervals[i].start){
		newInt.end = Math.max(newInt.end, intervals[i].end);
		newInt.start = Math.min(newInt.start, intervals[i].start);
		i++;
	}
	res.add(newInt);
	while (i < n){
		res.add(intervals[i++]);
	}
	return res;
}