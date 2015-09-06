public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root){
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	if(root == null){
		return res;
	}
	LinkedList<TreeNode> currLevel = new LinkedList<TreeNode>();
	currLevel.add(root);
	boolean leftToRight = true;
	
	while(currLevel.size() != 0){
		ArrayList<Integer> currList = new ArrayList<Integer>();
		LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
		while(currLevel.size()>0){
			TreeNode node currLevel.poll();
			if(node.left != null){
				nextLevel.add(node.left);
			}
			if(node.right != null){
				nextLevel.add(node.right);
			}
			if(leftToRight){
				currList.add(node.val);
			}else{
				currList.add(0, node.val);
			}
		}
		res.add(currList);
		currLevel = nextLevel;
		leftToRight = !leftToRight;
	}
	return res;
}