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
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            int []res= new int[size];
            int first=0; int last=res.length-1;
            while(size-->0){
                TreeNode t= q.poll();
                if(level==0){
                    res[first]=t.val;
                    first++;
                }else{
                    res[last]=t.val;
                    last--;
                }
                if(t.left!=null) q.add(t.left);
                if(t.right!=null) q.add(t.right);
            }
            level=1-level;
            List<Integer>list=new ArrayList<>();
            for(int i=0;i<res.length;i++){
                list.add(res[i]);
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}