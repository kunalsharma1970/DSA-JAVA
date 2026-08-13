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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q= new LinkedList<>();
        if(root==null)  return false;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            int count=0;
            while(size-->0){
                TreeNode t= q.poll();
                if(t.left!=null && t.right!=null){
                    if(t.left.val==x && t.right.val==y) return false;
                    else if(t.left.val==y && t.right.val==x) return false;
                }
                if(t.left!=null && t.left.val==x) count++;
                else if(t.left!=null && t.left.val==y) count++;
                else if(t.right!=null && t.right.val==x) count++;
                else if(t.right!=null && t.right.val==y) count++;
                if(t.left!=null) q.add(t.left);
                if(t.right!=null) q.add(t.right);
            }
            if(count==2) return true;
            count=0;
        }
        return false;
    }
}