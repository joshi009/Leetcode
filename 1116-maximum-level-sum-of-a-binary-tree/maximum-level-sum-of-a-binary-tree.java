
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int max_lvl = 1;
    int[] memo = new int[10010];

    public void dfs(TreeNode node, int lvl){
        if(node == null) return;

        memo[lvl] += node.val;
        max_lvl = Math.max(max_lvl, lvl);

        dfs(node.right, lvl + 1);
        dfs(node.left, lvl + 1);
    }

    public int maxLevelSum(TreeNode root) {
        dfs(root, 1);

        int ans = 0;
        long aux = Long.MIN_VALUE;

        for(int i = 1; i <= max_lvl; i++){
            if(aux < memo[i]){
                ans = i;
                aux = memo[i];
            }
        }

        return ans;
    }
}