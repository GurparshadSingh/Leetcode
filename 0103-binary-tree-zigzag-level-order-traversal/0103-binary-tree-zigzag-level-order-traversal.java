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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        List<Integer> level = new ArrayList<>();

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                ans.add(level);
                if (q.isEmpty()) {
                    break;
                } else {
                    q.offer(null);
                    level = new ArrayList<>();
                }
            } else {
                level.add(curr.val);

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        for (int i = 1; i < ans.size(); i += 2){
            Collections.reverse(ans.get(i));
        }
        return ans;

    }
}