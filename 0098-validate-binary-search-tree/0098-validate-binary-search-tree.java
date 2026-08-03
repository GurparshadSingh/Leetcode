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
    ArrayList<Integer> array = new ArrayList<>();

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        isValidBST(root.left);
        array.add(root.val);
        isValidBST(root.right);
    }

    public boolean compare(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size()-1; i++) {
            if (arr.get(i) >= arr.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        preorder(root);
        return compare(array);
    }
}