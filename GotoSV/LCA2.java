//给定两个节点，求它们在二叉树中LCA。每个节点有一个指向父节点的指针
TreeNode LCA2(TreeNode root, TreeNode p, TreeNode q){
	if (root == null || p == null || q == null){
		return null;
	}
	//pq.left, pq.right分别存储p,q在二叉树中对应的节点
	TreeNode pq = new TreeNode(0);
	//找出p和q在二叉树对应的节点
	help(root, p, q, pq);
	TreeNode pp = pq.left, qq = pq.right;
	if (pp == null || qq == null){
		return null;
	} 
	int lenp = 0, lenq = 0;
	TreeNode up1 = pp, up2 = qq;
	//计算到root长度
	while(up1 != root){
		up1 = up1.parent;
		lenp++;
	}
	while(up1 != root){
		up2 = up2.parent;
		lenq++;
	}
	up1 = pp;
	up2 = qq;
	//先同步到长度相同
	while(lenp > lenq){
		up1 = up1.parent;
		lenp--;
	}
	while(lenq > lenp){
		up2 = up2.parent;
		lenq--;
	}
	//往上爬，直到相遇就是lca
	while(up1 != up2){
		up1 = up1.parent;
		up2 = up2.parent;
	}
	return up1;
}

void help(TreeNode root, TreeNode p, TreeNode q, TreeNode pq){
	if (root == null){
		return;
	}
	if(root == p){
		pq.left = root;
	}
	if(root == q){
		pq.right = root;
	}
	if(pq.left == null || pq.right == null){
		help(root.left, p, q, pq);
		help(root.right, p, q, pq);
	}
}