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
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        int level=0;
        while(!q.isEmpty()){
            int levelSize=q.size();
            int[]arr=new int[levelSize];
            int left=0; int right=levelSize-1;
            while(levelSize-->0){
                TreeNode t=q.poll();
                if(level==0){
                    arr[left]=t.val;
                    left++;
                }else{
                    arr[right]=t.val;
                    right--;
                }
                if(t.left!=null) q.add(t.left);
                if(t.right!=null) q.add(t.right);
            }
            List<Integer> list= new ArrayList<>();
            for(int num:arr){
                list.add(num);
            }
            ans.add(new ArrayList<>(list));
            level=1-level;
        }
        return ans;
    }
}