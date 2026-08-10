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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans= new LinkedList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int levelsize=q.size();
            List<Integer> list= new ArrayList<>();
            while(levelsize-->0){
                TreeNode t=q.poll();
                list.add(t.val);
                if(t.left!=null) q.add(t.left);
                if(t.right!=null) q.add(t.right);
            }
            ans.addFirst(list);
        }
        return ans;
    }
}