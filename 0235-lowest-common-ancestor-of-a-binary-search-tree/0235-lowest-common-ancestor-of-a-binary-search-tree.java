/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p || root==q) return root;
        if(root.val<p.val && root.val<q.val){ 
            TreeNode rh= lowestCommonAncestor(root.right,p,q);
            return rh;
        }
        else if(root.val>p.val && root.val>q.val) {
            TreeNode lh= lowestCommonAncestor(root.left,p,q);
            return lh;
        }
        else return root;

    }
}