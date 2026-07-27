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
    public double getAverage(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0.0; // Return 0.0 to prevent errors if the list is empty
        }
        
        return list.stream()
                   .mapToInt(Integer::intValue) // Unboxes Integer to primitive int
                   .average()                  // Calculates the average
                   .orElse(0.0);               // Fallback value
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        // List<List<Integer>> ansList = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        List<Integer> level = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            if (curr == null) {
                // ansList.add(level);
                result.add(getAverage(level));
                if (q.isEmpty()) {
                    break;
                } else {
                    level = new ArrayList<>();
                    q.offer(null);
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
        return result;
    }
}