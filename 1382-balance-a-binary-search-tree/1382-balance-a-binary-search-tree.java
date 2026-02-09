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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        //extract sorted values via inorder traversal
        inorder(root, nodes);
        // build balanced bst from sorted array
        return makeBalanced(nodes, 0, nodes.size() - 1);
    }
    
    private void inorder(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }
        // traverse left subtree
        inorder(node.left, arr);
        // visit current node
        arr.add(node.val);
        // traverse right subtree
        inorder(node.right, arr);
    }
    
    private TreeNode makeBalanced(List<Integer> nodes, int left, int right) {
        if (left > right) {
            return null;
        }
        // find middle element to ensure balance
        int mid = left + (right - left) / 2;
        // create root with middle element
        TreeNode root = new TreeNode(nodes.get(mid));
        // recursively build left subtree
        root.left = makeBalanced(nodes, left, mid - 1);
        // recursively build right subtree
        root.right = makeBalanced(nodes, mid + 1, right);
        return root;
    }
}