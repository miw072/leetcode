ArrayList<Interval> merge(ArrayList<Interval> intervals){
	ArrayList<Interval> res = new ArrayList<Interval>();
	if (intervals == null || intervals.isEmpty()){
		return res;
	}
	Comparator<Interval> comparator = new Comparator<Interval>(){
		@Override
		public int compare(Interval a, Interval b){
			if (a.start < b.start){
				return -1;
			}else if(a.start > b.start){
				return 1;
			}else{
				if (a.end < b.end){
					return -1;
				}else if(a.end > b.end){
					return 1;
				}else{
					return 0;
				}
			}
		}
	}
	Collections.sort(intervals, comparator);
	for (int i = 0; i < intervals.size(); i++){
		Interval current = intervals.get(i);
		if (res.isEmpty()){
			res.add(current);
		}else{
			Interval last = res.get(res.size()-1);
			if (last.end >= current.start){
				last.end = Math.max(last.end, current.edn);
			}else{
				res.add(current);
			}
		}
	}
	return res;
}