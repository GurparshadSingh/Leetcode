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
    public TreeNode buildTree(int start,int end, int[] nums){
        if(start>end){
            return null;
        }
        int mid = start+ (end-start) / 2;
        TreeNode newNode = new TreeNode(nums[mid]);

        newNode.left = buildTree(start,mid-1,nums);
        newNode.right = buildTree(mid+1,end,nums);

        return newNode;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n-1;
        return buildTree(start,end,nums);
    }
}