//设计一个类：
//Save(int input):插入一个整数到集合里
//Test(int target):检查是否有两个数和为输入值，返回boolean

public class Twosum{
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	public void save(int input){
		int originalCount = 0;
		if (hm.containsKey(input)){
			//判断是否存在，如果存在，读取个数
			originalCount = hm.get(input);
		}
		hm.put(input, originalCount + 1);
	}
	
	public boolean test(int target){
		Iterator<Integer> it = hm.keySet().iterator();
		while (it.hasNext()){
			int val = it.next();
			if (hm.containsKey(target-val)){
				boolean isDouble = target == val * 2;
				if (!(isDouble && hm.get(val) == 1)){
					return true;
				}
			}
		}
		return false;
	}
}