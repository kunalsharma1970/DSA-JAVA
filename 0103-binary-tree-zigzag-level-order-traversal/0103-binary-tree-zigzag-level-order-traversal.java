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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        int level=0;
        while(!q.isEmpty()){
            int levelsize=q.size();
            int[]res= new int[levelsize];
            int first=0; int last=res.length-1;
            while(levelsize-->0){
                if(level==0){
                    TreeNode t=q.poll();
                    res[first]=t.val;
                    first++;
                    if(t.left!=null) q.add(t.left);
                    if(t.right!=null) q.add(t.right);
                }else{
                    TreeNode t=q.poll();
                    res[last]=t.val;
                    last--;
                    if(t.left!=null) q.add(t.left);
                    if(t.right!=null)q.add(t.right);
                }
            }
            level=1-level;
            List<Integer> list= new ArrayList<>();
            for(int num:res){
                list.add(num);
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}