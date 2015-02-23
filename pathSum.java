//leetcode 2nd 2015/2/15
//by Mingxuan Wang
//pathSum

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        
        dfs(result, path, root, sum);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> path, TreeNode root, int sum){
        if (root == null){
            return;
        }
        
        if (root.val == sum && root.left == null && root.right == null){
            path.add(root.val);
            result.add(new ArrayList<Integer>(path));
            path.remove(path.size() - 1);
            return;
        }
        
        path.add(root.val);
        dfs(result, path, root.left, sum - root.val);
        dfs(result, path, root.right, sum - root.val);
        path.remove(path.size() - 1);
    }
}