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
    public int sumNumbers(TreeNode root) {
        List<Integer> list= new ArrayList<>();
        if(root==null) return 0;
        int sum=0;
        fun(root,sum,list);
        int totalSum=0;
        for(int i=0;i<list.size();i++){
            totalSum+=list.get(i);
        }
        return totalSum;
    }
    public void fun(TreeNode root,int sum,List<Integer>list){
        if(root==null) return;
        sum=sum*10+root.val;
        if(root.left==null && root.right==null) {
            list.add(sum);
            return;
        }
        fun(root.left,sum,list);
        fun(root.right,sum,list);
    }
}