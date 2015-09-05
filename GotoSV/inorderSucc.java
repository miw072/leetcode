//给出一个二叉树的一个节点，求其中序遍历的下一个节点。有父节点。
public TreeNode inorderSucc(TreeNode e){
	if(e == null) return null;
	if(e.right != null){
		//如果有右节点，找到右子树的最左节点
		return getLeftMost(e.right);
	}else{
		//如果没有右节点，向上查看父节点，找到第一个使其父节点的左节点
		TreeNode p = e.parent;
		while (p != null && p.left != e){
			e = p;
			p = e.parent;
		}
		return p;
	}
}

TreeNode getLeftMost(TreeNode e){
	TreeNode res = e;
	while (res.left != null) res = res.left;
	return res;
}