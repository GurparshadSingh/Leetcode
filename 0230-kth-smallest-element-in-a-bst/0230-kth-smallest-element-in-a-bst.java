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
    ArrayList<Integer> list = new ArrayList<>();
    int ans = 0;
    int count = 0;

    public void inorder(TreeNode root,int k) {
        if (root == null) {
            return;
        }
        inorder(root.left,k);
        list.add(root.val);
        count++;
        if (count == k) {
            ans=root.val;
        }
        inorder(root.right,k);
    }

    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        // return list.get(k-1);
        return ans;
       
    }
}