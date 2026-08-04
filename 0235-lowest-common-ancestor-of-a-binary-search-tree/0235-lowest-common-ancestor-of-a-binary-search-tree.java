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
    public boolean path(TreeNode root, TreeNode x, ArrayList<TreeNode> path) {

        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.val == x.val) {
            return true;
        }

        boolean found;
        if (root.val > x.val) {
            found = path(root.left, x, path);
        } else {
            found = path(root.right, x, path);
        }

        if (!found) {
            path.remove(path.size() - 1);
        }
        return found;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path_p = new ArrayList<>();
        ArrayList<TreeNode> path_q = new ArrayList<>();
        path(root, p, path_p);
        path(root, q, path_q);

        int i = 0;
        while (i < path_p.size() && i < path_q.size() && path_p.get(i) == path_q.get(i)) {
            i++;
        }
        return path_p.get(i - 1);
    }
}