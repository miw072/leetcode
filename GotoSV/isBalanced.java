//给出一个二叉树，判断是否为平衡二叉树
public boolean isBalanced(TreeNode root){
	return (getHeight(root) != -1);
}

private int getHeight(TreeNode root){
	if(root == null){
		return 0;
	}
	int leftHeight = getHeight(root.left);
	if (leftHeight == -1){
		return -1;
	}
	int rightHeight = getHeight(root.right);
	if (rightHeight == -1){
		return -1;
	}
	if (Math.abs(leftHeight-rightHeight) > 1){
		return -1;
	}
}