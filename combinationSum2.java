//leetcode 2nd 2015/2/4
//Mingxuan Wang
//combinationSum2

public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0){
            return result;
        }
        
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(num);
        helper(result, path, num, target, 0);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> path, int[] num, int t, int pos){
        if (t == 0){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        if (pos >= num.length || t < 0) {
            return;
        }
        
        int prev = -1;
        for (int i = pos; i < num.length; i++){
            if (prev != num[i]){
                path.add(num[i]);
                helper(result, path, num, t - num[i], i + 1);
                path.remove(path.size() - 1);
                prev = num[i];
            }
        }
    }
}