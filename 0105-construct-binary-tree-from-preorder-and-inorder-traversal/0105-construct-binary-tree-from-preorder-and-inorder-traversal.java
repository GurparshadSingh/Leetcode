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
    static int idx = -1;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idx = -1;
        return build(preorder,inorder,0,preorder.length-1);
    }

    public TreeNode build(int[] preorder,int[] inorder,int start,int end){
        if(start>end){
            return null;
        }
        idx++;
        TreeNode node = new TreeNode(preorder[idx]);

        int k = start;
        while(inorder[k]!=preorder[idx]){
            k++;
        }

        node.left=build(preorder,inorder,start,k-1);
        node.right=build(preorder,inorder,k+1,end);

        return node;
    }
}