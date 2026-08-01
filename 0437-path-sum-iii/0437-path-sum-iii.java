/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;
    HashMap<Long, Integer> map = new HashMap<>();

    public void dfs(TreeNode root, long sum, int targetSum) {
        if (root == null) {
            return;
        }

        sum += root.val;

        if (map.containsKey(sum - targetSum)) {
            ans += map.get(sum - targetSum);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        dfs(root.left, sum, targetSum);
        dfs(root.right, sum, targetSum);
        map.put(sum, map.get(sum) - 1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1);
        dfs(root, 0L, targetSum);
        return ans;
    }
}