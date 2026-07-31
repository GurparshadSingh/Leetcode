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
    static int idx;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        idx = postorder.length-1;
        return build(inorder,postorder,0,inorder.length-1);
    }
    public TreeNode build(int[] inorder, int[] postorder,int start,int end){
        if(start>end){
            return null;
        }
        TreeNode newNode = new TreeNode(postorder[idx--]);

        // int k = start;
        // while (inorder[k] != newNode.val) {
        //     k++;
        // }

        int k =map.get(newNode.val);
        newNode.right = build(inorder,postorder,k+1,end);
        newNode.left = build(inorder,postorder,start,k-1);
        return newNode;
    }
}