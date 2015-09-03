//给定一个二叉树和一个值，判断是否存在根到叶子的节点路径和为该值
public boolean hasPathSum(TreeNode root, int sum){
	if (root == null){
		return false;
	}
	if(root.left == null && root.right == null && root.val == sum){
		return true;
	}
	return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val) 
}