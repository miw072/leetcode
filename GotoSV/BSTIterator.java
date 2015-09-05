class BSTIterator implements Iterator<Integer>{
	private Stack<TreeNode> stack = new Stack<TreeNode>();
	BSTIterator(TreeNode root){
		//初始化，压入最左节点
		pushLeft(root);
	}
	
	public boolean hasNext(){
		return !stack.isEmpty();
	}
	
	public int next(){
		TreeNode x = stack.pop();
		pushLeft(x.right);
		return x.val;
	}
	
	private void pushLeft(TreeNode n){
		while(x!=null){
			stack.push(x);
			x = x.left;
		}
	}
}