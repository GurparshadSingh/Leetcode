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
    static class Info {
        int dia;
        int ht;

        Info(int dia, int ht) {
            this.dia = dia;
            this.ht = ht;
        }
    }

    public Info diameter(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info left = diameter(root.left);
        Info right = diameter(root.right);

        int height = Math.max(left.ht, right.ht) + 1;
        // diameter calculate
        int diam = Math.max(
                Math.max(left.dia, right.dia),
                left.ht + right.ht);

        return new Info(diam, height);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Info ans = diameter(root);
        return ans.dia;
    }
}