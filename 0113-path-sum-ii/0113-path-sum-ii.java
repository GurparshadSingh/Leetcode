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
    public List<Integer> listBuild(String str){
        String s = str; //"1234"
        List<Integer> innerList = new ArrayList<>();
        for(String digit:s.split(",")){
            innerList.add(Integer.parseInt(digit));
        }
        return innerList;
    }
    public void dfs(TreeNode root, int chk, List<List<Integer>> arr, int targetSum, StringBuilder sb) {
        if (root == null) {
            return;
        }
        int len = sb.length();
        int val = root.val;
        if(len!=0){
            sb.append(",");
        }
        sb.append(root.val);

        chk += root.val;

        if (root.left == null && root.right == null) {
            // Leaf node
            if (targetSum == chk) {
                arr.add(listBuild(sb.toString()));
            }
            sb.setLength(len);
            chk -= val;
            return;
        }

        dfs(root.left, chk, arr, targetSum,sb);
        dfs(root.right, chk, arr, targetSum,sb);
        chk -= val;
        sb.setLength(len);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> arr = new ArrayList<>();
        dfs(root, 0, arr, targetSum, new StringBuilder());
        return arr;
    }
}