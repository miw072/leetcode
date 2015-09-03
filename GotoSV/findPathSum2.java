//一个二叉树和一个值，打印所有路径，和为给定值，可以是任意节点到叶子
void findPathSum2(TreeNode root, int sum){
	ArrayList<Integer> path = new ArrayList<Integer>();
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
	findPathSumHelper(root, sum, path, res, 0);		
}

void findPathSumHelper(TreeNode root, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res, int level){
	if (root == null){
		return;
	}
	path.add(res.data);
	if(root.left == null && root.right == null){
		int tmp = sum;
		for(int i = level; i > -1; i--){
			tmp -= path.get(i);
			if (tmp == 0){
				copyList(path, i, level, res);
			}
		}
	}else{
		findPathSumHelper(root.left, sum, path, level+1);
		findPathSumHelper(root.right, sum, path, level+1);
	}
	path.remove(path.size()-1);
}

private void copyList(ArrayList<Integer> path, int from, int end, ArrayList<ArrayList<Integer>> res){
	ArrayList<Integer> subPath = new ArrayList<Integer>();
	for(int i = from; i <= end; i++){
		subPath.add(path.get(i));
	}
	res.add(subPath);
}
