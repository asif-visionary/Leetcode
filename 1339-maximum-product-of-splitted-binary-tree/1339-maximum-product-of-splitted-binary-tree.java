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
    long max_product = Integer.MIN_VALUE;

    public int maxProduct(TreeNode root) {
        long totalSum = getCompleteTreeSum(root);
        calculateSubtreeSum(root, totalSum);
        return (int) (max_product % 1000000007);
    }

    private long calculateSubtreeSum(TreeNode root, long totalSum) {
        // base case
        if (root == null) {
            return 0;
        }

        long leftSum = calculateSubtreeSum(root.left, totalSum);
        long rightSum = calculateSubtreeSum(root.right, totalSum);

        long currentSubtreeSum = leftSum + rightSum + root.val;

        // calculate product if we cut this subtree from original tree
        long current_product = (totalSum - currentSubtreeSum) * currentSubtreeSum;
        max_product = Math.max(max_product, current_product);

        return currentSubtreeSum;
    }

    private long getCompleteTreeSum(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }
        return root.val+ getCompleteTreeSum(root.left)+ getCompleteTreeSum(root.right);
    }
}
