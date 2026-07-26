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
    public void preorder(TreeNode root, ArrayList<Integer> arr, StringBuilder sb) {
        if (root == null) {
            return;
        }
        int len = sb.length();
        int val = root.val;
        sb.append(val);

        if (root.left == null && root.right == null) {
            //leaf node
            arr.add(Integer.parseInt(sb.toString()));
            sb.setLength(len);//backtrack
            return; //zarurat nhi likhne ki apne aap aaa jata fxn back jb poora hojaye

        }

        preorder(root.left, arr, sb);
        preorder(root.right, arr, sb);

        sb.setLength(len);// backtrack
    }

    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        int ans = 0;
        
        preorder(root, arr, new StringBuilder());
        
        for(int digit : arr){
            ans+=digit;
        }
        return ans;
    }
}