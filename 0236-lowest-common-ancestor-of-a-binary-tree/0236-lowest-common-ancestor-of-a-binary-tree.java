/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean found = false;

    public void findPath(TreeNode root, List<TreeNode> p, TreeNode h) {
        if (root == null) {
            return;
        }

        p.add(root);

        if (root.val == h.val) {
            found = true;
            return;
        }

        findPath(root.left, p, h);
        findPath(root.right, p, h);
        if (!found) {
            p.remove(p.size() - 1);
        }

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        found = false;
        findPath(root, path1, p);

        found = false;
        findPath(root, path2, q);

        int i = 0;
        while (i < path1.size() &&
                i < path2.size() &&
                path1.get(i) == path2.get(i)) {
            i++;
        }

        return path1.get(i - 1);
    }
}