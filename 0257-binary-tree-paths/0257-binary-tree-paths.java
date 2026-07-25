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
    public void dfs(TreeNode root,String p,List<String> ans){
        if (root == null) {
            return;
        }
        p+=root.val;

        if (root.left == null && root.right == null) {
            // Leaf node
           ans.add(p);
        }
        p+="->";
        dfs(root.left,p,ans);
        dfs(root.right,p,ans);

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root,"",ans);
        return ans;
    }
}