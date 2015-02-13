//leetcode 2nd 2015/2/11
//Mingxuan Wang
//inorderTraversal

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
		if (root == null){
			return result;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		
		while (!stack.isEmpty() || node != null){
			if (node != null){
				stack.push(node);
				node = node.left;
			}else{
				TreeNode tmp = stack.pop();
				result.add(tmp.val);
				node = tmp.right;
			}
		}
		return result;
    }
}