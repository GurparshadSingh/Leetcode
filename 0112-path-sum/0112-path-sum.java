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
    public void dfs(TreeNode root,int sb,ArrayList<Integer> arr,int targetSum){
        if (root == null) {
            return;
        }
        int val = root.val;
        
        sb+=root.val;
        
        if (root.left == null && root.right == null) {
            // Leaf node
           if(targetSum==sb){
            arr.add(sb);
           }
           sb-=val;
           return;
        }
        
        dfs(root.left,sb,arr,targetSum);
        dfs(root.right,sb,arr,targetSum);
        sb-=val;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> arr = new ArrayList<>();
        dfs(root,0,arr,targetSum);
        if(arr.size()!=0){
            return true;
        }
        return false;
    }
}