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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> list= new ArrayList<>();
        int sum=0;
        if(root==null) return ans;
        fun(root,targetSum,sum,ans,list);
        return ans;
    }
    public void fun(TreeNode root,int targetSum,int sum,List<List<Integer>>ans,List<Integer>list){
        if(root==null)  return;
        sum+=root.val;
        list.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                ans.add(new ArrayList<>(list));
                list.remove(list.size()-1);
                return;
            }
        }
        fun(root.left,targetSum,sum,ans,list);
        fun(root.right,targetSum,sum,ans,list);
        list.remove(list.size()-1);
    }
}