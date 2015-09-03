//给定两个节点，求它们在一个普通树种的LCA
class TreeNode{
	int val;
	ArrayList<TreeNode> children;
}

TreeNode LCA4(TreeNode root, TreeNode p, TreeNode q){
	if(root == null || p == null || q == null){
		return null;
	}
	Queue<TreeNode> currLevel = new LinkedList<TreeNode>();
	Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
	currLevel.offer(root);
	
	//使用队列记录到根的路径
	Queue<TreeNode> pp = new LinkedList<TreeNode>();
	Queue<TreeNode> qq = new LinkedList<TreeNode>();
	
	//使用哈希存储父节点
	HashMap<TreeNode, TreeNode> backTracing = new HashMap<TreeNode, TreeNode>();
	
	//BFS
	while(!currLevel.isEmpty()){
		while(!currLevel.isEmpty()){
			nextLevel = new LinkedList<TreeNode>();
			TreeNode node = currLevel.poll();
			for (TreeNode child : node.children){
				backTracing.put(child, node);
				if (child == p){
					//求出p到根的路径
					addParent(pp, p, backTracing);
				}else if (child == q){
					addParent(qq, q, backTracing);
				}
				if (!pp.isEmpty() && !qq.isEmpty()){
					//求出两条路径的第一个交点
					return getLCA(pp, qq);
				}else{
					nextLevel.offer(child);
				}
			}
		}
		currLevel = nextLevel;
	}
	return null;
}

void addParent(Queue<TreeNode> que, TreeNode p, HashMap<TreeNode, TreeNode> bt){
	TreeNode parent = bt.get(q);
	while(parent != null){
		que.addFirst(parent);
		parent = bt.get(parent);
	}
}

TreeNode getLCA(Queue<TreeNode> pp, Queue<TreeNode> qq){
	TreeNode result = null;
	while(!pp.isEmpty() && qq.isEmpty()){
		TreeNode pParent = pp.poll();
		TreeNode qParent = qq.poll();
		if(pParent == qParent){
			result = pParent;
		}else{
			break;
		}
	}
}