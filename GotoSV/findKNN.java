//给定一个BST和一个值，找出和该值最接近的k个节点
void findKNN(TreeNode root, int k, int target){
	Comparator<Integer> comparator = new Comparator<Integer>(){
		public int compare(Integer a, Integer b){
			//绝对值大的放在堆顶
			int abs1 = Math.abs(a);
			int abs2 = Math.abs(b);
			if(abs2 > abs1){
				return 1;
			}else if(abs1 > abs2){
				return -1;
			}else{
				return 0；
			}
		}	
	};
	
	PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, comparator);
	findKNN(root, k, target, heap);
	Iterator it = heap.iterator();
	while(it.hasNext()){
		System.out.println(it.next());
	}

}

void findKNN(TreeNode root, int k, int target, PriorityQueue<Integer> heap){
	if(root == null) return;
	
	//中序遍历
	findKNN(root.left, k, target, heap);
	if(heap.size() < k) heap.add(root.val - target);
	else{
		int diff = Math.abs(root.val - target);
		int maxdiff = Math.abs(heap.peek());
		if(maxdiff>diff){
			heap.poll();
			heap.add(root.val-target);
		}
	}	
	findKNN(root.right, k, target, heap);
}