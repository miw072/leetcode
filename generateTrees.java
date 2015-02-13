//leetcode 2nd 2015/2/11
//Mingxuan Wang
//generateTrees

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return rec(1, n);
    }
	
	private List<TreeNode> rec(int start, int end){
		List<TreeNode> result = new ArrayList<TreeNode>();
		if (start > end){
			result.add(null);
			return result;
		}
		
		for (int i = start; i <= end; i++){
			ArrayList<TreeNode> left = rec(start, i - 1);
			ArrayList<TreeNode> right = rec(i + 1, end);
			for (TreeNode l:left){
				for (TreeNode r:right){
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					result.add(root);
				}
			}
		}
		return result;
	}
}